package dd.reito.httpTest.repository

import dd.reito.httpTest.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun existsByName(name: String): Boolean
    fun findByName(name: String): UserEntity?
}
