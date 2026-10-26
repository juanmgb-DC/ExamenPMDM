package org.danielcastelao.dam

sealed class Estados {

    abstract val nombre: String

    open fun enMovimiento(): Boolean = false

    open fun alEntrar() = println("Estado: $nombre")

    object Idle : Estados() {
        override val nombre = "En reposo"
        override fun enMovimiento() = false
    }

    object MovingUP : Estados() {
        override val nombre = "Subiendo"
        override fun enMovimiento() = true
    }

    object MovingDOWN : Estados() {
        override val nombre = "Bajando"
        override fun enMovimiento() = true
    }

    object Error : Estados() {
        override val nombre = "Error"
    }
}