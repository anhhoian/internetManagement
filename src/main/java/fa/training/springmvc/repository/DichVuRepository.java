/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import fa.training.springmvc.entities.DichVu;
import fa.training.springmvc.entities.KhachHang;

public interface DichVuRepository extends PagingAndSortingRepository<DichVu, String> {
	
	@Query("Select d from DichVu d where d.maDichVu Like ?1% or d.tenDichVu Like ?1% or d.donViTinh Like ?1% "
			+ "or d.dongia Like ?1%")
	Page<DichVu> search(String search, Pageable pageable);
}
