package cmonzon.com

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import cmonzon.com.plugins.*
import com.apurebase.kgraphql.GraphQL
import io.ktor.application.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        install(GraphQL) {
            playground = true
            schema {
                query("hello") {
                    resolver { ->
                        "World"
                    }
                }
            }
        }
    }.start(wait = true)
}
