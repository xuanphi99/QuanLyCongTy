package nhom15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nhom15.entity.DichVuCongTy;

@Repository
public interface DichVuCongTyRepository extends JpaRepository<DichVuCongTy, Long> {

}

