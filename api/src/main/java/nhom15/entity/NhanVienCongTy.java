package nhom15.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nhanviencongty")
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class NhanVienCongTy extends BaseEntity {
	
	
//	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//	@JsonBackReference
//	@JsonIgnore  // ngan chan dl qhe
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "congty_id",nullable = false)
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	@JsonIgnoreProperties("nhanViens")
//	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private CongTy congtys;
	
	@OneToMany(mappedBy = "nhanVienCongTy")
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	@JsonIgnoreProperties("nhanVienCongTy")
	Set<ChiTietVaoRa> chiTietVaoRas;
	
}
