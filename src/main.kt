package aquarium

import unidad4.simpleSpice

fun main() {
    println("Hello, ${World.get()}!")

    val especias = simpleSpice();
    println("la especias es ${especias.nombre} con un pico de nivel ${especias.picor} y un heat de ${especias.heat}")

}

fun buildAquarium() {
    val myAquarium = Aquarium();

    println("el largo del acuario es: ${myAquarium.length}")
    myAquarium.length = 10;

    println("el volumen de mi acuario es: ${myAquarium.volume()}")
}

