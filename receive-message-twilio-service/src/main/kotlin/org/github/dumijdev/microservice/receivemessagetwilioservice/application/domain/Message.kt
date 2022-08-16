package org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain

import java.util.UUID

data class Message(val contacts: List<Contact>, val text: String? = "", val id: UUID? = UUID.randomUUID())