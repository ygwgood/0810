package socket2208010;

import java.io.Serializable;

public class ClassInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public int getKor() {
	
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
		
	}
	
	public int getEng() {
		
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
		
	}
	
	public int getMath() {
		
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
		
	}
	public void setKor(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setEng(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setMath(String string) {
		// TODO Auto-generated method stub
		
	}
	
}