/**
 * Created by root on 19/10/2017.
 */
public class Nodo
{
        public   Object valor; //Guarda el valor
        public   Nodo siguiente;//Enlace al siguiente valor
    //Constructor para unicializar el valor de nuestras variables
    public  void Nodo(Object valor){
        this.valor=valor;
        this.siguiente=null;
    }
        public Object getValor(){return valor;}
        public void setValor(Object valor){
            this.valor=valor;
    }
        public Nodo getSiguiente(){
        return siguiente;
    }
        public void setSiguiente(Nodo siguiente){
        this.siguiente=siguiente;
    }
}
