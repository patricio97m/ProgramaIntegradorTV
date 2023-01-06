package personas;

public class Persona {
	private String nombre;
	private String apellido;
	private int dni;
	private int saldo;
	private String contrasenia;
	
public Persona (String nombre, String apellido, int dni, int saldo, String contrasenia) {
	this.nombre 		= nombre;
	this.apellido 		= apellido;
	this.contrasenia 	= contrasenia;
	this.dni			= dni;
	this.saldo			= saldo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public int getDni() {
	return dni;
}

public void setDni(int dni) {
	this.dni = dni;
}

public int getSaldo() {
	return saldo;
}

public void setSaldo(int saldo) {
	this.saldo = saldo;
}

public String getContrasenia() {
	return contrasenia;
}

public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}


}
