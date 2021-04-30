package nhom15.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietVaoRa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private Date thoiGianVaoRa ;
	
	private Date thoiGianRa ;
	    NhanVienCongTy nhanVienCongTy;


	    ViTriVaoRa viTriVaoRa;
	
	
	
}
