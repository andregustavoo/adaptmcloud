package tratador;

import repositorio.cliente.Cliente;
import repositorio.servico.Servico;

public class Requisicao {
	private Long id;
	private Servico servico;
	private Cliente cliente;
	private String parameter;
	private String compare;
	private String value;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getCompare() {
		return compare;
	}
	public void setCompare(String compare) {
		this.compare = compare;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
