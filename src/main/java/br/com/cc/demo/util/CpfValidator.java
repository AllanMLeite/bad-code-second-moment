package br.com.cc.demo.util;

import org.apache.commons.lang3.StringUtils;

public class CpfValidator {

	static public boolean isValidCpf(String cpf) {
		
		if(!StringUtils.isNumeric(cpf)) {
			return false;
		}
		
		int d1 = 0, d2 = 0;
		int digito1 = 0, digito2 = 0, resto = 0;
		int digitoCPF;
		String nDigResult;

		for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por
			// diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro digito
			// calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}

		// Primeiro resto da divisao por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito e 0 caso contrario o digito e 11 menos o
		// resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divisao por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito e 0 caso contrario o digito e 11 menos o
		// resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que esta sendo validado.
		String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
		return nDigVerific.equals(nDigResult);
	}

	public static void main(String[] args) {
		System.out.println(isValidCpf("04624193806"));
	}

}
