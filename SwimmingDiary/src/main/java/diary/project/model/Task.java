package diary.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "note_id")
    private Integer noteId;

    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "fins")
    private boolean fins;

    @Column(name = "snorkel")
    private boolean snorkel;

    @Column(name = "plane")
    private boolean plane;

    @Column(name = "paddles")
    private boolean paddles;

    public Task(){

    }

    public Task(Integer typeId, Integer noteId, String description, boolean fins, boolean snorkel, boolean plane, boolean paddles) {
        this.typeId = typeId;
        this.noteId = noteId;
        this.description = description;
        this.fins = fins;
        this.snorkel = snorkel;
        this.plane = plane;
        this.paddles = paddles;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFins() {
        return fins;
    }

    public void setFins(boolean fins) {
        this.fins = fins;
    }

    public boolean isSnorkel() {
        return snorkel;
    }

    public void setSnorkel(boolean snorkel) {
        this.snorkel = snorkel;
    }

    public boolean isPlane() {
        return plane;
    }

    public void setPlane(boolean plane) {
        this.plane = plane;
    }

    public boolean isPaddles() {
        return paddles;
    }

    public void setPaddles(boolean paddles) {
        this.paddles = paddles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return fins == task.fins &&
                snorkel == task.snorkel &&
                plane == task.plane &&
                paddles == task.paddles &&
                Objects.equals(id, task.id) &&
                Objects.equals(typeId, task.typeId) &&
                Objects.equals(noteId, task.noteId) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeId, noteId, description, fins, snorkel, plane, paddles);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", noteId=" + noteId +
                ", description='" + description + '\'' +
                ", fins=" + fins +
                ", snorkel=" + snorkel +
                ", plane=" + plane +
                ", paddles=" + paddles +
                '}';
    }
}
