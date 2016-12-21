package cn.hjycjc.spring.hibernate.helloworld;

import java.sql.Date;

import com.mysql.jdbc.Blob;

public class News {
	
	private Integer id;
	
	private String title;
	
	private String author;
	
	private Date date;
	
	private Blob img;

	public News() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public News(String title, String author, Date date, Blob img) {
	//	super();
		this.title = title;
		this.author = author;
		this.date = date;
		this.img = img;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author + ", date=" + date + ", img=" + img + "]";
	}

}
