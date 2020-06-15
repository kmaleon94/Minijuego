package juego;

import javax.swing.JPanel;

public class Link extends Personaje {
	
	// Propiedades únicas para Link:
	private int salud;
	private int escudo;
	private int arma;
	
	// Constructor: 
	Link(JPanel JP, int s, int e, int a) {
		super(JP);		// Primer llamamos al constructor padre.
		this.salud = s;
		this.escudo = e;
		this.arma = a;
	}

	// Métodos Getters y Setters:
	
	/**
	 * Método para mostrar la salud del personaje.
	 * @return salud del personaje.
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * Método para establecer la salud del personaje.
	 */
	public void setSalud(int salud) {
		this.salud = salud;
	}

	/**
	 * Método para mostrar el número de escudos del personaje.
	 * @return número de escudos del personaje.
	 */
	public int getEscudo() {
		return escudo;
	}

	/**
	 * Método para establecer el número de escudos del personaje.
	 */
	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	/**
	 * Método para mostrar el arma del personaje.
	 * @return arma del personaje.
	 */
	public int getArma() {
		return arma;
	}

	/**
	 * Método para establecer el arma del personaje.
	 */
	public void setArma(int arma) {
		this.arma = arma;
	}
	
	

}
