package com.jx372.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVo find(String keyword) {
		System.out.println("finding()... ");

//		if (2 + 1 == 3) {
//			throw new RuntimeException("ProductSercie Exception occurs");
//		}
		return new ProductVo(keyword);
	}
}
