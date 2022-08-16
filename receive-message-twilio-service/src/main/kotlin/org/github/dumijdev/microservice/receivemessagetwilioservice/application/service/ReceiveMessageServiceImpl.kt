package org.github.dumijdev.microservice.receivemessagetwilioservice.application.service

import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Contact
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Message
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.ReportMessage
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.ContactRepository
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.ReceiveMessageService
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.SendTo
import java.time.LocalDate

class ReceiveMessageServiceImpl(private val repository: ContactRepository, private val sendTo: SendTo) : ReceiveMessageService {

    override fun receive(message: Message) {
        val regexPhone = "([+][0-9]{1,3}[ ]?([0-9]{2,})?[ ]?)?[0-9]{3}([ .-]?[0-9]{3}){2,}"
        message.contacts.forEach { contact: Contact ->
            if (contact.number == "" || !Regex(regexPhone).matches(contact.number))
                throw IllegalArgumentException("A member of yours contacts is invalid")
        }

        requestMessageSending(message)

        repository.save(ReportMessage(message))
    }

    override fun requestMessageSending(message: Message) {
        sendTo.sendToQueue(message)
    }

    override fun generateSendingReport(date: LocalDate) {
        val reportMessage: ReportMessage = repository.findAllRequestsByDate(date)

        sendTo.sendToQueue(reportMessage)

    }

}