package pl.slyberry.series.repository

import pl.slyberry.series.domain.Movie

fun MovieJson.toDomain() = Movie(show.name, show.genres, show.image?.medium)
