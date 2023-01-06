package televisorPrueba;

import java.util.Scanner;

import televisor.Canal;
import televisor.Entradas;
import televisor.Televisor;

public class PruebaTelevisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		final byte ENCENDER_APAGAR = 1, DISPLAY = 2, INPUT = 3, CANAL_1D = 4, CANAL_2D = 5, CANAL_3D = 6, CANAL_4D = 7, SUBIR_VOL = 8, BAJAR_VOL = 9, MUTEAR_VOL = 10, CANAL_ANT = 11, NUEVO_CANAL = 12, MAPA_CONTROL = 13, NUM_SERIE = 14, LISTA_CANALES = 15;
		Televisor nuevoTelevisor = new Televisor();
		System.out.println("      Control remoto");
		System.out.println(mapaControlRemoto());
		while (true) {
		System.out.print("¿Que botón desea presionar?(Ingrese 13 para ver el mapa del control remoto): ");
		byte botonPresionado = sc.nextByte();
		while (botonPresionado < 1 || botonPresionado > 15) {
			System.out.println("------------------------------------------------");
			System.out.print("Botón ingresado incorrecto, ingréselo nuevamente: ");
			botonPresionado  = sc.nextByte();
		}
		switch (botonPresionado) {
		case ENCENDER_APAGAR:{
			nuevoTelevisor.EncenderOApagar();
			if (nuevoTelevisor.isEncendido()) {
				System.out.println(" -------------------");
				System.out.println("|Televisor encendido|");
				System.out.println(" -------------------");
				break;
			}
			System.out.println(" -----------------");
			System.out.println("|Televisor apagado|");
			System.out.println(" -----------------");
			break;
		}
		case DISPLAY:{
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("----------------------------------------");
				System.out.println(nuevoTelevisor.toString());
				System.out.println("----------------------------------------");
				break;
			}
			else {
				advertenciaTeleApagada();
				break;
			}
		}
		case INPUT:{
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("-------------------------");
				System.out.println("1- Entrada de aire| 2- Entrada de cable| 3- HDMI_1| 4- HDMI_2| 5- USB");
				System.out.print("¿Que entrada desea seleccionar?: ");
				//Se extrajo el switch que devolvía el tipo de entrada
				entradaDelMonitor(sc, nuevoTelevisor);
			}
			else advertenciaTeleApagada();
			break;
		}
		case CANAL_1D: {
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("-------------------------");
				System.out.print("Ingrese un dígito para cambiar de canal: ");
				byte canal = sc.nextByte();
				if (nuevoTelevisor.cambiarDeCanal(canal) == true) {
					System.out.println("-------------------------");
					System.out.println("Se ha cambiado al canal " + canal);
					System.out.println("-------------------------");
					break;
				}
				else {
					System.out.println("-------------------------");
					System.out.println("No se pudo cambiar de canal");
					System.out.println("-------------------------");
					break;
				}
			}
			else advertenciaTeleApagada();
			break;
		}
		case CANAL_2D: {
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("-------------------------");
				System.out.print("Ingrese el primer  dígito: ");
				byte digito1 = sc.nextByte();
				System.out.print("Ingrese el segundo dígito: ");
				byte digito2 = sc.nextByte();
				if (nuevoTelevisor.cambiarDeCanal(digito1, digito2) == true) {
					System.out.println("-------------------------");
					System.out.println("Se ha cambiado al canal " + nuevoTelevisor.getCanalActual());
					System.out.println("-------------------------");
					break;
				}
				else {
					System.out.println("-------------------------");
					System.out.println("No se pudo cambiar de canal");
					System.out.println("-------------------------");
					break;
				}
			}
			else advertenciaTeleApagada();
			break;
		}
		case CANAL_3D: {
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("-------------------------");
				System.out.print("Ingrese el primer  dígito: ");
				byte digito1 = sc.nextByte();
				System.out.print("Ingrese el segundo dígito: ");
				byte digito2 = sc.nextByte();
				System.out.print("Ingrese el tercer  dígito: ");
				byte digito3 = sc.nextByte();
				if (nuevoTelevisor.cambiarDeCanal(digito1, digito2, digito3) == true) {
					System.out.println("-------------------------");
					System.out.println("Se ha cambiado al canal " + nuevoTelevisor.getCanalActual());
					System.out.println("-------------------------");
					break;
				}
				else {
					System.out.println("-------------------------");
					System.out.println("No se pudo cambiar de canal");
					System.out.println("-------------------------");
					break;
				}
			}
			else advertenciaTeleApagada();
			break;
		}
		case CANAL_4D: {
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("-------------------------");
				System.out.print("Ingrese el primer  dígito: ");
				byte digito1 = sc.nextByte();
				System.out.print("Ingrese el segundo dígito: ");
				byte digito2 = sc.nextByte();
				System.out.print("Ingrese el tercer  dígito: ");
				byte digito3 = sc.nextByte();
				System.out.print("Ingrese el cuarto  dígito: ");
				byte digito4 = sc.nextByte();
				if (nuevoTelevisor.cambiarDeCanal(digito1, digito2, digito3, digito4) == true) {
					System.out.println("-------------------------");
					System.out.println("Se ha cambiado al canal " + nuevoTelevisor.getCanalActual());
					System.out.println("-------------------------");
					break;
				}
				else {
					System.out.println("-------------------------");
					System.out.println("No se pudo cambiar de canal");
					System.out.println("-------------------------");
					break;
				}
			}
			else advertenciaTeleApagada();
			break;
		}
		case SUBIR_VOL: {
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("-------------------------");
				System.out.print("¿Cuantas veces presiona el botón de subir volumen?: ");
				byte volumen = sc.nextByte();
				for (int i = 0; i < volumen; i++) {
					nuevoTelevisor.subirOBajarAnalogicamente('+');
					}
				System.out.println("Se ha subido el volumen al " + nuevoTelevisor.getVolumen() + "%");
				System.out.println("-------------------------");
				break;
			}
			else advertenciaTeleApagada();
			break;
		}
		case BAJAR_VOL: {
			if (nuevoTelevisor.isEncendido()) {
				System.out.println("-------------------------");
				System.out.print("¿Cuantas veces presiona el botón de bajar volumen?: ");
				byte volumen = sc.nextByte();
				for (int i = 0; i < volumen; i++) {
					nuevoTelevisor.subirOBajarAnalogicamente('-');
					}
				System.out.println("Se ha bajado el volumen al " + nuevoTelevisor.getVolumen() + "%");
				System.out.println("-------------------------");
				break;
			}
			else advertenciaTeleApagada();
			break;
		}
		case MUTEAR_VOL:{
			if (nuevoTelevisor.isEncendido()) {
				nuevoTelevisor.silenciar();
				System.out.println("-----------------------------");
				System.out.println("Se ha silenciado el televisor");
				System.out.println("-----------------------------");
				break;
				}
			else advertenciaTeleApagada();
			break;
		}
		case CANAL_ANT:{
			if(nuevoTelevisor.isEncendido()) {
				nuevoTelevisor.volverAlCanalAnterior();
				System.out.println("-------------------------");
				System.out.println("Se ha vuelto al canal " + nuevoTelevisor.getCanalActual());
				System.out.println("-------------------------");
				break;
			}
			else advertenciaTeleApagada();
			break;
		}
		case NUEVO_CANAL:{
			if (nuevoTelevisor.isEncendido()) {
				//Usé un nuevo scanner porque al usar el scanner anterior daba error al leer un espacio
				Scanner teclado = new Scanner (System.in);
				if (nuevoTelevisor.getEntradaActual() == Entradas.TELEVISION_DE_AIRE || nuevoTelevisor.getEntradaActual() == Entradas.TELEVISION_POR_CABLE) {
				System.out.println("-------------------------");
				System.out.print("¿Que número de canal desea agregar?: ");
				short numeroDeCanal = sc.nextShort();
					//Se verifica que el número ingresado esté dentro del rango de canales
					while (numeroDeCanal > nuevoTelevisor.cantCanalesMaximosActuales() || numeroDeCanal < 0) {
						System.out.print("Numero de canal incorrecto, ingréselo nuevamente: ");
						numeroDeCanal = sc.nextShort();
					}
				System.out.print("¿Que descripción quiere darle al canal?: ");
				String descripcion = teclado.nextLine();
				//Se extrajo el método que devuelve si tiene ClosedCaption o no
				System.out.print("¿Posee ClosedCaption? 1- Si| 2- No ");
				boolean closedCaption = seleccionClosedCaption(sc);
				//Se extrajo el método que devuelve si tiene sonido Stereo o no
				System.out.print("¿Posee sonido Stereo? 1- Si| 2- No ");
				boolean sonidoStereo = seleccionSonidoStereo(sc);
				//Creación del canal con los parámetros dados
				Canal nuevoCanal = new Canal(numeroDeCanal, descripcion, closedCaption, sonidoStereo);
				if (nuevoTelevisor.agregarCanal(nuevoCanal) == true) {
					System.out.println("-------------------------");
					System.out.println("Se ha agregado el canal " + numeroDeCanal + " exitosamente" );
					System.out.println("-------------------------");
					break;
					}
				else System.out.println("-------------------------"); 
					 System.out.println("No se ha podido agregar el canal");
					 System.out.println("-------------------------");
					 break;
			}
			else System.out.println("-----------------------------"); 
				 System.out.println("Opción no diponible");
				 System.out.println("-----------------------------");
				 break;
		}
			advertenciaTeleApagada();
			break;
		}
		case MAPA_CONTROL:{
			limpiarPantalla();
			System.out.println("      Control remoto");
			System.out.println(mapaControlRemoto());
			break;
		}
		case NUM_SERIE: //Opcion secreta para saber el número de serie de la plaqueta  	
			System.out.println("Número de serie: " + nuevoTelevisor.getNumeroDeSerie());
			break;
		case LISTA_CANALES:{
			System.out.println("-----------------------------"); 
			System.out.println(nuevoTelevisor.listaDeCanalesOrdenado());
			System.out.println("-----------------------------"); 
			break;
		}
			}
		}
	}
	private static boolean seleccionSonidoStereo(Scanner sc) {
		byte seleccion;
		seleccion = sc.nextByte();
		boolean sonidoStereo = false;
		switch (seleccion) {
		case 1:
			sonidoStereo = true;
			break;
		case 2:
			sonidoStereo = false;
			break;
		}
		return sonidoStereo;
	}

	private static boolean seleccionClosedCaption(Scanner sc) {
		byte seleccion = sc.nextByte();
		boolean closedCaption = false;
		switch (seleccion) {
		case 1:
			closedCaption = true;
			break;
		case 2:
			closedCaption = false;
			break;
		}
		return closedCaption;
	}

	private static void entradaDelMonitor(Scanner sc, Televisor nuevoTelevisor) {
		byte seleccion = sc.nextByte();
		switch (seleccion) {
		case 1:{
			nuevoTelevisor.seleccionarEntrada(Entradas.TELEVISION_DE_AIRE);
			System.out.println("-------------------------");
			System.out.println("Opción seleccionada");
			System.out.println("-------------------------");
			break;}
		case 2:{
			nuevoTelevisor.seleccionarEntrada(Entradas.TELEVISION_POR_CABLE);
			System.out.println("-------------------------");
			System.out.println("Opción seleccionada");
			System.out.println("-------------------------");
			break;}
		case 3:{
			nuevoTelevisor.seleccionarEntrada(Entradas.HDMI_1);
			System.out.println("-------------------------");
			System.out.println("Opción seleccionada");
			System.out.println("-------------------------");
			break;}
		case 4:{
			nuevoTelevisor.seleccionarEntrada(Entradas.HDMI_2);
			System.out.println("-------------------------");
			System.out.println("Opción seleccionada");
			System.out.println("-------------------------");
			break;}
		case 5:{
			nuevoTelevisor.seleccionarEntrada(Entradas.USB);
			System.out.println("-------------------------");
			System.out.println("Opción seleccionada");
			System.out.println("-------------------------");
			break;}
		}
	}

	private static void limpiarPantalla() {
		for (int i = 0; i < 20; i++) {
			System.out.println("");
		}
	}
	private static void advertenciaTeleApagada() {
		System.out.println("--------------------------------------------------");
		System.out.println("Televisor apagado, enciéndalo para ver esta opción");
		System.out.println("--------------------------------------------------");
		}
	private static String mapaControlRemoto() {
		String control = 
				"        .-------.\r\n"
				+ "    .-==============-.\r\n"
				+ "    | === [POWER]    | 1- [POWER] Encender o apagar \r\n"
				+ "    |[Display][Input]| 2- [Display] Estado del televisor \r\n"
				+ "    | o    ====      | 3- [Input] Selecciona la entrada deseada \r\n"
				+ "    |    [1][2][3]   | 4- Ingresar canal (Un dígito)\r\n"
				+ "    |    [4][5][6]   | 5- Ingresar canal (Dos digitos)\r\n"
				+ "    |    [7][8][9]   | 6- Ingresar canal (Tres digitos)\r\n"
				+ "    |       [0]      | 7- Ingresar canal (Cuatro digitos)\r\n"
				+ "    |     vol  ch    | 8- Subir el volumen n veces \r\n"
				+ "    |    [ + ][ + ]  | 9- bajar el volumen n veces \r\n"
				+ "    |    [ - ][ - ]  | 10- Mutear volumen \r\n"
				+ "    |   [mute][Prev] | 11- Canal anterior \r\n"
				+ "    |  [Nuev. canal] | 12- Nuevo Canal \r\n"
				+ "    '-==============-' 15- Lista de canales disponibles";
		return control;
	}
}
