package nhom15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import nhom15.entity.CongTy;
import nhom15.entity.NhanVienCongTy;


public interface NhanVienCongTyRepository extends JpaRepository<NhanVienCongTy, Long> {
	

}
