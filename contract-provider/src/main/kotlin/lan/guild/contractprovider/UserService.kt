package lan.guild.contractprovider

import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.annotation.PostConstruct

@Service
class UserService {
    private val data = mutableMapOf<Long, User>()

    fun get(userId: Long): User? {
        return data[userId]
    }

    fun add(user: UserCreationRequest): User? {
        val id = data.keys.maxOrNull() ?: 1
        return data.putIfAbsent(id, user.toUser(id))
    }

    @PostConstruct
    fun init() {
        add(
            UserCreationRequest(
                name = "John",
                surname = "Doy",
                birthday = LocalDate.now(),
                role = Role.USER,
                email = "john.doy@guild.lan",
                permissions = listOf(Permission("some"))
            )
        )
    }
}