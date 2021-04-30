package nhom15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import nhom15.entity.NhanVienToaNha;

@Transactional
public interface NhanVienToaNhaRepository extends JpaRepository<NhanVienToaNha, Long>{

}
