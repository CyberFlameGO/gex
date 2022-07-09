package au.id.wale.enter.the.gecko

import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
    serverHandler().asServer(Undertow(8080)).start()
}