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

import fa.training.springmvc.entities.DichVu;
import fa.training.springmvc.entities.KhachHang;
import fa.training.springmvc.entities.May;
import fa.training.springmvc.repository.DichVuRepository;
import fa.training.springmvc.repository.KhachHangRepository;
import fa.training.springmvc.repository.MayRepository;

@Service
public class DichVuServiceImpl implements ManageService<DichVu>{
	
	@Autowired
	private DichVuRepository dichVuRepository;

	@Override
	public Page<DichVu> listAll(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,5);
		Pageable pageable = pageRequest;
		return dichVuRepository.findAll(pageable);
	}

	@Override
	public void Save(DichVu dichVu) {
		dichVuRepository.save(dichVu);
		
	}

	@Override
	public void deleteByID(String id) {
		dichVuRepository.delete(id);
		
	}

	@Override
	public DichVu findByID(String id) {
		return dichVuRepository.findOne(id);
	}

	@Override
	public void update(DichVu dichVu) {
		DichVu dichVuFromDb= dichVuRepository.findOne(dichVu.getMaDichVu());
		dichVuFromDb.setMaDichVu(dichVu.getMaDichVu());
		dichVuFromDb.setTenDichVu(dichVu.getTenDichVu());
		dichVuFromDb.setDonViTinh(dichVu.getDonViTinh());
		dichVuFromDb.setDongia(dichVu.getDongia());
		dichVuRepository.save(dichVuFromDb);
	}

	@Override
	public Page<DichVu> search(String search,int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,5);
		Pageable pageable = pageRequest;
		return (Page<DichVu>) dichVuRepository.search(search,pageable);
	}

	@Override
	public List<DichVu> ListAllNoPage() {
		return (List<DichVu>) dichVuRepository.findAll();
	}
	
}
