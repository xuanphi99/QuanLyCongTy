package nhom15.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import nhom15.dto.CongTy;
import nhom15.dto.CongtyPage;
import nhom15.dto.DichVu;
import nhom15.dto.DichVuCongTy;

@Controller
@RequestMapping("/")
public class CongTyController {
	private RestTemplate rest = new RestTemplate();
	
	/* test Angular JS */
	@GetMapping("/angularjs")
	public String trangchu() {
		return "angular/testAngular";
	}
	/* form thong ke */
	@GetMapping("/tongketien")
	public String viewHomePage(Model model) {
		return findPaginated(model,1);		
	}
	
	@GetMapping("/tongketien/{page}")
	public String findPaginated(Model model,@PathVariable(value = "page") long page) {
		CongtyPage congtyPage = rest.getForObject("http://localhost:8080/api/congtys/page/{page}", CongtyPage.class,page);
		
		
	//	System.out.println(congtyPage.toString());
		List<CongTy> listcongty = congtyPage.getLists();
		
		for (CongTy congTy : listcongty) {
			System.out.println(congTy.toString());
		}
		
		
		model.addAttribute("currentPage", page);
		model.addAttribute("listEmployees", listcongty);
		model.addAttribute("totalPages", congtyPage.getTotalPage());
		model.addAttribute("totalItems", congtyPage.getPage());
		System.out.println("total = "+ congtyPage.getTotalPage());
		return "ThongkeTiendichVu";
	}
	
	
	@GetMapping
	public String index(Model model){		
List<DichVu> listDV = Arrays.asList( rest.getForObject("http://localhost:8080/api/dichvus/", DichVu[].class));
		
		model.addAttribute("dichvu", listDV);
		model.addAttribute("congty", new CongTy());
		return "index";
		
	}
	
	//update form

	@GetMapping("/{id}")
	public String updateCongty(Model model,@PathVariable(value = "id") long idCongTy) {
		List<DichVu> listDV = Arrays.asList( rest.getForObject("http://localhost:8080/api/dichvus/", DichVu[].class));
		CongTy congTy = rest.getForObject("http://localhost:8080/api/congtys/{id}", CongTy.class,idCongTy);
		
		Map< DichVu,Integer> map = new HashMap<>();
		if (congTy != null) {
			model.addAttribute("dichvu", listDV);
			model.addAttribute("congty",congTy);
			Set<DichVuCongTy> dichVuCongTies = congTy.getDichVuCongTys();
		//	List<Long> madvct = new ArrayList<Long>();
			Map< Long,Long> pairDv = new HashMap<>();
			for (DichVuCongTy dichVuCongTy : dichVuCongTies) {
		
				pairDv.put(dichVuCongTy.getId(), dichVuCongTy.getDichVu().getMaDv());
			}

			
			model.addAttribute("pairDv", pairDv);
		for (DichVu i : listDV) {
			boolean check =true;
			for (DichVuCongTy dichVuCongTy : dichVuCongTies) {
					
				if (dichVuCongTy.getDichVu().getMaDv()== i.getMaDv()) {
					map.put( i,0); check=false; break;
				}
		}
			if (check) {
				map.put(i,1);
			}
	}
		model.addAttribute("dvcongty",map);
		
			
			return "updatecongty";
		}
	
		
		
		return "exception/Error404";
	
	
	} 
	@GetMapping("/danhsachquanli")
	public String showListData(Model model) {
		List<DichVu> listDV = Arrays.asList( rest.getForObject("http://localhost:8080/api/dichvus/", DichVu[].class));
		List<CongTy> listCongTy = Arrays.asList(rest.getForObject("http://localhost:8080/api/congtys", CongTy[].class));
		
		
			
		model.addAttribute("dichvu", listDV);
		model.addAttribute("congty", listCongTy);
		
		return "danhsachquanli";
	}
	
	//insert
	
	@PostMapping("/")
	public String showAddForm(Model model, @ModelAttribute("congty") CongTy congty, @RequestParam(value = "dichvus", defaultValue = "1,2", required = true) String dichvus) {

	
	
		CongTy ctyTMP =	rest.postForObject("http://localhost:8080/api/congtys", congty, CongTy.class);
	//	System.out.println(congty.toString());
		String dvSD = dichvus;
		if (!dichvus.contains("1,2")) {
			
		
		 dvSD = dichvus +",1,2";
		}
	for (String i : dvSD.split("\\,")) {
		if (!i.equals(",")) {
			
	
		DichVuCongTy dichVuCongTy = new DichVuCongTy();
		DichVu dv = rest.getForObject("http://localhost:8080/api/dichvus/{id}", DichVu.class, i);
	//	System.out.println(dv.toString());
		
		dichVuCongTy.setDichVu(dv);
		congty.setId(ctyTMP.getId());
		dichVuCongTy.setCongTy(congty);
		dichVuCongTy.setNgaydangkydv(new Date());
		
		rest.postForObject("http://localhost:8080/api/dichvucongtys", dichVuCongTy, DichVuCongTy.class);
		//System.out.println(dichVuCongTy.toString());
		
	}
}	
		return "redirect:/danhsachquanli";
	}
	
	
	
	
	
}
