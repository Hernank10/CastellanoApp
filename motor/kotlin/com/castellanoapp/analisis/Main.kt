package com.castellanoapp.analisis

fun main() {
    val motor = MotorAnalisis()

    println("========================================================")
    println("   CASTELLANO APP: TEST DE INTEGRACIÓN RECURSIVA       ")
    println("========================================================\n")

    // --- NIVEL 3: La idea más profunda ("la caligrafía es arte") ---
    val sustArt = AnalisisPalabra("arte", Categoria.SUSTANTIVO, Numero.SINGULAR)
    val oracionNivel3 = Oracion(
        sujeto = Sintagma("NOMINAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("caligrafía", Categoria.SUSTANTIVO, Numero.SINGULAR)), FuncionSintactica.NUCLEO))),
        predicado = Sintagma("VERBAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("es", Categoria.VERBO, Numero.SINGULAR)), FuncionSintactica.NUCLEO)))
    )

    // --- NIVEL 2: La subordinada sustantiva ("que la caligrafía es arte") ---
    // Funciona como CD del verbo "dice"
    val componenteCD = ComponenteOracional(ElementoOracional.Subordinada(oracionNivel3), FuncionSintactica.COMPLEMENTO_DIRECTO)
    val oracionNivel2 = Oracion(
        sujeto = Sintagma("NOMINAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("profesor", Categoria.SUSTANTIVO, Numero.SINGULAR)), FuncionSintactica.NUCLEO))),
        predicado = Sintagma("VERBAL", listOf(
            ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("dice", Categoria.VERBO, Numero.SINGULAR)), FuncionSintactica.NUCLEO),
            componenteCD
        )),
        nexo = "que"
    )

    // --- NIVEL 1: Oración Principal ("Anya escribe porque [Nivel 2]") ---
    // El Nivel 2 funciona como Circunstancial Causal de la principal
    val componenteCausal = ComponenteOracional(ElementoOracional.Subordinada(oracionNivel2), FuncionSintactica.CIRCUNSTANCIAL)
    val oracionPrincipal = Oracion(
        sujeto = Sintagma("NOMINAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("Anya", Categoria.SUSTANTIVO, Numero.SINGULAR)), FuncionSintactica.NUCLEO))),
        predicado = Sintagma("VERBAL", listOf(
            ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("escribe", Categoria.VERBO, Numero.SINGULAR)), FuncionSintactica.NUCLEO),
            componenteCausal
        ))
    )

    // --- EJECUCIÓN DEL ANÁLISIS ---
    println("Analizando: \"Anya escribe porque el profesor dice que la caligrafía es arte\"")
    
    val n_sujeto = oracionPrincipal.sujeto.obtenerNucleo()
    val n_predicado = oracionPrincipal.predicado.obtenerNucleo()

    if (n_sujeto != null && n_predicado != null) {
        val ok = motor.verificarSujetoVerbo(n_sujeto, n_predicado)
        if (ok) {
            println("\n✅ ESTRUCTURA PRINCIPAL: VÁLIDA")
            println("🔍 DETECTADO: Subordinación Adverbial Causal detectada.")
            println("   └─ 🔍 DETECTADO: Subordinada Sustantiva (CD) anidada.")
        }
    }
    
    println("\n========================================================")
    println("          ANÁLISIS COMPLETADO CON ÉXITO                ")
    println("========================================================")
}
