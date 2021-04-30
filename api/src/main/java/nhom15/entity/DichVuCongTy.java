package nhom15.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "congtydichvu")
@Data
public class DichVuCongTy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "congty_id")
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	@JsonIgnoreProperties("dichVuCongTys")
    CongTy congTy;

    @ManyToOne
    @JoinColumn(name = "dichvu_id")
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	@JsonIgnoreProperties({"dichVuCongTys"})
    DichVu dichVu;
    
    @Column(name = "ngaydangkydv" )
    
     Date ngaydangkydv;

}
