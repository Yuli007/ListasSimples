import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        Scanner sc = new Scanner(System.in);
        System.out.println("MENÚ");
        System.out.println("1: Insertar ");
        System.out.println("2: Mostrar ");
        System.out.println("3: Buscar ");
        System.out.println("4: Eliminar ");
        System.out.println("5: Contar ");
        System.out.println("6: Limpiar lista ");
        System.out.println("7: Terminar");
        boolean opcionvalida =false;
        while (!opcionvalida) {
            System.out.println("Cual es tu opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad de elementos a insertar: ");
                        int valores = sc.nextInt();
                        for (int i = 0; i < valores; i++) {
                            System.out.println("Teclee el elemento [" + i + "]");
                            Object valor = sc.next();
                            lista.agregar(valor);
                        }
                        break;
                    case 2:
                        lista.listar();
                        break;
                    case 3:
                        boolean valido =false;
                        while (!valido) {
                            System.out.println("Desea buscar por valor o Índice ");
                            System.out.println("1: Por Valor\n2: Por Índice");
                            System.out.println("Cúal es tu opción: ");
                            int decision = sc.nextInt();
                            if (decision == 1) {
                                System.out.println("Ingrese el valor que desea buscar: ");
                                Object buscar = sc.next();
                                System.out.println(lista.getValor(buscar));
                                valido = true;break;
                            }
                            if (decision == 2) {
                                System.out.println("Ingrese el índice que desea buscar: ");
                                int buscar = sc.nextInt();
                                System.out.println(lista.getPosicion(buscar));
                                valido = true;
                            } else {
                                System.out.println("Ingrese una opción númerica entre 1-2");
                            }
                        }
                    break;
                    case 4:
                        boolean valido2 =false;
                        while (!valido2) {
                            System.out.println("Desea eliminar por valor o Índice ");
                            System.out.println("1: Por Valor\n2: Por Índice");
                            System.out.println("Cúal es tu opción: ");
                            int decision2 = sc.nextInt();
                            if (decision2 == 1) {
                                System.out.println("Ingrese el valor que desea eliminar: ");
                                Object eliminar = sc.next();
                                lista.removerporValor(eliminar);
                                lista.listar();
                                valido2 = true;break;
                            } if (decision2 == 2) {
                                System.out.println("Ingrese la posición que desea eliminar: ");
                                int eliminar = sc.nextInt();
                                lista.removerporPosicion(eliminar);
                                lista.listar();
                                valido2 = true;
                            } else {
                                System.out.println("Ingrese una opción númerica entre 1-2");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("El tamaño de la lista es: " + lista.getTamaño());
                        break;
                    case 6:
                        System.out.println(lista.eliminarlista());

                        break;
                    case 7:
                        opcionvalida = true;
                        break;
                    default:
                }
            }
        }
    }
