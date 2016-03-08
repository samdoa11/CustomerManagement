package customer.repository.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Veronika on 01.03.2016.
 */
@Entity
@Table
@XStreamAlias("customer")
public class Customer implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String fistname;

    @Column
    private String lastname;

    @Column
    private String username;

    @Column
    private String strasse;

    @Column
    private int plz;

    @Column
    private String ort;

    @Column
    private Date birthdate;

    @Column
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
