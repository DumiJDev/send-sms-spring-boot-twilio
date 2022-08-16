package org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.outbound.persistence.entities

import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Message
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.UUID

@Document(collection = "reports")
data class ReportMessageEntity(
    @Id val id: UUID = UUID.randomUUID(),
    val message: Message,
    val date: LocalDate = LocalDate.now()
)
