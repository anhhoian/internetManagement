/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import fa.training.springmvc.common.Info;
import fa.training.springmvc.entities.KhachHang;
import fa.training.springmvc.entities.May;

public interface KhachHangRepository extends PagingAndSortingRepository<KhachHang, String> {
	
	@Query("Select k from KhachHang k where k.maKH Like ?1% or k.tenKH Like ?1% or k.diaChi Like ?1% "
			+ "or k.soDienThoai Like ?1% or k.diaChiEmail Like ?1%")
	Page<KhachHang> search(String search, Pageable pageable);
	
	
//	@Query("select  kh.maKH , kh.tenKH , \r\n"
//			+ "m.maMay , m.viTri, m.trangThai\r\n"
//			+ ",sdm.ngayBatDauSuDung , sdm.gioBatDauSuDung, \r\n"
//			+ "sdm.thoiGianSuDung , sdv.maDichVu,sdv.ngaySuDung, sdv.gioSuDung, sdv.soLuong\r\n"
//			+ "from KhachHang kh \r\n"
//			+ " join  SuDungDichVu sdv on kh.maKH = sdv.maKH\r\n"
//			+ "left  join SuDungMay sdm on kh.maKH = sdm.maKH\r\n"
//			+ "left  join  DichVu dv on sdv.maDichVu = dv.maDichVu\r\n"
//			+ " join May m on sdm.maMay = m.maMay")
	@Query(value="select kh.maKH , kh.tenKH , \r\n"
			+ "m.maMay , m.viTri, m.trangThai\r\n"
			+ ",sdm.ngayBatDauSuDung , sdm.gioBatDauSuDung, \r\n"
			+ "sdm.thoiGianSuDung , sdv.maDichVu,	sdv.ngaySuDung, sdv.gioSuDung, sdv.soLuong \r\n"
			+ "from KhachHang kh, SuDungDichVu sdv, SuDungMay sdm, DichVu dv, May m\r\n"
			+ "where kh.maKH = sdv.maKH and kh.maKH = sdm.maKH and sdv.maDichVu = dv.maDichVu and sdm.maMay = m.maMay order by kh.maKH offset ?1 rows FETCH next ?2 rows only",nativeQuery = true)
	List<Info> selectAllInfor(int i, Integer size);
	
	@Query(value="select kh.maKH , kh.tenKH , \r\n"
			+ "m.maMay , m.viTri, m.trangThai\r\n"
			+ ",sdm.ngayBatDauSuDung , sdm.gioBatDauSuDung, \r\n"
			+ "sdm.thoiGianSuDung , sdv.maDichVu,	sdv.ngaySuDung, sdv.gioSuDung, sdv.soLuong \r\n"
			+ "from KhachHang kh, SuDungDichVu sdv, SuDungMay sdm, DichVu dv, May m\r\n"
			+ "where kh.maKH = sdv.maKH and kh.maKH = sdm.maKH and sdv.maDichVu = dv.maDichVu and sdm.maMay = m.maMay",nativeQuery = true)
	List<Info> selectAllInfor();
	
}
