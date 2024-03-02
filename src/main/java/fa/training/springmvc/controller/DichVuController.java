/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.springmvc.entities.DichVu;
import fa.training.springmvc.entities.KhachHang;
import fa.training.springmvc.entities.May;
import fa.training.springmvc.service.ManageService;
import fa.training.springmvc.service.MayServiceImpl;

@Controller
public class DichVuController{
	
	@Autowired
	private ManageService<DichVu> manageService;

	@RequestMapping(value="ShowInsertService")
	public String showCreate(Model model) {
		model.addAttribute("dichVu", new DichVu());
		return "createService";
	}
	
	@PostMapping(value="createService")
	public String createService(@Valid @ModelAttribute("dichVu") DichVu dichVu , BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "createService";
		}else {
			if(!dichVu.getMaDichVu().equals(dichVu.getTenDichVu())) {			
				manageService.Save(dichVu);
				model.addAttribute("message", "Thêm thành công");
				model.addAttribute("dichVu", new DichVu());
			}
			else {	
				model.addAttribute("dichVu", dichVu);
				model.addAttribute("message", "Thêm thất bại");
			}
			return showCreate(model);
		}
	}
	
	@RequestMapping(value="ShowListService")
	public String showList(Model model) {
		return listByPage(model,1, null);
	}
	
	
	@RequestMapping(value="/readService/{pageNumber}")
	public String listByPage(Model model,
			@PathVariable("pageNumber") int currentPage,
			@RequestParam(name="searchMaDV",required = false) String searchMaDV) {
			
		
		List<DichVu> listDV = null;
		if(searchMaDV != null) {
			Page<DichVu> page =(Page<DichVu>) manageService.search(searchMaDV,currentPage);
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages();
			int previousPage = currentPage-1;
			int nextPage = currentPage+1;
			
			if(previousPage<1) {
				previousPage = 1;
			}
			if(nextPage >totalPages) {
				nextPage =totalPages;
			}
			listDV = page.getContent();
			model.addAttribute("searchMaKH", searchMaDV);
		 	model.addAttribute("previousPage",previousPage);
			model.addAttribute("nextPage",nextPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("listDV", listDV);
		}else {
			Page<DichVu> page = manageService.listAll(currentPage);
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages();
			int previousPage = currentPage-1;
			int nextPage = currentPage+1;
			
			if(previousPage<1) {
				previousPage = 1;
			}
			if(nextPage >totalPages) {
				nextPage =totalPages;
			}
			listDV = page.getContent();
		 	model.addAttribute("previousPage",previousPage);
			model.addAttribute("nextPage",nextPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("listDV", listDV);
		}
		
		
		return "readService";
	}
	
	@RequestMapping(value="deleteService/{id}")
	public String deleteService(@PathVariable("id") String id,Model model) {
		try {
			manageService.deleteByID(id);
			model.addAttribute("message", "xóa thành công");
		} catch (Exception e) {
			model.addAttribute("message", "xóa thất bại ");
		}
		return showList(model);
	}
	
	
	@RequestMapping(value="showupdateService/{id}")
	public String showUpdate(@PathVariable("id") String id, Model model) {
		DichVu dichVu =manageService.findByID(id);
		model.addAttribute("dichVu", dichVu);
		return "updateService";
	}
	
	@RequestMapping(value = "updateService")
	public String updateMachine(@Valid @ModelAttribute("dichVu") DichVu dichVu,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "updateService";
		}else {		
			try {
				manageService.update(dichVu);
				model.addAttribute("message", "sửa thành công");
			} catch (Exception e) {
				model.addAttribute("message", "sửa thất bại");
			}
			return showList(model);
		}
	}
		
//	@RequestMapping(value = "SearchMachine")
//	public String searchMachine(@RequestParam(name="searchMaMay") String searchMaMay, Model model){
//		List<May> listMay = manageService.search(searchMaMay);
//		model.addAttribute("listMay", listMay);
//		return "readMachine";
//	}
	
}	
