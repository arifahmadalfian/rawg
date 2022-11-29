package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParentPlatformsItemDto(

	@SerialName("platform")
	val platform: PlatformDto? = null
)