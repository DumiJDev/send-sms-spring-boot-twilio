package org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain

import java.time.LocalDate
import java.util.UUID

data class ReportMessage(val id: UUID = UUID.randomUUID(), val date: LocalDate = LocalDate.now()) {

    lateinit var message: Message

    constructor(message: Message) : this() {
        this.message = message
    }
}
