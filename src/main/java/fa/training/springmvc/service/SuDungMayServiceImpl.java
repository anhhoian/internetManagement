/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.SuDungMay;
import fa.training.springmvc.repository.SuDungMayRepository;

@Service
public class SuDungMayServiceImpl implements ManageService<SuDungMay>{
	
	@Autowired
	SuDungMayRepository suDungMayRepository;

	@Override
	public Page<SuDungMay> listAll(int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Save(SuDungMay suDungMay) {
		suDungMayRepository.save(suDungMay);
	}

	@Override
	public void deleteByID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuDungMay findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SuDungMay t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<SuDungMay> search(String search, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuDungMay> ListAllNoPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
