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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.springmvc.common.Info;
import fa.training.springmvc.entities.KhachHang;
import fa.training.springmvc.entities.May;
import fa.training.springmvc.entities.PageAble;
import fa.training.springmvc.service.KhachHangServiceImpl;
import fa.training.springmvc.service.ListAllInfoService;
import fa.training.springmvc.service.ManageService;
import fa.training.springmvc.service.MayServiceImpl;

@Controller
public class KhachHangController{
	
	@Autowired
	private ManageService<KhachHang> manageService;
	
	@Autowired
	private ListAllInfoService listAllInfoService;
	
	@Autowired
	private KhachHangServiceImpl khachHangServiceImpl;
	
	@RequestMapping(value="ShowInsertCustom")
	public String showCreate(Model model) {
		model.addAttribute("khach", new KhachHang());
		return "createCustom";
	}
	
	@PostMapping(value="createCustom")
	public String createMachine(@Valid @ModelAttribute("khach") KhachHang khach ,BindingResult br, Model model) {
			if(br.hasErrors()) {
				return "createCustom";
			}else {	
				if(!khach.getMaKH().equals(khach.getTenKH())) {			
					manageService.Save(khach);
					model.addAttribute("message", "Thêm thành công");
					model.addAttribute("khach", new KhachHang());
				}
				else {	
					model.addAttribute("khach", khach);
					model.addAttribute("message", "Thêm thất bại");
				}
				return showCreate(model);
			}
		
	}
	
	@RequestMapping(value="ShowListCustom")
	public String showList(Model model) {
		return listByPage(model,1, null);
	}
	
	
	@RequestMapping(value="/readCustom/{pageNumber}")
	public String listByPage(Model model,
			@PathVariable("pageNumber") int currentPage,
			@RequestParam(name="searchMaKH",required = false) String searchMaKH) {
			
		
		List<KhachHang> listKhach = null;
		if(searchMaKH != null) {
			Page<KhachHang> page =(Page<KhachHang>) manageService.search(searchMaKH,currentPage);
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
			listKhach = page.getContent();
			model.addAttribute("searchMaKH", searchMaKH);
		 	model.addAttribute("previousPage",previousPage);
			model.addAttribute("nextPage",nextPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("listKhach", listKhach);
		}else {
			Page<KhachHang> page = manageService.listAll(currentPage);
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
			listKhach = page.getContent();
		 	model.addAttribute("previousPage",previousPage);
			model.addAttribute("nextPage",nextPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("listKhach", listKhach);
		}
		
		
		return "readCustom";
	}
	
	@RequestMapping(value="deleteCustom/{id}")
	public String deleteKhachHang(@PathVariable("id") String id, Model model) {
		try {
			manageService.deleteByID(id);
			model.addAttribute("message", "xóa thành công");
//			return "readCustom";
		} catch (Exception e) {
			model.addAttribute("message", "xóa thất bại ");
//			return "readCustom";
		}
		return showList(model);
	}
	
	
	@RequestMapping(value="showupdateCustom/{id}")
	public String showUpdate(@PathVariable("id") String id, Model model) {
		KhachHang khach =manageService.findByID(id);
		model.addAttribute("khach", khach);
		return "updateCustom";
	}
	
	@RequestMapping(value = "updateCustom")
	public String updateMachine(@Valid @ModelAttribute("khach") KhachHang khach,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "updateCustom";
		}else {			
			try {
				manageService.update(khach);
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
	
	@RequestMapping(value = "ShowHistoryUse")
	public String ShowHistoryUse(@RequestParam(defaultValue = "1") Integer page,Model model) {
			PageAble pageAble = new PageAble(page);
	        List<Info> customerDTOList = khachHangServiceImpl.getAllPage(pageAble);
	        Integer totalPage = khachHangServiceImpl.getTotalPageUse(pageAble);
	        model.addAttribute("totalPage", totalPage);
	        model.addAttribute("currentPage", page);
	        model.addAttribute("listAllInfo", customerDTOList);
		return "info";
	}
//	public String showListHistory(Model model) {
//		return listByPageHistory(model,1);
//	}
//	
//	@RequestMapping(value="/readHistory/{pageNumber}")
//	public String listByPageHistory(Model model,
//			@PathVariable("pageNumber") int currentPage) {
//			
//		
//			List<Info> listAllInfo = null;
//			Page<Info> page = khachHangServiceImpl.listAllInfo(currentPage);
//			long totalItems = page.getTotalElements();
//			int totalPages = page.getTotalPages();
//			int previousPage = currentPage-1;
//			int nextPage = currentPage+1;
//			
//			if(previousPage<1) {
//				previousPage = 1;
//			}
//			if(nextPage >totalPages) {
//				nextPage =totalPages;
//			}
//			listAllInfo = page.getContent();
//		 	model.addAttribute("previousPage",previousPage);
//			model.addAttribute("nextPage",nextPage);
//			model.addAttribute("currentPage",currentPage);
//			model.addAttribute("totalItems",totalItems);
//			model.addAttribute("totalPages",totalPages);
//			model.addAttribute("listAllInfo", listAllInfo);
//		return "info";
//	}
	
	
	
	
}	
