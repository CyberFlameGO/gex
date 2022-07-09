package au.id.wale.enter.the.gecko

import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes

fun serverHandler() : HttpHandler {
    return routes("/" bind Method.GET to { Response(OK).body("Hello World, from Gex!") })
}