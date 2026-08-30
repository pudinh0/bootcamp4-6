import aquarium.Aquarium
import unidad4.Book
import unidad4.Spice
import unidad4.eBook
import unidad4.makeSalt
import unidad4.simpleSpice


import java.lang.IO.println

fun main() {
    println("Hello, ${World.get()}!")

    val especias = simpleSpice();
    println("la especias es ${especias.nombre} con un pico de nivel ${especias.picor} y un heat de ${especias.heat}")

    val spices2 = listOf(
        Spice("Curry", "medium"),
        Spice("Pepper", "mild"),
        Spice("Cayenne", "spicy"),
        Spice("Ginger", "mild"),
        Spice("Red Curry", "very spicy"),
        Spice("Green Curry", "medium"),
        Spice("Habanero", "extremely spicy"),
        makeSalt()
    )


    val physicalBook = Book("Cien años de soledad", "Gabriel García Márquez");
    physicalBook.readPage();
    physicalBook.readPage();

    val digitalBook = eBook("Clean Code", "Robert C. Martin");
    digitalBook.readPage();
    digitalBook.readPage();
}

fun buildAquarium() {
    val myAquarium = Aquarium();

    println("el largo del acuario es: ${myAquarium.length}")
    myAquarium.length = 10;

    println("el volumen de mi acuario es: ${myAquarium.volume()}")
}

