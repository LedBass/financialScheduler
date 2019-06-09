package com.marcio.financialScheduler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinancialSchedulerApplicationTests {

	@Test
	void contextLoads() {
		FinancialSchedulerApplication.main(new String[] {
				"--spring.main.web-environment=false",
				"--spring.main.web-environment=true"
		});
	}

}
