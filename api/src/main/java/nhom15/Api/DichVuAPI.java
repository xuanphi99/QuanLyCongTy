package nhom15.Api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nhom15.entity.DichVu;
import nhom15.repository.DichVuRepository;

@RestController
@RequestMapping(path = "api/dichvus",produces = "application/json")
@CrossOrigin(origins = "*")
public class DichVuAPI {
	
	
	@Autowired
	EntityLinks entityLinks;
	
	
	private DichVuRepository dichVuRepository;
	
	
	@Autowired
	public DichVuAPI(DichVuRepository dichVuRepository) {
		super();
		this.dichVuRepository = dichVuRepository;
	}

	//getAll
	@GetMapping
	public Iterable<DichVu> getAllDichVus(){
		Iterable<DichVu> iterable = dichVuRepository.findAll();
		if (iterable.iterator() != null) {
			System.out.println(iterable.toString());
			return dichVuRepository.findAll();
		}
		return null;
		
	}
	
	// get by id 
		@GetMapping(path = "/{id}")
		@ResponseStatus(code = HttpStatus.OK)
		public DichVu getDichVuById( @PathVariable(value = "id") long idCongTy ){
			Optional<DichVu> optDichVu = dichVuRepository.findById(idCongTy);
			
			if (optDichVu.isPresent()) {
				return optDichVu.get();
			}
			return null;
			
		}
	
	
	
}
