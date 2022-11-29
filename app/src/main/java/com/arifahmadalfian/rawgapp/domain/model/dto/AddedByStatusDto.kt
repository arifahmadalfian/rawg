package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddedByStatusDto(

	@SerialName("owned")
	val owned: Int? = null,

	@SerialName("beaten")
	val beaten: Int? = null,

	@SerialName("dropped")
	val dropped: Int? = null,

	@SerialName("yet")
	val yet: Int? = null,

	@SerialName("playing")
	val playing: Int? = null,

	@SerialName("toplay")
	val toplay: Int? = null
)