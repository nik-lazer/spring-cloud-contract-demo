package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return user by userId"
    request{
        method GET()
        urlPath(regex("/user/\\d+"))
        headers {
            contentType applicationJson()
        }
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: anyNumber(),
                name: anyNonBlankString(),
                surname: anyNonBlankString(),
                birthday: anyDate(),
                salary: anyDouble(),
                email: anyEmail(),
                role: anyOf("USER", "ADMIN"),
                permissions: [[
                        name: anyNonBlankString()
                ]]
        )
    }
}