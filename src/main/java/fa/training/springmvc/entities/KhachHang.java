/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class KhachHang {
	
	@Id
	@NotEmpty(message="Not Null")
	@Pattern(regexp = "^(KH)[0-9]{3}$",
			message = "customer code not valid (KHXXX)")
	private String maKH;
	
	@NotEmpty(message="Not Null")
	private String tenKH;
	@NotEmpty(message="Not Null")
	private String diaChi;
	@NotEmpty(message="Not Null")
	@Pattern(regexp = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$",
	message = "Phone not valid (090|091|84+90|84+91)")
	private String soDienThoai;
	@NotEmpty(message="Not Null")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
	message = "email not valid")
	private String diaChiEmail;
	
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChiEmail() {
		return diaChiEmail;
	}
	public void setDiaChiEmail(String diaChiEmail) {
		this.diaChiEmail = diaChiEmail;
	}
	public KhachHang(String maKH, String tenKH, String diaChi, String soDienThoai, String diaChiEmail) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.diaChiEmail = diaChiEmail;
	}
	public KhachHang() {
		super();
	}
	
	
}
