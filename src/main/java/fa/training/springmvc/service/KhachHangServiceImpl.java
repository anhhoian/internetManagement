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

import fa.training.springmvc.common.Info;
import fa.training.springmvc.entities.KhachHang;
import fa.training.springmvc.entities.May;
import fa.training.springmvc.entities.PageAble;
import fa.training.springmvc.repository.KhachHangRepository;
import fa.training.springmvc.repository.MayRepository;

@Service
public class KhachHangServiceImpl implements ManageService<KhachHang>, ListAllInfoService{
	
	@Autowired
	private KhachHangRepository khachHangRepository;

	@Override
	public Page<KhachHang> listAll(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,5);
		Pageable pageable = pageRequest;
		return khachHangRepository.findAll(pageable);
	}

	@Override
	public void Save(KhachHang khach) {
		khachHangRepository.save(khach);
		
	}

	@Override
	public void deleteByID(String id) {
		khachHangRepository.delete(id);
		
	}

	@Override
	public KhachHang findByID(String id) {
		return khachHangRepository.findOne(id);
	}

	@Override
	public void update(KhachHang khach) {
		KhachHang khachFromDb= khachHangRepository.findOne(khach.getMaKH());
		khachFromDb.setMaKH(khach.getMaKH());
		khachFromDb.setTenKH(khach.getTenKH());
		khachFromDb.setDiaChi(khach.getDiaChi());
		khachFromDb.setSoDienThoai(khach.getSoDienThoai());
		khachFromDb.setDiaChiEmail(khach.getDiaChiEmail());
		khachHangRepository.save(khachFromDb);
	}

	@Override
	public Page<KhachHang> search(String search,int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1,5);
		Pageable pageable = pageRequest;
		return (Page<KhachHang>) khachHangRepository.search(search,pageable);
	}

	@Override
	public List<KhachHang> ListAllNoPage() {
		return (List<KhachHang>) khachHangRepository.findAll();
	}

	public List<Info> getAllCustomerUse() {
        return khachHangRepository.selectAllInfor();
    }

    public List<Info> getAllPage(PageAble pageAble) {
        return khachHangRepository.selectAllInfor((pageAble.getCurrent()-1)*pageAble.getSize(), pageAble.getSize());
    }
    public Integer getTotalPageUse(PageAble pageAble) {
        return (int)Math.ceil((double)getAllCustomerUse().size()/pageAble.getSize());
    }

	@Override
	public List<Info> listAllInfo(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Info> selectAllInfor() {
		// TODO Auto-generated method stub
		return null;
	}
}
