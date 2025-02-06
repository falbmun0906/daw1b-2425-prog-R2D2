import kotlin.random.Random

class Robot(private val nombre: String) {

    var posX: Int = 0
    var posY: Int = 0
    var direction = Direcciones.POSITIVEY

    /*constructor(nombre: String, posX: Int, posY: Int, direccion: Direcciones) : this(nombre) {
        this.posX = posX
        this.posY = posY
        this.direction = direccion
    }*/

    init {
        configurarRobot()
    }

    fun configurarRobot() {
        when (this.nombre) {
            "R2D2" -> {
                posX = 0
                posY = 0
                direction = Direcciones.POSITIVEY
            }
            "DAW1A" -> {
                posX = Random.nextInt(-5, 5)
                posY = 0
                direction = Direcciones.POSITIVEX
            }
            "DAW1B" -> {
                posX = 0
                posY = Random.nextInt(-10, 10)
                direction = Direcciones.entries.random()
            }
            "DAM1" -> {
                posX = Random.nextInt(-5, 5)
                posY = Random.nextInt(-5, 5)
                direction = Direcciones.entries.random()
            }
        }
    }

    fun mover(movimientos: Array<Int>) {
        for (movimiento in movimientos) {
            when (direction) {
                Direcciones.POSITIVEY -> {
                    posY += movimiento
                }

                Direcciones.NEGATIVEX -> {
                    posX -= movimiento
                }

                Direcciones.NEGATIVEY -> {
                    posY -= movimiento
                }

                Direcciones.POSITIVEX -> {
                    posX += movimiento
                }
            }
            alternarDireccion()
        }
    }

    fun alternarDireccion() {
        when(this.nombre) {

            // R2D2 sigue igual, comienza en (0, 0) y PositiveY cuando se instancia el objeto y realiza un giro de -90º al detenerse en cada movimiento.

            "R2D2" -> {
                direction = when(direction) {
                Direcciones.POSITIVEY -> Direcciones.NEGATIVEX
                Direcciones.NEGATIVEX -> Direcciones.NEGATIVEY
                Direcciones.NEGATIVEY -> Direcciones.POSITIVEX
                Direcciones.POSITIVEX -> Direcciones.POSITIVEY
                }
            }

            // DAW1A comienza en una posición aleatoria entre -5 y 5 para x y en el eje y en 0. La dirección será PositiveX. Al detenerse, si su valor de la posición x es positiva gira 180º y si su valor de la posición x es negativa gira 90º.

            "DAW1A" -> {
                if (posX >= 0) {
                    direction = when(direction) {
                        Direcciones.POSITIVEY -> Direcciones.NEGATIVEY
                        Direcciones.NEGATIVEX -> Direcciones.POSITIVEX
                        Direcciones.NEGATIVEY -> Direcciones.POSITIVEY
                        Direcciones.POSITIVEX -> Direcciones.NEGATIVEX
                    }
                } else {
                    direction = when(direction) {
                        Direcciones.POSITIVEY -> Direcciones.POSITIVEX
                        Direcciones.NEGATIVEX -> Direcciones.POSITIVEY
                        Direcciones.NEGATIVEY -> Direcciones.NEGATIVEX
                        Direcciones.POSITIVEX -> Direcciones.NEGATIVEY
                    }
                }
            }

            // DAW1B comienza en la posición x = 0, pero la posición y es aleatoria entre -10 y 10. Su dirección inicial será aleatoria. La dirección que toma al detenerse será -90º si el valor de su posición y es positivo y 270º si el valor de su posición y es negativo.

            "DAW1B" -> {
                if (posY >= 0) {
                    direction = when(direction) {
                        Direcciones.POSITIVEY -> Direcciones.NEGATIVEX
                        Direcciones.NEGATIVEX -> Direcciones.NEGATIVEY
                        Direcciones.NEGATIVEY -> Direcciones.POSITIVEX
                        Direcciones.POSITIVEX -> Direcciones.POSITIVEY
                    }
                } else {
                    direction = when(direction) {
                        Direcciones.POSITIVEY -> Direcciones.NEGATIVEX
                        Direcciones.NEGATIVEX -> Direcciones.NEGATIVEY
                        Direcciones.NEGATIVEY -> Direcciones.POSITIVEX
                        Direcciones.POSITIVEX -> Direcciones.POSITIVEY
                    }
                }
            }

            // DAM1 comienza en en una posición aleatoria entre -5 y 5 en cada eje. La dirección inicial es aleatoria. Debe tomar una también una dirección totalmente aleatoria al detenerse entre cada movimiento, siempre que no sea la misma en la que estaba.

            "DAM1" -> {
                val direccionActual = direction
                do {
                    direction = Direcciones.entries.random()
                } while (direction == direccionActual)
            }
        }
    }

    fun obtenerPosicion(): String {
        return ("($posX, $posY)")
    }

    fun obtenerDireccion(): String {
        return "$direction"
    }

    override fun toString(): String {
        return "$nombre está en ${obtenerPosicion()} ${obtenerDireccion()}"
    }
}