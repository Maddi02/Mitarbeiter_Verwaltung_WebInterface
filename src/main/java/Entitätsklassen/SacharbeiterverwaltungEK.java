package Entitätsklassen;

import javax.persistence.*;

@Entity
@Table(name = "SACHARBEITERVERWALTUNG", schema = "PUBLIC", catalog = "TEST")
public class SacharbeiterverwaltungEK {
    private String username;
    private String passwort;
    private String role;
    private String fortbildung1;
    private String fortbildung2;
    private String fortbildung3;
    private String fortbildung4;
    private long id;
    private int pk;

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORT")
    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    @Basic
    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "FORTBILDUNG1")
    public String getFortbildung1() {
        return fortbildung1;
    }

    public void setFortbildung1(String fortbildung1) {
        this.fortbildung1 = fortbildung1;
    }

    @Basic
    @Column(name = "FORTBILDUNG2")
    public String getFortbildung2() {
        return fortbildung2;
    }

    public void setFortbildung2(String fortbildung2) {
        this.fortbildung2 = fortbildung2;
    }

    @Basic
    @Column(name = "FORTBILDUNG3")
    public String getFortbildung3() {
        return fortbildung3;
    }

    public void setFortbildung3(String fortbildung3) {
        this.fortbildung3 = fortbildung3;
    }

    @Basic
    @Column(name = "FORTBILDUNG4")
    public String getFortbildung4() {
        return fortbildung4;
    }

    public void setFortbildung4(String fortbildung4) {
        this.fortbildung4 = fortbildung4;
    }

    @Basic
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @Column(name = "PK")
    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SacharbeiterverwaltungEK that = (SacharbeiterverwaltungEK) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (passwort != null ? !passwort.equals(that.passwort) : that.passwort != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (fortbildung1 != null ? !fortbildung1.equals(that.fortbildung1) : that.fortbildung1 != null) return false;
        if (fortbildung2 != null ? !fortbildung2.equals(that.fortbildung2) : that.fortbildung2 != null) return false;
        if (fortbildung3 != null ? !fortbildung3.equals(that.fortbildung3) : that.fortbildung3 != null) return false;
        if (fortbildung4 != null ? !fortbildung4.equals(that.fortbildung4) : that.fortbildung4 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (passwort != null ? passwort.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (fortbildung1 != null ? fortbildung1.hashCode() : 0);
        result = 31 * result + (fortbildung2 != null ? fortbildung2.hashCode() : 0);
        result = 31 * result + (fortbildung3 != null ? fortbildung3.hashCode() : 0);
        result = 31 * result + (fortbildung4 != null ? fortbildung4.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
