
package entity;

import java.util.List;


public class videoJuegos {

    public static void add(videoJuegos videojuegos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void add(List<videoJuegos> videojuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int idvideoJuegos;
    private String nombre;
    private String autor;
    private int cantJuegos;
    private double precio;
    private int copias;

    public videoJuegos(int idvideoJuegos, String nombre, String autor, int cantJuegos, double precio, int copias) {
        this.idvideoJuegos = idvideoJuegos;
        this.nombre = nombre;
        this.autor = autor;
        this.cantJuegos = cantJuegos;
        this.precio = precio;
        this.copias = copias;
    }

    public videoJuegos(String nombre, String autor, int cantJuegos, double precio, int copias) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantJuegos = cantJuegos;
        this.precio = precio;
        this.copias = copias;
    }

    public int getIdvideoJuegos() {
        return idvideoJuegos;
    }

    public void setIdvideoJuegos(int idvideoJuegos) {
        this.idvideoJuegos = idvideoJuegos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantJuegos() {
        return cantJuegos;
    }

    public void setCantJuegos(int cantJuegos) {
        this.cantJuegos = cantJuegos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "videoJuegos{" + "nombre=" + nombre + ", autor=" + autor + ", cantJuegos=" + cantJuegos + ", precio=" + precio + ", copias=" + copias + '}';
    }
    
            
}
