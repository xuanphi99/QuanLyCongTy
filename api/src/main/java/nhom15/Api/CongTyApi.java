package nhom15.Api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nhom15.DTO.CongTyDto;
import nhom15.DTO.CongTyPagin;
import nhom15.DTO.CongtyPage;
import nhom15.entity.CongTy;
import nhom15.entity.DichVu;
import nhom15.entity.DichVuCongTy;
import nhom15.repository.CongTyRepository;
import nhom15.repository.DichVuCongTyRepository;
import nhom15.repository.DichVuRepository;


@RestController
@RequestMapping(path = "api/congtys",produces = "application/json")
@CrossOrigin(origins = "*")
public class CongTyApi {
	
	@Autowired
	EntityLinks entityLinks;

	@Autowired
	private CongTyRepository congTyRepository;
	
	@Autowired
	private DichVuCongTyRepository dichVuCongTyRepository;
	
	@Autowired
	private DichVuRepository dichVuRepository;
	
	
	@Autowired
	public CongTyApi(CongTyRepository congTyRepository, DichVuCongTyRepository dichVuCongTyRepository,
			DichVuRepository dichVuRepository) {
		super();
		this.congTyRepository = congTyRepository;
		this.dichVuCongTyRepository = dichVuCongTyRepository;
		this.dichVuRepository = dichVuRepository;
	}
	public CongTyApi(CongTyRepository congTyRepository) {
		
		this.congTyRepository = congTyRepository;
	}
	// Get all cong ty
	@GetMapping
	public Iterable<CongTy> getAllCongTies(){
		Iterable<CongTy> iterable = congTyRepository.findAll();
		if (iterable.iterator() != null) {
			return congTyRepository.findAll();
		}
		return null;
		
	}
	// get by id 
	@GetMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CongTy getCongTyById( @PathVariable(value = "id") long idCongTy ){
		Optional<CongTy> optCongTy = congTyRepository.findById(idCongTy);
		
		if (optCongTy.isPresent()) {
			return optCongTy.get();
		}
		return null;
		
	}
	
	//add cong ty
	@PostMapping(consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CongTy addCongTy(@RequestBody CongTy congTy) {
		
		return congTyRepository.save(congTy);
	}
	
	// update CongTy
		@PutMapping(path = "/{id}")
		@ResponseStatus(code = HttpStatus.OK)
		public CongTy updateCongTy( @PathVariable(value = "id") long idCongTy,@RequestBody CongTyDto congTyDto) {	
			Optional<CongTy> currentcongTy = congTyRepository.findById(idCongTy);
			if (!currentcongTy.isPresent()) {
				return  null;
			}
			
			else {
//			congTy.setId(idCongTy);
		ModelMapper modelMapper = new ModelMapper();		
		CongTy congTy  = modelMapper.map(congTyDto, CongTy.class); 
		
		for (long item : congTyDto.getListMadv()) {
			DichVuCongTy dichVuCongTy = new DichVuCongTy();
			dichVuCongTy.setNgaydangkydv(new Date());
			dichVuCongTy.setCongTy(congTy);
			Optional<DichVu> optional = dichVuRepository.findById(item);
			dichVuCongTy.setDichVu(optional.get());
			dichVuCongTyRepository.save(dichVuCongTy);
		}

			return  congTyRepository.save(congTy);
			}
	//	
		}
		
		// xoa 
		@DeleteMapping("/{id}")
		@ResponseStatus(code = HttpStatus.OK)
		public void deleteCongTy(@PathVariable("id") Long id_congty) {
		try {

			congTyRepository.deleteById(id_congty);

		} catch (EmptyResultDataAccessException e) {
			
		}
		}	
	
		//phaan trang 
		//@GetMapping("/page/{pageNo}")
//		public CongtyPage pageShort(@RequestParam("page") int page, @RequestParam("limit") int limit) {
//			
//			CongtyPage congtyPage = new CongtyPage();
//			
//			List<CongTyDto > listsCongTy = new ArrayList<CongTyDto>();
//		Page< CongTy> pagecongty=	congTyRepository.findAll(PageRequest.of(page-1, limit));
//		for (CongTy congTy : pagecongty) {
//			ModelMapper modelMapper = new ModelMapper();		
//			CongTyDto item  = modelMapper.map(congTy, CongTyDto.class);
//			listsCongTy.add(item);
//		}
//			congtyPage.setPage(page);
//			congtyPage.setLists(listsCongTy);
//			congtyPage.setTotalPage((int)Math.ceil( congTyRepository.count()/limit )  );
//			return congtyPage;
//		}
		@GetMapping("/page/{pageNo}")
		public CongtyPage findPaginated(@PathVariable (value = "pageNo") int pageNo) {
			
			List<CongTy> listCongTy1 = congTyRepository.findAll();
			List<CongTyPagin > listCtyPagin = new ArrayList<CongTyPagin>();
		
			for (CongTy congTy : listCongTy1) {
				
				ModelMapper modelMapper = new ModelMapper();		
				CongTyPagin item  = modelMapper.map(congTy, CongTyPagin.class);
				item.setTongtiendv(Math.ceil(item.tinhTien(item)));	
				congTy.setTongtien(item.getTongtiendv());
				congTyRepository.save(congTy);
			//	listCtyPagin.add(item);
			//	System.out.println("hiihi"+item.getTongtiendv());
		
			}

			
			
			CongtyPage congtyPage = new CongtyPage();
			
			List<CongTyDto> listsCongTy = new ArrayList<CongTyDto>();
			
		//	Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
			Page< CongTy> pagecongty=	congTyRepository.findAll(PageRequest.of(pageNo-1, 5,Sort.by("tongtien").descending()));
			for (CongTy congTy : pagecongty) {
			ModelMapper modelMapper = new ModelMapper();		
			CongTyDto item  = modelMapper.map(congTy, CongTyDto.class);
			listsCongTy.add(item);
			
		}
		
			congtyPage.setPage(pageNo);
			congtyPage.setLists(listsCongTy);
			congtyPage.setTotalPage((int)Math.ceil( (double) congTyRepository.count()/ (double)5)  );
			System.out.println(congtyPage.toString());
//			return congtyPage;		
		
			return congtyPage;
		}
	
		
	
}
