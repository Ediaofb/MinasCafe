package com.minascafe.api.repositories;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")//ativando um profile do tipo 'Teste'

public class Cafe_BaixadoRepositoryTest {

	private Cafe_BaixadoRepository cafe_BaixadoRepository;
}