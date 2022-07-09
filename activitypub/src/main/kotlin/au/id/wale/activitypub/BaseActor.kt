package au.id.wale.activitypub

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class BaseActor(
    @SerialName("@context")
    @Contextual
    val context: Any, // will either be a String or a List<Any> depending on type of actor
    val type: String, // todo: convert to enum
    val id: String
)