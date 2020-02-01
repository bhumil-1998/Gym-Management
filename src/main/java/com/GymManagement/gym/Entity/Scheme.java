package com.GymManagement.gym.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scheme_details")
public class Scheme implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scheme_id")
	private Long id; 
	
	@Column(name = "scheme_name")
	private String schemeName;
	
	@Column(name = "createdby")
	private Long createdBy;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;

	public Scheme() {
		super();
	}

	public Scheme(Long id, String schemeName, Long createdBy, Date createdDate, boolean isDeleted) {
		super();
		this.id = id;
		this.schemeName = schemeName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.isDeleted = isDeleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Scheme [id=" + id + ", schemeName=" + schemeName + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", isDeleted=" + isDeleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((schemeName == null) ? 0 : schemeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scheme other = (Scheme) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (schemeName == null) {
			if (other.schemeName != null)
				return false;
		} else if (!schemeName.equals(other.schemeName))
			return false;
		return true;
	}
	
	
	
}
