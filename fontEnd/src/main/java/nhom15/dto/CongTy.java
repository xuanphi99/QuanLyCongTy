package nhom15.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongTy  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double giaThueMB = 10;
	private long id;
	private String maSoThue;
	private String tencongty;
	private int soNhanVien;
	private Long vonDieuLe;
	private String linhVucHoatDong;
	private String diaChi;
	private long soDienThoai;
	private double DtMatbang;
	private Set<DichVuCongTy> dichVuCongTys;	
	private Set<NhanVienCongTy> nhanViens;
	private double tongtien;
	
	
	
//	@Override
//	public int compareTo(CongTy o) {
//		  if (this.getTongTien()<o.getTongTien()) {
//              return 1;
//          }
//          else if (this.getTongTien()>o.getTongTien()) {
//              return -1;
//          }
//          else {
//		return 0;
//		}
//	}
	
	//getDay
//	public static long getSumDay(String startdate) {
//		DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//		Date currentDate = new Date();
//		Date date1 = null;
//		Date date2 = null;
//		long getDaysDiff = 0;
//		try {
//			// String startDate = "2020-01-01";
//			String endDate = simpleDateFormat.format(currentDate);
//
//			date1 = simpleDateFormat.parse(startdate);
//			date2 = simpleDateFormat.parse(endDate);
//
//			long getDiff = date2.getTime() - date1.getTime();
//
//			getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
//
////			System.out.println(
////					"Differance between date " + startdate + " and " + endDate + " is " + getDaysDiff + " days.");
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		
//		}	
//		return getDaysDiff;
//	}
	
//	public long calc(CongTy congTy) {
//		long day =0;
//	Set<DichVuCongTy> set =	congTy.getDichVuCongTys();
//		for (DichVuCongTy item : set) {
//			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
//		 day =	getSumDay(dateFormat.format(item.getNgaydangkydv()));
//		
//		}
//		return day;
//	}
	
//	public double tinhTien(CongTy congTy) {
//		double tongTien =0;
//	Set<DichVuCongTy> setdDichVuCongTies =	congTy.getDichVuCongTys();
//		if (congTy.getSoNhanVien()<=10 && congTy.getDtMatbang()<=100) {
//	//		System.out.println("----TH1");
//			for (DichVuCongTy dichVuCongTy : setdDichVuCongTies) {
//				
//				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
//				String startdate = dateFormat.format(dichVuCongTy.getNgaydangkydv()); 
//				long soNgay = congTy.getSumDay(startdate);
//				tongTien+= dichVuCongTy.getDichVu().getDonGia()* soNgay ; 
//	//			System.out.println(" tong tien dv "+ dichVuCongTy.getId());
//			}
//			tongTien+= congTy.getDtMatbang() * congTy.getGiaThueMB();
//	//		System.out.println("them dtmb "+ tongTien);
//		}
//		else {
//	//		System.out.println("----TH2-----------");
//			
//			double PhanTrammb =( congTy.getDtMatbang() - 100)%10;
//			int phanTramNv = (congTy.getSoNhanVien() - 10)% 5;
//		double	giaMbTang = congTy.giaThueMB + congTy.giaThueMB* 0.05* PhanTrammb;
//			tongTien+= congTy.getDtMatbang() * giaMbTang;
//	//		System.out.println("them dtmb tang  "+giaMbTang +" tong dtmb "+ tongTien);
//			
//			for (DichVuCongTy dichVuCongTy : setdDichVuCongTies) {
//				
//				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
//				String startdate = dateFormat.format(dichVuCongTy.getNgaydangkydv()); 
//				long soNgay = congTy.getSumDay(startdate);
//			
//				
//			double	dongiaTang = dichVuCongTy.getDichVu().getDonGia()*0.05*phanTramNv + dichVuCongTy.getDichVu().getDonGia();
//				tongTien+= dongiaTang* soNgay ; 
//	//			System.out.println(" tong tien dv "+ dichVuCongTy.getId()+ " ngay "+ soNgay + " don gia dv "+dongiaTang* soNgay);
//			}
//		}
//		
//		
//		return tongTien;
//	}
//	
}
