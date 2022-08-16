package org.github.dumijdev.microservice.receivemessagetwilioservice.adapters.inbound.controller

import org.github.dumijdev.microservice.receivemessagetwilioservice.application.domain.Message
import org.github.dumijdev.microservice.receivemessagetwilioservice.application.ports.ReceiveMessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/contacts")
@RestController
class ContactController(val receiveMessageService: ReceiveMessageService) {

    @PostMapping
    fun postContacts(@RequestBody message: Message): ResponseEntity<Any> {
        receiveMessageService.receive(message)
        println("Save!!!")
        return ResponseEntity.ok("Added with successfully")
    }
}