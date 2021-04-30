package nhom15.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "nhanvientoanha")
@Data
public class NhanVienToaNha extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "diachi")
	private String diaChi;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dichvu_id", nullable = false)
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@JsonIgnoreProperties({"nhanVienToaNhas"})
	private DichVu dichVus;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "baccongviec_id", nullable = false)
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@JsonIgnoreProperties({"nhanVienToaNhas"})
	private BacCongViec bacCongViecs;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vitricongviec_id", nullable = false)
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@JsonIgnoreProperties({"nhanVienToaNhas"})
	private ViTriCongViec vitriCongViecs;
	
}
