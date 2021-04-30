package nhom15.DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class CongtyPage   {
	private int page;
	private int totalPage;
	private List<CongTyDto> lists;
	
	
}
