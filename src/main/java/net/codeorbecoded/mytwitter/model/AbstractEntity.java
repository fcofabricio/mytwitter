package net.codeorbecoded.mytwitter.model;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {
	
	@Id	@GeneratedValue
	private long id;
	
	@CreatedDate
	private Date created;
	
	@LastModifiedDate
	private Date modified;
	
	@Version
	private long version;
		
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
}
