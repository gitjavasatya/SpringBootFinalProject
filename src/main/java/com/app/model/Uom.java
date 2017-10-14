package com.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uom_tab")
public class Uom implements Comparable<Uom> {
	@Id
	@GeneratedValue(generator="uomgen")
	@GenericGenerator(strategy="increment",name="uomgen")
	@Column(name="u_id")
	private long uomId;
	
	@Column(name="u_type")
	private String uomType;
	
	@Column(name="u_model")
	private String uomModel;
	
	@Column(name="u_crtdDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="u_lmDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name="u_desc")
	private String description;
	

	public Uom() {
		super();
	}
	public Uom(long uomId) {
		super();
		this.uomId = uomId;
	}
	
	
	public Uom(String uomType, String uomModel,String description,Date createdDate) {
		super();
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.createdDate = createdDate;
		this.description = description;
	}
	public long getUomId() {
		return uomId;
	}


	public void setUomId(long uomId) {
		this.uomId = uomId;
	}


	public String getUomType() {
		return uomType;
	}


	public void setUomType(String uomType) {
		this.uomType = uomType;
	}


	public String getUomModel() {
		return uomModel;
	}


	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", createdDate="
				+ createdDate + ", lastModifiedDate=" + lastModifiedDate + ", description=" + description + "]";
	}
	



	@Override
	public int compareTo(Uom o) {
		return (int) (o.getUomId()-this.getUomId());
	}
	
	
	
	

}
