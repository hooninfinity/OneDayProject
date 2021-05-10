package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//INSERT와 UPDATE를 수행할때 사용할

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {
	
	private Integer my_seq;
	private String my_date;
	private String fd_fcode;
	private Integer my_eat;

}
