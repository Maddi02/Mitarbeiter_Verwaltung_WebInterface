package Entitätsklassen;

import javax.persistence.*;

@Entity
@Table(name = "FORTBILDUNGVORRAUSSETZUNG", schema = "PUBLIC", catalog = "TEST")
public class FortbildungvorraussetzungEK {
    private String fortbildung;
    private String vorraussetzung1;
    private String vorraussetzung2;
    private int id;

    @Basic
    @Column(name = "FORTBILDUNG")
    public String getFortbildung() {
        return fortbildung;
    }

    public void setFortbildung(String fortbildung) {
        this.fortbildung = fortbildung;
    }

    @Basic
    @Column(name = "VORRAUSSETZUNG1")
    public String getVorraussetzung1() {
        return vorraussetzung1;
    }

    public void setVorraussetzung1(String vorraussetzung1) {
        this.vorraussetzung1 = vorraussetzung1;
    }

    @Basic
    @Column(name = "VORRAUSSETZUNG2")
    public String getVorraussetzung2() {
        return vorraussetzung2;
    }

    public void setVorraussetzung2(String vorraussetzung2) {
        this.vorraussetzung2 = vorraussetzung2;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FortbildungvorraussetzungEK that = (FortbildungvorraussetzungEK) o;

        if (fortbildung != null ? !fortbildung.equals(that.fortbildung) : that.fortbildung != null) return false;
        if (vorraussetzung1 != null ? !vorraussetzung1.equals(that.vorraussetzung1) : that.vorraussetzung1 != null)
            return false;
        if (vorraussetzung2 != null ? !vorraussetzung2.equals(that.vorraussetzung2) : that.vorraussetzung2 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fortbildung != null ? fortbildung.hashCode() : 0;
        result = 31 * result + (vorraussetzung1 != null ? vorraussetzung1.hashCode() : 0);
        result = 31 * result + (vorraussetzung2 != null ? vorraussetzung2.hashCode() : 0);
        return result;
    }
}
