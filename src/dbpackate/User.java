package dbpackate;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class User {
	private String userId;
	private String userName;
	private int birthYear;
	private String addr;
	private String mobile1;
	private String mobile2;
	private int height;
	private Date mdate;	

	public User(String puserId, String puserName, int pbirthYear, 
			String paddr, String pmobile1, String pmobile2, 
			int pheight, Date pmdate) {
		this.userId=puserId;
		this.userName=puserName;
		this.birthYear=pbirthYear;
		this.addr=paddr;
		this.mobile1=pmobile1;
		this.mobile2=pmobile2;
		this.height=pheight;
		this.mdate=pmdate;		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getUserId() {
		return userId;
	}

}
