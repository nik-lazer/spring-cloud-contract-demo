package lan.guild.contractconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
class ContractConsumerApplication

fun main(args: Array<String>) {
	runApplication<ContractConsumerApplication>(*args)
}
