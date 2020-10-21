# Relatorio-Receita-MEI
Software para preenchimento de relatório da receita bruta mensal de MEI

Preencher os campos com os dados de acordo com os campos pedidos.

Os campos obrigatórios são:
- Nome do empreendedor
- CNPJ
- Periodo de apuração, data de inicio e data final (não pode ser superior a 1 mês)
- Local e data de preenchimento

Campos de receita:
- Preencher apenas os valores relativos ao cadastrado no MEI.
- Para os campos não aplicaveis, substituir o valor "00,00" por "--". Assim o sistema ira desconsiderar esses campos ao calcular o valor total da receita mensal

Calcular a receita bruta mensal:
1 - Preencher os campos aplicaveis.
2 - Preencher os campos não aplicaveis com "--".
3 - Clicar em "Calcular". O software irá apontar o valor total da receita.
4 - Verificar se os valores estão corretos e cliar em "Gerar Relatório", definir: nome do arquivo, extensão e local onde será salvo o PDF gerado.

Recursos futuros:
- Validação completa das informações nos campos obrigatórios.
- Opção de impressão do arquivo gerado.
- Melhora na interface do usuario.
