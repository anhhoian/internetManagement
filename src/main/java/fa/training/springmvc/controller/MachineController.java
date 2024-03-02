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

import fa.training.springmvc.entities.KhachHang;
import fa.training.springmvc.entities.May;
import fa.training.springmvc.service.ManageService;
import fa.training.springmvc.service.MayServiceImpl;

@Controller
public class MachineController{
	
	@Autowired
	private ManageService<May> manageService;
	
	@RequestMapping(value="ShowInsertMachine")
	public String showCreate(Model model) {
		model.addAttribute("may", new May());
		return "createmachine";
	}
	
	@PostMapping(value="createMachine")
	public String createMachine(@Valid @ModelAttribute("may") May may , BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "createmachine";
		}else {			
			if(!may.getMaMay().equals(may.getViTri())) {			
				manageService.Save(may);
				model.addAttribute("message", "Thêm thành công");
				model.addAttribute("may", new May());
			}
			else {	
				model.addAttribute("may", may);
				model.addAttribute("message", "Thêm thất bại");
			}
			return showCreate(model);
		}
	}
	
	@RequestMapping(value="ShowListMachine")
	public String showList(Model model) {
		return listByPage(model,1, null);
	}
	
	
	@RequestMapping(value="/readMachine/{pageNumber}")
	public String listByPage(Model model,
			@PathVariable("pageNumber") int currentPage,
			@RequestParam(name="searchMaMay",required = false) String searchMaMay) {
			
		
		List<May> listMay = null;
		if(searchMaMay != null) {
			Page<May> page =(Page<May>) manageService.search(searchMaMay,currentPage);
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
			listMay = page.getContent();
			model.addAttribute("searchMaMay", searchMaMay);
		 	model.addAttribute("previousPage",previousPage);
			model.addAttribute("nextPage",nextPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("listMay", listMay);
		}else {
			Page<May> page = manageService.listAll(currentPage);
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
			listMay = page.getContent();
		 	model.addAttribute("previousPage",previousPage);
			model.addAttribute("nextPage",nextPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("listMay", listMay);
		}
		
		
		return "readMachine";
	}
	
	@RequestMapping(value="deleteMachine/{id}")
	public String deleteMay(@PathVariable("id") String id,Model model) {
		try {
			manageService.deleteByID(id);
			model.addAttribute("message", "xóa thành công");
		} catch (Exception e) {
			model.addAttribute("message", "xóa thất bại ");
		}
		return showList(model);
	}
	
	
	@RequestMapping(value="showupdateMachine/{id}")
	public String showUpdate(@PathVariable("id") String id, Model model) {
		May may =manageService.findByID(id);
		model.addAttribute("may", may);
		return "updateMachine";
	}
	
	@RequestMapping(value = "updateMachine")
	public String updateMachine(@Valid @ModelAttribute("may") May may, BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "updateMachine";
		}else {
			
			try {
				manageService.update(may);
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
