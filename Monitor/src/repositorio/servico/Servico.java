package repositorio.servico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Servico {
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private Boolean contexto;
	
	public Servico(){
		contexto = false;
	}
	
	public Servico(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getContexto() {
		return contexto;
	}

	public void setContexto(Boolean contexto) {
		this.contexto = contexto;
	}
	
	
	
	
}
