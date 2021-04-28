package br.com.garbo.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;

import br.com.garbo.enumerations.Niveis;

public final class Utils {
	
	public static String verificarMD5(String texto) {		
		try {
	       MessageDigest m = MessageDigest.getInstance("MD5");
	       m.update(texto.getBytes(),0,texto.length());	       
	       return new BigInteger(1,m.digest()).toString(16);
		}catch(Exception e) {
			return null;
		}
	}
	
	public static Niveis buscarNivel(String nivel) {
		Niveis n = null;
		
		switch (nivel) {
		case "ADM":
			n = Niveis.ADM;
			break;
		case "CLIENTE":
			n = Niveis.CLIENTE;
			break;			
		case "PREST":
			n = Niveis.PREST;
			break;					
		}
		
		return n;
	}
}
