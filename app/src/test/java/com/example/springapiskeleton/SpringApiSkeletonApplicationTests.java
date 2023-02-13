package com.example.springapiskeleton;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringApiSkeletonApplicationTests {

	@Autowired
	private SpringApiSkeletonApplication  app;

	@Test
	void contextLoads() {
		assertNotNull(app);
	}

}
