package clases;


import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigos {
	private int x;
	private int y;
	
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private String indiceImagen;
	private int velocidad;
	private boolean capturado;
	private int invertir=1;
	
	public Enemigos(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}
	
	public Enemigos(int tipoTile,int x, int y, String indiceImagen, int velocidad){
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		//this.invertir = invertir;
		switch(tipoTile){
			case 1:
				this.altoImagen = 159;
				this.anchoImagen = 422;
				this.xImagen = 237;
				this.yImagen = 374;
			break;
			case 2:
				this.altoImagen = 91;
				this.anchoImagen = 459;
				this.xImagen = 225;
				this.yImagen = 11;
			break;
			case 3:
				this.altoImagen = 102;
				this.anchoImagen = 291;
				this.xImagen =48;
				this.yImagen = 239;
			break;
			case 4:
				this.altoImagen = 99;
				this.anchoImagen = 295;
				this.xImagen = 266;
				this.yImagen = 128;
			break;
			
			
		
		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getAltoImagen() {
		return altoImagen;
	}
	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}
	public int getAnchoImagen() {
		return anchoImagen;
	}
	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}
	public int getxImagen() {
		return xImagen;
	}
	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}
	public int getyImagen() {
		return yImagen;
	}
	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x-=5, this.y,
				this.anchoImagen, this.altoImagen
			);
			
	
		
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 422, 159);
	
}
	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}

