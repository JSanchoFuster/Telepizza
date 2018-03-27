/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telepizza;

/**
 *
 * @author alumno
 */
public class Pizza {
    private String nombre;
    private String tamaño;
    private double precio;
    private String extras;

    public Pizza(String nombre, String tamaño, double precioextras,String extras) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.precio = calcularPrecio()+ precioextras;
        this.extras = extras;
    }
    
    private float calcularPrecio(){
        
        float dinero=0;
        
        if (getTamaño().equalsIgnoreCase("Pequeña")){
            dinero=8;
        }
        if (getTamaño().equalsIgnoreCase("Mediana")){
            dinero=15;
        }
        if (getTamaño().equalsIgnoreCase("Grande")){
            dinero=22;
        }
        
       return dinero;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tamaño
     */
    public String getTamaño() {
        return tamaño;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " " + tamaño + " -- " + precio + " -- " + extras + "\n";
    }
    
    
    
    
}
