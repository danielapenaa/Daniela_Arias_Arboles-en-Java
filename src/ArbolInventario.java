// clase ArbolInventario: aca esta toda la logica del arbol binario de busqueda
// cada metodo tiene una version publica (la que se usa desde Main) y una
// version privada y recursiva (la que realmente recorre el arbol nodo por nodo)

public class ArbolInventario {

    // raiz del arbol, empieza vacia
    private Producto raiz;

    // constructor: el arbol nace sin ningun producto
    public ArbolInventario() {
        raiz = null;
    }

    // ================== INSERTAR ==================

    // metodo publico: agrega un producto nuevo al arbol
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    // metodo privado: busca el lugar correcto para el producto nuevo
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // si llegamos a un espacio vacio, aqui va el producto nuevo
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // si el id es menor, va por la izquierda
        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, nombre));
        }
        // si el id es mayor, va por la derecha
        else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, nombre));
        }
        // si el id ya existe, no se hace nada (no se repiten ids)

        return actual;
    }

    // ================== RECORRIDO INORDEN ==================

}