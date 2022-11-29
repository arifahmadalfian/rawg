package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortScreenshotsItemDto(

	@SerialName("image")
	val image: String? = null,

	@SerialName("id")
	val id: Int? = null
)