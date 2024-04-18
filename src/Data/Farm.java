
package Data;

/**
 *
 * @author eefre
 */
public class Farm {
    private String idFarm;
    private String nameFarm;
    private String location;
    private String owner;
    private String farmField;

    public Farm(String idFarm, String nameFarm, String location, String owner, String farmField) {
        this.idFarm = idFarm;
        this.nameFarm = nameFarm;
        this.location = location;
        this.owner = owner;
        this.farmField = farmField;
    }

    public String getIdFarm() {
        return idFarm;
    }

    public void setIdFarm(String idFarm) {
        this.idFarm = idFarm;
    }

    public String getNameFarm() {
        return nameFarm;
    }

    public void setNameFarm(String nameFarm) {
        this.nameFarm = nameFarm;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFarmField() {
        return farmField;
    }

    public void setFarmField(String farmField) {
        this.farmField = farmField;
    }
    
    
}
