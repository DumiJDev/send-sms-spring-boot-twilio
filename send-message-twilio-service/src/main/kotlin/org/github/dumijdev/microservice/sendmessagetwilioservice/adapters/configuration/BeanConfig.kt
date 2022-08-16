package org.github.dumijdev.microservice.sendmessagetwilioservice.adapters.configuration

import org.github.dumijdev.microservice.sendmessagetwilioservice.application.ports.SMSService
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.service.SendMessageServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

    @Bean
    fun sendMessageServiceBean(smsService: SMSService) = SendMessageServiceImpl(smsService)

}