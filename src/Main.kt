import kotlin.random.Random

fun main() {

    // PARTE 1
    println("""PARTE 1
        **********************************************************""")

    /*var dir = Direcciones.DERECHA

    dir = if (dir.ordinal < Direcciones.entries.size - 1) Direcciones.entries[dir.ordinal + 1] else Direcciones.entries[0]
    println(dir)*/

    val robots1 = listOf(Robot("R2D2"), Robot("Arturito"))

    val movimientos1: Map<String, Array<Int>> = mapOf(
        "1" to arrayOf(10, 5, -2),
        "2" to arrayOf(0, 0, 0),
        "3" to arrayOf(),
        "4" to arrayOf(-10, -5, 2),
        "5" to arrayOf(-10, -5, 2, 4, -8)
    )

    val movimientos2: Map<String, Array<Int>> = mapOf(
        "1" to arrayOf(1, -5, 0, -9),
        "2" to arrayOf(3, 3, 5, 6, 1, 0, 0, -7),
        "3" to arrayOf(2, 1, 0, -1, 1, 1, -4),
        "4" to arrayOf(),
        "5" to arrayOf(3, 5)
    )

    println("\nMOVIENDO A R2D2:\n")

    for (movimiento in movimientos1.values) {
        robots1[0].mover(movimiento)
        println(robots1[0])
    }

    println("\nMOVIENDO A ARTURITO:\n")

    for (movimiento in movimientos2.values) {
        robots1[1].mover(movimiento)
        println(robots1[1])
    }

// PARTE 2

    val robots2: List<Robot> = listOf(
        /*Robot("R2D2", 0, 0, Direcciones.POSITIVEY),
        Robot("DAW1A", Random.nextInt(-5, 5), 0, Direcciones.POSITIVEX),
        Robot("DAW1B",0, Random.nextInt(-10, 10), Direcciones.entries.random()),
        Robot("DAM1", Random.nextInt(-5, 5), Random.nextInt(-5, 5), Direcciones.entries.random())*/

        Robot("R2D2"),
        Robot("DAW1A"),
        Robot("DAW1B"),
        Robot("DAM1")
    )

    for (robot in robots2) {
        for (movimiento in movimientos2.values)
        robot.mover(movimiento)
        println("POSICION FINAL:\n\t$robot")
    }
}