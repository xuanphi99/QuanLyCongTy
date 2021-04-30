package nhom15.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DichVuCongTy {

    Long id;
    CongTy congTy;
    DichVu dichVu;
    Date ngaydangkydv;

   
}
