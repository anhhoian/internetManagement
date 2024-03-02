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
import fa.training.springmvc.entities.SuDungMay;
import fa.training.springmvc.service.ManageService;
import fa.training.springmvc.service.MayServiceImpl;

@Controller
public class SuDungMayController{
	
	@Autowired
	private ManageService<SuDungMay> manageService;
	
	@Autowired
	private ManageService<May> manageServiceMay;
	
	@Autowired
	private ManageService<KhachHang> manageServiceKH;

	@RequestMapping(value="ShowInsertUseMachine")
	public String showCreate(Model model) {
		List<May> listMay = manageServiceMay.ListAllNoPage();
		List<KhachHang> listKhachHang = manageServiceKH.ListAllNoPage();
		model.addAttribute("listMay", listMay);
		model.addAttribute("listKhachHang", listKhachHang);
		model.addAttribute("suDungMay", new SuDungMay());
		return "dkSuDungMay";
	}
	
	@PostMapping(value="dkSuDungMay")
	public String createdkSuDungMay(@Valid @ModelAttribute("suDungMay") SuDungMay suDungMay,BindingResult br ,Model model) {
		if(br.hasErrors()) {
			return "dkSuDungMay";
		}else {	
			try {
				manageService.Save(suDungMay);	
				model.addAttribute("message", "Thêm thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Thêm thất bại");
			}
			return showCreate(model);
		}
	}
	
	
	
}	
