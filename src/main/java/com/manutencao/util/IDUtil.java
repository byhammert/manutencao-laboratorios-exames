package com.manutencao.util;

import java.util.UUID;

public class IDUtil {
	
	public static String gerarID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
