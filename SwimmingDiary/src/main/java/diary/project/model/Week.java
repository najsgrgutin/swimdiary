package diary.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "week")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Type type;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Note note;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Period period;

    @NotNull
    @Column(name = "ordinal")
    private Integer ordinal;

    @NotNull
    @Column(name = "length")
    private double length;

    public Week(){

    }

	public Week(Type type, Note note, Period period, Integer ordinal, double length) {
		super();
		this.type = type;
		this.note = note;
		this.period = period;
		this.ordinal = ordinal;
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

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
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
    
}
