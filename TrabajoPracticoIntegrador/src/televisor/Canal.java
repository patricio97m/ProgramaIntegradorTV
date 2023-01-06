package televisor;

public class Canal {
	private short 	numeroDeCanal;
	private String 	descripcion;
	private boolean closedCaption;
	private boolean sonidoStereo;
	
public Canal (short numeroDeCanal, String descripcion, boolean closedCaption, boolean sonidoStereo) {
	this.numeroDeCanal 	= numeroDeCanal;
	this.descripcion 	= descripcion;
	this.closedCaption 	= closedCaption;
	this.sonidoStereo	= sonidoStereo;
}

public int getNumeroDeCanal() {
	return numeroDeCanal;
}

public String getDescripcion() {
	return descripcion;
}

public boolean isClosedCaption() {
	return closedCaption;
}

public boolean isSonidoStereo() {
	return sonidoStereo;
}
}
