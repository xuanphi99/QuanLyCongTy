package nhom15.dto;

import java.util.Date;

import lombok.Data;

@Data
public abstract class BaseEntity {
	

	private long maNV;
	private String CMT;
	private String tenNV;
	private Date ngaysinh;
	private long sodienthoai;
}
