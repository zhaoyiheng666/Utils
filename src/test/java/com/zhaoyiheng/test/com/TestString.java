package com.zhaoyiheng.test.com;

import org.junit.Test;

import com.zhaoyiheng.utils.StringUtils;


public class TestString {
	
	@Test
	public void testGetPercent(){
		int a = 1;
		int b = 3;
		String c = StringUtils.getPercent(a, b);
		System.out.println("百分比为："+c+"%");
	}

}
