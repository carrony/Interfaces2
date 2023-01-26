package modelo;

import java.util.Objects;

public class Persona {
	
	private String dni;
	private String nombre;
	private String apellido;
	private int dia;
	private int mes;
	private int anio;
	
	public Persona() {
		this.dni="";
		this.nombre="";
		this.apellido="";
	}

	public Persona(String dni, String nombre, String apellido, int dia, 
			int mes, int anio) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public String getFecha() {
		return String.format("%02d",this.dia)+"/"+
			   String.format("%02d",this.mes)+"/"+this.anio;
	}

	@Override
	public String toString() {
		return "Dni:" + dni + "\nNombre:" + nombre 
				+ "\nApellido:" + apellido + "\nFecha Nacimiento:" 
				+ getFecha();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return dni.equalsIgnoreCase(other.dni);
	}
	
	
	
	
	
}
