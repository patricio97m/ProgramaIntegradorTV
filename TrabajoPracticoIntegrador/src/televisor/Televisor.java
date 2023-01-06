package televisor;

import static televisor.Entradas.TELEVISION_DE_AIRE;

public class Televisor {
	private static int 	NUMERO_DE_SERIE;
	private byte 		cantCanalesDeAire;
	private short 		cantCanalesDeCable;
	private byte 		volumen;
	private short		canalActual;
	private short 		canalAnterior;
	private boolean 	onOff 	= false;
	private static 		Entradas seleccionarEntrada;
	private Canal[] 	canalesDeAire;
	private Canal[]		canalesDeCable;
	
//Constructores	
public Televisor () {
	this.cantCanalesDeAire 	= 127;
	this.cantCanalesDeCable	= 32767;
	canalesDeAire 			= new Canal [cantCanalesDeAire];
	canalesDeCable			= new Canal [cantCanalesDeCable];
	Televisor.NUMERO_DE_SERIE ++;
	this.seleccionarEntrada(TELEVISION_DE_AIRE);
}
public Televisor (byte canalMaximoTelevisionAbierta, short canalMaximoTelevisionPorCable) {
	canalesDeAire 	= new Canal [canalMaximoTelevisionAbierta];
	canalesDeCable	= new Canal [canalMaximoTelevisionPorCable];
	this.seleccionarEntrada(TELEVISION_DE_AIRE);
	Televisor.NUMERO_DE_SERIE ++;
}

//Métodos
public void EncenderOApagar() {
	if (onOff 	== true) {
		onOff 	=  false;
		}
	else onOff 	=  true;
}
public String toString(){
	if (getEntradaActual() == Entradas.TELEVISION_DE_AIRE) {
		if (canalesDeAire[canalActual] == null) {
			return "Opción no disponible, no hay ningún canal configurado con este número";
		}
		String estadoDeTv = "Canal actual: " + canalActual + "| Descripción: " + canalesDeAire[canalActual].getDescripcion() + "| ClosedCaption: " + canalesDeAire[canalActual].isClosedCaption() + "| Sonido Stereo: " + canalesDeAire[canalActual].isSonidoStereo();
		return estadoDeTv;
	}
	
	if (getEntradaActual() == Entradas.TELEVISION_POR_CABLE) {
		if (canalesDeCable[canalActual] == null) {
			return "Opción no disponible, no hay ningún canal configurado con este número";
		}
		String estadoDeTv = "Canal actual: " + canalActual + "| Descripción: " + canalesDeCable[canalActual].getDescripcion() + "| ClosedCaption: " + canalesDeCable[canalActual].isClosedCaption() + "| Sonido Stereo: " + canalesDeCable[canalActual].isSonidoStereo();
		return estadoDeTv;
	}
	return "Opción no disponible";
		}
public void seleccionarEntrada (Entradas entradaDeseada) {
	seleccionarEntrada = entradaDeseada; 
}

public boolean subirOBajarAnalogicamente (char operacion) {
	switch (operacion) {
	case '+': {
		if (volumen < 100) {
			volumen ++;
			return true;
		}
		return false;
	}
	case '-': {
		if (volumen > 0) {
			volumen --;
			return true;
		}
		return false;
	}
	case '>':{
		if (seleccionarEntrada == TELEVISION_DE_AIRE) {
			if (canalActual <= 127) {
				canalAnterior = canalActual;
				canalActual ++;
				return true;
			}
			return false;
		}
		if (seleccionarEntrada == Entradas.TELEVISION_POR_CABLE) {
			if (canalActual <= 32767) {
				canalAnterior = canalActual;
				canalActual ++;
				return true;
			}
			return false;
		}
	}
	case '<':{
		if (canalActual > 0) {
			canalAnterior = canalActual;
			canalActual --;
			return true;
		}
		return false;
	}
	}
return false;
}

public boolean cambiarDeCanal (byte canalDeseado) {
	if(getEntradaActual() 	== Entradas.TELEVISION_DE_AIRE || getEntradaActual() == Entradas.TELEVISION_POR_CABLE ) {
		if (canalDeseado >= 0 && canalDeseado <= 9) {
		canalAnterior 		= canalActual;
		canalActual 		= canalDeseado;
		return true;
		}
	}	
	return false;
}
public boolean cambiarDeCanal (byte primerDigito, byte segundoDigito) {
	String cadenaDeCanal = String.valueOf(primerDigito) + String.valueOf(segundoDigito);
	byte canal = Byte.valueOf(cadenaDeCanal);
	if (getEntradaActual() 	== Entradas.TELEVISION_DE_AIRE) {
		if (canal <= canalesDeAire.length ) {
			canalAnterior 	= canalActual;
			canalActual 	= canal;
			return true;
			}
	}
	if (getEntradaActual() 	== Entradas.TELEVISION_POR_CABLE) {
		if (canal <= canalesDeCable.length ) {
			canalAnterior 	= canalActual;
			canalActual 	= canal;
			return true;
			}
		}
	return false;
}
public boolean cambiarDeCanal (byte primerDigito, byte segundoDigito, byte tercerDigito) {
	String cadenaDeCanal = String.valueOf(primerDigito) + String.valueOf(segundoDigito) + String.valueOf(tercerDigito);
	short canal = Short.valueOf(cadenaDeCanal);
	if (getEntradaActual() 	== Entradas.TELEVISION_DE_AIRE) {
		if (canal <= canalesDeAire.length ) {
			canalAnterior 	= canalActual;
			canalActual   	= canal;
			return true;
			}
		}
	if (getEntradaActual() == Entradas.TELEVISION_POR_CABLE) {
		if (canal <= canalesDeCable.length ) {
			canalAnterior 	= canalActual;
			canalActual   	= canal;
			return true;
			}
		}
	return false;
}
public boolean cambiarDeCanal (byte primerDigito, byte segundoDigito, byte tercerDigito, byte CuartoDigito) {
	String cadenaDeCanal = String.valueOf(primerDigito) + String.valueOf(segundoDigito) + String.valueOf(tercerDigito) + String.valueOf(CuartoDigito);
	short canal = Short.valueOf(cadenaDeCanal);
	if (getEntradaActual() == Entradas.TELEVISION_DE_AIRE) {
		if (canal <= canalesDeAire.length ) {
			canalAnterior 	= canalActual;
			canalActual 	= canal;
			return true;
			}
	}
	if (getEntradaActual() == Entradas.TELEVISION_POR_CABLE) {
		if (canal <= canalesDeCable.length ) {
			canalAnterior 	= canalActual;
			canalActual 	= canal;
			return true;
			}
		}
	return false;
}

public void volverAlCanalAnterior() {
	canalActual = canalAnterior;
}
public void silenciar () {
	volumen  = 0;
}
public int getNumeroDeSerie() {
	return NUMERO_DE_SERIE;
}
public boolean isEncendido() {
	if (onOff == true) {
		return true;
	}
	return false;
}
public int getVolumen() {
	return volumen;
}
public int getCanalActual() {
	return canalActual;
}
public Entradas getEntradaActual() {
	return Televisor.seleccionarEntrada;
}
public boolean agregarCanal (Canal nuevoCanal) {
	if (getEntradaActual() == Entradas.TELEVISION_DE_AIRE) {
		canalesDeAire[nuevoCanal.getNumeroDeCanal()] = nuevoCanal;
		return true;
	}
	if (getEntradaActual() == Entradas.TELEVISION_POR_CABLE) {
		canalesDeCable[nuevoCanal.getNumeroDeCanal()] = nuevoCanal;
		return true;
	}
	return false;
}
public int cantCanalesMaximosActuales() {
	if (seleccionarEntrada == Entradas.TELEVISION_DE_AIRE) {
		return canalesDeAire.length;
	}
	if (seleccionarEntrada == Entradas.TELEVISION_POR_CABLE) {
		return canalesDeCable.length;
	}
return 0;	
}
public String listaDeCanalesOrdenado (){
	String listaCompleta = "";
	if (seleccionarEntrada == Entradas.TELEVISION_DE_AIRE) {
		for (int i = 0; i < canalesDeAire.length; i++) {
			for (int j = 0; j < canalesDeAire.length - 1; j++ ) {
				if (canalesDeAire[j] != null && canalesDeAire[j + 1] != null) {
					if (canalesDeAire[j].getNumeroDeCanal() < canalesDeAire[j + 1].getNumeroDeCanal()) {
						Canal auxiliar = canalesDeAire[j + 1];
						canalesDeAire[j + 1] = canalesDeAire[j];
						canalesDeAire[j] = auxiliar;
					}
				}
			}
		}
		for (int i = 0; i < canalesDeAire.length; i++) {
			if (canalesDeAire[i] != null) {
				listaCompleta += "Canal número : " + canalesDeAire[i].getNumeroDeCanal() + " | Descripción: " + canalesDeAire[i].getDescripcion() + "\n";
			}
		}
		return listaCompleta;
	}
	if (seleccionarEntrada == Entradas.TELEVISION_POR_CABLE) {
		for (int i = 0; i < canalesDeCable.length; i++) {
			for (int j = 0; j < canalesDeCable.length - 1; j++ ) {
				if (canalesDeCable[j] != null && canalesDeCable[j + 1] != null) {
					if (canalesDeCable[j].getNumeroDeCanal() < canalesDeCable[j + 1].getNumeroDeCanal()) {
						Canal auxiliar = canalesDeCable[j + 1];
						canalesDeCable[j + 1] = canalesDeCable[j];
						canalesDeCable[j] = auxiliar;
					}
				}
			}
		}
		for (int i = 0; i < canalesDeCable.length; i++) {
			if (canalesDeCable[i] != null) {
				listaCompleta += "Canal número : " + canalesDeCable[i].getNumeroDeCanal() + " | Descripción: " + canalesDeCable[i].getDescripcion() + "\n ";
			}
		}
		return listaCompleta;
	}
	
	return listaCompleta = "No disponible";
}
}
