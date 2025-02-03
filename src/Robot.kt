class Robot(private val nombre: String) {

    var posX: Int = 0
    var posY: Int = 0

    var direction = Direcciones.POSITIVEY

    fun mover(movimientos: Array<Int>) {
        for (movimiento in movimientos)
            when (direction) {
                Direcciones.POSITIVEY -> {
                    posY += movimiento
                    alternarDireccion()
                }
                Direcciones.NEGATIVEX -> {
                    posX -= movimiento
                    alternarDireccion()
                }
                Direcciones.NEGATIVEY -> {
                    posY -= movimiento
                    alternarDireccion()
                }
                Direcciones.POSITIVEX -> {
                    posX += movimiento
                    alternarDireccion()
                }
            }
    }

    fun alternarDireccion() {
        direction = when(direction) {
            Direcciones.POSITIVEY -> Direcciones.NEGATIVEX
            Direcciones.NEGATIVEX -> Direcciones.NEGATIVEY
            Direcciones.NEGATIVEY -> Direcciones.POSITIVEX
            Direcciones.POSITIVEX -> Direcciones.POSITIVEY
        }
    }

    fun obtenerPosicion(): String {
        return ("($posX, $posY)")
    }

    fun obtenerDireccion(): String {
        return "$direction"
    }

    override fun toString(): String {
        return "R2D2 está en ${obtenerPosicion()} ${obtenerDireccion()}"
    }
}