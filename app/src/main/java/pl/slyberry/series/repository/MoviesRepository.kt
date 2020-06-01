package pl.slyberry.series.repository

import pl.slyberry.series.domain.Movie

interface MoviesRepository {
    suspend fun getMovies(query: String): List<Movie>
}