package lan.guild.contractconsumer

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(value = "producer", url = "\${producer.url}")
interface UserClient {
    @GetMapping("user/{userId}")
    fun fetchUser(@PathVariable("userId") userId: Long): User
}