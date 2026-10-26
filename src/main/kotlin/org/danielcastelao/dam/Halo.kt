package org.danielcastelao.dam

enum class Nivel(val valor: Int) {
    avenida(0),
    plaza(1),
    movimiento(2),
    error(-1)
}

class Halo {
    val nivel_actual: Nivel = Nivel.avenida
        private set

    var estado_actual: Estados = Estados.Idle
        private set

    fun nivel_0() {
        if (estado_actual is Estados.Idle && nivel_actual == Nivel.plaza) {
            estado_actual = Estados.MovingDOWN
            nivel_actual = Nivel.movimiento
        }
    }

    fun nivel_1() {
        if (estado_actual is Estados.Idle && nivel_actual == Nivel.avenida) {
            estado_actual = Estados.MovingUP
            nivel_actual = Nivel.movimiento
        }
    }

    fun llegar() {
        when (estado_actual) {
            is Estados.MovingUP -> {
                nivel_actual = Nivel.plaza
                cambiarEstado(Estados.Idle)
            }
            is Estados.MovingDOWN -> {
                nivel_actual = Nivel.avenida
                cambiarEstado(Estados.Idle)
            }
        }
    }

    fun fallo() = cambiarEstado(Estados.Error)

}