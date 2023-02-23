package com.edu.springshop.model.product;

import java.util.List;

import com.edu.springshop.domain.Product;

public interface ProductService {
	public List selectAll();
	public Product select(int product_idx);
	public void regist(Product product, String dir); //db연동+file제어+메일발송+sms
	public void update(Product product);
	public void delete(int product_idx);
}





