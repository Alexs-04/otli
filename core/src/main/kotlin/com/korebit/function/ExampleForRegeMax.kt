package com.korebit.function

fun main() {
    val inputStream = object {}.javaClass.classLoader.getResourceAsStream("herramientas.txt")
        ?: error("Archivo herramientas.txt no encontrado en classpath")

    val strings = listOf(
        "Truper", "Pretul", "Dewalt", "Bosch", "Surtek", "Milwaukee", "Stanley",
        "Makita", "Ryobi", "Black And Decker", "Craftsman", "Chicago Electric", "Bellota", "QEP"
    )

    val lines = inputStream.bufferedReader().readLines()

    val normaliceTools = lines.map { normaliceTool(it, strings) }

    normaliceTools.forEach { println(it) }
}

fun normaliceTool(line: String, brads: List<String>): String {
    var text = line.trim()

    text = text.lowercase().split(" ").joinToString(" ") { str ->
        str.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }.replace(Regex("\\s+"), " ")

    text = text.replace(Regex("(?i)(\\d+/\\d+)(\\s*['\"]|\\s*pulgadas?)"), "$1”")
    text = text.replace(Regex("(\\d+)\\s*pulgadas?", RegexOption.IGNORE_CASE), "$1”")

    val bradFound = brads.firstOrNull { brad ->
        Regex("\\b$brad\\b", RegexOption.IGNORE_CASE).containsMatchIn(text)
    }

    if (bradFound != null && !text.startsWith(bradFound, ignoreCase = true)) {
        text = text.replace(Regex("\\b$bradFound\\b", RegexOption.IGNORE_CASE), "").trim()
        text = "$bradFound $text"
    }

    val matchResult = Regex("\\b([A-Z]{2,}[\\w-]+|\\d{4,})\\b").find(text)
    val model = matchResult?.value ?: ""

    if (model.isNotEmpty()) {
        text = text.replace(model, "").trim()
        text = "$text - $model"
    }

    return text
}
