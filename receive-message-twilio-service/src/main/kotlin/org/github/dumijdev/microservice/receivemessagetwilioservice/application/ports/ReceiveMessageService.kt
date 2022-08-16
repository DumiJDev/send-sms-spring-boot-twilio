package org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports

import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Message
import java.time.LocalDate

interface ReceiveMessageService {
    fun receive(message: Message)

    fun requestMessageSending(message: Message)

    fun generateSendingReport(date: LocalDate)
}