package org.github.dumijdev.microservice.sendmessagetwilioservice.adapters.outbound.service

import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain.Contact
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.ports.SMSService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
@Primary
class TwilioSMSService : SMSService {

    @Value("\${twilio.account-sid}")
    lateinit var accountSID: String
    @Value("\${twilio.auth-token}")
    lateinit var authToken: String
    @Value("\${twilio.phone-number}")
    lateinit var twilioPhone: String
    @Value("\${twilio.username}")
    lateinit var username: String

    @PostConstruct
    fun initTwilio() {
        Twilio.init(accountSID, authToken)
    }

    override fun sendSMS(text: String?, contact: Contact): Boolean {
        val message = Message.creator(
            PhoneNumber(contact.number),
            PhoneNumber(twilioPhone),
            text
        ).create()

        return true
    }
}