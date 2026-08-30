package unidad4

import java.lang.IO.println

class simpleSpice {
    var nombre:String = "curry";
    var picor:String = "medio";
    var heat: Int = 0
        get() {return 5}

}


class Spice (val name: String="", val picor: String? = "mild"){
    val heat: Int
        get() = when (picor?.lowercase()) {
            "mild" -> 1
            "medium" -> 2
            "spicy" -> 3
            "very spicy" -> 4
            "extremely spicy" -> 5
            else -> 0
        }
    init {
        println("especia creada -> nombre $name, picor $picor, heat $heat")
    }

}

fun makeSalt() = Spice("salt", picor= "mild");
