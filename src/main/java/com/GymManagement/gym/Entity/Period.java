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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "period_details")
public class Period implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Long createdBy;
	
	private Date createdDate;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "id" , cascade = CascadeType.ALL , orphanRemoval = true )
	@JsonIgnoreProperties("period")
	private List<Plan> plans = new ArrayList<Plan>();

	public Period() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Period(Long id, String name, Long createdBy, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	@Override
	public String toString() {
		return "Period [id=" + id + ", name=" + name + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ "]";
	}
	
	
}
