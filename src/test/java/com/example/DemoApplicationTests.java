package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Value("${author.realName}")
	private String realName;
	@Value("${author.nickName}")
	private String nickName;

	@Test
	public void contextLoads() {
		System.out.println("real_name : " + realName);
		System.out.println("nick_name : " + nickName);
	}

}
