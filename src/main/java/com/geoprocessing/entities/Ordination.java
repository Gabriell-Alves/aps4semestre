package com.geoprocessing.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.geoprocessing.entities.enuns.SortName;

@Entity(name = "tb_ordination")
public class Ordination implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private SortName name;
	private Long elements100;
	private Long elements1000;
	private Long elements10000;
	private Long elements5000;
	
	public Ordination() {
		
	}

	public Ordination(Long id, SortName name, Long elements100, Long elements1000,
			Long elements10000, Long elements5000) {
		super();
		this.id = id;
		this.name = name;
		this.elements100 = elements100;
		this.elements1000 = elements1000;
		this.elements10000 = elements10000;
		this.elements5000 = elements5000;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SortName getName() {
		return name;
	}

	public void setName(SortName name) {
		this.name = name;
	}

	public Long getElements100() {
		return elements100;
	}

	public void setElements100(Long elements100) {
		this.elements100 = elements100;
	}

	public Long getElements1000() {
		return elements1000;
	}

	public void setElements1000(Long elements1000) {
		this.elements1000 = elements1000;
	}

	public Long getElements10000() {
		return elements10000;
	}

	public void setElements10000(Long elements10000) {
		this.elements10000 = elements10000;
	}

	public Long getElements5000() {
		return elements5000;
	}

	public void setElements5000(Long elements5000) {
		this.elements5000 = elements5000;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ordination other = (Ordination) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
