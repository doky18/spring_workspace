package com.edu.springshop.model.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springshop.domain.Pimg;
import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.PimgException;
import com.edu.springshop.exception.ProductException;
import com.edu.springshop.exception.UploadException;
import com.edu.springshop.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService{
	
	//DAO 모델
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private PimgDAO pimgDAO;
	
	//FileManager 모델
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public Product select(int product_idx) {
		return productDAO.select(product_idx);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void regist(Product product, String dir) throws ProductException, UploadException, PimgException {
		//1. 상품저장(부모 Product)
		productDAO.insert(product);		//select-key에 의해 pk가 존재하게 됨
		
		//2. 파일저장----이 3개를 등록이라고 추상화 시킴 (컨트롤러를 위해서)
		fileManager.save(product, dir);
		
		List<Pimg> pImgList=product.getPimgList();
		
		//3. 이미지저장 
		/*MultipartFile[] photoList=product.getPhoto();
		for(MultipartFile photo : pImgList) {
			Pimg pimg = new Pimg();
			pimgDAO.insert(pimg);
		}*/
		for(Pimg pimg : pImgList) {
			pimgDAO.insert(pimg);
		}	
	}

	@Override
	public void update(Product product) {
		productDAO.update(product);
	}

	@Override
	public void delete(int product_idx) {
		productDAO.delete(product_idx);
	}
	
}