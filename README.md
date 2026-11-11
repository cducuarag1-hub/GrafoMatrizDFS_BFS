# GrafoMatrizDFS_BFS

Implementación en **Java** de un grafo no dirigido representado mediante una **matriz de adyacencia**, incluyendo los algoritmos de búsqueda y recorrido en profundidad (**DFS**) y en anchura (**BFS**).

---

## 🛠️ Estructura del Código

- **`Grafo.java`**: Contiene la definición de la clase `Grafo`, la matriz de adyacencia, el arreglo de vértices, validaciones e implementación de los algoritmos de recorrido.
- **`Main.java`**: Punto de entrada del programa donde se instancia el grafo, se agregan 6 vértices (`A` a `F`), se definen las aristas y se ejecutan las demostraciones.

---

## Ejemplo de Ejecución

El programa genera un grafo no dirigido con los vértices `A, B, C, D, E, F` y las siguientes conexiones:
- `A` - `B`
- `A` - `C`
- `B` - `D`
- `B` - `E`
- `C` - `F`

### Salida esperada en consola:

```text
Matriz de adyacencia:
       A   B   C   D   E   F
   A   0   1   1   0   0   0
   B   1   0   0   1   1   0
   C   1   0   0   0   0   1
   D   0   1   0   0   0   0
   E   0   1   0   0   0   0
   F   0   0   1   0   0   0

DFS: A B D E C F 
BFS: A B C D E F