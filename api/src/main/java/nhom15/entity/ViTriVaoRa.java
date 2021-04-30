package nhom15.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vitrivaora")
public class ViTriVaoRa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maVT;
	private String tenVT ;
	
	@OneToMany(mappedBy = "viTriVaoRa", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@JsonIgnoreProperties({"viTriVaoRa"})
	private Set<ChiTietVaoRa> chiTietVaoRas;
	
}
