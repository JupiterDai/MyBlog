package com.dyf.myblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dyf.myblog.common.AppContext;
import com.dyf.myblog.common.jpa.exec.JPAExecutor;
import com.dyf.myblog.entity.UserInfo;

@SpringBootTest
class MyBlogApplicationTests {

	@Test
	void contextLoads() {
		UserInfo userInfo = new UserInfo();
		userInfo.setPassword("654321");
		userInfo.setUsername("DYF2");
		AppContext context = new AppContext();
		context.setUserName("TEST");
		userInfo.createAuditValues(context);
		JPAExecutor.save(userInfo);
	}

}
