package dd.reito.httpTest.service

import dd.reito.httpTest.entity.UserEntity
import dd.reito.httpTest.repository.UserRepository
import org.springframework.data.domain.Score
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }
    fun createUser(name: String): UserEntity {
        val user = UserEntity(name = name)
        return userRepository.save(user)
    }
    fun patchUser(id: Long, name:String): UserEntity {
        val targetUser = userRepository.findById(id)
            .orElseThrow { RuntimeException("user not found") }
        val updatedUser = targetUser.copy(name = name)
        return userRepository.save(updatedUser)
    }

    fun deleteUser(id: Long): Unit {
        val targetUser = userRepository.findById(id)
            .orElseThrow { RuntimeException("not found") }
        userRepository.deleteById(id)
    }

    fun allDelete() {
        userRepository.deleteAll()
    }
}
