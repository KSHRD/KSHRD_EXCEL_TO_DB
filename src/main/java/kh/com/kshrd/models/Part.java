package kh.com.kshrd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parts")
public class Part implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="part_id")
	private Long id;
	private String no;
	private String partNo;
	private String koreanDescription;
	private String englishDescription;
	private String quantity;
	private String remarks;
	private String code;
	@Column(name="model_id")
	private Long modelId;
	
	public Part(String no, String partNo, String koreanDescription, String englishDescription, String quantity,
			String remarks, String code, Long modelId) {
		super();
		this.no = no;
		this.partNo = partNo;
		this.koreanDescription = koreanDescription;
		this.englishDescription = englishDescription;
		this.quantity = quantity;
		this.remarks = remarks;
		this.code = code;
		this.modelId = modelId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getKoreanDescription() {
		return koreanDescription;
	}

	public void setKoreanDescription(String koreanDescription) {
		this.koreanDescription = koreanDescription;
	}

	public String getEnglishDescription() {
		return englishDescription;
	}

	public void setEnglishDescription(String englishDescription) {
		this.englishDescription = englishDescription;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	
}
