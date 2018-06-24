package sw_delivery;

import java.util.*;

public class delivery {

	int id, cantidad, precio, total;
    String agrega = "S";
    List <producto> Detalle_producto = new ArrayList<producto>();
    
    inventario inventario = new inventario();
    Scanner scanner = new Scanner( System.in );

    public delivery() {
    }
    
    
    //Create delivery request 
    public void crea_delivery (String nombre_usuario, String direccion_usuario)
    {
        
        System.out.println("Hola "+nombre_usuario+ "! /nIniciemos con su pedido:");
        do {
         System.out.println("¿Le gustaría agregar un producto a la lista? /nSi (S)/nNo(N)");
         agrega = scanner.nextLine();
         
         if (agrega.equals("S")) {

             agrega_producto();
         }
         else if (agrega.equals("N")){
             System.out.println("¡Gracias por su compra!");
         } else {
             System.out.println("Favor ingresar un dato válido");
         } 
   
        } while (agrega == "S"); //On the loop while the customer wants to add products
        
    
    }
    
    public void agrega_producto ()
    {
         System.out.println("Por favor introduzca id del producto: ");
         id = scanner.nextInt();
         System.out.println("Por favor introduzca la cantidad de producto: ");
         cantidad = scanner.nextInt();
         //Check existence and amount on inventory
         for(int x=0;x<inventario.inventarioList.size();x++) {
            if (id == inventario.inventarioList.get(x).getId_producto())
            {
                if (cantidad <= inventario.inventarioList.get(x).getCantidad_producto()){
                Detalle_producto.add(new producto (inventario.inventarioList.get(x).getId_producto(),cantidad, inventario.inventarioList.get(x).getPrecio_producto(),inventario.inventarioList.get(x).getNombre_producto()));
                    System.out.println("El producto se agregó exitosamente");
                }else {
                    
                   System.out.println("Actualmente la cantidad de producto requerida es mayor a la cantidad en inventario. En este momento contanmos con una cantidad de: "+inventario.inventarioList.get(x).getCantidad_producto());
                }
                
            } else {
            System.out.println("El producto no existe en inventario");
   
            }
            }
        
    }
	public void prueba () {
		
		System.out.println ("Hola Mundo");
	}
	//Se obtiene los datos de el usuario
	public void GetUsuario() {
		
	}
	//SE puede seleccionar un producto y añadirlo
	public void AgregarProducto() {
		
	}
	
}
