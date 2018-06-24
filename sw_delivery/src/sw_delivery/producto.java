package sw_delivery;

public class producto {

    private int id_producto, cantidad_producto, precio_producto;
    private String nombre_producto;

    
     public producto()
    {
        this.id_producto = 0;
        this.cantidad_producto=0;
        this.precio_producto=0;
        this.nombre_producto="";
    }

    public producto(int id_producto, int cantidad_producto,int precio_producto, String nombre_producto)
    {   this.id_producto = id_producto;
        this.cantidad_producto= cantidad_producto;
        this.precio_producto= precio_producto;
        this.nombre_producto= nombre_producto;
    }
    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the cantidad_producto
     */
    public int getCantidad_producto() {
        return cantidad_producto;
    }

    /**
     * @param cantidad_producto the cantidad_producto to set
     */
    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    /**
     * @return the precio_producto
     */
    public int getPrecio_producto() {
        return precio_producto;
    }

    /**
     * @param precio_producto the precio_producto to set
     */
    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    /**
     * @return the nombre_producto
     */
    public String getNombre_producto() {
        return nombre_producto;
    }

    /**
     * @param nombre_producto the nombre_producto to set
     */
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
}
