/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.May;

public interface ManageService<T>  {
	List<T> ListAllNoPage();
	
	Page<T> listAll(int pageNumber);
	
	void Save(T t);
	
	void deleteByID(String id);
	
	T findByID(String id);
	
	void update(T t);
	
	Page<T> search(String search, int pageNumber);

}
