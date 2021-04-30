package nhom15.Api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nhom15.entity.CongTy;
import nhom15.entity.DichVu;
import nhom15.entity.DichVuCongTy;
import nhom15.repository.DichVuCongTyRepository;
//
@RestController
@RequestMapping(path = "api/dichvucongtys",produces = "application/json")
@CrossOrigin(origins = "*")
public class DichVuCongTyApi {
	
	@Autowired
	EntityLinks entityLinks;
	
	@Autowired
	private DichVuCongTyRepository dichVuCongTyRepository;

	public DichVuCongTyApi(DichVuCongTyRepository dichVuCongTyRepository) {
		super();
		this.dichVuCongTyRepository = dichVuCongTyRepository;
	}
	//getAll
	@GetMapping(path = "/dichvucongtys")
	public Iterable<DichVuCongTy> getAllCongTies(){
		Iterable<DichVuCongTy> iterable = dichVuCongTyRepository.findAll();
		if (iterable.iterator() != null) {
			return dichVuCongTyRepository.findAll();
		}
		return null;
		
	}
	// get by id 
			@GetMapping(path = "/dichvucongtys/{id}")
			@ResponseStatus(code = HttpStatus.OK)
			public DichVuCongTy getCongTyById( @PathVariable(value = "id") long idCongTy ){
				Optional<DichVuCongTy> optDichVucongty = dichVuCongTyRepository.findById(idCongTy);
				
				if (optDichVucongty.isPresent()) {
					return optDichVucongty.get();
				}
				return null;
				
			}
	
			//add DV cong ty
			@PostMapping(path = "",consumes = "application/json")
			@ResponseStatus(code = HttpStatus.CREATED)
			public DichVuCongTy addDVCongTy(@RequestBody DichVuCongTy dichVuCongTy) {
				System.out.println(dichVuCongTy);
				return dichVuCongTyRepository.save(dichVuCongTy);
			}
			
		//xoa
			@DeleteMapping("/{id}")
			@ResponseStatus(code = HttpStatus.OK)
			public void deleteCongTy(@PathVariable("id") Long id_dvct) {
			try {

				dichVuCongTyRepository.deleteById(id_dvct);

			} catch (EmptyResultDataAccessException e) {
				
			}
			}	
			
			

}
