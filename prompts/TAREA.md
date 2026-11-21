# Tarea: Mi prompt avanzado

## Tarea elegida

Generar casos de prueba funcionales y de borde en formato tabla para validar un formulario web de registro de usuarios.

## Version 1: prompt basico

```text
Dame casos de prueba para un registro de usuarios.
```

* **Tecnica agregada:** Ninguna (solo una instruccion directa sin contexto ni formato).
* **Por que:** Para tener un punto de partida y observar como responde la IA sin restricciones.
* **Que mejoro en la respuesta:** Genero ideas generales de prueba, pero en una lista desordenada y sin reglas reales de validacion.

## Version 2

```text
<rol>Actua como ingeniero QA senior especializado en aplicaciones web.</rol>
<contexto>Formulario de registro de usuarios con los campos: nombre completo, correo electronico, contrasena (minimo 8 caracteres y un numero) y confirmacion de contrasena.</contexto>
<tarea>Piensa paso a paso en los posibles errores del usuario y genera 5 casos de prueba.</tarea>
<formato>Tabla con las columnas: ID | Escenario | Datos de entrada | Resultado esperado</formato>
```

* **Tecnica agregada:** Role prompting (rol especifico de ingeniero QA senior), Prompt estructurado (etiquetas XML separadoras) y Chain of Thought ("piensa paso a paso").
* **Por que:** En la version 1 la IA no sabia que campos existian ni entregaba una tabla lista para documentacion de pruebas.
* **Que mejoro en la respuesta:** Organizo los 5 casos en una tabla de 4 columnas con vocabulario tecnico de QA y validaciones acordes a los requisitos.

## Version 3: prompt final

```text
<rol>Actua como ingeniero QA senior especializado en aplicaciones web.</rol>
<contexto>Formulario de registro de usuarios con los campos: nombre completo, correo electronico, contrasena (minimo 8 caracteres y un numero) y confirmacion de contrasena.</contexto>
<tarea>Piensa paso a paso en los posibles errores del usuario y genera 6 casos de prueba (positivos y negativos).</tarea>
<ejemplos>
Sigue exactamente el estilo de redaccion de estas filas:
| TC-01 | Registro exitoso con datos validos | Nombre: Ana Diaz, Correo: ana@mail.com, Pass: Clave1234, Confirm: Clave1234 | Cuenta creada y redireccion al inicio |
| TC-02 | Contrasena menor a 8 caracteres | Nombre: Luis Paz, Correo: luis@mail.com, Pass: Abc12, Confirm: Abc12 | Error: "La contrasena debe tener minimo 8 caracteres" |
</ejemplos>
<formato>Entrega unicamente una tabla Markdown con las columnas: ID | Escenario | Datos de entrada | Resultado esperado. Al final, revisa tu propia tabla (autocritica) para verificar que no falte probar correos duplicados ni contrasenas que no coincidan; si falta alguno, agregalo e indica cual fue.</formato>
```

* **Tecnica agregada:** Few-shot (2 ejemplos de filas formateadas) y Autocritica (revision final de casos faltantes).
* **Por que:** Faltaba uniformidad en la redaccion de los datos de entrada y asegurar que no se omitieran escenarios criticos de borde.
* **Que mejoro en la respuesta:** Estandarizo el formato exacto de cada celda (IDs `TC-01`, `TC-02`...) y verifico la cobertura de correos duplicados y confirmacion de contrasena.

## Tecnicas usadas en el prompt final

| Tecnica | Parte del prompt final donde se aplica |
|---|---|
| Role prompting | `<rol>Actua como ingeniero QA senior especializado en aplicaciones web.</rol>` |
| Prompt estructurado | Uso de las etiquetas `<rol>`, `<contexto>`, `<tarea>`, `<ejemplos>` y `<formato>` para separar instrucciones. |
| Chain of Thought | `<tarea>Piensa paso a paso en los posibles errores del usuario y genera 6 casos de prueba...</tarea>` |
| Few-shot | Bloque `<ejemplos>` con las dos filas modelo (`TC-01` y `TC-02`) que fijan la estructura de cada celda. |
| Autocritica | `Al final, revisa tu propia tabla (autocritica) para verificar que no falte probar correos duplicados ni contrasenas que no coincidan...` |

## Evaluacion del resultado

| Criterio | Cumple (Si/No) |
|---|---|
| Usa un rol especifico (ingeniero QA senior) y no uno vago | Si |
| Respeta las 4 columnas y el estilo de los ejemplos few-shot | Si |
| Incluye tanto casos positivos como negativos de validacion | Si |
| Ejecuta la autocritica verificando correo duplicado y contrasenas distintas | Si |

## Por que elegi estas tecnicas

Elegi combinar Role prompting, Prompt estructurado, Chain of Thought, Few-shot y Autocritica porque las pruebas de software requieren precision tecnica, cobertura de errores y un formato tabular uniforme. El rol y el razonamiento paso a paso ayudan a detectar fallos reales del usuario, las etiquetas evitan que las reglas del formulario se mezclen, los ejemplos aseguran que todas las filas mantengan exactamente la misma estructura y la autocritica actua como filtro final para no dejar escenarios criticos fuera.