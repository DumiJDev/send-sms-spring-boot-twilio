package org.github.dumijdev.microservice.receivemessagetwilioservice

import org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.outbound.producers.MessageProducers
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Contact
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Message
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ReceiveMessageTwilioServiceApplicationTests {

    @Autowired
    lateinit var producers: MessageProducers

    @Test
    fun receiveMessageAndSendToQueue_ReturnAnEntity() {
        val message =
            Message(
                listOf(
                    Contact("Dumildes", "997284487"),
                    Contact("Paulo", "936376157")
                )
            )

        producers.sendToQueue(message)

        println("Sent")

    }

}
