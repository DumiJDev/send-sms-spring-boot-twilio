package org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports

import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Message
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.ReportMessage

interface SendTo {
    fun sendToQueue(message: Message)
    fun sendToQueue(report: ReportMessage)
}