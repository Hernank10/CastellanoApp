package com.castellanoapp.analisis

/**
 * Define si el componente es una palabra única o una estructura anidada
 */
sealed class ElementoOracional {
    data class Palabra(val analisis: AnalisisPalabra) : ElementoOracional()
    data class Subordinada(val oracion: Oracion) : ElementoOracional()
}

/**
 * Asigna la función sintáctica al elemento (sea palabra u oración)
 */
data class ComponenteOracional(
    val elemento: ElementoOracional,
    val funcion: FuncionSintactica
)

/**
 * El Sintagma organiza los componentes (pueden ser muchos o uno solo)
 */
data class Sintagma(
    val tipo: String, // "NOMINAL" o "VERBAL"
    val componentes: List<ComponenteOracional>
) {
    // Busca el núcleo (palabra) dentro del sintagma para validaciones de concordancia
    fun obtenerNucleo(): AnalisisPalabra? {
        val componenteNucleo = componentes.find { it.funcion == FuncionSintactica.NUCLEO }
        return (componenteNucleo?.elemento as? ElementoOracional.Palabra)?.analisis
    }
}

/**
 * La Oración ahora puede ser una entidad independiente o parte de otra
 */
data class Oracion(
    val sujeto: Sintagma,
    val predicado: Sintagma,
    val nexo: String? = null // Para el "QUE" de las sustantivas
)
