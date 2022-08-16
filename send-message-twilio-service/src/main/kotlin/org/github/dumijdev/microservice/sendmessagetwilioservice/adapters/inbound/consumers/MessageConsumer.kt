package org.github.dumijdev.microservice.sendmessagetwilioservice.adapters.inbound.consumers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain.Message
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.ports.SendMessageService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class MessageConsumer(private val sendMessageService: SendMessageService) {

    @RabbitListener(queues = ["\${rabbitmq.queue.message.name}"], ackMode = "MANUAL")
    fun receiveAndSendSMS(@Payload messageJSON: String) {
        val mapper = jacksonObjectMapper()
        val message = mapper.readValue<Message>(messageJSON)
        sendMessageService.sendMessage(message)
    }

}