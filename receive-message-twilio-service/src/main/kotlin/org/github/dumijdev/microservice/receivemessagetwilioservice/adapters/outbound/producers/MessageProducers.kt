package org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.outbound.producers

import com.fasterxml.jackson.databind.ObjectMapper
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Message
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.ReportMessage
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.SendTo
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MessageProducers(private val rabbitTemplate: RabbitTemplate) : SendTo{
    @Value("\${rabbitmq.exchange.message.name}")
    private lateinit var messageExchange: String

    @Value("\${rabbitmq.routing.message.key}")
    private lateinit var messageRoutingKey: String

    @Value("\${rabbitmq.exchange.report.name}")
    private lateinit var reportExchange: String

    @Value("\${rabbitmq.routing.report.key}")
    private lateinit var reportRoutingKey: String


    override fun sendToQueue(message: Message) {
        val messageJSON: String = ObjectMapper().writeValueAsString(message)
        println(messageJSON)
        rabbitTemplate.convertAndSend(messageExchange, messageRoutingKey, messageJSON)
    }

    override fun sendToQueue(report: ReportMessage) {
        val messageJSON: String = ObjectMapper().writeValueAsString(report)
        println(messageJSON)
        rabbitTemplate.convertAndSend(reportExchange, reportRoutingKey, messageJSON)
    }

}