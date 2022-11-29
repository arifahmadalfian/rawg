package com.arifahmadalfian.rawgapp.domain.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.dto.ResultsItemDto
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "game_table")
data class GameEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val released: String,
    val backgroundImage: String,
    val rating: Double,
    val isFavorite: Boolean
)

fun List<GameEntity>.toResultItem() = map {
    ResultsItemDto(
        id = it.id,
        name = it.name,
        released = it.released,
        backgroundImage = it.backgroundImage,
        rating = it.rating,
        isFavorite = it.isFavorite
    )
}

fun GameDetailDto.toGameEntity() = GameEntity(
    id = id ?: 0,
    name = name ?: "",
    released = released ?: "",
    backgroundImage = backgroundImage ?: "",
    rating = rating ?: 0.0,
    isFavorite = true
)