# Project Overview

En este proyecto debes crear una aplicación que sea un juego de preguntas (tipo trivial).

El juego presentará al usuario un conjunto de preguntas en secuencia, que éste irá contestando hasta llegar al final.
Las preguntas pueden estar clasificadas por categorías.
El usuario deberá seleccionar la respuesta correcta de entre cuatro opciones.

La aplicación tendrá varias pantallas con una navegación entre sí que harán que el usuario tenga una experiencia confortable.
La aplicación deberá tener un estilo propio que debe seguirse a lo largo de las diversas pantallas.

La aplicación constará de una única Activity.
La aplicación utilizará la arquitectura MVVM.

En total tendrán 30 preguntas. 10 por categoría de dificultad (Easy/Medium/Hard).
1 respuesta correcta y 3 incorrectas por pregunta.

## Wireframes

### Launch Screen
Esta pantalla es lo que se llama Splash screen.
Muestra una imagen de marca de tu aplicación antes de cargar la interfaz de usuario.

### Menu Screen
Es la primera pantalla de la aplicación.
El usuario puede empezar una nueva partida, seleccionando el nivel de dificultad.

### Game Screen
El juego constará de varias rondas, en cada una de ellas se mostrará una pregunta.
Cuando el usuario conteste a la pregunta, pasará a la siguiente.
Debe haber un tiempo atrás que, cuando acabe, pase a la siguiente pregunta aunque el usuario no haya contestado.

### Result Screen
A esta pantalla se llega cuando se contesta la última pregunta de la partida (o termina el tiempo).
Debe contener el resultado de la partida.
Además, el usuario tendrá la opción de compartir su resultado o de volver a la pantalla de menú.