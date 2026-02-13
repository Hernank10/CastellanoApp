package com.castellanoapp.analisis

class MotorAnalisis {

    /**
     * CAPÍTULO 1: Concordancia Nominal (Sustantivo + Adjetivo)
     */
    fun verificarConcordanciaNominal(sustantivo: AnalisisPalabra, adjetivo: AnalisisPalabra): Boolean {
        val coinciden = sustantivo.genero == adjetivo.genero && 
                        sustantivo.numero == adjetivo.numero
        
        imprimirResultado(coinciden, "${sustantivo.texto} + ${adjetivo.texto}")
        return coinciden
    }

    /**
     * CAPÍTULO 2: Concordancia Verbal (Sujeto + Verbo)
     */
    fun verificarSujetoVerbo(sujeto: AnalisisPalabra, verbo: AnalisisPalabra): Boolean {
        // La regla de oro: Sujeto y Verbo deben coincidir en PERSONA y NÚMERO
        val coinciden = sujeto.persona == verbo.persona && 
                        sujeto.numero == verbo.numero
        
        imprimirResultado(coinciden, "Sujeto: ${sujeto.texto} -> Verbo: ${verbo.texto}")
        return coinciden
    }

    private fun imprimirResultado(exito: Boolean, info: String) {
        if (exito) {
            println("✅ OK: $info")
        } else {
            println("❌ ERROR de concordancia: $info")
        }
    }
}
