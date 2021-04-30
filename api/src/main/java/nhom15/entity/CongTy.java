package nhom15.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "congty")
@Data
public class CongTy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "masothue")
	private String maSoThue;
	
	@Column(name = "tencongty")
	private String tencongty;
	
	@Column(name = "sonhanvien")
	private int soNhanVien;
	
	@Column(name = "vondieule")
	private Long vonDieuLe;
	
	@Column(name = "linhvuchoatdong")
	private String linhVucHoatDong;
	
	@Column(name = "diachi")
	private String diaChi;
	
	@Column(name = "sodienthoai")
	private long soDienThoai;
	
	@Column(name = "dtmatbang")
	private double DtMatbang;
	@Column(name = "tongtien")
	private double tongtien;
	
	@OneToMany(mappedBy ="congTy", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	@JsonIgnoreProperties("congTy")
	private Set<DichVuCongTy> dichVuCongTys;

	
	// @JsonIgnore
	@OneToMany(mappedBy = "congtys")
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	@JsonIgnoreProperties("congtys")
	private Set<NhanVienCongTy> nhanViens = new HashSet<>();
	
	
}
