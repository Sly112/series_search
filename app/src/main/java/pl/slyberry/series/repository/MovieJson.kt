package pl.slyberry.series.repository

import com.squareup.moshi.Json

data class MovieJson(

    @field:Json(name = "show")
    val show: ShowJson
)

data class ShowJson(

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "genres")
    val genres: List<String>,

    @field:Json(name = "image")
    val image: ImageJson?
)

data class ImageJson(

    @field:Json(name = "medium")
    val medium: String?
)
