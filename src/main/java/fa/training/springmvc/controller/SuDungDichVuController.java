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
import fa.training.springmvc.entities.SuDungDichVu;
import fa.training.springmvc.entities.SuDungMay;
import fa.training.springmvc.service.ManageService;
import fa.training.springmvc.service.MayServiceImpl;

@Controller
public class SuDungDichVuController{
	
	@Autowired
	private ManageService<SuDungDichVu> manageService;
	
	@Autowired
	private ManageService<DichVu> manageServiceDV;
	
	@Autowired
	private ManageService<KhachHang> manageServiceKH;

	@RequestMapping(value="ShowInsertUseService")
	public String showCreate(Model model) {
		List<DichVu> listDV = manageServiceDV.ListAllNoPage();
		List<KhachHang> listKhachHang = manageServiceKH.ListAllNoPage();
		model.addAttribute("listDV", listDV);
		model.addAttribute("listKhachHang", listKhachHang);
		model.addAttribute("suDungDV", new SuDungDichVu());
		return "dkSuDungDV";
	}
	
	@PostMapping(value="dkSuDungDV")
	public String createdkSuDungDV(@Valid @ModelAttribute("suDungDV") SuDungDichVu suDungDV,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "dkSuDungDV";
		}else {
			try {
				manageService.Save(suDungDV);	
				model.addAttribute("message", "Thêm thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Thêm thất bại");
			}
			return showCreate(model);
		}
	}
	
	
	
}	
