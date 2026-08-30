package unidad5

import java.util.Random

class Libro(val title: String, val author: String, val year: Int, var pages: Int = 100) {

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }


    //4
    companion object {
        const val BASE_URL = "popusitas.net/"
    }
}
    //1
    const val MAX_NUMBER_BOOKS = 20

    //2
    fun canBorrow(hasBooks: Int): Boolean {
        return (hasBooks < MAX_NUMBER_BOOKS)
    }

    //3
    object Constants {
        const val BASE_URL = "popusitas.net/sobreEllas"
    }



fun libros1(){
    val libro = Libro("Romeon and Juliet", "William Shakespeare", 1597)
    val libroAutor = libro.getTitleAuthor()
    val libroAutorAño = libro.getTitleAuthorYear()

    println("Here is your book ${libroAutor.first} by ${libroAutor.second}")

    println("Here is your book ${libroAutorAño.first} " +
            "by ${libroAutorAño.second} written in ${libroAutorAño.third}")

}

fun masLibros(){
    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })
    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)

}

fun Libro.weight(): Double {
    return pages * 1.5
}

fun Libro.tornPages(torn: Int) {
    if (pages >= torn) {
        pages -= torn
    } else {
        pages = 0
    }
}

class Cachorro {
    private val random = Random()

    fun playWithBook(book: Libro) {
        // Genera un número aleatorio de páginas a romper entre 1 y 12
        val torn = random.nextInt(12) + 1
        book.tornPages(torn)
        println("El cachorro rompio $torn paginas, quedan ${book.pages} paginas (Peso: ${book.weight()} g)")
    }
}

fun librosYAsi(){

    val miLibro = Libro("Kotlin Programming", "JetBrains", 2023, 50)
    val cachorro = Cachorro()
    println("Libro inicial: '${miLibro.title}' con ${miLibro.pages} paginas (Peso: ${miLibro.weight()} g)\n")
    while (miLibro.pages > 0) {
        cachorro.playWithBook(miLibro)
    }

    println("\n paginas restantes: ${miLibro.pages}")
}


fun main(args: Array<String>) {

   libros1();
    println("---------------------------------------")
    masLibros();
    println("---------------------------------------")
    librosYAsi();



}