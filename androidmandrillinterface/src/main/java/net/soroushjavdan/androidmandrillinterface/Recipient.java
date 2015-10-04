package net.soroushjavdan.androidmandrillinterface;

/**
 * Created by SoroushJavdan on 1/28/15.
 */
public class Recipient {

    private String email;
    private String name;
    private String type="to";

    public String getEmail() {
        return email;
    }

    public void setName(String name ){
        this.name =  name ;
    }


    public void setEmail(String email) {
            this.email = email;
        }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
