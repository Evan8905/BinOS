package Data;

/**
 *
 * @author eefre
 */
public class Cosecha {

    private String idCosecha;
    private String tipo;
    private String description;

    public Cosecha(String idCosecha, String tipo, String description) {
        this.idCosecha = idCosecha;
        this.tipo = tipo;
        this.description = description;
    }

    public String getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(String idCosecha) {
        this.idCosecha = idCosecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
