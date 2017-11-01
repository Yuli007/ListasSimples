    import javafx.scene.control.Alert;
    import javax.swing.*;
    public class Lista {
        //Indicamos el puntero o cabeza de la lista
        private Nodo inicio;
        //Tamaño de la lista
        private int tamaño;
        //----------------------------------------------------------------------------------------------------------
        public void lista() {
            inicio = null;
            tamaño = 0;
        }
        //----------------------------------------------------------------------------------------------------------
        /*returna true si la lista esta vacia*/
        public boolean esVacia() {
            return inicio == null;
        }
        //Consulta cuantos datos tiene la lista
        public int getTamaño() {
            return tamaño;
        }
            //Agrega un nuevo nodo al inicio de la lista.
            //----------------------------------------------------------------------------------------------------------
        //AGREGA UN NODO NUEVO SIEMRE AL FINAL DE UNA LISTA POR MEDIO DEL MÉTODO, setSiguiente
        public void agregar ( Object valor){
            // Define un nuevo nodo.
            Nodo nuevo = new Nodo();
            // Agrega al valor al nodo.
            nuevo.setValor(valor);
            // Consulta si la lista esta vacia.
            if (esVacia()) {
                // Inicializa la lista agregando como inicio al nuevo nodo.
                inicio = nuevo;
                // Caso contrario recorre la lista hasta llegar al ultimo nodo
                //y agrega el nuevo.
            } else {
                // Crea ua copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta llegar al ultimo nodo.
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                // Agrega el nuevo nodo al final de la lista.
                aux.setSiguiente(nuevo);
            }
            // Incrementa el contador de tamaño de la lista
            tamaño++;
            }
        //----------------------------------------------------------------------------------------------------------
        //OBTIENE EL VALOR DE UN NODO POR SU ÍNDICE
        public String getPosicion(int posicion){
            //si posicion esta dentro de la lista ya que esta entre 0 y un valor menor al tamaño
            if (posicion >= 0 && posicion < tamaño) {
                //si posicion es el inicio de la lista
                if (posicion == 0) {
                    return "Posición ["+posicion+"] es igual a: "+inicio.getValor();
                } else {
                    //crea una copia de la lista
                    Nodo aux = inicio;
                    //Recorre toda la lista hasta la posiciín ingresada
                    for (int i = 0; i < posicion; i++) {
                        aux = aux.getSiguiente();
                    }
                    //retorna el valor del nodo
                    return "Posición["+posicion+"] es igual a: "+aux.getValor();
                }
            } else {
                return "Posición no encontrada";
            }
        }

        //COMPRUEBA SI UN VALOR EXISTE, SI ES ASÍ RETORNA TRUE PARA LA BUSCAR UN VALOR O ELIMINAR UN VALOR

        public Boolean buscar (Object referencia){
            // Crea una copia de la lista.
            Nodo aux = inicio;
            //indicar si el valor existe.
            boolean encontrado = false;
            // Recorre la lista hasta encontrar el elemento o hasta
            // llegar al final de la lista.
            while(aux != null && encontrado != true){
                // Consulta si el valor del nodo es igual al de referencia.
                if (referencia.equals(aux.getValor())){
                    // Canbia el valor de la bandera.
                    encontrado = true;
                }
                else{
                    // Avansa al siguiente. nodo.
                    aux = aux.getSiguiente();
                }
            }
            // Retorna el resultado de la bandera.
            return encontrado;
        }
        //ENCUANTRA UN ÍNDICE POR SU VALOR, UTILIZANDO UN CONTADOR
        public String getValor (Object referencia) {
            // Consulta si el valor existe en la lista.
            if (buscar(referencia)) {
                // Crea una copia de la lista.
                Nodo aux = inicio;
                // COntado para almacenar la posición del nodo.
                int cont = 0;
                // Recoore la lista hasta llegar al nodo de referencia.
                while(!referencia.equals(aux.getValor())){
                    // Incrementa el contador.
                    cont ++;
                    // Avansa al siguiente. nodo.
                    aux = aux.getSiguiente();
                }
                // Retorna el valor del contador.
                return "El valor "+referencia+" se en cuentra en la posición: "+cont;
                // Crea una excepción de Valor inexistente en la lista.
            } else {
                return "Valor inexistente en la lista.";
            }
        }
        public String removerporValor(Object referencia){
            if(buscar(referencia)){
                tamaño--;
                if(referencia.equals(inicio.getValor())){
                    inicio=inicio.getSiguiente();
                    return "Valor eliminado";
                } else{
                    Nodo aux=inicio;
                    while (!referencia.equals(aux.getSiguiente( ).getValor( ))){
                        aux=aux.getSiguiente();
                    }
                    Nodo pasar=aux.getSiguiente().getSiguiente();
                    aux.setSiguiente(pasar);
                }
            }
            return "Valor no encontrado";
        }
        //----------------------------------------------------------------------------------------------------------
        public void removerporPosicion(int posicion){
            //si posicion esta dentro de la lista ya que esta entre 0 y un valor menor al tamaño
            if(posicion>=0 && posicion<tamaño){
                // Consulta si el nodo a eliminar es el primero
                if(posicion == 0){
                    // Elimina el primer nodo apuntando al siguinte.
                    inicio = inicio.getSiguiente();
                }
                // En caso que el nodo a eliminar este por el medio
                // o sea el ultimo
                else{
                    // Crea una copia de la lista.
                    Nodo aux = inicio;
                    // Recorre la lista hasta lleger al nodo anterior al eliminar.
                    for (int i = 0; i < posicion-1; i++) {
                        aux = aux.getSiguiente();
                    }
                    // Guarda el nodo siguiente al nodo a eliminar.
                    Nodo siguiente = aux.getSiguiente();
                    // Elimina la referencia del nodo apuntando al nodo siguiente.
                    aux.setSiguiente(siguiente.getSiguiente());
                }
                // Disminuye el contador de tamaño de la lista.
                tamaño--;
            }else{
                System.out.println("Ésta posición no existe :(");
            }
        }

        //----------------------------------------------------------------------------------------------------------
        public  String eliminarlista(){
            if (inicio!= null) {
                inicio = null;
                tamaño = 0;
                return "La lista ha sido eliminada";
            }else {
                return "La lista no tiene valores";
            }
        }
        //----------------------------------------------------------------------------------------------------------
        //Muestra en pantalla los elementos de la lista.
        public void listar(){
            //verifica si la lista tiene elementos
            if(!esVacia()){
                //crea una copia de la lista
                Nodo aux=inicio;
                //posicion de los elementos de la lista
                int i=0;
                //recorre los elementos de la lista
                while (aux!=null){
                    //Imprime en pantalla el valor del nodo
                    System.out.print(i+".["+aux.getValor()+"]"+"\n");
                    //Avanza al siguiente nodo.
                    aux=aux.getSiguiente();
                    i++;
                }
            }else{System.out.println("La lista no tiene valores a mostrar");}
        }
    }