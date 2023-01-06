package recuperatorio;

public class Sistema {
	private String nombreDelSistema;
	private Usuario usuarios[];
	
public Sistema (String nombreDelSistema, int cantidadMaximaDeUsuarios) {
	this.nombreDelSistema 	= nombreDelSistema;
	this.usuarios 			= new Usuario[cantidadMaximaDeUsuarios];
}

public boolean ingresarUsuario (Usuario nuevoUsuario) {
	boolean estadoUsuario = false;
	for (int i = 0; i < usuarios.length; i++) {
		if (usuarios[i] == null ) {
			usuarios[i] = nuevoUsuario;
			estadoUsuario = true;
			return estadoUsuario;
		}
		else if (usuarios[i].getUsuario().equals(nuevoUsuario.getUsuario())){
			return estadoUsuario;
		}
	}
	return estadoUsuario;
}

public int calcularCantidadDeUsuariosLogueados() {
	int cantUsuarios = 0;
	for (int i = 0; i < usuarios.length; i++) {
		if (usuarios[i] != null) {
			if (usuarios [i].isLogueado() == true) {
				cantUsuarios ++;
			}
		}
	}
	return cantUsuarios;
}

public int calcularCantidadDeUsuariosBloqueados () {
	int cantUsuarios = 0;
	for (int i = 0; i < usuarios.length; i++) {
		if (usuarios[i] != null) {
			if (usuarios [i].isbloqueado() == true) {
				cantUsuarios ++;
			}
		}
	}
	return cantUsuarios;
}

public double calcularEdadPromedio () {
	double edadPromedio = 0.0;
	int cantUsuarios 	= 0;
	int sumaDeEdades	= 0;
	for (int i = 0; i < usuarios.length; i++) {
		if (usuarios[i] != null) {
			sumaDeEdades += usuarios[i].getEdad();
			cantUsuarios ++;
		}
	}
	edadPromedio = sumaDeEdades / cantUsuarios;
	return edadPromedio;
}

public boolean logearUsuario (String usuario, String contrasenia) {
	boolean estadoUsuario = false;
	for (int i = 0; i < usuarios.length; i++) {
		if (usuarios[i] != null) {
			if (usuarios[i].getUsuario().equals(usuario) && usuarios[i].getContrasenia().equals(contrasenia)) {
				estadoUsuario = true;
				return estadoUsuario;
			}
		}
	}
	return estadoUsuario;
}

public Usuario buscar (String usuario) {
	Usuario encontrado = null;
	for (int i = 0; i < usuarios.length; i++) {
		if (usuarios[i] != null) {
			if (usuarios[i].getUsuario().equals(usuario)) {
				encontrado = usuarios[i];
				return encontrado;
			}
		}
	}
	return encontrado;
}

public String getNombreDelSistema() {
	return nombreDelSistema;
}

}
