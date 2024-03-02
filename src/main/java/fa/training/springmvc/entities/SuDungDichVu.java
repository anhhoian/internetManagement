/**
 * @author AnhP2
 *
 * @date 2001_05_28
 *
 */

package fa.training.springmvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@IdClass(IdClassSuDungDichVu.class)
public class SuDungDichVu implements Serializable {

	@Id
	private String maDichVu;
	
	@Id
	private String maKH;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maKH")
	@JoinColumn(name = "maKH", insertable = false, updatable = false)
	private KhachHang khach;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maDichVu")
	@JoinColumn(name = "maDichVu", insertable = false, updatable = false)
	private DichVu dichvu;
	
	@Id
	@NotEmpty(message="Not Null")
	private String ngaySuDung;
	
	@Id
	@NotEmpty(message="Not Null")
	private String gioSuDung;
	
	@Min(0)
	private int soLuong;

	public SuDungDichVu() {
		super();
	}

	public SuDungDichVu(String maDichVu, String maKH, String ngaySuDung, String gioSuDung, int soLuong) {
		super();
		this.maDichVu = maDichVu;
		this.maKH = maKH;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public KhachHang getKhach() {
		return khach;
	}

	public void setKhach(KhachHang khach) {
		this.khach = khach;
	}

	public DichVu getDichvu() {
		return dichvu;
	}

	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}

	public String getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(String ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public String getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(String gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}
