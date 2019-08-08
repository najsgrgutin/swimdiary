package diary.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)    
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Note note;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Training> trainings;
    
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

	public Task(Type type, Note note, List<Training> trainings, @NotNull String description, boolean fins, boolean snorkel,
			boolean plane, boolean paddles) {
		super();
		this.type = type;
		this.note = note;
		this.trainings = trainings;
		this.description = description;
		this.fins = fins;
		this.snorkel = snorkel;
		this.plane = plane;
		this.paddles = paddles;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTraining(List<Training> trainings) {
		this.trainings = trainings;
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
    
}
