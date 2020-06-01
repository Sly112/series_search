package pl.slyberry.series.repository

import pl.slyberry.series.domain.Movie

class MoviesRepositoryImpl(val api: MoviesApi) : MoviesRepository {

    override suspend fun getMovies(query: String): List<Movie> =
        api.getMovies(query).map { it.toDomain() }
}
