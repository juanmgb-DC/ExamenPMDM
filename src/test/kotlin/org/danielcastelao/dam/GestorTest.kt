package org.danielcastelao.dam

import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GestorTest {

    private var halo = Halo()
    @AfterTest
    fun restaurarEstado() {
       halo = Halo()
    }

    @Test
    fun `el nivel es 0 cuando el estado es Idle`() {
        assertEquals(Estados.Idle,halo.estado_actual)
        assertEquals(0, halo.nivel_actual.valor)
    }

    @Test
    fun `el nivel es 2 cuando el estado es MovingUP`() {
        halo.nivel_1()

        assertEquals(Estados.MovingUP,halo.estado_actual)
        assertEquals(2, halo.nivel_actual.valor)
    }

    @Test
    fun `el nivel es 2 cuando el estado es MovingDOWN`() {
        halo.nivel_1()
        halo.llegar()
        halo.nivel_0()

        assertEquals(Estados.MovingDOWN, halo.estado_actual)
        assertEquals(2, halo.nivel_actual.valor)
    }

    @Test
    fun `el nivel es -1 cuando el estado es Error`() {
        halo.fallo()

        assertEquals(Estados.Error, halo.estado_actual)
        assertEquals(-1, halo.nivel_actual.valor)
    }
}
