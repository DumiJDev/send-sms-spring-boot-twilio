package org.github.dumijdev.microservice.sendmessagetwilioservice.application.ports

import org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain.Contact

interface SMSService {
    fun sendSMS(text: String?, contact: Contact): Boolean
}