package nhom15.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BacCongViec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private long id;
	
	private int heSoBac;
	
	private Set<NhanVienToaNha> nhanVienToaNhas;
	
}
