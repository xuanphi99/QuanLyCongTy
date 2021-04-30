package nhom15.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "baccongviec")
public class BacCongViec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "hesobac")
	private int heSoBac;
	
	@OneToMany(mappedBy = "bacCongViecs", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	@JsonIgnoreProperties("bacCongViecs")
	private Set<NhanVienToaNha> nhanVienToaNhas;
	
}
