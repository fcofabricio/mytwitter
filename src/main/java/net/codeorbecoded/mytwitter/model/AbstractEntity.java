package net.codeorbecoded.mytwitter.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity {
	
	@Id	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Calendar created;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modified;
	
	@Version
	private long version;
	
	@PrePersist
	public void prePersist() {
		setCreated(Calendar.getInstance());
		setModified(Calendar.getInstance());
	}
	
	@PreUpdate
	public void preUpdate() {
		setModified(Calendar.getInstance());
	}
	
	@Override
	public String toString() {
		return String.format("%s[$d]", getClass().getName(), getId());
	}
	
	@Override
	public boolean equals(Object other) {
		if (other != null && other instanceof AbstractEntity) {
			if (this.getClass().equals(other.getClass())) {
				AbstractEntity entity = (AbstractEntity) other;
				return this.getId() > 0 && this.getId() == entity.getId();
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public Calendar getModified() {
		return modified;
	}

	public void setModified(Calendar modified) {
		this.modified = modified;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
}
