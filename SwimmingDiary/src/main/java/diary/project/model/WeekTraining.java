package diary.project.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "week_training")
public class WeekTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_week")
    private Integer weekId;

    @Column(name = "id_training")
    private Integer training_id;

    public WeekTraining(){

    }

    public WeekTraining(Integer weekId, Integer training_id) {
        this.weekId = weekId;
        this.training_id = training_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public Integer getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Integer training_id) {
        this.training_id = training_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeekTraining that = (WeekTraining) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(weekId, that.weekId) &&
                Objects.equals(training_id, that.training_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weekId, training_id);
    }

    @Override
    public String toString() {
        return "WeekTraining{" +
                "id=" + id +
                ", weekId=" + weekId +
                ", training_id=" + training_id +
                '}';
    }
}
