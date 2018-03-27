/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telepizza;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Pedido {
    private Cliente c1;
    private ArrayList<Pizza> pizzas;
    private String domicilio;
    private double precioFinal;

    public Pedido(Cliente c1, ArrayList<Pizza> pizzas, String domicilio) {
        this.c1 = c1;
        this.pizzas = pizzas;
        this.domicilio = domicilio;
        this.precioFinal = calcularPrecioFinal();
    }
    
    private float calcularPrecioFinal(){
        
        float precio=0;
    
        for (int i = 0; i < getPizzas().size(); i++) {
            precio+=getPizzas().get(i).getPrecio();
        }
        if (getDomicilio().equalsIgnoreCase("Si")){
            precio=precio+2;
        }
        
        return precio;
    }
    
    public String DevolverPizzas(){
    String aux="";
    for (int i = 0; i < getPizzas().size(); i++) {
            aux+=getPizzas().get(i).toString();
        }
    return aux;
    }

    @Override
    public String toString() {
        String aux="";
        
        for (int i = 0; i < getPizzas().size(); i++) {
            aux+=getPizzas().get(i).toString();
        }
        
        return getC1().toString() + "--PEDIDO--" + "\n" + aux + "-----------------------" + "\n" + "Precio: " + getPrecioFinal() + "\n";
    }

    /**
     * @return the c1
     */
    public Cliente getC1() {
        return c1;
    }

    /**
     * @param c1 the c1 to set
     */
    public void setC1(Cliente c1) {
        this.c1 = c1;
    }

    /**
     * @return the pizzas
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * @param pizzas the pizzas to set
     */
    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the precioFinal
     */
    public double getPrecioFinal() {
        return precioFinal;
    }

    /**
     * @param precioFinal the precioFinal to set
     */
    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
    
    
        
      
}

