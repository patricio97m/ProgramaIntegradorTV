package prueba;

import java.util.Scanner;
import personas.Persona;

public class personaPrueba {
	public static void main(String[] args) {
		final int CANT_PERSONAS_MAX = 10, ALTA_PERSONA = 1, MAYOR_SALDO = 2, IMPRIMIR = 3, INGRESO = 4, SIN_SALDO = 0;
		Persona listado[] = new Persona [CANT_PERSONAS_MAX];
		Scanner sc = new Scanner (System.in);
		byte opcionIngresada = 1;
		
		do {
			System.out.print("\n************Opciones Menu#1***********\r\n"
					+ "************Menu Principal*************\n"
					+ "*1- Alta Nueva Persona******************\n"
					+ "*2- Consulta Persona con Mayor Saldo******\n"
					+ "*3- Imprimir Listado Personas*************\n"
					+ "*4- INGRESO AL CAJERO (DNI y Contraseña)**\n"
					+ "***************************************\n"
					+ "Por favor, ingrese una opción: ");
			
			opcionIngresada = sc.nextByte();
			switch (opcionIngresada) {
			case ALTA_PERSONA:{
				altaNuevaPersona(SIN_SALDO, listado, sc);
				break;
			}
			case MAYOR_SALDO:{
				System.out.println(listaOrdenada(listado));
				break;
			}
			case IMPRIMIR: {
				System.out.println(imprimirLista(listado)); 
				break;
			}
			case INGRESO:{
				menuDeIngreso(sc, listado);
			}
				

			default:
				break;
			}
		}
		while (opcionIngresada > 0 || opcionIngresada <= 4);
	}

	private static void menuDeIngreso(Scanner sc, Persona[] listado) {
		String dniEnString 	= "";
		int cantIntentos 	= 0;
		System.out.println("\n*********Opciones Menu#2*****\r\n"
				+ "**********Menu Login**********\r\n");
		do {
			System.out.println("Ingrese el DNI: ");
			dniEnString = sc.next();
		}
		while (seIngresoUnNumero(dniEnString) == false || comprobarDNIValido(dniEnString, listado) == false);
		
		
		}
		
		
		
		
		
		
	

	private static  boolean comprobarDNIValido(String dniEnString, Persona listado[]) {
		int dni = Integer.parseInt(dniEnString);
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null) {
				if (listado[i].getDni() == dni) {
					return true;
				}
			}
		}
		return false;
		
	}

	private static String imprimirLista(Persona[] listado) {
		String listaOrdenada = "Lista completa de clientes: \n";
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null) {
				listaOrdenada += "Nombre: " + listado[i].getNombre() +  " | Apellido: " + listado[i].getApellido() +  "| DNI: " + listado[i].getDni() + "\n" ;
			}
		}
		return listaOrdenada;
	}

	private static String listaOrdenada(Persona[] listado) {
		String listaOrdenada = "";
		for (int i = 0; i < listado.length; i++) {
			for (int j = 0; j < listado.length - 1; j++) {
				if (listado[j] != null && listado [j+1] != null) {
					if (listado[j].getSaldo() > listado[j+1].getSaldo()) {
						Persona auxiliar = listado[j+1];
						listado[j+1] = listado[j];
						listado[j] = auxiliar;
					}
				}
			}
		}
		
		listaOrdenada = "Persona con mayor saldo: \nNombre: " + listado[0].getNombre() +  " | Apellido: " + listado[0].getApellido() +  "| DNI: " + listado[0].getDni() +  " | Saldo: " + listado[0].getSaldo() ;
		return listaOrdenada;
	}

	private static void altaNuevaPersona(final int SIN_SALDO, Persona[] listado, Scanner sc) {
		System.out.print("Ingrese nombre a agregar: ");
		String nombre = sc.next();
		System.out.print("Ingrese apellido: ");
		String apellido = sc.next();
		String dniEnString;
		do {
		System.out.println("Ingrese el DNI: ");
		dniEnString = sc.next();
		}
		while(seIngresoUnNumero(dniEnString) == false);
		int dni = Integer.parseInt(dniEnString);
		System.out.print("Ingrese nueva contraseña: "); 
		String contrasenia = sc.next();
		Persona nueva = new Persona(nombre, apellido, dni, SIN_SALDO, contrasenia);
		agregarNuevaPersona (nueva, listado);
		System.out.println("Se ha agregado a la persona correctamente");
	}

	private static boolean agregarNuevaPersona(Persona nueva, Persona listado[]) {
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] == null) {
				listado[i] = nueva;
				return true;
			}
		}
		return false;
	}

	private static boolean seIngresoUnNumero(String numero) {
		char cadenaDeNumeros[] = numero.toCharArray();
		 for (int i = 0; i < cadenaDeNumeros.length; i++) {
			if (cadenaDeNumeros[i]  != '0' && cadenaDeNumeros[i] != '1' && cadenaDeNumeros[i] != '2' && cadenaDeNumeros[i] != '3' && cadenaDeNumeros[i] != '4' && cadenaDeNumeros[i] != '5' && cadenaDeNumeros[i] != '6' && cadenaDeNumeros[i] != '7' && cadenaDeNumeros[i] != '8' && cadenaDeNumeros[i] != '9') {
				return false;
			}
		}
		return true;
	}
}
