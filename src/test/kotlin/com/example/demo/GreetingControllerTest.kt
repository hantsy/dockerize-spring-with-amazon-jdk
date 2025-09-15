package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest(controllers = [GreetingController::class])
class GreetingControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun `should return Hello World`() {
        webTestClient.get().uri("/hello")
            .exchange()
            .expectStatus().isOk
            .expectBody(String::class.java).value { assertEquals("Hello World!", it) }
    }
}