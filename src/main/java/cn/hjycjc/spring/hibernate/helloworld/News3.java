package cn.hjycjc.spring.hibernate.helloworld;

import java.util.Date;

public class News3 {
	
	private Integer id;
	
	private String title;
	
	private String author;
	
	private java.util.Date date;

	public News3() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public News3(String title, String author, Date date) {
		//super();
		this.title = title;
		this.author = author;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "News3 [id=" + id + ", title=" + title + ", author=" + author + ", date=" + date + "]";
	}
	
}
