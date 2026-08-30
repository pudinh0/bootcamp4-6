package unidad6

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game {
    var path = mutableListOf(Directions.START)

    // Lambdas de dirección (retornan Boolean)
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }

    val end = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()
        false
    }

    // 1 y 2. Función de orden superior que invoca el lambda recibido
    fun move(where: () -> Boolean) {
        where()
    }

    // 3 y 4. Evalúa la entrada y llama a move() con la lambda adecuada
    fun makeMove(direction: String?) {
        when (direction?.trim()?.lowercase()) {
            "w" -> move(north)
            "s" -> move(south)
            "d" -> move(east)
            "a" -> move(west)
            else -> move(end)
        }
    }
}

fun main() {
    val game = Game()

    // 5 a 7. Bucle infinito que lee la entrada del usuario
    while (true) {
        print("Enter a direction: a/s/w/d: ")
        val input = readlnOrNull()
        game.makeMove(input)

        // Se detiene cuando se llama a 'end', ya que vacía la lista
        if (game.path.isEmpty()) {
            break
        }
    }
}