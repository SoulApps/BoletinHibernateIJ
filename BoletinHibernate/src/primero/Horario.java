package primero;
// Generated 01-feb-2018 11:06:06 by Hibernate Tools 5.2.8.Final

/**
 * Horario generated by hbm2java
 */
public class Horario implements java.io.Serializable {

	private HorarioId id;
	private Asignatura asignatura;
	private Curso curso;
	private Tramohorario tramohorario;

	public Horario() {
	}

	public Horario(HorarioId id, Asignatura asignatura, Curso curso, Tramohorario tramohorario) {
		this.id = id;
		this.asignatura = asignatura;
		this.curso = curso;
		this.tramohorario = tramohorario;
	}

	public HorarioId getId() {
		return this.id;
	}

	public void setId(HorarioId id) {
		this.id = id;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Tramohorario getTramohorario() {
		return this.tramohorario;
	}

	public void setTramohorario(Tramohorario tramohorario) {
		this.tramohorario = tramohorario;
	}

}
