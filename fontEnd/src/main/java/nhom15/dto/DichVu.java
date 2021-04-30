package nhom15.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DichVu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long maDv;

	private String tenDV;
	
	
	private String loaiDV;
	
	
	private double heSoLuong ;
	
	private double donGia;
	Set<DichVuCongTy> dichVuCongTys;


	private Set<NhanVienToaNha> nhanVienToaNhass;
	
}
