package org.github.dumijdev.microservice.sendmessagetwilioservice.adapters.configuration

import org.springframework.amqp.core.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMQConfig {
    @Value("\${rabbitmq.queue.message.name}")
    private val messageQueue: String? = null

    @Value("\${rabbitmq.exchange.message.name}")
    private val messageExchange: String? = null

    @Value("\${rabbitmq.routing.message.key}")
    private val messageRoutingKey: String? = null

    @Value("\${rabbitmq.queue.report.name}")
    private val reportQueue: String? = null

    @Value("\${rabbitmq.exchange.report.name}")
    private val reportExchange: String? = null

    @Value("\${rabbitmq.routing.report.key}")
    private val reportRoutingKey: String? = null

    // spring bean for rabbitmq queue
    @Bean
    fun messageQueue(): Queue? {
        return Queue(messageQueue)
    }

    // spring bean for rabbitmq queue
    @Bean
    fun reportQueue(): Queue? {
        return Queue(reportQueue)
    }

    // spring bean for rabbitmq exchange
    @Bean
    fun messageExchange(): DirectExchange? {
        return DirectExchange(messageExchange)
    }

    @Bean
    fun reportExchange(): DirectExchange? {
        return DirectExchange(reportExchange)
    }

    // binding between queue and exchange using routing key
    @Bean
    fun messageBinding(): Binding? {
        return Binding(
            messageQueue,
            Binding.DestinationType.QUEUE,
            messageExchange,
            messageRoutingKey,
            null
        )
    }

    // binding between queue and exchange using routing key
    @Bean
    fun reportBinding(): Binding? {
        return Binding(
            reportQueue,
            Binding.DestinationType.QUEUE,
            reportExchange,
            reportRoutingKey,
            null
        )
    }
}