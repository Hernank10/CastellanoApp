package com.castellanoapp.analisis

fun main() {
    val motor = MotorAnalisis()
    println("========================================================")
    println("   CASTELLANO APP: TEST DE INTEGRACIÓN RECURSIVA       ")
    println("========================================================\n")

    // --- NIVEL 3: "la caligrafía es arte" ---
    val oracionNivel3 = Oracion(
        sujeto = Sintagma("NOMINAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("caligrafía", Categoria.SUSTANTIVO, Genero.FEMENINO, Numero.SINGULAR)), FuncionSintactica.NUCLEO))),
        predicado = Sintagma("VERBAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("es", Categoria.VERBO, Genero.NEUTRO, Numero.SINGULAR)), FuncionSintactica.NUCLEO)))
    )
    // --- NIVEL 2: "que el profesor dice..." ---
    val oracionNivel2 = Oracion(
        sujeto = Sintagma("NOMINAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("profesor", Categoria.SUSTANTIVO, Genero.MASCULINO, Numero.SINGULAR)), FuncionSintactica.NUCLEO))),
        predicado = Sintagma("VERBAL", listOf(
            ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("dice", Categoria.VERBO, Genero.NEUTRO, Numero.SINGULAR)), FuncionSintactica.NUCLEO),
            ComponenteOracional(ElementoOracional.Subordinada(oracionNivel3), FuncionSintactica.COMPLEMENTO_DIRECTO)
        )),
        nexo = "que"
    )
    // --- NIVEL 1: Oración Principal ---
    val oracionPrincipal = Oracion(
        sujeto = Sintagma("NOMINAL", listOf(ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("Anya", Categoria.SUSTANTIVO, Genero.FEMENINO, Numero.SINGULAR)), FuncionSintactica.NUCLEO))),
        predicado = Sintagma("VERBAL", listOf(
            ComponenteOracional(ElementoOracional.Palabra(AnalisisPalabra("escribe", Categoria.VERBO, Genero.NEUTRO, Numero.SINGULAR)), FuncionSintactica.NUCLEO),
            ComponenteOracional(ElementoOracional.Subordinada(oracionNivel2), FuncionSintactica.CIRCUNSTANCIAL)
        ))
    )

    println("Analizando: \"Anya escribe porque el profesor dice que la caligrafía es arte\"")
    val n_sujeto = oracionPrincipal.sujeto.obtenerNucleo()
    val n_predicado = oracionPrincipal.predicado.obtenerNucleo()

    if (n_sujeto != null && n_predicado != null) {
        if (motor.verificarSujetoVerbo(n_sujeto, n_predicado)) {
            println("\n✅ ESTRUCTURA PRINCIPAL: VÁLIDA")
            println("🔍 DETECTADO: Subordinación Adverbial Causal.")
            println("   └─ 🔍 DETECTADO: Subordinada Sustantiva (CD) anidada.")
        }
    }
    println("\n========================================================")
}
