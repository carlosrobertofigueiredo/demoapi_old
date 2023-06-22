package net.figueiredo.java.demoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long cmt_id;

	@Column(length = 25)
	private String cmt_date;

	@Column
	private String firebase_name;

	@Column
	private String firebase_email;

	@Column
	private String firebase_photo;

	@Column
	private String firebase_uid;

	@Column
	private Long cmt_article;

	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String cmt_comment;

	@Column(length = 5)
	private String cmt_status;

	public Long getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(Long cmt_id) {
		this.cmt_id = cmt_id;
	}

	public String getCmt_date() {
		return cmt_date;
	}

	public void setCmt_date(String cmt_date) {
		this.cmt_date = cmt_date;
	}

	public String getFirebase_name() {
		return firebase_name;
	}

	public void setFirebase_name(String firebase_name) {
		this.firebase_name = firebase_name;
	}

	public String getFirebase_email() {
		return firebase_email;
	}

	public void setFirebase_email(String firebase_email) {
		this.firebase_email = firebase_email;
	}

	public String getFirebase_photo() {
		return firebase_photo;
	}

	public void setFirebase_photo(String firebase_photo) {
		this.firebase_photo = firebase_photo;
	}

	public String getFirebase_uid() {
		return firebase_uid;
	}

	public void setFirebase_uid(String firebase_uid) {
		this.firebase_uid = firebase_uid;
	}

	public Long getCmt_article() {
		return cmt_article;
	}

	public void setCmt_article(Long cmt_article) {
		this.cmt_article = cmt_article;
	}

	public String getCmt_comment() {
		return cmt_comment;
	}

	public void setCmt_comment(String cmt_comment) {
		this.cmt_comment = cmt_comment;
	}

	public String getCmt_status() {
		return cmt_status;
	}

	public void setCmt_status(String cmt_status) {
		this.cmt_status = cmt_status;
	}

}
