
package Data;

/**
 *
 * @author eefre
 */
public class Fvariedad {
    private String idVariedad;
    private String name;
    private String description;

    public Fvariedad(String idVariedad, String name, String description) {
        this.idVariedad = idVariedad;
        this.name = name;
        this.description = description;
    }

    public String getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(String idVariedad) {
        this.idVariedad = idVariedad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
