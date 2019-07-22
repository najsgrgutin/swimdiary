package diary.project.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "training_task")
public class TrainingTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_training")
    private Integer trainingId;

    @Column(name = "id_task")
    private Integer taskId;

    public TrainingTask(){

    }

    public TrainingTask(Integer trainingId, Integer taskId) {
        this.trainingId = trainingId;
        this.taskId = taskId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingTask that = (TrainingTask) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(trainingId, that.trainingId) &&
                Objects.equals(taskId, that.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainingId, taskId);
    }

    @Override
    public String toString() {
        return "TrainingTask{" +
                "id=" + id +
                ", trainingId=" + trainingId +
                ", taskId=" + taskId +
                '}';
    }
}
