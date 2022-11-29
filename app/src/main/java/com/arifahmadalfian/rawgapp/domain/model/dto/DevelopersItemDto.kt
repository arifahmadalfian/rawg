package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DevelopersItemDto(

	@SerialName("games_count")
	val gamesCount: Int? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("image_background")
	val imageBackground: String? = null,

	@SerialName("slug")
	val slug: String? = null
)