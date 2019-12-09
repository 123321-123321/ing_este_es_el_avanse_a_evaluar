package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.Enemigos;
import clases.Fondo;
import clases.Item;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private int puntuacion = 0;
	//private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	
	
	private Fondo fondo1;

	//private ArrayList<Image> imagenes;
	private ArrayList<Item> items;
	private ArrayList<Tile> tiles;
	//nuevo
	private ArrayList<Enemigos> enemix;
	//nuevo
	private int[][] mapa = {
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			{0,1,1,1,1,0,0},
			{0,2,2,2,2,0,0},
			{0,3,3,3,3,0,0},
			{0,4,4,4,4,0,0},
			
	};
	
//nuevo
	private int[][] mapaenemigo = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,3,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,4,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,2,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
		};
	//nuevo
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("ES PA FUERA QUE VAS JOH");
		gestionarEventos();
		ventana.show();
		cicloJuego();		
	}
	
	public void inicializarComponentes() {
		//jugador = new Jugador(-50,400,"goku",1);
		jugadorAnimado = new JugadorAnimado(50,200,"carro",1, "correr");
		root = new Group();
		escena = new Scene(root,1200,550);
		canvas  = new Canvas(1200,600);
		imagenes = new HashMap<String,Image>();
	//	item = new Item(400,200,0,0,"item");
		
		cargarImagenes();
		fondo1 = new Fondo(0,0,5,"fondo1");
		cargarTiles();
		cargaritems();
		cargarenemigos();
	}
	
	public void cargarImagenes() {
	
		
		imagenes.put("tilemap", new Image("carreteraaumento.jpg"));
		imagenes.put("carro", new Image("jugadorenemigos.png"));
		imagenes.put("item", new Image("itemllanta.png"));
		imagenes.put("fondo1", new Image("fondo3.jpg"));
		imagenes.put("enemigos", new Image("enemigosmatones79.png"));
	}
	
 	 public void pintar() {
		graficos.setFill(Color.GREEN);
		graficos.fillRect(0, 0, 1200, 600);
		graficos.setFill(Color.WHITE);
		graficos.fillText("Puntuacion: " + puntuacion, 0, 0);
		
		fondo1.pintar(graficos);
		
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		
		for (int i=0;i<items.size();i++)
			items.get(i).pintar(graficos);
		//nuevo
		for (int i=0;i<enemix.size();i++)
			enemix.get(i).pintar(graficos);
		//nuevo
		
	jugadorAnimado.pintar(graficos);
		
	
		
	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j],i*150, j*92, "tilemap",0));
			}
		}
		
		
		
	
	}
	

	public void cargaritems() {
		
		
		items =new ArrayList<Item>();
		items.add( new Item(7000,200,0,0,"item"));
	}
	
	
	//nuevo
	public void cargarenemigos() {
		enemix = new ArrayList<Enemigos>();
		
		
		
	
		for(int i=0; i<mapaenemigo.length; i++) {
			for(int j=0; j<mapaenemigo[i].length; j++) {
				if (mapaenemigo[i][j]!=0)
					enemix.add(new Enemigos(mapaenemigo[i][j], i*150, j*92, "enemigos",0));
			}
		}
	
	}
	//nuevo
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							jugadorAnimado.setVelocidad(3);
							break;
						case "LEFT": //derecha
							
							izquierda=true;
							jugadorAnimado.setVelocidad(3);
						break;
						case "UP":
							arriba=true;
							jugadorAnimado.setVelocidad(3);
							break;
						case "DOWN":
							abajo=true;
							jugadorAnimado.setVelocidad(3);
							break;
						case "SPACE":
							jugadorAnimado.setVelocidad(10);
							
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					break;
				case "LEFT": //derecha
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					jugadorAnimado.setVelocidad(1);
				
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);
				
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		
		for(int i=0;i<items.size();i++)
		jugadorAnimado.verificarColisiones(items.get(i));
		//nuevo
		for(int i=0;i<enemix.size();i++)
			jugadorAnimado.verificarColisiones(enemix.get(i));
		//nuevo
		
	}

}