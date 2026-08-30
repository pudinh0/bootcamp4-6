package unidad6

// 1. Función de extensión de orden superior sobre List<Int>
fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}

fun main() {
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    // 2. Invocación pasando la lambda que calcula el residuo con módulo 3 (%)
    val divisiblesPor3 = numbers.divisibleBy { it % 3 }

    println(divisiblesPor3) // Salida: [3, 6, 9, 0]
}