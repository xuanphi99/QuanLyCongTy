package nhom15.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class NhanVienToaNha extends BaseEntity implements Serializable {
	
	
	private String diaChi;
	
	

	private DichVu dichVus;
	

	private BacCongViec bacCongViecs;
	

	private BacCongViec vitriCongViecs;
	
}
