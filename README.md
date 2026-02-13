# 🖋️ CastellanoApp - Motor de Análisis Sintáctico

**CastellanoApp** es una herramienta educativa diseñada para la enseñanza de la gramática y la caligrafía artística. El núcleo del proyecto es un motor de análisis morfosintáctico desarrollado en **Kotlin**, capaz de procesar estructuras gramaticales complejas y subordinación recursiva.

## 🚀 Capacidades del Motor
El sistema utiliza una arquitectura de árboles sintácticos para validar:
* **Concordancia Sujeto-Verbo**: Verificación de número y persona.
* **Subordinación Sustantiva**: Cláusulas que funcionan como Complemento Directo (CD).
* **Subordinación Adverbial**: Cláusulas causales y circunstanciales.
* **Recursividad**: Capacidad de anidar oraciones dentro de oraciones indefinidamente.

## 📂 Estructura del Proyecto
* `/motor`: Lógica central en Kotlin (Modelos de datos y Motor de Análisis).
* `/curso`: Contenido pedagógico y lecciones de gramática.

## 🛠️ Cómo ejecutar el Test de Integración
Para probar el motor con la frase *"Anya escribe porque el profesor dice que la caligrafía es arte"*:

1. **Compilar el motor:**
   \`\`\`bash
   cd motor/kotlin/com/castellanoapp/analisis/
   kotlinc *.kt -include-runtime -d MotorCastellano.jar
   \`\`\`

2. **Ejecutar el análisis:**
   \`\`\`bash
   java -jar MotorCastellano.jar
   \`\`\`

---
Desarrollado por **Hernank10** | 2026
