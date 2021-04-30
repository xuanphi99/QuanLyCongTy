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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vitricongviec")
public class ViTriCongViec implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "tenvitri")
	private int tenViTri;
	
	@Column(name = "hesoluong")
	private int heSoLuong;
	
	//1 vi tri co nhieu nv
	
	@OneToMany(mappedBy = "vitriCongViecs", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@JsonIgnoreProperties({"vitriCongViecs"})
	private Set<NhanVienToaNha> nhanVienToaNhas;
	

}
