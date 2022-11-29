package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformsItemDto(

	@SerialName("requirements")
	val requirements: RequirementsDto? = null,

	@SerialName("released_at")
	val releasedAt: String? = null,

	@SerialName("platform")
	val platform: PlatformDto? = null
)