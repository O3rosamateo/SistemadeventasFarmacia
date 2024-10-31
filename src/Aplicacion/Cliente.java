
package Aplicacion;

/**
 *
 * @author Vinz
 */
public class CLIENTES {
    private int id;
    private int dni;
    private int telefono;
    private String direccion;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CLIENTES() {
    }

    public CLIENTES(int id, int dni, int telefono, String direccion, String nombre) {
        this.id = id;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
    }
    
 
    
}
