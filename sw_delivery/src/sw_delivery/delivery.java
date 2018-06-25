package sw_delivery;

import java.util.*;
import javax.swing.JOptionPane;

public class delivery {
    
 
    
    
	int id, cantidad, precio, total;
    String agrega = "S";
    String confirma = "S";
    List <producto> Detalle_producto = new ArrayList<producto>();
    
    inventario inventario = new inventario();
    
    Scanner scanner = new Scanner( System.in );

    public delivery() {
        inventario.llena_inventario();
    }
    
    
    //Create delivery request 
    public void crea_delivery (String nombre_usuario, String direccion_usuario)
    {
      String agrega= "S";
      JOptionPane.showMessageDialog(null, "Hola "+nombre_usuario+ "! \nIniciemos con su pedido:");
        do{
        agrega = "S";
        if(agrega != null && (agrega == "N" || agrega == "S")){
            agrega= preguntar(nombre_usuario, direccion_usuario,agrega);
        }else{
            //joption
            System.out.println("Ingrese un dato valido");
            JOptionPane.showMessageDialog(null, "Ingrese un dato valido");
            crea_delivery(nombre_usuario, direccion_usuario);
        }
        }while(agrega != null && agrega == "S");  
    }
    
    //Asks if the user wants to add a product to the list
    public String preguntar(String nombre_usuario, String direccion_usuario, String agrega){
        try {
            agrega = JOptionPane.showInputDialog("Le gustaria agregar un producto a la lista? \nSi (S)\nNo (N)");
        System.out.println("Le gustaria agregar un producto a la lista? \nSi (S)\nNo (N) \n Respuesta: "+agrega);
        
         switch (agrega) {
                case "S":
                   agrega_producto(nombre_usuario, direccion_usuario,agrega);
                   break;
                case "N":
                    if(Detalle_producto.size() <= 0){
                        System.out.println("Gracias por su compra!");
                        JOptionPane.showMessageDialog(null, "Gracias por su compra!");
                    }else{
                        System.out.println(Detalle_producto.size());  
                    confirmarEntrega(nombre_usuario, direccion_usuario);
                    agrega="N";
                    break;
                    }
                    break;
                default:
                    System.out.println("Favor ingresar un dato valido"); 
                    JOptionPane.showMessageDialog(null, "Favor ingresar un dato valido");
                    preguntar(nombre_usuario, direccion_usuario, agrega);
                    break;
            }
        
        } catch (NullPointerException e) {
            
        }
        return agrega;
    }
    
    
    //Asks the user for the product id and the amount
    public void agrega_producto (String nombre_usuario, String direccion_usuario, String agrega)
    {
        try {
            
             id = Integer.parseInt(JOptionPane.showInputDialog("Por favor introduzca id del producto: "));
         System.out.println("Por favor introduzca id del producto: "+id);   
         
          cantidad = Integer.parseInt(JOptionPane.showInputDialog("Por favor introduzca la cantidad deseada: "));
             System.out.println("Por favor introduzca la cantidad deseada: "+cantidad);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Ingrese datos correctos por favor");
           // 
        }
                      
      
         //Check existence and amount on inventories
         try {
             if (0 != id  && 0 != cantidad){    
             check_inventory(id,cantidad,nombre_usuario, direccion_usuario, agrega);
             }else{
                 agrega_producto(nombre_usuario, direccion_usuario, agrega);
             }
                   
        } catch (Exception e) {
            
        }
                    
    }
    //Checks inventory...duh...
    public void check_inventory(int id, int cantidad,String nombre_usuario, String direccion_usuario, String agrega){
            boolean isAvailable;
            isAvailable = false;
            for(int x=0;x<inventario.inventarioList.size();x++) {
            
            if (id == inventario.inventarioList.get(x).getId_producto())
            {
                isAvailable = true;
                 System.out.println("Disponible, agrega=");
                 
                if (cantidad <= inventario.inventarioList.get(x).getCantidad_producto()){
                Detalle_producto.add(new producto (inventario.inventarioList.get(x).getId_producto(),cantidad, inventario.inventarioList.get(x).getPrecio_producto(),inventario.inventarioList.get(x).getNombre_producto()));
                    System.out.println("El producto se agrego exitosamente");
                    agrega="S";
                    preguntar(nombre_usuario, direccion_usuario, agrega);
                   }else {
                    System.out.println("Actualmente la cantidad de producto requerida es mayor a la cantidad en inventario. En este momento contanmos con una cantidad de: "+inventario.inventarioList.get(x).getCantidad_producto());
                }
                            } 
            }
            if(isAvailable == false){
                
                JOptionPane.showMessageDialog(null,"Ese producto no se encuentra disponible o no existe.");
                agrega_producto(nombre_usuario, direccion_usuario, agrega);
            }
          }
    //Confirms delivery
   public void confirmarEntrega(String nombre_usuario, String direccion_usuario){
        int precioTotal= 0;
        confirma = "";
        String factura = "";
      
            confirma=  JOptionPane.showInputDialog("Desea confirmar su entrega a la ubicación: "
                  +direccion_usuario+"? \nSi (S)\nNo(N)");  
           
                   System.out.println("Desea confirmar su entrega a la ubicación: "
                  +direccion_usuario+"? \nSi (S)\nNo(N) \n Respuesta: "+confirma);
    
               switch (confirma) {
                case "S":
                    for (int i = 0; i < Detalle_producto.size(); i++) {
                        factura += Detalle_producto.get(i).getCantidad_producto()+ " * "+Detalle_producto.get(i).getNombre_producto()
                               + " Precio: "+ Detalle_producto.get(i).getCantidad_producto() * Detalle_producto.get(i).getPrecio_producto()+"\n";
                        precioTotal += Detalle_producto.get(i).getCantidad_producto() * Detalle_producto.get(i).getPrecio_producto();
                    }
                    JOptionPane.showMessageDialog(null, "Factura\n"+factura+ "\n TOTAL: "+precioTotal);
                     JOptionPane.showMessageDialog(null, nombre_usuario+", la entrega ha sido confirmada en la direccion indicada :"+direccion_usuario+"!\n Gracias por su compra!");
                    break;
                case "N":
                    System.out.println("Compra cancelada!");
                    JOptionPane.showMessageDialog(null, "Compra cancelada!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingrese el dato corretamente");
                  //  System.out.println("Favor ingresar un dato valido"); 
                    confirmarEntrega(nombre_usuario, direccion_usuario);
                    break;
            }
 
    }
		
}
