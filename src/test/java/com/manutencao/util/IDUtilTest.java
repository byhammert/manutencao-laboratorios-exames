package com.manutencao.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IDUtilTest {
	
	@Test
	public void deve_gerar_ids_diferentes() {
		final String id1 = IDUtil.gerarID();
		final String id2 = IDUtil.gerarID();
		
		System.out.println(id1);
		
		assertThat(id1).isNotNull().isNotEmpty();
		assertThat(id2).isNotNull().isNotEmpty();
		assertThat(id1).isNotEqualTo(id2);
	}
	
	@Test
	public void nao_deve_conter_hifen() {
		final String id = IDUtil.gerarID();
		assertThat(id).isNotNull().isNotEmpty();
		assertThat(id).doesNotContain("-");
	}

}
