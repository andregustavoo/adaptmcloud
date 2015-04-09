package healthwatcher.model.complaint;

import java.io.Serializable;
public class Situation implements Serializable {


	private Long id;


	private String description;

	public static int QUEIXA_ABERTA = 1;

	public static int QUEIXA_SUSPENSA = 2;

	public static int QUEIXA_FECHADA = 3;

	public Situation(Long codigo, String descricao) {
		this.id = codigo;
		this.description = descricao;
	}

	public Long getCode() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}
