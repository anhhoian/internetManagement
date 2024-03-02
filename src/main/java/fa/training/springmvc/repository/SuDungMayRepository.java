/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.springmvc.entities.SuDungMay;

public interface SuDungMayRepository extends JpaRepository<SuDungMay, String> {
	
}
