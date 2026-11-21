# Bitacora de tecnicas avanzadas

Laboratorio 07: Tecnicas Avanzadas de Prompting.

Herramienta de IA usada: Gemini

## Ejercicio 2: Zero-shot, one-shot y few-shot

| Tipo | Aciertos (de 5) | Formato de la respuesta | Todas con el mismo formato (Si/No) |
|---|---|---|---|
| Zero-shot | 5 | Lista numerada con texto introductorio y negritas | No |
| One-shot | 5 | Lista numerada usando flecha -> sin comillas | No |
| Few-shot | 5 | Lineas exactas con "comentario" -> Etiqueta sin texto extra | Si |

## Ejercicio 3: Chain of Thought

| Pedido | Respuesta de la IA | Muestra los pasos (Si/No) | Correcta (Si/No) |
|---|---|---|---|
| Directo | 318.60 | No | Si |
| Paso a paso | 318.60 (muestra cada operacion) | Si | Si |

Ver el razonamiento paso a paso permite auditar cada calculo y confirmar que la IA aplico bien el orden de las operaciones (primero el descuento y luego el IGV), en lugar de confiar a ciegas en un numero. Ademas, si llega a existir un error, facilita identificar exactamente en que paso fallo.

## Ejercicio 4: Role prompting

| Version | Vocabulario (sencillo/tecnico) | Usa ejemplos o codigo | A quien le sirve mas |
|---|---|---|---|
| A. Sin rol | Intermedio (mixto) | Si, un ejemplo basico general | Estudiantes con nociones basicas |
| B. Rol docente | Sencillo | Si, comparaciones de la vida diaria (ej. una caja con etiqueta) | Personas que nunca han programado |
| C. Rol senior | Tecnico | Si, conceptos de memoria, tipo de dato y codigo Java | Desarrolladores o companeros de equipo |

## Ejercicio 5: Descomposicion

- **Paso 1 (Requisitos):** Entrego una lista clara con los 5 requisitos funcionales principales del sistema de inventario.
- **Paso 2 (Diseno de clases):** Propuso las clases necesarias indicando cada atributo con su tipo de dato correspondiente en Java.
- **Paso 3 (Codigo de Producto):** Genero el codigo Java de la clase Producto coherente con los atributos del diseno, incluyendo constructor, getters y setters.
- **Paso 4 (Revision y mejoras):** Analizo el codigo creado y propuso 3 mejoras concretas (como validaciones de datos y metodo toString).
- **Comparacion con el pedido de una sola vez:** A diferencia del pedido directo que genero una respuesta muy extensa y generica, dividir la tarea permitio controlar cada etapa y obtener codigo coherente con un diseno previo.

## Ejercicio 6: Prompt estructurado y autocritica

| Qué revisar | Cumple (Si/No) |
|---|---|
| ¿Tiene las 4 columnas pedidas? | Si |
| ¿Incluye el bloqueo después de 3 intentos? | Si |
| ¿Incluye casos con campos vacíos? | Si |
| ¿Indica qué casos agregó en la autocrítica? | Si |
| ¿Hay algún caso repetido o que no tenga sentido? | No |

### Prompts utilizados

```text
<rol>Actua como analista de pruebas de software.</rol>
<contexto>Login web con correo y contrasena. La cuenta se bloquea
despues de 3 intentos fallidos.</contexto>
<tarea>Piensa paso a paso que puede fallar y escribe 6 casos de prueba.</tarea>
<formato>Tabla con las columnas: ID, escenario, datos de entrada,
resultado esperado.</formato>

--- Mensaje de autocritica ---
Revisa tu tabla: faltan casos limite como campos vacios, correo sin @
o contrasena con espacios? Agrega los que falten e indica cuales agregaste.
```