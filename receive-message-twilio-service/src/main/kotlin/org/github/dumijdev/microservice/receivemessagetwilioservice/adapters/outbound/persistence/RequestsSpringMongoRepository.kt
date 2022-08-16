package org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.outbound.persistence

import org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.outbound.persistence.entities.ReportMessageEntity
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.ReportMessage
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.ContactRepository
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Primary
class RequestsSpringMongoRepository(private val repository: RequestsMongoRepository) : ContactRepository {

    override fun findAllRequestsByDate(date: LocalDate): ReportMessage {
        val requests: ReportMessageEntity = repository.findByDate(date)

        val report =  ReportMessage(requests.id, requests.date)
        report.message = requests.message

        return report
    }

    override fun save(reportMessage: ReportMessage): ReportMessage {
        val entity =
            ReportMessageEntity(reportMessage.id, reportMessage.message, reportMessage.date)

        repository.insert(entity)

        val report =  ReportMessage(entity.id, entity.date)
        report.message = entity.message

        return report
    }
}