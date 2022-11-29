package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformDto(

	@SerialName("image")
	val image: String? = null,

	@SerialName("games_count")
	val gamesCount: Int? = null,

	@SerialName("year_end")
	val yearEnd: String? = null,

	@SerialName("year_start")
	val yearStart: String? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("image_background")
	val imageBackground: String? = null,

	@SerialName("slug")
	val slug: String? = null
)