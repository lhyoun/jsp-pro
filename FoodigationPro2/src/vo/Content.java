package vo;

import java.util.Date;

public class Content {
	private int cno;
	private String cname;
	private String writer;
	private int point;
	private String imagename;
	private String atemenu;
	private String review;
	private int readcount;
	private Date writedate;
	
	
	public Content() {}


	public Content(String cname, String writer, int point, String atemenu, String review) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.writer = writer;
		this.point = point;
		this.atemenu = atemenu;
		this.review = review;
		
	}

	public Content(int cno, String cname, String writer, int point, String imagename, String atemenu, String review,
			int readcount, Date writedate) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.writer = writer;
		this.point = point;
		this.imagename = imagename;
		this.atemenu = atemenu;
		this.review = review;
		this.readcount = readcount;
		this.writedate = writedate;
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getImagename() {
		return imagename;
	}


	public void setImagename(String imagename) {
		this.imagename = imagename;
	}


	public String getAtemenu() {
		return atemenu;
	}


	public void setAtemenu(String atemenu) {
		this.atemenu = atemenu;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public int getReadcount() {
		return readcount;
	}


	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public Date getWritedate() {
		return writedate;
	}


	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}


	@Override
	public String toString() {
		return "Content [cno=" + cno + ", cname=" + cname + ", writer=" + writer + ", point=" + point + ", imagename="
				+ imagename + ", atemenu=" + atemenu + ", review=" + review + ", readcount=" + readcount
				+ ", writedate=" + writedate + "]";
	}
	
	
	
}
