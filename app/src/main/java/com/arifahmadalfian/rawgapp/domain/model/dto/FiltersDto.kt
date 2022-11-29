package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FiltersDto(

	@SerialName("years")
	val years: List<YearsItemDto>? = null
)