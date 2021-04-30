package nhom15.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class CongTyDto {
	
	private long id;
	private String maSoThue;
	private String tencongty;
	private int soNhanVien;
	private Long vonDieuLe;
	private String linhVucHoatDong;
	private String diaChi;
	private long soDienThoai;
	private double DtMatbang;
	private double tongtien;
	private List<Long> listMadv;
	private List<Long> listMadvRemove;
	private List<Long> listMaNV;
	
	
	
	public boolean checkExist(List<Long> listMadv, long madv) {
		for (Long long1 : listMadv) {
			if (long1 == madv) {
				return false;
			}
		}
		return true;
	}
	
}
