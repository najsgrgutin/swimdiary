package diary.project.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date")
    private String date;

    @NotNull
    @Column(name = "length")
    private Double length;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "note_id")
    private Integer noteId;

    public Training(){

    }

    public Training(String date, Double length, Integer typeId, Integer noteId) {
        this.date = date;
        this.length = length;
        this.typeId = typeId;
        this.noteId = noteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id, training.id) &&
                Objects.equals(date, training.date) &&
                Objects.equals(length, training.length) &&
                Objects.equals(typeId, training.typeId) &&
                Objects.equals(noteId, training.noteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, length, typeId, noteId);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", length=" + length +
                ", typeId=" + typeId +
                ", noteId=" + noteId +
                '}';
    }
}
