package dd.reito.httpTest.seed

import dd.reito.httpTest.entity.UserEntity
import dd.reito.httpTest.repository.UserRepository
// このimportで初回起動時にrunするようにハンドリング buildっぽい
import org.springframework.boot.CommandLineRunner
// このimportで@Component以下を探してくれる。
import org.springframework.stereotype.Component

@Component
class DataSeeder(
    private val userRepository: UserRepository
) : CommandLineRunner {

    override fun run(vararg args: String) {

        if (userRepository.count() == 0L) {

            val user1 = UserEntity(
                name = "Reito",
                bestScore = 0
            )

            val user2 = UserEntity(
                name = "TestUser",
                bestScore = 0
            )

            userRepository.saveAll(listOf(user1, user2))
        }
    }
}