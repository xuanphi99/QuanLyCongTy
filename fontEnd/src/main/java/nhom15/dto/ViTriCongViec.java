package nhom15.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ViTriCongViec implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	private long id;
	

	private int tenViTri;
	
	private int heSoLuong;
	
	//1 vi tri co nhieu nv
	
	
	private Set<NhanVienToaNha> nhanVienToaNhas;
	

}
