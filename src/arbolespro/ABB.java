package arbolespro;

public class ABB {
    //private

    Node raiz;

    ABB() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return (this.raiz == null);

    }

    public Node regresaRaiz() {

        return this.raiz;
    }

    public void insertarValor(int valor) {
        if (this.raiz == null) {
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Node();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        } else {
            insertarNodo(valor, this.raiz);
        }
    }

    public void insertarNodo(int valor, Node nodoRef) {
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null) {
                System.out.println("Insertando hijo izquierdo de: " + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo = new Node();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            } else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        } else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null) {
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho = new Node();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                } else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }

    public void muestraAcostado(int nivel, Node nodoRef) {
        if (nodoRef == null) {
            return;
        } else {
            muestraAcostado(nivel + 1, nodoRef.derecho);

            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }

            System.out.println(nodoRef.dato);
            muestraAcostado(nivel + 1, nodoRef.izquierdo);
        }
    }

    //metodo recorrer  inorden  
    public void inorden(Node raiz) {
        if (raiz != null) {
            inorden(raiz.izquierdo);
            System.out.print(raiz.dato + ", ");
            inorden(raiz.derecho);

        }
    }// 

    //metodo recorrer preorden
    public void preorden(Node raiz) {
        if (raiz != null) {

            System.out.print(raiz.dato + ", ");
            preorden(raiz.izquierdo);
            preorden(raiz.derecho);
        }
    }//

//metodo recorrer posorden
    public void posorden(Node raiz) {
        if (raiz != null) {
            posorden(raiz.izquierdo);
            posorden(raiz.derecho);
            System.out.print(raiz.dato + ", ");
        }
    }//   

    //metodo buscar nodo en el arbol
    public Node buscarnodo(int d) {
        Node aux = raiz;

        while (aux.dato != d) {

            if (d < aux.dato) {
                aux = aux.izquierdo;

            } else {
                aux = aux.derecho;

            }
            if (aux == null) {

                return null;
            }
        }

        return aux;

    }//     

    public void buscarEImprimir(int valor) {
        Node nodoEncontrado = buscarnodo(valor);
        if (nodoEncontrado == null) {
            System.out.println("El Nodo " + valor + " NO se encuentra en el arbol");
        } else {
            System.out.println("El Nodo " + valor + " SI se encuentra en el arbol");
        }
    }
    
    
    public void borrarEImprimir(int valor) {
        boolean nodoeliminar = eliminar(valor);
        if (nodoeliminar == false) {
           System.out.println("El Nodo NO se encuentra en el arbol");

        } else {
            System.out.println("El Nodo " + valor + " ha sido eliminado del arbol");

    }
    
    }
    
 
//metodo eliminar un nodo del arbo
    public boolean eliminar(int d) {

        Node aux = raiz;
        Node padre = raiz;
        boolean esizquierdo = true;
        while (aux.dato != d) {
            padre = aux;
            if (d < aux.dato) {
                esizquierdo = true;
                aux = aux.izquierdo;
            } else {
                esizquierdo = false;
                aux = aux.derecho;
            }
            if (aux == null) {

                return false;
            }
        }//while
        if (aux.izquierdo == null && aux.derecho == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esizquierdo) {

                padre.izquierdo = null;

            } else {
                padre.derecho = null;
            }
//
        } else if (aux.derecho == null) {
            if (aux == raiz) {
                raiz = aux.izquierdo;
            } else if (esizquierdo) {

                padre.izquierdo = aux.izquierdo;

            } else {
                padre.derecho = aux.izquierdo;
            }
//
        } else if (aux.izquierdo == null) {
            if (aux == raiz) {
                raiz = aux.derecho;
            } else if (esizquierdo) {

                padre.derecho = aux.derecho;

            } else {
                padre.izquierdo = aux.derecho;
            }

        } else {
            Node reemplazo = obtenerNodoRemplazo(aux);
            if (aux == raiz) {

                raiz = reemplazo;
            } else if (esizquierdo) {
                padre.izquierdo = reemplazo;

            } else {
                padre.derecho = reemplazo;//

            }
            reemplazo.izquierdo = aux.izquierdo;
        }
        return true;
    }

//metodo encargado de devolver el nodo reemplazo
    public Node obtenerNodoRemplazo(Node nodorem) {
        Node reemplazarpadre = nodorem;
        Node reemplazo = nodorem;
        Node aux = nodorem.derecho;
        while (aux != null) {
            reemplazarpadre = reemplazo;
            reemplazo = aux;
            aux = aux.izquierdo;
        }
        if (reemplazo != nodorem.derecho) {
            reemplazarpadre.izquierdo = reemplazo.derecho;
            reemplazo.derecho = nodorem.derecho;

        }
        System.out.println("El nodo reemplazo es " + reemplazo.dato);
        return reemplazo;
    }

}//clase

