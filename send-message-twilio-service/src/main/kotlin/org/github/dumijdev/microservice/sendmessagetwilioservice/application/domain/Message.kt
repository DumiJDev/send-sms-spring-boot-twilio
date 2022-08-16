package org.github.dumijdev.microservice.sendmessagetwilioservice.application.domain

import java.util.*

data class Message(val id: UUID?, val text: String?, val contacts: List<Contact>)