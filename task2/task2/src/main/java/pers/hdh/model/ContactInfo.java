package pers.hdh.model;

public class ContactInfo {
    private Integer phone;
    private String address;

    @Override
    public String toString() {
        return "ContactInfo{" +
                "phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
