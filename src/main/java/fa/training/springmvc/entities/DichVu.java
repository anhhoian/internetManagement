/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class DichVu {
	
	@Id
	@NotEmpty(message="Not Null")
	@Pattern(regexp = "^(DV)[0-9]{3}$",
			message = "Service code not valid (DVXXX)")
	private String maDichVu;
	@NotEmpty(message="Not Null")
	private String tenDichVu;
	@NotEmpty(message="Not Null")
	private String donViTinh;
	@Min(0)
	private int dongia;
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public DichVu(String maDichVu, String tenDichVu, String donViTinh, int dongia) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.donViTinh = donViTinh;
		this.dongia = dongia;
	}
	public DichVu() {
		super();
	}
	
	
}
