/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@IdClass(IdClassSuDungMay.class)
public class SuDungMay implements Serializable {
	
	@Id
	private String maKH;
	
	@Id
	private String maMay;
	
	@ManyToOne
	@MapsId("maKH")
	@JoinColumn(name = "maKH", insertable = false, updatable = false)
	private KhachHang khach;
	
	@ManyToOne
	@MapsId("maMay")
	@JoinColumn(name = "maMay", insertable = false, updatable = false)
	private May may;
	
	@Id
	@NotEmpty(message="Not Null")
	private String ngayBatDauSuDung;
	@Id
	@NotEmpty(message="Not Null")
	private String gioBatDauSuDung;
	
	@NotEmpty(message="Not Null")
	@Pattern(regexp = "^[1-9][0-9]*$",
	message = "time must > 0")
	private String thoiGianSuDung;

	public SuDungMay() {
		super();
	}

	public SuDungMay(String maKH, String maMay, String ngayBatDauSuDung, String gioBatDauSuDung,
			String thoiGianSuDung) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public KhachHang getKhach() {
		return khach;
	}

	public void setKhach(KhachHang khach) {
		this.khach = khach;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public String getNgayBatDauSuDung() {
		return ngayBatDauSuDung;
	}

	public void setNgayBatDauSuDung(String ngayBatDauSuDung) {
		this.ngayBatDauSuDung = ngayBatDauSuDung;
	}

	public String getGioBatDauSuDung() {
		return gioBatDauSuDung;
	}

	public void setGioBatDauSuDung(String gioBatDauSuDung) {
		this.gioBatDauSuDung = gioBatDauSuDung;
	}

	public String getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(String thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}
	

}
