import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    client.use { client ->
        val response: List<Product> = client
            .get("http://localhost:8080/api/products")
            .body()

        response.forEach { product ->
            println("${product.name}: ${product.price}")
        }
    }
}

suspend fun otherExample() {
    val client = HttpClient(CIO)

    client.use { client ->
        val response = client
            .get("http://localhost:8080")
            .bodyAsText()

        println(response)
    }
}

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)