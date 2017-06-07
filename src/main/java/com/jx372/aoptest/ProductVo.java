package com.jx372.aoptest;

public class ProductVo {
	private String name;
	
	public ProductVo(String name){
		this.name = name ;
	}
	
	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductVo [name=" + name + "]";
	}
	
}
