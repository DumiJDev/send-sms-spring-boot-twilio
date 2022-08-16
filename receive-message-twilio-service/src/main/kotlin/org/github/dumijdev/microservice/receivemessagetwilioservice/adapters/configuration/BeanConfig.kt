package org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.configuration

import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.ContactRepository
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.SendTo
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.service.ReceiveMessageServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {
    @Bean
    fun contactServiceBean(
        contactRepository: ContactRepository,
        sendTo: SendTo
    ) = ReceiveMessageServiceImpl(contactRepository, sendTo)
}