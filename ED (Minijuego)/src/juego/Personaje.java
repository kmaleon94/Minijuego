package juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Personaje {
	
	// Propiedades o atributos:
	protected int x;
	protected int y;
	protected String Direccion;
	
	private JPanel MiJP;
	
	// Constructor:
	public Personaje(JPanel JP) {
		this.x = -30;
		this.y = 0;	
		this.MiJP = JP;
	}
		
	// Método que devuelve la coordenada x:
	public int CoordX() {
		return this.x;
	}
	
	// Método que devuelve la coordenada y:
	public int CoordY() {
		return this.y;
	}
	
	public String getDireccion() {return this.Direccion;}
	
	public void setDireccion(String Direccion) {this.Direccion=Direccion;}
	
	public void setCoordX(int x) {this.x=x;}
	
	public void setCoordY(int y) {this.y=y;}
	
	public JPanel getPanel() {return this.MiJP;}
	

}
