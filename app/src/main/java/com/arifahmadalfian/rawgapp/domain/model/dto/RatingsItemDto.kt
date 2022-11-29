package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingsItemDto(

	@SerialName("count")
	val count: Int? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("percent")
	val percent: Double? = null
)