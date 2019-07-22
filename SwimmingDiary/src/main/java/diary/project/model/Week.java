package diary.project.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "week")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "note_id")
    private Integer noteId;

    @Column(name = "period_id")
    private Integer periodId;

    @Column(name = "ordinal")
    private Integer ordinal;

    @Column(name = "length")
    private double length;

    public Week(){

    }

    public Week(Integer typeId, Integer noteId, Integer periodId, Integer ordinal, double length) {
        this.typeId = typeId;
        this.noteId = noteId;
        this.periodId = periodId;
        this.ordinal = ordinal;
        this.length = length;
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

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Week week = (Week) o;
        return Double.compare(week.length, length) == 0 &&
                Objects.equals(id, week.id) &&
                Objects.equals(typeId, week.typeId) &&
                Objects.equals(noteId, week.noteId) &&
                Objects.equals(periodId, week.periodId) &&
                Objects.equals(ordinal, week.ordinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeId, noteId, periodId, ordinal, length);
    }

    @Override
    public String toString() {
        return "Week{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", noteId=" + noteId +
                ", periodId=" + periodId +
                ", ordinal=" + ordinal +
                ", length=" + length +
                '}';
    }
}
