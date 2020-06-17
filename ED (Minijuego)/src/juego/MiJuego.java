package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

import javax.swing.JLabel;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

//  Librerias para el tiempo:
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class MiJuego extends JFrame {

	private JPanel contentPane;
	
	Timer reloj;
	
	Link player; 	// Creamos el objeto.

	/**
	 * Create the frame.
	 */
	public MiJuego() {
		setTitle("The Legend of Zelda");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		contentPane.add(panel, BorderLayout.CENTER);
		
		player = new Link(panel, 100, 0, 0);
		
		// Creación de nuestro primer enemigo (Broncas) en la posición:
		// x=80 y=130.
		Broncas broncas = new Broncas(panel, 80, 130);
		
		// Creación de nuestro segundo enemigo (Topo) en la posición:
		// x=70 y=70.
		Topo topo = new Topo(panel, 70, 70);
		
		// Creación de nuestra último enemigo (Fantasma) en la posición:
		// x=50 y=50.
		Fantasma ghost = new Fantasma(panel, 50, 50);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setEnabled(true);
		lblNewLabel_3.setBackground(SystemColor.menu);
		lblNewLabel_3.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/Map Resize Max.png")));
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Salud: "+player.getSalud());
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Escudo: "+player.getEscudo());
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.BOLD, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Arma: "+player.getArma());
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				// Imprimmos por pantalla las coordenadas para ver que como se desplaza correctamente:
				System.out.println("x-->"+player.CoordX()+", y-->"+player.CoordY());
				
				// Imprimimos por pantalla las dimensiones del panel para poder ajustar el fondo:
				System.out.println(panel.getWidth());
				System.out.println(panel.getHeight());
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (player.CoordX()>-30) {
						player.setCoordX(player.CoordX()-10);
						player.setDireccion("src/juego/imagenes/Izquierda.png");
					}					
					break;
				case KeyEvent.VK_RIGHT:
					if (player.CoordX()<(panel.getWidth()-100)) {
						player.setCoordX(player.CoordX()+10);
						player.setDireccion("src/juego/imagenes/Derecha.png");
					}					
					break;
				case KeyEvent.VK_UP:
					if (player.CoordY()>0) {
						player.setCoordY(player.CoordY()-10);
						player.setDireccion("src/juego/imagenes/Arriba.png");
					}					
					break;
				case KeyEvent.VK_DOWN:
					if (player.CoordY()<(panel.getWidth()-251)) {
						player.setCoordY(player.CoordY()+10);
						player.setDireccion("src/juego/imagenes/Abajo.png");
					}					
					break;			
				}				
			}				
		});	
		
		// Parte del código que cada 100 milisegundos moverá a los enemigos:
					reloj = new Timer(100, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							double contTiempo=0;
							contTiempo=(contTiempo+reloj.getDelay())%5000;
							//System.out.println(contTiempo);
							
							// Actualizamos las posiciones de los personajes:
							topo.getPanel().update(panel.getGraphics());
							broncas.getPanel().update(panel.getGraphics());
							player.getPanel().update(panel.getGraphics());
							ghost.getPanel().update(panel.getGraphics());
							
							//  Actualizamos al personaje Player:
							ImageIcon MiImagen = new ImageIcon(player.getDireccion());
							panel.getGraphics().drawImage(MiImagen.getImage(), player.CoordX(), player.CoordY(), panel);
							
							// Actualizamos al personaje Broncas:
							broncas.movimientoBroncas();
							ImageIcon ImagenBroncas = new ImageIcon(broncas.getDireccion());
							panel.getGraphics().drawImage(ImagenBroncas.getImage(), broncas.CoordX(), broncas.CoordY(), panel);
							
							// Actualizamos al personaje Topo:
							topo.movimientoTopo();
							ImageIcon ImagenTopo = new ImageIcon(topo.getDireccion());
							panel.getGraphics().drawImage(ImagenTopo.getImage(), topo.CoordX(), topo.CoordY(), panel);
							
							//Actualizamos a Fantasma
							if (contTiempo==0) {
								ghost.setVisible();
								Random r = new Random();
								int valorX = r.nextInt(650);
								int valorY = r.nextInt(460);
								ghost.setCoordX(valorX);
								ghost.setCoordY(valorY);
								//System.out.println("Cambio");
							}
							
							// Linea para evitar parpadeos:
							panel.getGraphics().drawImage(null, 10, 80, null);
														
							//Colisión con los personajes
							int hiddenBox=100;	//Variable creada para regular el tamaño de la caja oculta
							if ((player.CoordX() >= broncas.CoordX()-hiddenBox && player.CoordX() <= broncas.CoordX()+hiddenBox) 
									&& ((player.CoordY() >= broncas.CoordY()-hiddenBox && player.CoordY() <= broncas.CoordY()+hiddenBox))){
									
								System.out.println("¡Player está tocando a broncas!");
								
									if(player.getEscudo() <= 0) {
										player.setSalud(player.getSalud()-10);
										lblNewLabel.setText("Salud: " + player.getSalud());
									}
									if(player.getSalud() <= 0) {
										reloj.stop();
										dispose();
									}		
							}
																					
						}							
					});
					reloj.start();
							
	}
	
}
