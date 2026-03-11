package dd.reito.httpTest.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column
    val bestScore: Int = 0,

    @Column
    val bestScoreDateTime:LocalDateTime? = null

)