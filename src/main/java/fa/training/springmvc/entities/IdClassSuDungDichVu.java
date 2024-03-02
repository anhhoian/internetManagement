/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.entities;

import java.io.Serializable;

public class IdClassSuDungDichVu implements Serializable {

	private String maKH;
	private String maDichVu;
	private String ngaySuDung;
	private String gioSuDung;
	public IdClassSuDungDichVu(String maKH, String maDichVu, String ngaySuDung, String gioSuDung) {
		super();
		this.maKH = maKH;
		this.maDichVu = maDichVu;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
	}
	
	
	public IdClassSuDungDichVu() {
		super();
	}


	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
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
	
	
}
