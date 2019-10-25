package com.bilikai.bootdb;

import com.bilikai.boot.accounts.entity.Accounts;
import com.bilikai.boot.accounts.mapper.AccountsMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class BootDbApplicationTests {
	@Autowired
	private AccountsMapper accountsMapper;

	@Test
	void contextLoads() {
		System.out.println(("----- selectAll method test ------"));
		List<Accounts> userList = accountsMapper.selectList(null);
		Assert.assertEquals(1, userList.size());
		userList.forEach(System.out::println);
	}


}
