package com.eshop4j.web.enums;

import com.eshop4j.core.base.KeyValueEnum;

public enum AppTypeEnum implements KeyValueEnum{
	
	FORALL(0,"all"),
	CHANNEL(1,"channel"),
	INVESTOR(2,"investor");
	
	AppTypeEnum(int key,String value){
		this.key = key;
		this.value = value;
	}

	private int key;
	private String value;
	
	
	public int getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}

}
