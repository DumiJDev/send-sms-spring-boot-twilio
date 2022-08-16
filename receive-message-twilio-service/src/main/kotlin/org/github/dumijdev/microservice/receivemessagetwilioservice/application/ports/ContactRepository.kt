package org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports

import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.ReportMessage
import java.time.LocalDate

interface ContactRepository {
    fun findAllRequestsByDate(date: LocalDate): ReportMessage
    fun save(reportMessage: ReportMessage) : ReportMessage
}