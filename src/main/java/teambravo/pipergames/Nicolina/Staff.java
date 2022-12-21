package teambravo.pipergames.Nicolina;

import javax.persistence.*;

@Entity
@Table(name = "staff")

public class Staff {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;

    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String staff_nickname;
    @Column
    private String address;
    @Column
    private int zipcode;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String email;

    public Staff() {
    }

    public Staff(int staff_id, String first_name, String last_name, String staff_nickname, String address, int zipcode, String city, String country, String email) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.staff_nickname = staff_nickname;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.email = email;
    }

    public Staff(String first_name, String last_name, String staff_nickname, String address, int zipcode, String city, String country, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.staff_nickname = staff_nickname;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.email = email;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getStaff_nickname() { return staff_nickname; }

    public void setStaff_nickname(String staff_nickname) { this.staff_nickname = staff_nickname; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }

    public int getZipcode() { return zipcode; }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) { this.country = country; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    @Override
    public String toString() {
        return " " +
                " " + staff_id +
                " " + first_name + '\'' +
                " " + last_name + '\'' +
                " " + staff_nickname + '\'' +
                " " + address + '\'' +
                " " + zipcode + '\'' +
                " " + city + '\'' +
                " " + country + '\'' +
                " " + email + '\'' +
                ' ';
    }
}