package net.figueiredo.java.demoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long art_id;

	@Column(length = 25)
	private String art_date;

	@Column
	private Long art_author;

	@Column(length = 127)
	private String art_title;

	@Column(length = 255)
	private String art_thumbnail;

	@Column(length = 127)
	private String art_resume;

	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String art_content;

	@Column
	private Long art_views;

	@Column(length = 5)
	private String art_status;

	public Long getArt_id() {
		return art_id;
	}

	public void setArt_id(Long art_id) {
		this.art_id = art_id;
	}

	public String getArt_date() {
		return art_date;
	}

	public void setArt_date(String art_date) {
		this.art_date = art_date;
	}

	public Long getArt_author() {
		return art_author;
	}

	public void setArt_author(Long art_author) {
		this.art_author = art_author;
	}

	public String getArt_title() {
		return art_title;
	}

	public void setArt_title(String art_title) {
		this.art_title = art_title;
	}

	public String getArt_thumbnail() {
		return art_thumbnail;
	}

	public void setArt_thumbnail(String art_thumbnail) {
		this.art_thumbnail = art_thumbnail;
	}

	public String getArt_resume() {
		return art_resume;
	}

	public void setArt_resume(String art_resume) {
		this.art_resume = art_resume;
	}

	public String getArt_content() {
		return art_content;
	}

	public void setArt_content(String art_content) {
		this.art_content = art_content;
	}

	public Long getArt_views() {
		return art_views;
	}

	public void setArt_views(Long art_views) {
		this.art_views = art_views;
	}

	public String getArt_status() {
		return art_status;
	}

	public void setArt_status(String art_status) {
		this.art_status = art_status;
	}

}
