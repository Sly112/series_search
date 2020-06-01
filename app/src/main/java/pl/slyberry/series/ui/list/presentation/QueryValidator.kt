package pl.slyberry.series.ui.list.presentation

class QueryValidator {

    fun isValid(query: String): Boolean {
        return query.length > 3
    }
}