package com.minascafe.api;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest//Spring gerará um contexto de teste e não de aplicação de produção real
@ActiveProfiles("test")//Definindo o profile como sendo teste - para não tentar utilizar o MySql
class MinasCafeApplicationTests {

	@Test
	void contextLoads() {
	}

}
