package nhom15.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "dichvu")
@Data
public class DichVu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "madv")
	private long maDv;
	
	@Column(name = "tendv")
	private String tenDV;
	
	@Column(name = "loaidv")
	private String loaiDV;
	
    @Column(name = "dongia")
    double donGia;
	
	@Column(name = "hesoluong")
	private double heSoLuong ;
	
	@OneToMany(mappedBy = "dichVu",cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@JsonIgnoreProperties({"dichVu"})
	
	Set<DichVuCongTy> dichVuCongTys;

	// 1dv cho nhieu nv cung cap
	@OneToMany(mappedBy = "dichVus")
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@JsonIgnoreProperties("dichVus")
	private Set<NhanVienToaNha> nhanVienToaNhas;
	
}
