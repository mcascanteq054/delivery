package sw_delivery;

import java.util.*;

public class inventario {

    
    public List <producto> inventarioList = new ArrayList<producto>();

    public inventario() {
        
    }
 
    
    public void llena_inventario (){
    inventarioList.add(new producto (1, 525, 300, "Papa"));
    inventarioList.add(new producto (2, 524, 300, "Mel�n"));
    inventarioList.add(new producto (3, 876, 300, "Sand�a"));
    inventarioList.add(new producto (4, 52, 300, "Tomate"));
    inventarioList.add(new producto (5, 96, 300, "Ma�z"));
    inventarioList.add(new producto (6, 74, 300, "Manzana"));
   
    }
}
