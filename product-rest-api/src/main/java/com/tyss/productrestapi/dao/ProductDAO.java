package com.tyss.productrestapi.dao;

import java.util.List;

import com.tyss.productrestapi.dto.ProductInfoBean;

public interface ProductDAO {
	public boolean addProduct(ProductInfoBean bean);
	public boolean removeProduct(int id);
	public boolean updateProduct(ProductInfoBean bean);
	public List<ProductInfoBean> getProductByName(String name);
	public List<ProductInfoBean> getAllProduct();
	
}
