package lan.guild.contractprovider.contract

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
abstract class BaseContractTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setupMockMvc() {
        RestAssuredMockMvc.mockMvc(mockMvc)
    }
}
