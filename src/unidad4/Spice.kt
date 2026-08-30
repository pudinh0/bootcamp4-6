package unidad4



// 1. Enum class Color con valor RGB y la constante YELLOW añadida
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}

// 2. Interfaz SpiceColor usando el tipo enum Color
interface SpiceColor {
    val color: Color
}

// 3. Singleton YellowSpiceColor con la constante Color.YELLOW
object YellowSpiceColor : SpiceColor {
    override val color: Color = Color.YELLOW
}

interface Grinder {
    fun grind()
}

// 4. Spice convertida en Sealed Class (Clase Sellada)
sealed class Spice2(
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor = YellowSpiceColor
) : SpiceColor by color {

    val heat: Int
        get() = when (spiciness.lowercase()) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }

    init {
        println("Especia creada -> Nombre: $name, Picante: $spiciness, Heat: $heat, Color: $color (${color.color.rgb})")
    }

    abstract fun prepareSpice()
}

// Subclases de Spice dentro del mismo paquete/archivo
class Curry(
    name: String = "Curry",
    spiciness: String,
    color: SpiceColor = YellowSpiceColor
) : Spice2(name, spiciness, color), Grinder {

    override fun grind() {
        println("Moliendo $name...")
    }

    override fun prepareSpice() {
        grind()
    }
}

class Pepper(
    spiciness: String = "spicy"
) : Spice2("Pepper", spiciness) {
    override fun prepareSpice() {
        println("Triturando pimienta...")
    }
}

fun main() {
    val curry = Curry(spiciness = "medium")
    println("Color RGB del curry: #${curry.color.rgb.toString(16)}")
}