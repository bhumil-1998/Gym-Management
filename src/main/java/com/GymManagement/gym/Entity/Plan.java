package com.GymManagement.gym.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "plan_details")
public class Plan implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Integer amount;
	
	private Integer serviceTaxAmount;
	
	private Integer serviceTaxPercentage;
	
	private Long creeatedBy;
	
	private Date createdDate;
	
	@Value("false")
	private boolean isDeleted;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "period_id" , referencedColumnName = "id")
	@JsonIgnoreProperties("plans")
	private Period period;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scheme_id" , referencedColumnName = "id")
	@JsonIgnoreProperties("plans")
	private Scheme scheme;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "id" , cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonIgnoreProperties("member")
	private List<Member> members = new ArrayList<Member>();
	
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Plan(Long id, String name, Integer amount, Integer serviceTaxAmount, Integer serviceTaxPercentage,
			Long creeatedBy, Date createdDate, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.serviceTaxAmount = serviceTaxAmount;
		this.serviceTaxPercentage = serviceTaxPercentage;
		this.creeatedBy = creeatedBy;
		this.createdDate = createdDate;
		this.isDeleted = isDeleted;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public Integer getServiceTaxAmount() {
		return serviceTaxAmount;
	}


	public void setServiceTaxAmount(Integer serviceTaxAmount) {
		this.serviceTaxAmount = serviceTaxAmount;
	}


	public Integer getServiceTaxPercentage() {
		return serviceTaxPercentage;
	}


	public void setServiceTaxPercentage(Integer serviceTaxPercentage) {
		this.serviceTaxPercentage = serviceTaxPercentage;
	}


	public Long getCreeatedBy() {
		return creeatedBy;
	}


	public void setCreeatedBy(Long creeatedBy) {
		this.creeatedBy = creeatedBy;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
}
