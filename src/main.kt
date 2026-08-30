import aquarium.Aquarium
import unidad4.Book
import unidad4.Curry
import unidad4.Pepper
import unidad4.Spice
import unidad4.Spice2
import unidad4.eBook
import unidad4.makeSalt
import unidad4.simpleSpice


import java.lang.IO.println

fun main() {
    println("Hello, ${World.get()}!")

    val especias = simpleSpice();
    println("la especias es ${especias.nombre} con un pico de nivel ${especias.picor} y un heat de ${especias.heat}")

    println("--------------------------------------------------------")

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

    println("--------------------------------------------------------")
    val physicalBook = Book("Cien anos de soledad", "Gabriel García Márquez");
    physicalBook.readPage();
    physicalBook.readPage();

    val digitalBook = eBook("Clean Code", "Robert C. Martin");
    digitalBook.readPage();
    digitalBook.readPage();
    println("--------------------------------------------------------")

    val curryAmarillo = Curry(spiciness = "medium")
    val curryPicante = Curry(spiciness = "spicy")
    curryAmarillo.prepareSpice()

    println("Nombre: ${curryAmarillo.name}")
    println("Nivel de heat: ${curryAmarillo.heat}")
    println("Color enum: ${curryAmarillo.color}")
    println("Color RGB (decimal): ${curryAmarillo.color.rgb}")
    println("Color RGB (hexadecimal): #${curryAmarillo.color.rgb.toString(16).uppercase()}")

    val especias2: List<Spice2> = listOf(curryAmarillo, curryPicante)

    for (especia in especias2) {
        when (especia) {
            is Curry -> println("${especia.name} es un tipo de Curry listo para moler.")
            // Al ser sealed class, no necesitas 'else' si cubres todas las subclases
            is Pepper -> println("${especia.name} es pimienta, lista para triturar.")
        }
    }

}

fun buildAquarium() {
    val myAquarium = Aquarium();

    println("el largo del acuario es: ${myAquarium.length}")
    myAquarium.length = 10;

    println("el volumen de mi acuario es: ${myAquarium.volume()}")
}

