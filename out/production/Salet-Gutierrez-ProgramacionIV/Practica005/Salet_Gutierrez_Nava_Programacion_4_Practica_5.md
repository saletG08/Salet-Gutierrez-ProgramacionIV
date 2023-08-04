## Practica 5
### Nombre: Salet Yasmin Gutierrez Nava

Crear los siguientes arboles Heaps representados gráficamente uno después del insert de todos 
los valores y otro después de la eliminación

1)
**Tipo:** min heap

**Insertar:** 1, 2, 50, 3, 80, 51, 70, 4, -10

**Eliminar:** -10

![Ejercicio1-1.png](https://i.postimg.cc/T3r2Q0fc/Ejercicio1-1.png)

[![Ejercicio1-2.png](https://i.postimg.cc/3NgFQrYy/Ejercicio1-2.png)](https://postimg.cc/rRwrSkdc)

2)
**Tipo:** max heap

**Insertar:** 7, 6, 1, 5, 10, 5, 3, 2.8

**Eliminar:** 10

[![Ejercicio2-1.png](https://i.postimg.cc/MHCX2Mv5/Ejercicio2-1.png)](https://postimg.cc/Cn4wbKCn)

[![Ejercicio2-2.png](https://i.postimg.cc/SNVc3q4M/Ejercicio2-2.png)](https://postimg.cc/qzht6PzJ)
3)
**Tipo:** min heap

**Insertar:** 3, 1, 2, 80, 51, 70, -10, 50, 4

**Eliminar:**  80, 70, 50

[![Ejercicio3-1.png](https://i.postimg.cc/HxqCTfC0/Ejercicio3-1.png)](https://postimg.cc/vgtKz2TD)

[![Ejercicio3-2.png](https://i.postimg.cc/NGkNs3Yg/Ejercicio3-2.png)](https://postimg.cc/qggcQZzY)

[![Ejercicio3-3.png](https://i.postimg.cc/wjC5c2Hf/Ejercicio3-3.png)](https://postimg.cc/fVv0MxVm)

4)
**Tipo:** max heap

**Insertar:** 3, 1, 2, 80, 51, 70, -10, 50, 4

**Eliminar:**  1, 2, 4, 3

[![Ejercicio4-1.png](https://i.postimg.cc/4ysqMx9d/Ejercicio4-1.png)](https://postimg.cc/TLNt5GQM)

[![Ejercicio4-2.png](https://i.postimg.cc/9MJYmmkz/Ejercicio4-2.png)](https://postimg.cc/G8TyzCd1)

[![Ejercicio4-3.png](https://i.postimg.cc/pT61v8zg/Ejercicio4-3.png)](https://postimg.cc/CBb4HRvN)

[![Ejercicio4-4.png](https://i.postimg.cc/zBb4V0zJ/Ejercicio4-4.png)](https://postimg.cc/jwTM16n9)

5)
**Tipo:** min heap
**Insertar:** 7, 6, 1, 5, 10, 5, 3, 2.8
**Eliminar:** 6,1,8

[![Ejercicio5-1.png](https://i.postimg.cc/d13VRSvS/Ejercicio5-1.png)](https://postimg.cc/k6rCqs2x)

[![Ejercicio5-2.png](https://i.postimg.cc/Dy9vjqzy/Ejercicio5-2.png)](https://postimg.cc/8jbgsfWq)

[![Ejercicio5-3.png](https://i.postimg.cc/QCW5mMsP/Ejercicio5-3.png)](https://postimg.cc/K3xRvx1r)

6)
**Tipo:** max heap

**Insertar:** 2, 8, 5, 7, 6, 10, 1, 5, 3, 5, 0, 9

**Eliminar:** 1, 10, 3, 9

[![Ejercicio6-1.png](https://i.postimg.cc/zfVcNnkR/Ejercicio6-1.png)](https://postimg.cc/XZ68cBmV)

[![Ejercicio6-2.png](https://i.postimg.cc/R0KwwhSD/Ejercicio6-2.png)](https://postimg.cc/t1R1jXV3)

[![Ejercicio6-3.png](https://i.postimg.cc/T3GKB0fC/Ejercicio6-3.png)](https://postimg.cc/BXYZKx8K)

[![Ejercicio6-4.png](https://i.postimg.cc/rFqstYby/Ejercicio6-4.png)](https://postimg.cc/w3bgCFgn)

[![Ejercicio6-5.png](https://i.postimg.cc/nrSLxn1d/Ejercicio6-5.png)](https://postimg.cc/9wT2t5KT)

7)
**Tipo:** min heap

**Insertar:** 15, 10, 8, 12, 7, 6, 9,-60, 80, 9

**Eliminar:** 15, 7, 9

[![Ejercicio7-1.png](https://i.postimg.cc/zvxk1HM9/Ejercicio7-1.png)](https://postimg.cc/2LBWQyCw)

[![Ejercicio7-2.png](https://i.postimg.cc/YCzQcWW8/Ejercicio7-2.png)](https://postimg.cc/75b50bXT)

[![Ejercicio7-3.png](https://i.postimg.cc/bJDGvDs7/Ejercicio7-3.png)](https://postimg.cc/zbNDtfw7)

8)
**Tipo:** max heap

**Insertar:** 500, 10, 62, 74, 10, -6, 9, -60, -80, 8

**Eliminar:**  74, -60, 500

[![Ejercicio8-1.png](https://i.postimg.cc/J7Kwh6WW/Ejercicio8-1.png)](https://postimg.cc/z3L2tkBd)

[![Ejercicio8-2.png](https://i.postimg.cc/yxpryGVg/Ejercicio8-2.png)](https://postimg.cc/zHWjJ0H8)

### Teoría:

**¿Que son las Colas de Prioridad y como se puede aplicar los árboles heap en estos?**

Las colas de prioridad son estructuras de datos que permiten almacenar un conjunto de 
elementos y recuperarlos en un orden específico basado en su prioridad. La prioridad 
se define como una propiedad asociada a cada elemento que indica su importancia relativa 
en relación con los otros elementos de la cola.

Los árboles heap son una implementación común de las colas de prioridad.

Los árboles heap se pueden aplicar a las colas de prioridad de varias maneras. Una de 
las operaciones principales en una cola de prioridad es la inserción de un nuevo 
elemento. En un árbol heap, se inserta el nuevo elemento en la siguiente posición 
disponible en el nivel inferior más a la izquierda del árbol y luego se realiza un 
reordenamiento ascendente del árbol para restaurar la propiedad del heap.

Otra operación común en una cola de prioridad es la eliminación del elemento de mayor
o menor prioridad, según el tipo de heap utilizado. En un árbol heap, se elimina el 
elemento de la raíz del árbol y se reemplaza con el último elemento del nivel inferior 
más a la derecha del árbol. Luego, se realiza un reordenamiento descendente del árbol 
para restaurar la propiedad del heap.

Los árboles heap también se pueden utilizar para implementar algoritmos de búsqueda 
de camino más corto, como el algoritmo de Dijkstra, y algoritmos de ordenamiento, 
como el heapsort.

**¿Por que se dice que heapsort es más rápido en algunos casos que Quicksort?**

Heapsort y Quicksort son dos algoritmos de ordenamiento muy populares y ampliamente 
utilizados. Ambos tienen una complejidad temporal promedio de O(n log n) y se consideran 
algoritmos de ordenamiento eficientes para grandes conjuntos de datos.

Sin embargo, en algunos casos, se puede demostrar que Heapsort es más rápido que Quicksort. 
Una de las razones principales es que Heapsort tiene una complejidad temporal garantizada 
de O(n log n) en el peor caso, mientras que Quicksort tiene una complejidad temporal de 
O(n²) en el peor caso.

El peor caso de Quicksort se produce cuando la partición inicial divide el conjunto de 
datos en dos conjuntos desequilibrados, lo que puede suceder si la elección del pivote 
no es adecuada. En este caso, el algoritmo se vuelve ineficiente y puede tomar mucho tiempo 
para ordenar los datos. En contraste, Heapsort siempre divide el conjunto de datos en dos 
mitades iguales y siempre tiene una complejidad temporal de O(n log n) en el peor caso.

Además, Heapsort tiene la ventaja de que su implementación es más simple y su estructura de 
datos subyacente (el árbol heap) es más fácil de entender y de implementar que el proceso de
particionar y seleccionar pivotes utilizado por Quicksort.

**¿Que es el método buildheap y cómo funciona? de 2 ejemplos.**

El método buildheap es un algoritmo utilizado para construir un árbol heap a partir de un 
conjunto de datos no ordenados. El proceso implica transformar el conjunto de datos en un 
árbol heap, que es una estructura de datos que cumple con la propiedad de que cada nodo es 
mayor o menor que sus hijos, dependiendo del tipo de heap utilizado (máximo o mínimo).

El método buildheap funciona de la siguiente manera:

1. Se toma el conjunto de datos no ordenados y se organiza en un árbol binario completo, 
donde el primer elemento del conjunto de datos se coloca en la raíz del árbol, el segundo 
elemento se coloca en el nodo izquierdo del primer nivel, el tercer elemento se coloca en 
el nodo derecho del primer nivel, y así sucesivamente.

2. Se realiza un reordenamiento descendente del árbol para garantizar que cada nodo cumpla 
con la propiedad del heap. Para hacer esto, se comienza en el último nivel del árbol y se 
compara cada nodo con sus hijos. Si el nodo es menor (o mayor, según el tipo de heap) que 
uno de sus hijos, se intercambian los valores de los nodos. Luego, se sube un nivel en el 
árbol y se repite el proceso hasta llegar a la raíz.

### Ejemplo 1:
**Heap Máximo**

Se tiene la siguiente lista no ordenada:

+ [10, 7, 5, 3, 2, 8, 6]
1. Se comenzará a organizar los datos en un arbol binario:

``` json
        10
       /  \
      7    5
     / \  / \
    3  2  8  6
```
2. Luego, se realiza un reordenamiento descendente del árbol para que cada nodo 
cumpla con la propiedad del heap. Comenzando en el último nivel del árbol, se compara cada 
nodo con sus hijos y se intercambian los valores si es necesario:

``` json
        10
       /  \
      7    8
     / \  / \
    3  2  5  6
```

3. Luego, se sube un nivel en el árbol y se repite el proceso:

``` json
        10
       /  \
      7    8
     / \  / \
    6  2  5  3
```
4. Finalmente, se obtiene el heap máximo [10, 8, 7, 6, 5, 3, 2].

### Ejemplo 2

**Heap Mínimo**

Se tiene la siguiente lista no ordenada:
+ [5, 9, 3, 1, 8, 6]

1. Se comenzará organizando lo datos de un arbol binario:

``` json
        5
       / \
      9   3
     / \  /
    1   8 6
```

2. Luego, se realiza un reordenamiento descendente del árbol 
para que cada nodo cumpla con la propiedad del heap. Comenzando 
en el último nivel del árbol, se compara cada nodo con sus hijos y se 
intercambian los valores si es necesario:

``` json
        1
       / \
      8   3
     / \  /
    5   9 6
```
3. Luego, se sube un nivel en el árbol y se repite el proceso:

``` json
        1
       / \
      5   3
     / \  /
    9   8 6
```

4. Finalmente, se obtiene el heap mínimo [1, 5, 3, 9, 8, 6].

**¿Por qué se dice que la búsqueda en los árboles heap no es óptima y como se podría mejorar?**

La búsqueda en los árboles heap no es óptima porque esta estructura de datos no garantiza que los 
elementos estén organizados de una manera que permita una búsqueda eficiente.
En cambio, los árboles heap se construyen a medida que se insertan los elementos y se van reordenando
para mantener la propiedad del heap, lo que puede resultar en un árbol desequilibrado con profundidades
de rama muy diferentes.

Sin embargo, se pueden implementar algunas mejoras para optimizar la búsqueda en los árboles heap. 
Una solución es utilizar índices adicionales para acceder a los elementos del árbol de manera más 
eficiente. Por ejemplo, se puede utilizar un mapa o diccionario que asocie cada elemento con su 
posición en el árbol heap. De esta manera, se puede acceder directamente a un elemento específico 
sin tener que recorrer todo el árbol.

**De 5 ejemplos de situaciones reales en donde se puede aplicar los árboles heap**

**Colas de prioridad:** los árboles heap se utilizan a menudo para implementar colas de prioridad, 
donde los elementos se almacenan en orden según su prioridad. Por ejemplo, en un sistema de 
gestión de emergencias, los pacientes se pueden organizar en una cola de prioridad basada en 
la gravedad de su condición médica.

**Algoritmos de búsqueda de caminos más cortos:** los árboles heap se pueden utilizar para implementar 
algoritmos de búsqueda de caminos más cortos, como el algoritmo de Dijkstra. En un mapa de carreteras, 
se puede utilizar el algoritmo de Dijkstra para encontrar la ruta más rápida entre dos ciudades.

**Sistemas de gestión de memoria:** los árboles heap se utilizan a menudo en los sistemas operativos 
para gestionar la memoria disponible. Por ejemplo, en un sistema de memoria virtual, las páginas de 
memoria se organizan en un árbol heap según su tamaño y se asignan a los procesos de manera eficiente.

**Almacenamiento de datos en disco:** los árboles heap se pueden utilizar para organizar y ordenar grandes 
conjuntos de datos en disco. Por ejemplo, en una base de datos, los registros se pueden almacenar en un 
archivo y organizarse en un árbol heap para permitir búsquedas y ordenamiento eficientes.

**Algoritmos de ordenamiento:** como se mencionó anteriormente, los árboles heap se pueden utilizar 
para implementar algoritmos de ordenamiento, como el heapsort. Este algoritmo se utiliza a menudo en 
la clasificación de grandes conjuntos de datos y en la optimización de consultas en bases de datos.
