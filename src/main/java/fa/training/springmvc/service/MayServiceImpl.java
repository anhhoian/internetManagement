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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.springmvc.entities.May;
import fa.training.springmvc.repository.MayRepository;

@Service
public class MayServiceImpl implements ManageService<May>{
	
	@Autowired
	private MayRepository mayRepository;

	@Override
	public Page<May> listAll(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,5);
		Pageable pageable = pageRequest;
		return mayRepository.findAll(pageable);
	}

	@Override
	public void Save(May may) {
		mayRepository.save(may);
	}

	@Override
	public void deleteByID(String id) {
		mayRepository.delete(id);
	}

	@Override
	public May findByID(String id) {
		return mayRepository.findOne(id);
	}

	@Override
	public void update(May may) {
		May mayFromDb= mayRepository.findOne(may.getMaMay());
		mayFromDb.setMaMay(may.getMaMay());
		mayFromDb.setViTri(may.getViTri());
		mayFromDb.setTrangThai(may.getTrangThai());
		mayRepository.save(mayFromDb);
	}

	@Override
	public Page<May> search(String search,int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,5);
		Pageable pageable = pageRequest;
		return (Page<May>) mayRepository.search(search,pageable);
	}

	@Override
	public List<May> ListAllNoPage() {
		return (List<May>) mayRepository.findAll();
	}
	
	
}
