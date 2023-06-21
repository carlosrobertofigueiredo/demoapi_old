package net.figueiredo.java.demoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Social {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long scl_id;

	@Column
	private Long scl_user;

	@Column(length = 255)
	private String scl_name;

	@Column(length = 255)
	private String scl_link;

	public Long getScl_id() {
		return scl_id;
	}

	public void setScl_id(Long scl_id) {
		this.scl_id = scl_id;
	}

	public Long getScl_user() {
		return scl_user;
	}

	public void setScl_user(Long scl_user) {
		this.scl_user = scl_user;
	}

	public String getScl_name() {
		return scl_name;
	}

	public void setScl_name(String scl_name) {
		this.scl_name = scl_name;
	}

	public String getScl_link() {
		return scl_link;
	}

	public void setScl_link(String scl_link) {
		this.scl_link = scl_link;
	}

}
