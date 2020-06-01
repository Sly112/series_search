package pl.slyberry.series.ui.list.view

import pl.slyberry.series.domain.Movie

fun Movie.toViewEntity() = MovieViewEntity(name, categories.joinToString(), image)
