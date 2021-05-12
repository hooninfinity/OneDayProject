package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.persistence.DBContract;
import com.com.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService{

	protected Connection dbConn;
	public FoodServiceImplV1() {
		// TODO 데이터 연결
		dbConn = DBContract.getDBConnection();
	}
	
	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException{
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setMy_seq(rStr.getInt("섭취번호"));
			foodDTO.setMy_date(rStr.getString("날짜"));
			foodDTO.setFd_fcode(rStr.getString("식품코드"));
			foodDTO.setMy_eat(rStr.getInt("섭취량"));
			foodDTO.setFd_name(rStr.getString("식품명"));
			foodDTO.setFd_year(rStr.getInt("출시연도"));
			foodDTO.setFd_ccode(rStr.getString("제조사코드"));
			foodDTO.setFd_tcode(rStr.getString("분류코드"));
			foodDTO.setFd_serving(rStr.getInt("1회제공량"));
			foodDTO.setFd_total(rStr.getInt("총내용량"));
			foodDTO.setFd_energy(rStr.getInt("에너지"));
			foodDTO.setFd_protein(rStr.getInt("단백질"));
			foodDTO.setFd_fat(rStr.getInt("지방"));
			foodDTO.setFd_carbo(rStr.getInt("탄수화물"));
			foodDTO.setFd_sugar(rStr.getInt("총당류"));
			foodList.add(foodDTO);
		}
		return foodList;
	}
	
	@Override
	public List<FoodDTO> selectAll() {
		// TODO 전체리스트
		String sql = " SELECT * FROM view_식품정보 ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> foodList = this.select(pStr);
			pStr.close();
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FoodDTO findById(Integer my_seq) {
		// TODO PK로 조회하기
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 섭취번호 = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setInt(1, my_seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public FoodDTO findByDate(String my_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodDTO> findByName(String fd_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodDTO> findByEat(Integer my_eat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(FoodVO foodVO) {
		// TODO 일일 가공식품 섭취정보
		String sql = " INSERT INTO tbl_myfoods ";
		sql += " (my_seq, my_date, my_fcode, my_eat) ";
		sql += " VALUES(seq_food.NEXTVAL, ?, ?, ?) ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, foodVO.getMy_date());
			pStr.setString(2, foodVO.getFd_fcode());
			pStr.setInt(3, foodVO.getMy_eat());
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(FoodVO foodVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String fd_fcode) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
