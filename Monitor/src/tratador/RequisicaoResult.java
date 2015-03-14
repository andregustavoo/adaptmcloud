package tratador;

import java.util.Date;

import repositorio.metadados.Metadado;

public class RequisicaoResult {
	private Long id;
	private Metadado metadado;
	private String parameter;
	private String compare;
	private String value;
	private Date timeStamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Metadado getMetadado() {
		return metadado;
	}
	public void setMetadado(Metadado metadado) {
		this.metadado = metadado;
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
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
