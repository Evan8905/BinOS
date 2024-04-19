
package Data;

/**
 *
 * @author eefre
 */
public class Proveedor {
    
    private String idProveedor;
    private String name;
    private String address;
    private String phone;
    private String idCosecha; // FK

    public Proveedor(String idProveedor, String name, String address, String phone, String idCosecha) {
        this.idProveedor = idProveedor;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.idCosecha = idCosecha;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(String idCosecha) {
        this.idCosecha = idCosecha;
    }
    
}
