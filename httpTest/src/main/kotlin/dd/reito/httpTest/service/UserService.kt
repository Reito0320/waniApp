package dd.reito.httpTest.service

import dd.reito.httpTest.entity.UserEntity
import dd.reito.httpTest.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }
    // nameでの検索ではなくてidでの検索、idでの検索なので、localstorage的なのでidを保管
    // しかしlogin時にはidをそもそも取得するために必要。
    fun getTargetUser(name: String): UserEntity {
        println("login name = $name")
        return userRepository.findByName(name)?: throw RuntimeException("user not Found")
    }

    fun createUser(name: String): UserEntity {
        val find: Boolean = userRepository.existsByName(name)
        if (find) {
            throw RuntimeException("user already exists")
        }
          val user = UserEntity(name = name)
          return userRepository.save(user)
    }

    fun patchUser(id: Long ,currentScore: Int, bestScore: Int, bestScoreDateTime: LocalDateTime): UserEntity {
        val targetUser = userRepository.findById(id).orElseThrow { RuntimeException("not Found") }
        if (bestScore > targetUser.bestScore)  {
          val updatedUser = targetUser.copy(currentScore=bestScore, bestScore = bestScore, bestScoreDateTime = bestScoreDateTime)
          return userRepository.save(updatedUser)
        }
        val result = targetUser.copy(currentScore=bestScore, bestScore = targetUser.bestScore, bestScoreDateTime = targetUser.bestScoreDateTime)
        return userRepository.save(result)
    }

    // userのdateを消すシーンがないので今回使わないかも。。
    fun deleteUser(id: Long): Unit {
        val targetUser = userRepository.findById(id)
            .orElseThrow { RuntimeException("not found") }
        userRepository.deleteById(id)
    }
    fun allDelete() {
        userRepository.deleteAll()
    }
}
