package arbolespro;

public class ArbolesPro {

    public static void main(String[] args) {
        ABB arbol = new ABB();

        Node raizArbolABB = arbol.regresaRaiz();
        /*	
		//25, 8, 29, 38, 27
		arbol.insertarValor(25);
		arbol.insertarValor(8);
		arbol.insertarValor(29);
		arbol.insertarValor(38);
		arbol.insertarValor(27);
         */

        arbol.insertarValor(45);
        arbol.insertarValor(23);
        arbol.insertarValor(65);
        arbol.insertarValor(2);
        arbol.insertarValor(38);
        arbol.insertarValor(96);
        arbol.insertarValor(52);
        arbol.insertarValor(7);
        arbol.insertarValor(48);

        System.out.println("Nodo raiz: " + arbol.regresaRaiz().dato);
        System.out.println("");
        arbol.muestraAcostado(0, arbol.regresaRaiz());
        
        System.out.println("");
        System.out.println("Recorrido inorden");//i,r,d
        arbol.inorden(arbol.raiz);
        
        System.out.println("");
        System.out.println("Recorrido preorden");//r,i,d
        arbol.preorden(arbol.raiz);
        
        System.out.println("");
        System.out.println("Recorrido posorden");//i,d,r
        arbol.posorden(arbol.raiz);
        System.out.println("");
        System.out.println("");

        
        //buscar nodos
        System.out.println("Busqueda de nodos");
        arbol.buscarEImprimir(86);
        arbol.buscarEImprimir(7);
        arbol.buscarEImprimir(2);
        arbol.buscarEImprimir(13);
        System.out.println("");
        
       //eliminar nodos 
       arbol.borrarEImprimir(23);
        System.out.println("");
        arbol.muestraAcostado(0, arbol.regresaRaiz());
        System.out.println("");
        //
        arbol.borrarEImprimir(48);
        System.out.println("");
        arbol.muestraAcostado(0, arbol.regresaRaiz());
        System.out.println("");
        //
        arbol.borrarEImprimir(45);
        System.out.println("");
        arbol.muestraAcostado(0, arbol.regresaRaiz());
        System.out.println("");
        
        

    }

}
