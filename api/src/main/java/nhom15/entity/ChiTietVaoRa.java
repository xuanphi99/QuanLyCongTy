package nhom15.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "chitietvaora")
public class ChiTietVaoRa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "thoigianvao")
	private Date thoiGianVaoRa ;
	
	@Column(name = "thoigianra")
	private Date thoiGianRa ;
	
	
	   @ManyToOne
	    @JoinColumn(name = "nhanVienCongTy_id")
		@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
		@ToString.Exclude // Khoonhg sử dụng trong toString()
		@JsonIgnoreProperties("chiTietVaoRas")
		NhanVienCongTy nhanVienCongTy;

	    @ManyToOne
	    @JoinColumn(name = "viTriVaoRa_id")
		@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
		@ToString.Exclude // Khoonhg sử dụng trong toString()
		@JsonIgnoreProperties({"chiTietVaoRas"})
		ViTriVaoRa viTriVaoRa;
	
	
	
}
