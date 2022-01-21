package Entitätsklassen;

import javax.persistence.*;

@Entity
@Table(name = "FORTBILDUNGENSACHBEARBEITER", schema = "PUBLIC", catalog = "TEST")
public class FortbildungensachbearbeiterEK {
    private String username;
    private String fortbildung1;
    private String status1;
    private String fortbildung2;
    private String status2;
    private String fortbildung3;
    private String status3;
    private String fortbildung4;
    private String status4;
    private int id;
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
    @Column(name = "FORTBILDUNG1")
    public String getFortbildung1() {
        return fortbildung1;
    }

    public void setFortbildung1(String fortbildung1) {
        this.fortbildung1 = fortbildung1;
    }

    @Basic
    @Column(name = "STATUS1")
    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
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
    @Column(name = "STATUS2")
    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
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
    @Column(name = "STATUS3")
    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
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
    @Column(name = "STATUS4")
    public String getStatus4() {
        return status4;
    }

    public void setStatus4(String status4) {
        this.status4 = status4;
    }

    @Basic
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

        FortbildungensachbearbeiterEK that = (FortbildungensachbearbeiterEK) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (fortbildung1 != null ? !fortbildung1.equals(that.fortbildung1) : that.fortbildung1 != null) return false;
        if (status1 != null ? !status1.equals(that.status1) : that.status1 != null) return false;
        if (fortbildung2 != null ? !fortbildung2.equals(that.fortbildung2) : that.fortbildung2 != null) return false;
        if (status2 != null ? !status2.equals(that.status2) : that.status2 != null) return false;
        if (fortbildung3 != null ? !fortbildung3.equals(that.fortbildung3) : that.fortbildung3 != null) return false;
        if (status3 != null ? !status3.equals(that.status3) : that.status3 != null) return false;
        if (fortbildung4 != null ? !fortbildung4.equals(that.fortbildung4) : that.fortbildung4 != null) return false;
        if (status4 != null ? !status4.equals(that.status4) : that.status4 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (fortbildung1 != null ? fortbildung1.hashCode() : 0);
        result = 31 * result + (status1 != null ? status1.hashCode() : 0);
        result = 31 * result + (fortbildung2 != null ? fortbildung2.hashCode() : 0);
        result = 31 * result + (status2 != null ? status2.hashCode() : 0);
        result = 31 * result + (fortbildung3 != null ? fortbildung3.hashCode() : 0);
        result = 31 * result + (status3 != null ? status3.hashCode() : 0);
        result = 31 * result + (fortbildung4 != null ? fortbildung4.hashCode() : 0);
        result = 31 * result + (status4 != null ? status4.hashCode() : 0);
        return result;
    }
}
