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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Note note;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Week> weeks;

    public Training(){

    }

	public Training(@NotNull String date, @NotNull Double length, Type type, Note note, List<Week> weeks) {
		super();
		this.date = date;
		this.length = length;
		this.type = type;
		this.note = note;
		this.weeks = weeks;
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

	public List<Week> getWeeks() {
		return weeks;
	}

	public void setWeek(List<Week> weeks) {
		this.weeks = weeks;
	}

}
