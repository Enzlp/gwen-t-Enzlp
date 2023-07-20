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
# Explicación clases

. **Jugador**: Esta clase implementa el trait IJugador, contiene un value nombre, y cuatro variables privadas, _mano, _mazo, _gemas, boardClima y _personalBoard. Estas variables se declarán privadas para evitar manipulaciones externas de forma directa, para esto existen métodos getter y setter definidos en el trait IJugador, estos son: gemas, para poder obtener el valor de las gemas actualmente del jugador (getter), el método personalBoard es un getter de acceso a la variable _personalBoard, el método mano es el método de acceso a la variable mano, el método mazo es el método de acceso a la variable mazo, y el método shuffleMazo es un método setter que define el valor de la variable mazo como el mazo revuelto. También contiene el método robarCarta que toma la primera carta del mazo del jugador y lo pone en el indice final de la mano. Y también está el método jugarCarta, que saca la carta de la mano en el indice específicado y lo juega en el tablero, para esto delega la acción de jugar la carta a la clase(tipo) de carta que se juega, esto es double dispatch, y toma como argumento el tablero personal de las zonas de unidades y el tablero común de clima, esto para poder unificar en un solo método de jugar carta y después especificar el tablero y la acción según el tipo de carta.