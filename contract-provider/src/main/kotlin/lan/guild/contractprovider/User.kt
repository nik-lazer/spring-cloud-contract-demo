package lan.guild.contractprovider

import java.time.LocalDate

data class User(
    val id: Long,
    val name: String,
    val surname: String,
    val email: String,
    val birthday: LocalDate,
    val salary: Double? = 0.0,
    val role: Role,
    val permissions: List<Permission>
)

data class Permission(
    val name: String
)

enum class Role {
    USER,
    ADMIN
}
