package nhom15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nhom15.entity.CongTy;


public interface CongTyRepository extends JpaRepository<CongTy, Long> {
	

}
