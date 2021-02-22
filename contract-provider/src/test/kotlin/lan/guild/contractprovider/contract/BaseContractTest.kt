package lan.guild.contractprovider.contract

import io.restassured.module.mockmvc.RestAssuredMockMvc
import lan.guild.contractprovider.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import java.time.LocalDate

@WebMvcTest
abstract class BaseContractTest {
    @Autowired
    lateinit var mockMvc: MockMvc
    @MockBean
    lateinit var userService: UserService

    @BeforeEach
    fun setupMockMvc() {
        RestAssuredMockMvc.mockMvc(mockMvc)
    }

    @BeforeEach
    fun setupUserService() {
        Mockito.`when`(userService.get(anyLong())).thenAnswer {
            User(
            id = it.getArgument(0),
            name = "John",
            surname = "Doy",
            birthday = LocalDate.now(),
            role = Role.USER,
            email = "john.doy@guild.lan",
            permissions = listOf(Permission("some"))
        ) }
//        Mockito.`when`(userService.add(any())).thenAnswer {
//            val request:UserCreationRequest = it.getArgument(0)
//            User(
//                id = 1,
//                name = request.name,
//                surname = request.surname,
//                birthday = request.birthday,
//                role = request.role,
//                email = request.email,
//                permissions = request.permissions
//            )
//       }
    }
}
