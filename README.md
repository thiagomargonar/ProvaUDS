# ProvaUDS
Serviço de webservice para cadastro de pessoas físicas.

# Executando o projeto
Este projeto foi desenvolvido em maven, sendo assim, basta ser importado como um projeto existente do maven dentro do seu eclipse para que voce consiga visualizar/executar ou exportar o projeto.

# Pré requisitos
Banco de dados MySQL na versão community 5.6
JDK 8
tomcat8
postman


# endpoint
Metodo GET para listar pessoas fisícas.
http://localhost:8080/ProvaUDS/webService/pessoa/listaPessoasFisica
exemplo de json:
[
    {
        "id": 5,
        "nome": "Thiago Margonar",
        "email": "margonarbr@gmail.com",
        "telefone": "44 3026-1122",
        "cpf": "06762256910"
    },
    {
        "id": 6,
        "nome": "UDS",
        "email": "UDS@uds.com",
        "telefone": "123456",
        "cpf": "00000000000"
    }
]
-------------------------------------------------------------------------
Metodo GET para listar pessoa física por id
http://localhost:8080/ProvaUDS/webService/pessoa/pessoaFisica
exemplo de JSON
{
        "id": 5,
        "nome": "Thiago Margonar",
        "email": "margonarbr@gmail.com",
        "telefone": "44 3026-1122",
        "cpf": "06762256910"
}
-------------------------------------------------------------------------
Metodo POST para adicionar pessoa física
http://localhost:8080/ProvaUDS/webService/pessoa/adicionarPessoaFisica
exemplo de cadastro.
# key      # value
nome        Thiago
email       margonarbr@gmail.com
telefone    4444444444
cpf         00000000000
-------------------------------------------------------------------------
Metodo PUT para atualizar pessoa física
http://localhost:8080/ProvaUDS/webService/pessoa/atualizaPessoaFisica
exemplo de cadastro.
# key      # value
id          1
nome        Thiago margonar
email       thiago.margonar@hotmail.com
telefone    4444444444
cpf         00000000000

-------------------------------------------------------------------------
Metodo DELETE para excluir pessoa física
http://localhost:8080/ProvaUDS/webService/pessoa/removerPessoaFisica
exemplo de cadastro.
# key      # value
id          1
-------------------------------------------------------------------------

# Versão
1.0

# Autor
Thiago Henrique Fonseca Margonar

# License
Livre.
