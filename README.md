# Bad Code - Relat�rio

## Primeiro momento
Possu�mos uma impress�o do relat�rio de pessoas e alguns ajustes foram detectados
nesse primeiro momento para atender algumas demandas dos nossos cliente. 
Abaixo foram listados o cen�rios de melhoria da nossa impress�o do Relat�rio de Pessoas.

* **Cen�rio 1: Corrigir erro na impress�o do relat�rio de pessoas. Est� aparecendo "ll"**<br>
Dado que seja realizado uma impress�o de relat�rio<br> 
Quando o relat�rio for impresso<br>
Ent�o n�o deve aparecer 'll'<br>

* **Cen�rio 2: Telefone com menos de 10 d�gitos**<br>
Dado que seja realizado uma impress�o de relat�rio <br>
 E a pessoa tenha telefone celular<br> 
Quando for imprimir os dados da pessoa<br> 
 E o n�meros de d�gitos do telefone � diferente de 10 d�gitos<br>
Ent�o deve dar a mensagem "Telefone invalido!"<br>
 E n�o deve imprimir a pessoa no relat�rio<br>

* **Cen�rio 3: Telefone com 10 d�gitos**<br>
Dado que seja realizado uma impress�o de relat�rio <br>
 E a pessoa tenha telefone celular<br> 
Quando for imprimir os dados da pessoa<br> 
 E o telefone tem 10 d�gitos<br>
Ent�o deve ser poss�vel imprimir a pessoa no relat�rio<br>
 
* **Cen�rio 4: Introduzir valida��o a CPF invalido**<br>
Dado que seja realizado uma impress�o de relat�rio<br>
 E a pessoa tenha um CPF<br>
Quando for imprimir os dados da pessoa <br>
 E o CPF � invalido<br>
Ent�o deve dar a mensagem "CPF invalido!"<br>
 E n�o deve imprimir a pessoa no relat�rio<br>
 
* **Cen�rio 5: Introduzir valida��o a CPF valido**<br>
Dado que seja realizado uma impress�o de relat�rio<br>
 E a pessoa tenha um CPF<br>
Quando for imprimir os dados da pessoa <br>
 E o CPF � valido<br>
Ent�o deve ser poss�vel imprimir a pessoa no relat�rio<br>

* **Cen�rio 6: Formato de impress�o**<br> 
Dado que seja realizado uma impress�o de relat�rio<br> 
 E a pessoa tenha telefone celular valido<br>
 E a pessoa tenha um CPF valido<br>
Quando for imprimir os dados da pessoa <br>
Ent�o o formado de impress�o deve ser:<br>
*Nome: Fulano da Silva<br>
Fone: XXXXXXXXX<br>
CPF: XXXXXXXXXXX<br>*

## Segundo momento
* Com base nas necessidades e regras de neg�cio existentes, reeescreva do zero a aplica��o
* Cadastrar Pessoas com as seguintes informa��es (nome, sobrenome, telefone residencial, telefone celular, cpf)
* Validar as seguintes informa��es (CPF - telefone celular com m�nimo de 10 digitos, nome)
* Utilize um timebox para realizar o exerc�cio (Ex.: 3 horas) e avalie o que consegues desenvolver.