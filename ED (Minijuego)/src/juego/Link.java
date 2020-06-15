package juego;

import javax.swing.JPanel;

public class Link extends Personaje {
	
	// Propiedades �nicas para Link:
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

	// M�todos Getters y Setters:
	
	/**
	 * M�todo para mostrar la salud del personaje.
	 * @return salud del personaje.
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * M�todo para establecer la salud del personaje.
	 */
	public void setSalud(int salud) {
		this.salud = salud;
	}

	/**
	 * M�todo para mostrar el n�mero de escudos del personaje.
	 * @return n�mero de escudos del personaje.
	 */
	public int getEscudo() {
		return escudo;
	}

	/**
	 * M�todo para establecer el n�mero de escudos del personaje.
	 */
	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	/**
	 * M�todo para mostrar el arma del personaje.
	 * @return arma del personaje.
	 */
	public int getArma() {
		return arma;
	}

	/**
	 * M�todo para establecer el arma del personaje.
	 */
	public void setArma(int arma) {
		this.arma = arma;
	}
	
	

}
