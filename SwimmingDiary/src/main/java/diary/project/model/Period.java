package diary.project.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "period")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_id")
    private Integer typeId;

    public Period(){

    }

    public Period(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(id, period.id) &&
                Objects.equals(typeId, period.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeId);
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", typeId=" + typeId +
                '}';
    }
}
