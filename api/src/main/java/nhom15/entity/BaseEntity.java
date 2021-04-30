package nhom15.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maNV;
	private String CMT;
	private String tenNV;
	private Date ngaysinh;
	private long sodienthoai;
}
