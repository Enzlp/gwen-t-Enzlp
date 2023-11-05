# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**
El objetivo de este proyecto es crear una versión simplificada del juego Gwent (ver link de referencia más arriba), para esto se debió tomar en consideración el siguiente enunciado:

# 1. Descripción

El proyecto a realizar será crear un clon (simplificado) del juego de cartas Gwent desarrollado por CD Projekt RED. A grandes rasgos el juego tendrá dos jugadores, uno controlado por el usuario y otro controlado por la computadora. Cada jugador tendrá un mazo y una mano de cartas que puede jugar en un tablero en una partida al mejor de tres rondas. A continuación se explicarán en detalle los requisitos que debe cumplir su programa al finalizar el proyecto.

# 1.1. Jugador

Llamaremos jugador a cada uno de los participantes de una partida, estos serán controlados por un usuario y una
computadora.
Cada jugador tiene:

* **Nombre**: Es el identificador del jugador. Es una manera de distinguir a los distintos participantes en la partida.
* **Sección del tablero**: Es la zona del tablero que le corresponde al jugador. En ella, el jugador ubicará sus cartas.
* **Contador de gemas**: Es la cantidad de gemas que tiene el jugador. Estas gemas representan la «vida» del jugador.
* **Mazo de cartas**: Es el conjunto de cartas que tiene el jugador. Desde aquí, podrá robar cartas.
* **Mano de cartas**: Es el conjunto de cartas que el jugador tiene en su mano. Estas cartas pueden ser utilizadas para jugar durante la partida

Las acciones que un jugador puede realizar son:

* **Jugar una carta de su mano**: Seleccionar una carta de su mano y colocarla en el tablero para realizar una acción
* **Robar una carta del mazo**: Tomar una carta del mazo y agregarla a su mano

# 1.2 Tablero
El tablero es la representación física del campo de batalla en el que los jugadores colocan sus cartas. Está dividido en dos secciones simétricas, una para cada jugador, y cada sección se subdivide en tres zonas: la zona de combate cuerpo a cuerpo, la zona de combate a distancia y la zona de asedio. Utilizaremos indistintamente los términos tablero y campo de batalla, así como los términos zona y fila.

Además de las zonas de combate, existe una zona adicional para las cartas de clima que afectan el campo de batalla y pueden tener efectos como modificar la fuerza de las unidades en diferentes zonas. Esta zona es compartida por ambos jugadores, por lo que solo puede haber una carta de clima en el campo.

La única diferencia entre las zonas del tablero son las cartas que pueden ser colocadas en cada una de ellas.

# 1.3 Cartas
En el juego, las cartas desempeñan un papel fundamental. Existen dos tipos principales de cartas: las cartas de unidad y las cartas de clima. Las cartas de unidad son aquellas que cada jugador debe colocar estratégicamente en las zonas correspondientes del campo de batalla. Estas cartas tienen tres clasificaciones: cuerpo a cuerpo, a distancia y de asedio, cada uno de los cuales determina la ubicación en la que puede ser colocada. Por ejemplo, las cartas cuerpo a cuerpo solo pueden ser colocadas en la zona de combate cuerpo a cuerpo, mientras que las cartas de distancia solo pueden ser colocadas en la zona de combate a distancia. Además, cada carta de unidad tiene un número que representa su valor de fuerza.

Por otro lado, las cartas de clima son cartas especiales que pueden ser colocadas en la zona de clima. Estas cartas tienen el poder de afectar el campo de batalla y brindar ventajas o desventajas a los jugadores, dependiendo del tipo de clima que se haya elegido.

Cada carta tiene un nombre y su clasificación que la identifica. Finalmente, cada carta de unidad puede tener su propia habilidad especial, esto se explica en la sección.

# 1.4 Efectos
Las cartas de unidad pueden tener una habilidad especial que se activa cuando la carta es colocada en el campo de batalla y que se mantiene activo mientras la carta permanezca en el tablero. Considere que no todas las cartas de unidad tienen una habilidad especial, pero todas las cartas de clima sí poseen una.
A continuación se presentan los efectos que debe implementar su programa:

# 1.4.1 Carta de Unidad
* **Refuerzo moral**: Cuando la carta entra en el campo, añade +1 a la fuerza de todas las cartas en su fila, excepto a sí misma.
* **Vínculo estrecho**: Si ya existe una carta con el mismo nombre en la fila, duplica la fuerza de esa(s) carta(s), incluyéndose a sí misma.

# 1.4.2 Cartas de Clima
* **Escarcha Mordiente**: Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1.
* **Niebla impenetrable**: Establece el valor de fuerza de todas las cartas de combate a distancia a 1.
* **Lluvia torrencial**: Establece el valor de todas las cartas de asedio a 1.
* **Clima despejado**: Elimina todos los efectos climáticos actualmente en efecto en el campo de batalla.

# 1.5 Reglas del Juego

El objetivo del juego es acumular más fuerza en el campo de batalla que el oponente al final de cada ronda. Al finalizar una ronda, el jugador que tenga menos fuerza total en su zona pierde una gema. El juego finaliza cuando un jugador pierde todas sus gemas. Si se da la situación que ambos jugadores tengan la misma fuerza al término de una ronda, esta es considerada un empate, en cuyo caso ambos perderán una gema.

Cada jugador cuenta con un mazo de 25 cartas de cualquier clasificación y 2 gemas. Al inicio de la primera ronda, ambos jugadores barajan sus mazos y roban 10 cartas cada uno. Luego, para las siguientes rondas, barajan sus mazos y solo podrán robar 3 cartas cada uno, pudiendo tener hasta un máximo de 10 en sus manos.

Cada ronda se divide en turnos alternados, donde cada jugador tiene la oportunidad de jugar una sola carta de su mano o pasar su turno, es decir, no jugar ninguna carta. Cuando un jugador pasa su turno, el otro puede jugar tantos turnos como desee hasta que no tenga más cartas que pueda jugar o hasta que también pase su turno. Si un jugador no tiene cartas que pueda jugar en su mano, entonces pasa su turno automáticamente.

# 2. Arquitectura
Para este proyecto se implementará la parte de modelo del patrón modelo-vista-controlador, que se explica de la siguiente manera:

**Modelo:** Se le solicitará que cree todas las entidades necesarias que servirán de estructura base del proyecto y las interacciones posibles entre dichas entidades. Las entidades en este caso se refieren a los
elementos que componen el juego.

-------
# Descarga y revisión del proyecto

Para descargar y revisar el proyecto porfavor dirigirse a la branch **tarea-3/entrega-final**, este es el estado final del proyecto,  y ahi descargar el zip correspondiente en las opciones de Code.
