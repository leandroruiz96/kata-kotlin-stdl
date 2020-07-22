# Kotlin STDL

La kata consta de tres ejercicios en las que el código está escrito como una traducción directa de código Java 8. La idea de los ejercicios no es llegar a un resultado sino que ahonden en la documentación de Kotlin para descubrir las soluciones idiomáticas que propone el lenguaje. Es uno de esos casos donde el viaje vale más que el destino.

El orden de los ejercicios es indistinto, cada uno abarca temas casi disjuntos. Sin embargo, recomendaría empezar por `scoped`, luego por `collections` y por último `comparisons`. Todo esta pensado para que lo hagan de manera intuitiva primero y luego miren la documentación del lenguaje para ver si Kotlin propone alguna solución propia. En todo caso, si se sienten trabados o les da curiosidad pueden ver el package `proposed` para ver la solución propuesta (no tiene por qué ser la mejor solución!).

Notar que ninguno de los ejercicios está pensado para que analicen absolutamente todo el código, cada ejercicio tiene un dominio completamente distinto y no vale la pena revisarlo. **No es una kata de refactor.**

## Scoped

La idea de este ejercicio es identificar cuándo usar `let`, `run`, `apply` y `with`. Miren el código de `Message.kt` y de `OneTimePad.kt`. Analicen si es aplicable, en dónde y si es mejor aplicarlo o no.

Pueden usar de referencia [la documentación de kotlin](https://kotlinlang.org/docs/reference/scope-functions.html) sobre scoped functions o como extra este [post en Medium](https://medium.com/mobile-app-development-publication/mastering-kotlin-standard-functions-run-with-let-also-and-apply-9cd334b0ef84).

Cosas a considerar:
- Cómo explicarían cuándo usar cada función?
- Mejora el código o empeora su legibilidad?
- Dado que las cuatro funciones se comportan igual, para qué tenemos diferentes funciones?
- Miren la versión propuesta. Es un abuso de las funciones?

## Collections

En este ejercicio lo importante son las funciones sobre collections que ofrece Kotlin. Pueden la [documentacion sobre Collections](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/) para ver cuáles son. De ser necesario, reemplacen lo que les parezca mejor.

Para reflexionar:
- Todas las soluciones fueron mejores? Aplican siempre?
- Usaron secuencias? Por qué?
- Usaron diferentes versiones de la misma función? Por ejemplo, `filter`y `filterNotNull`. Valen la pena?

Bonus track: en el archivo `Grade.kt` se puede hacer una ligera mejora con funciones de rango.

## Comparisons

Al igual que en el anterior ejercicio, la idea es revisar la [documentación sobre comparadores](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.comparisons/) y reemplazar en el código de `FileRepository.kt` lo que sientan que ya está resuelto por la biblioteca estándar del lenguaje.

Otras preguntas:
- El IDE se da cuenta en estos casos que estamos intentando hacer cosas que no son propias del lenguaje Kotlin, pero está dando la mejor solución?
- Sienten que es mejor sobrecargar la interfaz `Comparable` o conviene usar siempre `Comparator`?
- Era más legible la anterior solución o la nueva? Considerar que ahora la compación está oculta detrás de la STDL de Kotlin.
- Fue mejor usar rangos o hacer la doble comparación?