package recuperatorio;

public class Usuario {
	private String 	usuario;
	private String 	contrasenia;
	private String 	nombre;
	private String 	apellido;
	private int 	edad;
	private boolean logueado ;
	private boolean bloqueado ;

public Usuario (String usuario, String contrasenia, String nombre, String apellido, int edad) {
	this.usuario 		= usuario;
	this.contrasenia 	= contrasenia;
	this.nombre			= nombre;
	this.apellido		= apellido;
	this.edad			= edad;
}

public boolean laContraseniaEsValida(String contrasenia) {
	char cantCaracteres[] 		= contrasenia.toCharArray();
	boolean estadoContrasenia 	= false;
	boolean contieneNumero 		= false, contieneMinuscula = false, contieneMayuscula = false, contieneCaracter = false;
		for (int i = 0; i < cantCaracteres.length; i++) {
			if (Character.isDigit(cantCaracteres[i])) {
				contieneNumero 		= true;
			}
			if (Character.isLowerCase(cantCaracteres[i])) {
				contieneMinuscula 	= true;
			}
			if (Character.isUpperCase(cantCaracteres[i])) {
				contieneMayuscula 	= true;
			}
			if(!Character.isAlphabetic(cantCaracteres[i]) && !Character.isDigit(cantCaracteres[i])) {
				contieneCaracter 	= true;
			}
		}
	if (contieneNumero == true && contieneCaracter == true && contieneMayuscula == true && contieneMinuscula == true && cantCaracteres.length >= 8) {
		estadoContrasenia = true;
		return estadoContrasenia;
	}
	return estadoContrasenia;
}

public boolean cambiarContrasenia (String contrasenia) {
	boolean estadoContrasenia 	= false;
	String contraseniaAnterior 	= this.contrasenia;
	if (laContraseniaEsValida(contrasenia) == true && !contraseniaAnterior.equals(contrasenia)) {
		this.contrasenia 	= contrasenia;
		estadoContrasenia 	= true;
		return estadoContrasenia;
	}
	return estadoContrasenia;
}

public String getUsuario() {
	return usuario;
}

public String getNombre() {
	return nombre;
}

public String getApellido() {
	return apellido;
}

public int getEdad() {
	return edad;
}

public String getContrasenia() {
	return contrasenia;
}
public boolean isLogueado() {
	logueado = true;
	bloqueado = false;
	return logueado;
}
public boolean isbloqueado() {
	bloqueado = true;
	logueado = false;
	return bloqueado;
}
}
