package njc.koinprototype

class MainInteractor(private val repo: IntervalRepository) {
    data class Result(val text: String, val number: Long)

    fun create() = repo.interval().map { Result("$it", it) }
}
