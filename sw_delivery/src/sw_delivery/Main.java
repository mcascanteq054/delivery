/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw_delivery;

/**
 *
 * @author mkeyl
 */
public class Main {
       public static void main (String [] args){
            inventario Inv = new inventario();
                 Inv.llena_inventario();                             
            delivery Delivery1 = new delivery();
                 Delivery1.crea_delivery("David", "San Pedro");
   }
}
