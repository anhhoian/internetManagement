package fa.training.springmvc.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.training.springmvc.entities.May;

@Repository
public interface MayRepository extends PagingAndSortingRepository<May, String> {
	
	@Query("Select m from May m where m.maMay Like ?1% or m.viTri Like ?1% or m.trangThai Like ?1%")
	Page<May> search(String search, Pageable pageable);
	
	
	
}
