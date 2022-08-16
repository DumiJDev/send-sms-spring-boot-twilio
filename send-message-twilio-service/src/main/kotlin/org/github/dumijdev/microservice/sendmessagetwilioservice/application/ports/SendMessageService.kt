package org.github.dumijdev.microservice.sendmessagetwilioservice.application.ports

import org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain.Message

interface SendMessageService {
    fun sendMessage(message: Message)
}