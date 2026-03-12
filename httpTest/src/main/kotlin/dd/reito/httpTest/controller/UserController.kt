package dd.reito.httpTest.controller

import dd.reito.httpTest.entity.UserEntity
import dd.reito.httpTest.service.UserService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
// これによって前エンドポイントにapiがつく。
// それによって画面として見たいエンドポイントか、
// データ通信としてのエンドポイントかの棲み分けができる。
@RequestMapping("/api")
class UserController(
    private val userService: UserService
) {
    // game終了後のランキング画面にて使う。
    @GetMapping("/users")
    fun getAllUsers(): List<UserEntity> {
        return userService.getAllUsers()
    }

    // loginで使うAPI
    @GetMapping("/login/{name}")
    fun getTargetUser(@PathVariable name: String): UserEntity {
        return userService.getTargetUser(name)
    }


    // 初回signOn時にname経由でpost
    @PostMapping("/signOn/{name}")
    fun createUser(@PathVariable name: String): UserEntity {
        return userService.createUser(name)
    }

    data class PatchUserScore(
        val currentScore: Int,
        val bestScore: Int,
        val bestScoreDateTime: LocalDateTime,
    )
    // game終了後にscore関連の更新するためのエンドポイント
    @PatchMapping("/user/{id}")
    fun patchUser(@PathVariable id: Long, @RequestBody score: PatchUserScore): UserEntity {
        return userService.patchUser(
            id,
            score.currentScore,
            score.bestScore,
            score.bestScoreDateTime
        )
    }

    // 今回userのdateを消すことがないと思うので、一旦stay
    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }
    @DeleteMapping("/user")
    fun allDelete() {
        userService.allDelete()
    }
}