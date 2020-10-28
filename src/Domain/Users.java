package Domain;

public class Users {

    private String userName, pass, depart;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Users(String userName, String pass, String depart) {
        this.userName = userName;
        this.pass = pass;
        this.depart = depart;
    }
}
