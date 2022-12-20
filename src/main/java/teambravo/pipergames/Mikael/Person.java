package teambravo.pipergames.Mikael;


import javax.persistence.*;


public class Person {

    @Id
    @Column(name = "personID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personID;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "address")
    private String address;

    @Column(name = "zipcode")
    private int zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "e_mail")
    private String e_mail;


    public Person() {

    }

    public Person(int personID, String first_name, String last_name, String nickname, String address, int zipcode, String city, String country, String e_mail) {
        this.personID = personID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.e_mail = e_mail;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
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

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}
