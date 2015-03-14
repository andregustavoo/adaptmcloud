package modulo.blackboard;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import repositorio.servico.Servico;

@Entity
public class RequestData {
	@Id @GeneratedValue
	private Long id;
	private Long responseTime;
	@OneToOne
	private Servico service;
	private Date timeStamp;
	private Date freshness;
	private boolean available;
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public Long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}
	public Servico getService() {
		return service;
	}
	public void setService(Servico service) {
		this.service = service;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFreshness() {
		return freshness;
	}
	public void setFreshness(Date freshness) {
		this.freshness = freshness;
	}
	
}
