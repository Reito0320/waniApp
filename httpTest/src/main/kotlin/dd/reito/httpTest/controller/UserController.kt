package dd.reito.httpTest.controller

import dd.reito.httpTest.entity.UserEntity
import dd.reito.httpTest.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/login")
    fun getAllUsers(): List<UserEntity> {
        return userService.getAllUsers()
    }
    @PostMapping("/user")
    fun createUser(): UserEntity {
        return userService.createUser(
            "Reito",
        )
    }
    @PatchMapping("/user/{id}")
    fun patchUser(@PathVariable id: Long, @RequestBody user: UserEntity): UserEntity {
        return userService.patchUser(
            id,
            user.name,
        )
    }
    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }
    @DeleteMapping("/user")
    fun allDelete() {
        userService.allDelete()
    }
}