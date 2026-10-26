package org.danielcastelao.dam

fun mostrar(halo: Halo) {
    println("Estado: ${halo.estado_actual.nombre} | Nivel ${halo.nivel_actual.valor}")
}

    fun main() {
        val halo = Halo()

        println("- Inicio -")
        mostrar(halo)

        println("- Idle , Subir , Idle -")
        halo.nivel_1()
        mostrar(halo)
        halo.llegar()
        mostrar(halo)

        println("- Idle , Bajar , Idle -")
        halo.nivel_0()
        mostrar(halo)
        halo.llegar()
        mostrar(halo)

        println ("- Subir , Error -")
        halo.fallo()
        mostrar(halo)

    }