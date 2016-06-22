<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:nf="http://ifmt.edu.br/NotaFiscal"
				xmlns:ifmt="http://ifmt.edu.br">
	<xsl:template match="/nf:NotaFiscal">
	<html>
		<head>
			<title>NotaFiscal</title>
			<style>
				h3 {text-decoration:underline;}
				table {width:600px;}
				th {text-align:left;}
			</style>
		</head>
		<body>
			<h1 style="text-align:center;">Nota Fiscal</h1>
			<hr />
			<h3>Empresa</h3>
			<table>
				<tr>
					<th>CNPJ</th><th>Nome</th>
				</tr>
				<tr>
					<td><xsl:value-of select="nf:empresa/ifmt:cnpj" /></td><td><xsl:value-of select="nf:empresa/ifmt:nomeFantasia" /></td>
				</tr>
				<tr>
					<th>Razão Social</th>
				</tr>
				<tr>
					<td><xsl:value-of select="nf:empresa/ifmt:razaoSocial" /></td>
				</tr>
				<tr>
					<th>Rua</th>
				</tr>
				<tr>
					<td><xsl:value-of select="nf:empresa/ifmt:endereco/ifmt:rua" />, <xsl:value-of select="nf:empresa/ifmt:endereco/ifmt:numero" /></td>
				</tr>
				<tr>
					<th>CEP</th><th>Bairro</th><th>Cidade</th>
				</tr>
				<tr>
					<td><xsl:value-of select="nf:empresa/ifmt:endereco/ifmt:cidade" /></td><td><xsl:value-of select="nf:empresa/ifmt:endereco/ifmt:bairro" /></td><td><xsl:value-of select="nf:empresa/ifmt:endereco/ifmt:cidade" />-<xsl:value-of select="nf:empresa/ifmt:endereco/ifmt:uf" /></td>
				</tr>
			</table>

			<h3>Cliente</h3>
			<table>
				<tr>
					<th>CPF</th><th>Nome</th>
				</tr>
				<tr>
					<td><xsl:value-of select="nf:cliente/ifmt:cpf" /></td><td><xsl:value-of select="nf:cliente/ifmt:nome" /></td>
				</tr>
				<tr>
					<th>Rua</th>
				</tr>
				<tr>
					<td><xsl:value-of select="nf:cliente/ifmt:endereco/ifmt:rua" />, <xsl:value-of select="nf:cliente/ifmt:endereco/ifmt:numero" /></td>
				</tr>
				<tr>
					<th>CEP</th><th>Bairro</th><th>Cidade</th>
				</tr>
				<tr>
					<td><xsl:value-of select="nf:cliente/ifmt:endereco/ifmt:cidade" /></td><td><xsl:value-of select="nf:cliente/ifmt:endereco/ifmt:bairro" /></td><td><xsl:value-of select="nf:cliente/ifmt:endereco/ifmt:cidade" />-<xsl:value-of select="nf:cliente/ifmt:endereco/ifmt:uf" /></td>
				</tr>
			</table>
			
			<h3>Produtos</h3>
			
			<table>
				<tr>
					<th>Produto</th>
					<th style="text-align:center;">qtde</th>
					<th style="text-align:center;">Valor Unitário</th>
				</tr>
				<xsl:for-each select="nf:produtos/nf:produto">
				<tr>
					<td><xsl:value-of select="nf:nome" /></td>
					<td style="text-align:center;"><xsl:value-of select="nf:qtde" /></td>
					<td style="text-align:center;"><xsl:value-of select="nf:valorUnitario" /></td>
				</tr>
				</xsl:for-each>
			</table>
		</body>
	</html>
	</xsl:template>
</xsl:stylesheet>