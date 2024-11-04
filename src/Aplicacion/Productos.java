package Aplicacion;
public class Productos {
    
    private int id;
    private String Codigo; 
    private String Nombre; 
    private int Cantidad;
    private double Precio; 
    private String Provedores;
    
    public Productos(){    
    }

    public Productos(int id, String Codigo, String Nombre, int Cantidad, double Precio, String Provedores) {
        this.id = id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Provedores = Provedores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getProvedores() {
        return Provedores;
    }

    public void setProvedores(String Provedores) {
        this.Provedores = Provedores;
    }
    
    
    
}
