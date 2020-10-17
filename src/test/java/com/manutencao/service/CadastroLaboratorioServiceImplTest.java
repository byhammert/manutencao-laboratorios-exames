package com.manutencao.service;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class CadastroLaboratorioServiceImplTest {
	
	@Test
	public void test_UUID() {
		final String uuid = UUID.randomUUID().toString().replace("-", "");
	    System.out.println("uuid = " + uuid);
	}

}
