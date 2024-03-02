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

import fa.training.springmvc.entities.SuDungDichVu;
import fa.training.springmvc.entities.SuDungMay;
import fa.training.springmvc.repository.SuDungDichVuRepository;
import fa.training.springmvc.repository.SuDungMayRepository;

@Service
public class SuDungDichVuServiceImpl implements ManageService<SuDungDichVu>{
	
	@Autowired
	SuDungDichVuRepository suDungDichVuRepository;

	@Override
	public List<SuDungDichVu> ListAllNoPage() {
		return null;
	}

	@Override
	public Page<SuDungDichVu> listAll(int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Save(SuDungDichVu t) {
		suDungDichVuRepository.save(t);
		
	}

	@Override
	public void deleteByID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuDungDichVu findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SuDungDichVu t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<SuDungDichVu> search(String search, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
