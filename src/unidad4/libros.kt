package unidad4

open class Book(val title: String, val author: String) {

    private var currentPage: Int = 0;

    open fun readPage() {
        currentPage++;
        println("Leyendo '$title': página actual -> $currentPage");
    }
}

class eBook(
    title: String,
    author: String,
    val format: String = "texto"
) : Book(title, author) {

    private var wordCount: Int = 0;

    override fun readPage() {
        wordCount += 250;
        println("Leyendo eBook '$title' ($format): total palabras leídas -> $wordCount");
    }
}

