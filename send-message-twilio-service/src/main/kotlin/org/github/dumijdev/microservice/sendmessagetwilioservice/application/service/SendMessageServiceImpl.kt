package org.github.dumijdev.microservice.sendmessagetwilioservice.application.service

import org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain.Contact
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain.Message
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain.ReportMessage
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.ports.SMSService
import org.github.dumijdev.microservice.sendmessagetwilioservice.application.ports.SendMessageService

class SendMessageServiceImpl(private val smsService: SMSService) : SendMessageService {

    override fun sendMessage(message: Message) {
        val listOfMessagesThatFails: MutableList<Contact> = ArrayList()

        for (contact in message.contacts) {
            if (smsService.sendSMS(message.text, contact))
                listOfMessagesThatFails.add(contact)
        }

        val messageFail: Message = Message(message.id, message.text, listOfMessagesThatFails)

        val report: ReportMessage = ReportMessage(message)
    }
}