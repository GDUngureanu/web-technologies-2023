package web.technologies.lab08.request;

public class UserUpdateRequest {

    private String name;
    private String deliveryAddress;
    private String company;
    private String address;

    public UserUpdateRequest() {
       
    }

    public UserUpdateRequest(String name, String deliveryAddress, String company, String address) {
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.company = company;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
