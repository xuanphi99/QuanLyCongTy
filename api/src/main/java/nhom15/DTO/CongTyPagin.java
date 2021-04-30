package nhom15.DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nhom15.entity.CongTy;
import nhom15.entity.DichVuCongTy;
import nhom15.entity.NhanVienCongTy;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongTyPagin {
	private final double giaThueMB = 10;
	private long id;
	private String masothue;
	private String tencongty;
	private int sonhanvien;
	private Long vondieule;
	private String linhVucHoatDong;
	private String diaChi;
	private long soDienThoai;
	private double DtMatbang;
	private double tongtiendv;
	private Set<DichVuCongTy> dichVuCongTys;
	private Set<NhanVienCongTy> nhanViens = new HashSet<>();
	
	//getDay
		public static long getSumDay(String startdate) {
			DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			Date currentDate = new Date();
			Date date1 = null;
			Date date2 = null;
			long getDaysDiff = 0;
			try {
				// String startDate = "2020-01-01";
				String endDate = simpleDateFormat.format(currentDate);

				date1 = simpleDateFormat.parse(startdate);
				date2 = simpleDateFormat.parse(endDate);

				long getDiff = date2.getTime() - date1.getTime();

				getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

//				System.out.println(
//						"Differance between date " + startdate + " and " + endDate + " is " + getDaysDiff + " days.");
			} catch (Exception e) {
				e.printStackTrace();

			
			}	
			return getDaysDiff;
		}
	
	
		public double tinhTien(CongTyPagin congTy) {
			double tongTien =0;
		Set<DichVuCongTy> setdDichVuCongTies =	congTy.getDichVuCongTys();
			if (congTy.getSonhanvien()<=10 && congTy.getDtMatbang()<=100) {
		//		System.out.println("----TH1");
				for (DichVuCongTy dichVuCongTy : setdDichVuCongTies) {
					
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
					String startdate = dateFormat.format(dichVuCongTy.getNgaydangkydv()); 
					long soNgay = congTy.getSumDay(startdate);
					tongTien+= dichVuCongTy.getDichVu().getDonGia()* soNgay ; 
		//			System.out.println(" tong tien dv "+ dichVuCongTy.getId());
				}
				tongTien+= congTy.getDtMatbang() * congTy.getGiaThueMB();
		//		System.out.println("them dtmb "+ tongTien);
			}
			else {
		//		System.out.println("----TH2-----------");
				
				double PhanTrammb =( congTy.getDtMatbang() - 100)%10;
				int phanTramNv = (congTy.getSonhanvien() - 10)% 5;
			double	giaMbTang = congTy.giaThueMB + congTy.giaThueMB* 0.05* PhanTrammb;
				tongTien+= congTy.getDtMatbang() * giaMbTang;
		//		System.out.println("them dtmb tang  "+giaMbTang +" tong dtmb "+ tongTien);
				
				for (DichVuCongTy dichVuCongTy : setdDichVuCongTies) {
					
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
					String startdate = dateFormat.format(dichVuCongTy.getNgaydangkydv()); 
					long soNgay = congTy.getSumDay(startdate);
				
					
				double	dongiaTang = dichVuCongTy.getDichVu().getDonGia()*0.05*phanTramNv + dichVuCongTy.getDichVu().getDonGia();
					tongTien+= dongiaTang* soNgay ; 
		//			System.out.println(" tong tien dv "+ dichVuCongTy.getId()+ " ngay "+ soNgay + " don gia dv "+dongiaTang* soNgay);
				}
			}
			
			
			return tongTien;
		}
	
	
	
	
	
}
