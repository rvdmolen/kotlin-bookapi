package com.codingmill.bookapi.web.scheduler

import com.codingmill.bookapi.generated.data.BookDTO
import com.codingmill.bookapi.web.services.BooksService
import mu.KotlinLogging
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import kotlin.random.Random

private val logger = KotlinLogging.logger { }


@Configuration
@EnableScheduling
class SchedulerService(val booksService: BooksService) {
    private val ids: List<Long> = (1..50).map { it.toLong() }

    @Scheduled(initialDelay = 10000, fixedRate = 30000)
    fun generateFailure() {
        val book = randomBook()
        logger.info("Generating new random book... $book")
        booksService.createBook(book)
    }

    private fun randomBook(): BookDTO =
        BookDTO(
            id = -1,
            name = "Richard",
            author = 1,
            isbn = "",
            category = "Development"
        )

    private fun randomId() =
        ids[Random.nextInt(ids.size)]
}