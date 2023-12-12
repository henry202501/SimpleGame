package com.game;

public enum ControlWinlossEnum {
    WIN("0", "WIN"),
    LOSS("1", "LOSS");

    ControlWinlossEnum(String string, String string2) {
		
	}
	private String code;
    private String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
    
    
    
    
}
