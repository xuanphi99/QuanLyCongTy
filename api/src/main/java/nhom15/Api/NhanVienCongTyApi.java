package nhom15.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom15.entity.NhanVienCongTy;
import nhom15.repository.NhanVienCongTyRepository;


@RestController
@RequestMapping(path = "api/nvcongtys",produces = "application/json")
@CrossOrigin(origins = "*")
public class NhanVienCongTyApi {
	
	@Autowired
	EntityLinks entityLinks;

//	@Autowired
	private NhanVienCongTyRepository nhanVienCongTyRepository;
	
	
	@Autowired
	public NhanVienCongTyApi(NhanVienCongTyRepository nhanVienCongTyRepository) {
	
		this.nhanVienCongTyRepository = nhanVienCongTyRepository;
	}

	// Get all cong ty
	@GetMapping
	public Iterable<NhanVienCongTy> getAllCongTies(){
		Iterable<NhanVienCongTy> iterable = nhanVienCongTyRepository.findAll();
		if (iterable.iterator() != null) {
			return nhanVienCongTyRepository.findAll();
		}
		return null;
		
	}	
	
}
