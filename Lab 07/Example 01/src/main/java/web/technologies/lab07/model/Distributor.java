package web.technologies.lab07.model;

public class Distributor {

    private String name;
    private String email;
    private String password;
    private String company;
    private String address;
    
    public Distributor() {

    }

    public Distributor(String name, String email, String password, String company, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.company = company;
        this.address = address;
    } 
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }
    
}
