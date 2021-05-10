package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;

public interface FoodService {
	
	public List<FoodDTO> selectAll();
	
	public FoodDTO findById(Integer my_seq);
	public FoodDTO findByDate(String my_date);
	public List<FoodDTO> findByName(String fd_name);
	public List<FoodDTO> findByEat(Integer my_eat);
	
	public int insert(FoodVO foodVO);
	public int update(FoodVO foodVO);
	public int delete(String fd_fcode);

}
