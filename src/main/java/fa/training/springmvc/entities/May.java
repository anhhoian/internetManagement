package fa.training.springmvc.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "May")
public class May {
	
	@Id
	@Column(name = "maMay") 
	@NotEmpty(message="Not Null")
	@Pattern(regexp = "^(MM)[0-9]{3}$",
			message = "Machine code not valid (DVXXX)")
	private String maMay;
	
	@Column(name = "viTri") 
	@NotEmpty(message="Not Null")
	private String viTri;
	
	@Column(name = "trangThai") 
	@NotEmpty(message="Not Null")
	private String trangThai;
	
//	@OneToMany(mappedBy = "May", fetch = FetchType.LAZY)
//	private List<SuDungMay> suDungMays;
	
	public May() {
		super();
	}
	public May(String maMay, String viTri, String trangThai) {
		super();
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
	}
	public String getMaMay() {
		return maMay;
	}
	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
