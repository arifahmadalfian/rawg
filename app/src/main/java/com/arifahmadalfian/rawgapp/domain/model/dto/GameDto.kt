package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
	@SerialName("count")
	val count: Int? = null,

	@SerialName("results")
	val results: List<ResultsItemDto>? = null,
)