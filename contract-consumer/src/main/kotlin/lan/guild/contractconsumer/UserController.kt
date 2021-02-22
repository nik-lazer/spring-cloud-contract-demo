package lan.guild.contractconsumer

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController(val userClient: UserClient) {

    @GetMapping
    fun search(@RequestParam userId: Long): User? {
        return userClient.fetchUser(userId)
    }
}