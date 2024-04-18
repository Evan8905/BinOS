
package Data;

/**
 *
 * @author eefre
 */
public class FarmField {
    private String idFarmField;
    private int numberField;
    private String fieldSize;
    private String idFromFarm;   

    public FarmField(String idFarmField, int numberField, String fieldSize, String idFromFarm) {
        this.idFarmField = idFarmField;
        this.numberField = numberField;
        this.fieldSize = fieldSize;
        this.idFromFarm = idFromFarm;
    }

    public String getIdFarmField() {
        return idFarmField;
    }

    public void setIdFarmField(String idFarmField) {
        this.idFarmField = idFarmField;
    }

    public int getNumberField() {
        return numberField;
    }

    public void setNumberField(int numberField) {
        this.numberField = numberField;
    }

    public String getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(String fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getIdFromFarm() {
        return idFromFarm;
    }

    public void setIdFromFarm(String idFromFarm) {
        this.idFromFarm = idFromFarm;
    }
    
}
