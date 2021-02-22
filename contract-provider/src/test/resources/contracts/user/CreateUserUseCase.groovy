package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create user"
    request{
        method POST()
        urlPath(("/user"))
        headers {
            contentType applicationJson()
        }
        body(
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
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: anyNumber(),
                name: fromRequest().body("name"),
                surname: fromRequest().body("surname"),
                birthday: fromRequest().body("birthday"),
                salary: fromRequest().body("salary"),
                email: fromRequest().body("email"),
                role: fromRequest().body("role"),
                //permissions: fromRequest().body("permissions")
        )
    }
}