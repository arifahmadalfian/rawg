package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class YearsItemDto(

	@SerialName("filter")
	val filter: String? = null,

	@SerialName("nofollow")
	val nofollow: Boolean? = null,

	@SerialName("decade")
	val decade: Int? = null,

	@SerialName("count")
	val count: Int? = null,

	@SerialName("from")
	val from: Int? = null,

	@SerialName("to")
	val to: Int? = null,

	@SerialName("years")
	val years: List<YearsItemDto>? = null,

	@SerialName("year")
	val year: Int? = null
)