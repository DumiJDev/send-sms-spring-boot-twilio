package org.github.dumijdev.microservice.discoverymessagetwilioservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class DiscoveryMessageTwilioServiceApplication

fun main(args: Array<String>) {
	runApplication<DiscoveryMessageTwilioServiceApplication>(*args)
}
