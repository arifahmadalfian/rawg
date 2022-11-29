package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EsrbRatingDto(

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("slug")
	val slug: String? = null
)