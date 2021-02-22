package lan.guild.contractprovider

import org.springframework.web.bind.annotation.*

@RestController
class UserController(val userService: UserService) {
    @GetMapping("user/{userId}")
    fun getUser(@PathVariable("userId") userId: Long): User? {
        return userService.get(userId)
    }

    @PostMapping("user")
    fun addUser(@RequestBody user: UserCreationRequest): User? {
        return userService.add(user)
    }

}