package lan.guild.contractprovider

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class UserController {
    @GetMapping("user/{userId}")
    fun getUser(@PathVariable("userId") userId: Long): User {
        return User(id = userId,
            name = "John",
            surname = "Doy",
            birthday = LocalDate.now(),
            role = Role.USER,
            email = "john.doy@guild.lan",
            permissions = listOf(Permission("some"))
        )
    }
}