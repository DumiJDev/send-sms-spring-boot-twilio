package org.github.dumijdev.microservice.sendmessagetwilioservice.adapters.configuration

import com.twilio.Twilio
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import javax.annotation.PostConstruct

class TwilioConfig {
    @Value("\${twilio.account-sid}")
    lateinit var accountSID: String
    @Value("\${twilio.auth-token}")
    lateinit var authToken: String
    @Value("\${twilio.phone-number}")
    lateinit var twilioPhone: String
    @Value("\${twilio.username}")
    lateinit var username: String
    @Value("\${twilio.password}")
    lateinit var password: String

    @PostConstruct
    fun initTwilio() {
        Twilio.init(username, password, accountSID)
    }
}