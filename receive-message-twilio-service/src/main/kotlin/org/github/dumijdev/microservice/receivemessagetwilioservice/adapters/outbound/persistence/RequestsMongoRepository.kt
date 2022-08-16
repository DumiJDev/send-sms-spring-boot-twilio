package org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.outbound.persistence

import org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.outbound.persistence.entities.ReportMessageEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.UUID

@Repository
interface RequestsMongoRepository : MongoRepository<ReportMessageEntity, UUID> {
    @Query("{date: '?0'}")
    fun findByDate(date: LocalDate): ReportMessageEntity
}