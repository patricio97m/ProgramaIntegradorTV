package recuperatorio;

import java.util.Scanner;

public class PruebaSistema {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int opcionSeleccionada = 0;
		Sistema nuevoSistema = new Sistema("Nuevo sistema", 10);
		do {
		System.out.println("-------------");
		System.out.println("Menu");
		System.out.println("-------------");
		System.out.println("1. Registrar nuevos usuarios en el Sistema");
		System.out.println("2. Ver las estad�sticas del sistema (Cantidad de usuarios logueados, bloqueados, porcentaje de"
				+ "usuarios logueados y edad promedio de los usuarios)");
		System.out.println("3. Probar el login.");
		System.out.print("Seleccione una opci�n: ");
		opcionSeleccionada = sc.nextInt();
		
		switch (opcionSeleccionada) {
		case 1:{
			registrarNuevoUsuario(sc, nuevoSistema);
			break;
		}
		case 2:{
			verEstadisticas(nuevoSistema);
			break;
		}
		case 3: {
			probarLogin(sc, nuevoSistema);
			break;
		}

		default:
			break;
		}
		}
		while (opcionSeleccionada < 5);
		

	}

	private static void probarLogin(Scanner sc, Sistema nuevoSistema) {
		System.out.print("Ingrese usuario a buscar: ");
		String usuario = sc.next();
		System.out.println("Ingrese contrase�a a verificar: ");
		String contrasenia = sc.next();
		if(nuevoSistema.logearUsuario(usuario, contrasenia) == true) {
			System.out.println("Este usuario existe en el sistema");
		}
		else {
			System.out.println("Este usuario NO se loge� con exito");
		}
		
	}

	private static void verEstadisticas(Sistema nuevoSistema) {
		System.out.println("Cantidad de usuarios logueados: " + nuevoSistema.calcularCantidadDeUsuariosLogueados());
		System.out.println("Cantidad de usuarios bloqueados: " + nuevoSistema.calcularCantidadDeUsuariosBloqueados());
		System.out.println("Edad promedio de usuarios: " + nuevoSistema.calcularEdadPromedio());
		
	}

	private static void registrarNuevoUsuario(Scanner sc, Sistema nuevoSistema) {
		System.out.print("Ingrese usuario: ");
		String usuario = sc.next();
		System.out.println("Ingrese contrase�a: ");
		String contrasenia = sc.next();
		System.out.print("Ingrese nombre: ");
		String nombre = sc.next();
		System.out.print("Ingrese apellido: ");
		String apellido = sc.next();
		System.out.print("Ingrese edad: ");
		int edad = sc.nextInt();
		Usuario nuevo = new Usuario(usuario, contrasenia, nombre, apellido, edad);
		if (nuevo.laContraseniaEsValida(contrasenia) && nuevoSistema.ingresarUsuario(nuevo)) {
			System.out.println("Se ha agregado con �xito");
		}
		else {
			System.out.println("No se pudo agregar. Contraseña y/o usuario incorrectos");
		}
		
		
		
	}

}
