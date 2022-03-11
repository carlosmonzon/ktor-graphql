package com.cmonzon

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.apurebase.kgraphql.GraphQL
import com.cmonzon.graphql.dessertSchema
import com.cmonzon.plugins.configureRouting
import io.ktor.application.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        install(GraphQL) {
            playground = true
            schema {
                dessertSchema()
            }
        }
    }.start(wait = true)
}
