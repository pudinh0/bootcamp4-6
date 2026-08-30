package unidad5

open class MaterialesBase(val cantidadNecesitada: Int = 1)

class Madera : MaterialesBase(cantidadNecesitada = 4)

class Ladrillo : MaterialesBase(cantidadNecesitada = 8)

// 2. Clase genérica con
class Building<out T : MaterialesBase>(val material: T) {

    val MaterialBase: Int = 100

    val materialActualNecesitado: Int
        get() = MaterialBase * material.cantidadNecesitada

    fun build() {
        println("$materialActualNecesitado ${material::class.simpleName} necesitado")
    }
}

//3
fun <T : MaterialesBase> isSmallBuilding(building: Building<T>) {
    if (building.materialActualNecesitado < 500) {
        println("edificio pequeño")
    } else {
        println("edificio grande")
    }
}



fun main() {
    val woodBuilding = Building(Madera())
    woodBuilding.build()

    val brickBuilding = Building(Ladrillo())
    brickBuilding.build()

    isSmallBuilding(woodBuilding)

}