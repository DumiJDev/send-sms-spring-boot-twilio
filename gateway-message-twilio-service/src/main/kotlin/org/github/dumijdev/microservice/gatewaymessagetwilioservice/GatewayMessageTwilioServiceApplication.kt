package org.github.dumijdev.microservice.gatewaymessagetwilioservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class GatewayMessageTwilioServiceApplication

fun main(args: Array<String>) {
	runApplication<GatewayMessageTwilioServiceApplication>(*args)
}
