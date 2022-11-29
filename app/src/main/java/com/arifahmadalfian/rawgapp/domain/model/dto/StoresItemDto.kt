package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoresItemDto(

	@SerialName("id")
	val id: Int? = null,

	@SerialName("store")
	val store: StoreDto? = null,

	@SerialName("url")
	val url: String? = null
)