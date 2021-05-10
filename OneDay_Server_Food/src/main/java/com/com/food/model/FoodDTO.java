package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 식품코드	가변문자열	fd_fcode	VARCHAR2(10)		PRIMARY KEY
	식품명	한글가변문자열	fd_name	NVARCHAR2(125)	NOT NULL	
	출시연도	숫자형	fd_year	NUMBER	NOT NULL	
	제조사코드	가변문자열	fd_ccode	VARCHAR2(10)	NOT NULL	
	분류코드	가변문자열	fd_tcode	VARCHAR2(10)	NOT NULL	
	1회제공량	숫자형	fd_serving	NUMBER		
	총내용량(g)	숫자형	fd_total	NUMBER		
	에너지(㎉)	숫자형	fd_energy	NUMBER		
	단백질(g)	숫자형	fd_protein	NUMBER		
	지방(g)	숫자형	fd_fat	NUMBER		
	탄수화물(g)	숫자형	fd_carbo	NUMBER		
	총당류(g)	숫자형	fd_sugar	NUMBER		
	
	조회할때(SELECT) Service 각 method가 return할 type
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

	private Integer my_seq = 0;
	private String my_date;
	private String fd_fcode;
	private Integer my_eat = 0;
	private String fd_name;
	private Integer fd_year = 0;
	private String fd_ccode;
	private String fd_tcode;
	private Integer fd_serving = 0;
	private Integer fd_total = 0;
	private Integer fd_energy = 0;
	private Integer fd_protein = 0;
	private Integer fd_fat = 0;
	private Integer fd_carbo = 0;
	private Integer fd_sugar = 0;
	
	
	

	
}
