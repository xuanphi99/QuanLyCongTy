package nhom15.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom15.entity.NhanVienToaNha;
import nhom15.repository.NhanVienToaNhaRepository;


@RestController
@RequestMapping(path = "/api/nhanvientoanha", produces = "application/json")
@CrossOrigin(origins = "*")
public class NhanVienToaNhaAPI {
	private NhanVienToaNhaRepository nhanvienRepo;
	@Autowired
	public NhanVienToaNhaAPI(NhanVienToaNhaRepository nhanvienRepo) {
		this.nhanvienRepo = nhanvienRepo;
	}
	@GetMapping
	public Iterable<NhanVienToaNha> getAllNhanVienToaNhas() {
		return nhanvienRepo.findAll();
	}
}
