package dao.pojo;

public class Equip {

	private Integer equipId;
	
	private String equipName;
	
	private Integer equipNum;

	@Override
	public String toString() {
		return "Equip [equipId=" + equipId + ", equipName=" + equipName + ", equipNum=" + equipNum + "]";
	}

	public Equip() {
		super();
	}

	public Equip(Integer equipId, String equipName, Integer equipNum) {
		super();
		this.equipId = equipId;
		this.equipName = equipName;
		this.equipNum = equipNum;
	}

	public Integer getEquipId() {
		return equipId;
	}

	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public Integer getEquipNum() {
		return equipNum;
	}

	public void setEquipNum(Integer equipNum) {
		this.equipNum = equipNum;
	}
	
}
