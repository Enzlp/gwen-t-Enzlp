# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---


**Explicacion General:** 
Se tiene la clase Jugador que genera los objetos jugador que serán los participantes del juego, tenemos el tablero dividido en 3 partes, primero una zona de tablero clima creada por su propia clase, y dos zonas del tablero individuales creadas por una clase tableroUnidad, la dividisión del tablero se hizo en favor de facilitar la jugabilidad de las cartas de clima por ambos jugadores, tener un tablero en común ayuda a poder tener presente la condición deque solo pueda haber una carta de clima a la vez. Las clases implementadas son:

1. **Jugador**: Esta clase implementa el trait IJugador, contiene un value nombre, y cuatro variables privadas, _mano, _mazo, _gemas, boardClima y _personalBoard. Estas variables se declarán privadas para evitar manipulaciones externas de forma directa, para esto existen métodos getter y setter definidos en el trait IJugador, estos son: gemas, para poder obtener el valor de las gemas actualmente del jugador (getter), el método personalBoard es un getter de acceso a la variable _personalBoard, el método mano es el método de acceso a la variable mano, el método mazo es el método de acceso a la variable mazo, y el método shuffleMazo es un método setter que define el valor de la variable mazo como el mazo revuelto. También contiene el método robarCarta que toma la primera carta del mazo del jugador y lo pone en el indice final de la mano. Y también está el método jugarCarta, que saca la carta de la mano en el indice específicado y lo juega en el tablero, para esto delega la acción de jugar la carta a la clase(tipo) de carta que se juega, esto es double dispatch, y toma como argumento el tablero personal de las zonas de unidades y el tablero común de clima, esto para poder unificar en un solo método de jugar carta y después especificar el tablero y la acción según el tipo de carta.
2. **AbstractCarta**: Implementa el trait Carta, de este hereda los val nombre y descripcion, y se definen del tipo protected, para que sean vistos por las subclases que extiendan a esta superclase.
3. **AbstractClima**: implementa tanto el nombre como la descripcion de la clase AbstractCarta, y tambien hereda la funcion jugarCarta. Se hace un override del método jugarCarta, para definir especificamente la función de este método para las subclases que extiendan a la clase AbstractClima, en este sentido, como es una carta del tipo Clima, se delega la tarea de jugar la carta a un método propio de la clase tableroClima, que toma como argumento la carta que se va a jugar esto se especifica usando this. 
4. **AbstractUnidad**: Implementa tanto el nombre como la descripcion desde la clase AbstractCarta, además agrega un val poder que representa el poder de la carta. Esta variable no tiene un método getter, debido a que a futuro, se implementarán efectos de cartas que modificaran el valor del poder de la carta, además poder es del tipo val por lo que tiene un getter inherente. Implementamos tambien una variable privada llamada poder actual, esta variable definirá el poder que tiene la carta después de aplicarles los efectos propios de jugar cartas de clima, o de unidad. Para poder acceder al valor asociado a esta variable implementamos un método getter llamado poderActual.
5. **Subclases de Clima**: cada una es una subclase de la clase abstracta AbstractClima, y cada una implementa un nombre y descripción.
6. **CombateAsedio**: implementa el nombre, descripción y poder desde la clase AbstractUnidad, además en esta clase definimos mediante un override lo que hace el método jugarCarta para la carta de combate de asedio, esta función toma como argumento el tablero de unidad y de clima, de los cuales delega el jugar la carta al tablero de unidad, que es donde se juegan este tipo de cartas, para esto se usa el método recibeCartaCA propio del tablero unidad, que toma como argumento la carta de combate asedio y la juega en su zona respectiva.
6. **CombateCuerpoCuerpo**: implementa el nombre, descripción y poder desde la clase AbstractUnidad, además en esta clase definimos mediante un override lo que hace el método jugarCarta para la carta de combate cuerpo a cuerpo, esta función toma como argumento el tablero de unidad y de clima, de los cuales delega el jugar la carta al tablero de unidad, que es donde se juegan este tipo de cartas, para esto se usa el método recibeCartaCC propio del tablero unidad, que toma como argumento la carta de combate cuerpo a cuerpo y la juega en su zona respectiva.
6. **CombateDistancia**: implementa el nombre, descripción y poder desde la clase AbstractUnidad, además en esta clase definimos mediante un override lo que hace el método jugarCarta para la carta de combate a distancia, esta función toma como argumento el tablero de unidad y de clima, de los cuales delega el jugar la carta al tablero de unidad, que es donde se juegan este tipo de cartas, para esto se usa el método recibeCartaCD propio del tablero unidad, que toma como argumento la carta de combate a distancia y la juega en su zona respectiva.
7. **TableroClima**: implementa métodos de el trait ITableroClima. Posee un val privado llamado _zonaClima, que es una array que almacenara la carta de clima actual siendo jugada por uno de los jugadores. Tenemos el método de acceso zonaClima (getter), que nos permite acceder al valor de la variable _zonaClima. Y el método recibeCarta, este método elimina todos los elementos del arrreglo de zona clima y luego agrega a la carta, que toma como argumento, al array asi ses cumple la condición de que solo haya una carta de clima a la vez.
8. **TableroUnidad**: Implementa métodos de el trait ITableroUnidad. Posee tres val privados, _zonaCD, _zonaCA y _zonaCC. Cada uno tiene su propio método de acceso(getter), zonaCD, zonaCA y zonaCC. Además implementa tres métodos para jugar cartas, recibeCartaCC, recibeCartaCA y recibeCartaCD, cada uno posee de argumento la carta que va a implementar, y usa el método addOne, para agregar la carta a su array correspondiente (dependiendo de la zona). 
