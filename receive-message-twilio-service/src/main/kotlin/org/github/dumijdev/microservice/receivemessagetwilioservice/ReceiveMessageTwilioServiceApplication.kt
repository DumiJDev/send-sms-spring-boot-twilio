package org.github.dumijdev.microservice.receivemessagetwilioservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class ReceiveMessageTwilioServiceApplication

fun main(args: Array<String>) {
	runApplication<ReceiveMessageTwilioServiceApplication>(*args)
}
