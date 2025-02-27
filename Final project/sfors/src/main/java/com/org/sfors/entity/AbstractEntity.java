package com.org.sfors.entity;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MappedSuperclass
public class AbstractEntity {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractEntity.class);

	@Id
	@Column(name = "UUID", updatable = false, nullable = false)
	protected String uuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;
	
	private boolean isDelete;

	@PrePersist
	public void prePersit() {
		uuid = UUID.randomUUID().toString();
		dateCreated = new Date();
		lastUpdated = new Date();
		isDelete = false;
	}

	@PreUpdate
	public void updateTimeStamps() {

		lastUpdated = new Date();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public boolean equals(Object o) {

		LOG.debug("abstract domain class" + this.getClass());
		if (this == o)
			return true;
		if (o == null)
			return false;
		LOG.debug("comparing " + o.getClass().getName() + " and " + this.getClass().getName());
		String oname = o.getClass().getName();
		String myName = this.getClass().getName();
		if (oname.contains("_$$_javassist_") || oname.contains("_$$_jvst") || oname.contains("$HibernateProxy")) {
			oname = o.getClass().getSuperclass().getName();
		}
		if (myName.contains("_$$_javassist_") || myName.contains("_$$_jvst") || myName.contains("$HibernateProxy")) {
			myName = o.getClass().getSuperclass().getName();
		}

		LOG.debug("classes " + myName + " and " + oname);

		if (!(oname.equals(myName)))
			return false;
		if (!(o instanceof AbstractEntity))
			return false;
		AbstractEntity book = (AbstractEntity) o;
		return (getUuid() != null && Objects.equals(getUuid(), book.getUuid()));
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
