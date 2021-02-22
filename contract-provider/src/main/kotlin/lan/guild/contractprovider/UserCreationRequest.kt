package lan.guild.contractprovider

import java.time.LocalDate

data class UserCreationRequest(
    val name: String,
    val surname: String,
    val email: String,
    val birthday: LocalDate,
    val salary: Double? = 0.0,
    val role: Role,
    val permissions: List<Permission>
) {
    fun toUser(id: Long) =
        User(
            id = id,
            name = name,
            surname = surname,
            email = email,
            birthday = birthday,
            salary = salary,
            role = role,
            permissions = permissions
        )
}

