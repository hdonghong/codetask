package person.dh.mybaties;

/**
 * applicant表实体
 */
public class Applicant {
	private Integer id;
	private String name;
	private String qq;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Applicant(String name, String qq) {
		super();
		this.name = name;
		this.qq = qq;
	}
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
