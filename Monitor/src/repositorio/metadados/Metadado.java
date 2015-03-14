package repositorio.metadados;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import repositorio.servico.Servico;
@Entity
public class Metadado {
	@Id @GeneratedValue
	private Long id;
	private Date timeStamp;
	
	//Parametros de QoS
	private Long latency;
	private Long responseTime;
	
	//Segundos
	private Long mttr;
	private Long mtbf;
	private Boolean recoverable;
	private Float upTime;
	private Float errorRate;
	private Float throughput;
	
	//Parametros de QoC
	private Long freshness;
	
	@OneToOne
	private Servico service;
	
	public Metadado(){
		
	}

	public Servico getService() {
		return service;
	}

	public void setService(Servico service) {
		this.service = service;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getLatency() {
		return latency;
	}

	public void setLatency(Long latency) {
		this.latency = latency;
	}

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	public Long getMttr() {
		return mttr;
	}
	public void setMttr(Long mttr) {
		this.mttr = mttr;
	}
	public Long getMtbf() {
		return mtbf;
	}
	public void setMtbf(Long mtbf) {
		this.mtbf = mtbf;
	}
	public Boolean getRecoverable() {
		return recoverable;
	}
	public void setRecoverable(Boolean recoverable) {
		this.recoverable = recoverable;
	}
	public Float getUpTime() {
		return upTime;
	}
	public void setUpTime(Float upTime) {
		this.upTime = upTime;
	}
	public Float getThroughput() {
		return throughput;
	}
	public void setThroughput(Float throughput) {
		this.throughput = throughput;
	}

	public Float getErrorRate() {
		return errorRate;
	}

	public void setErrorRate(Float errorRate) {
		this.errorRate = errorRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFreshness() {
		return freshness;
	}

	public void setFreshness(Long freshness) {
		this.freshness = freshness;
	}
	
	
	public String toString(){
		
		StringBuffer buffer=new StringBuffer();
		buffer.append("UpTime: "+upTime);
		buffer.append("-TimeStamp:"+timeStamp);
		buffer.append("-Latency:"+latency);
		
		return buffer.toString();
	}
	
	
}
