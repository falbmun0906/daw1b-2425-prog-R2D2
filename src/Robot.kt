class Robot(private val nombre: String) {

    var posX: Int = 0
    var posY: Int = 0
    var direction = Direcciones.POSITIVEY

    constructor(nombre: String, posX: Int, posY: Int, direccion: Direcciones) : this(nombre) {
        this.posX = posX
        this.posY = posY
        this.direction = direccion
    }

    fun mover(movimientos: Array<Int>) {
        when (this.nombre) {
            "R2D2" -> {}
            "DAW1A" -> {}
            "DAW1B" -> {}
            "DAM1" -> {}
        }

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