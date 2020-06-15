package juego;

import javax.swing.JPanel;

public class Topo extends Personaje {
	
	private String Sentido;
	
	Topo(JPanel JP, int x, int y) {
		super (JP);		// Primero llamamos al constructor padre.
		this.x = x;
		this.y = y;
		this.Sentido = "ABAJO";
	}
	
	public void movimientoTopo() {
		if (this.y<0) {
			this.Sentido = "ABAJO";
			this.y = this.y+10;
			this.setDireccion("src/juego/imagenes/Topo_Abajo.png");
		}
		
		// Le restamos 200 a la condición de movimiento pra evitar que el personaje desaparezca debido a la anchura del escenario.
		else if (this.y>this.getPanel().getWidth()-100) {
			this.Sentido = "ARRIBA";
			this.y = this.y-10;
			this.setDireccion("src/juegos/imagenes/Topo_Arriba.png");			
		}
		else if (this.Sentido.contentEquals("ABAJO")) {
			this.y = this.y+10;
			this.setDireccion("src/juegos/imagenes/Topo_Abajo.png");			
		}
		else if (this.Sentido.contentEquals("OESTE")) {
			this.y = this.y-10;
			this.setDireccion("src/juegos/imagenes/Topo_Arriba.png");			
		}
	}

}
