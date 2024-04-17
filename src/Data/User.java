
package Data;

/**
 *
 * @author eefre
 */
public class User {
    private String idUser;
    private String name;
    private String userName;
    private String password;
     private boolean type;
    private boolean status;

    public User(String idUser, String name, String userName, String password, boolean type, boolean status) {
        this.idUser = idUser;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
