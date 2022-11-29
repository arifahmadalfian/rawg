package com.arifahmadalfian.rawgapp.domain.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultsItemDto(

	@SerialName("added")
	val added: Int? = null,

	@SerialName("rating")
	val rating: Double? = null,

	@SerialName("metacritic")
	val metacritic: Int? = null,

	@SerialName("playtime")
	val playtime: Int? = null,

	@SerialName("short_screenshots")
	val shortScreenshots: List<ShortScreenshotsItemDto>? = null,

	@SerialName("platforms")
	val platforms: List<PlatformsItemDto>? = null,

	@SerialName("user_game")
	val userGame: String? = null,

	@SerialName("rating_top")
	val ratingTop: Int? = null,

	@SerialName("reviews_text_count")
	val reviewsTextCount: Int? = null,

	@SerialName("ratings")
	val ratings: List<RatingsItemDto>? = null,

	@SerialName("genres")
	val genres: List<GenresItemDto>? = null,

	@SerialName("saturated_color")
	val saturatedColor: String? = null,

	@SerialName("id")
	val id: Int,

	@SerialName("added_by_status")
	val addedByStatus: AddedByStatusDto? = null,

	@SerialName("parent_platforms")
	val parentPlatforms: List<ParentPlatformsItemDto>? = null,

	@SerialName("ratings_count")
	val ratingsCount: Int? = null,

	@SerialName("slug")
	val slug: String? = null,

	@SerialName("released")
	val released: String? = null,

	@SerialName("suggestions_count")
	val suggestionsCount: Int? = null,

	@SerialName("stores")
	val stores: List<StoresItemDto?>? = null,

	@SerialName("tags")
	val tags: List<TagsItemDto>? = null,

	@SerialName("background_image")
	val backgroundImage: String? = null,

	@SerialName("tba")
	val tba: Boolean? = null,

	@SerialName("dominant_color")
	val dominantColor: String? = null,

	@SerialName("esrb_rating")
	val esrbRating: EsrbRatingDto? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("updated")
	val updated: String? = null,

	@SerialName("clip")
	val clip: String? = null,

	@SerialName("reviews_count")
	val reviewsCount: Int? = null,

	@SerialName("score")
	val score: String? = null,

	@SerialName("community_rating")
	val communityRating: Int? = null,

	val isFavorite: Boolean = false


	)