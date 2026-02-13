package com.castellanoapp.analisis

// Rasgos gramaticales básicos
enum class Genero { MASCULINO, FEMENINO, NEUTRO, NO_APLICA }
enum class Numero { SINGULAR, PLURAL }

// Rasgos específicos del Verbo (Capítulo 2)
enum class Persona { PRIMERA, SEGUNDA, TERCERA, NO_APLICA }
enum class Tiempo { PRESENTE, PASADO, FUTURO, NO_APLICA }

/**
 * CATEGORÍAS GRAMATICALES (Actualizado Cap 6)
 */
enum class Categoria {
    SUSTANTIVO, ADJETIVO, VERBO, PRONOMBRE, 
    PREPOSICION, CONJUNCION, ADVERBIO, DETERMINANTE
}

/**
 * FUNCIONES SINTÁCTICAS (Actualizado Cap 6)
 */
enum class FuncionSintactica {
    NUCLEO, 
    MODIFICADOR_DIRECTO, 
    COMPLEMENTO_DIRECTO, 
    COMPLEMENTO_INDIRECTO, 
    CIRCUNSTANCIAL,
    ENLACE // <-- Para las preposiciones y conjunciones
}

// Estructura de una palabra analizada (Finalizada para análisis simple)
data class AnalisisPalabra(
    val texto: String,
    val categoria: Categoria,
    val genero: Genero = Genero.NO_APLICA,
    val numero: Numero,
    val persona: Persona = Persona.NO_APLICA,
    val tiempo: Tiempo = Tiempo.NO_APLICA
)
