package nhom15.dto;

import java.util.List;

import lombok.Data;

@Data
public class CongtyPage {
	private int page;
	private int totalPage;
	private List<CongTy> lists;
}
