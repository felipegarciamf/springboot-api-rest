
INSERT INTO PERFIL(nome) VALUES ('usuario');
INSERT INTO PERFIL(nome) VALUES ('prestadorservico');

/* INSERT INTO SERVICO(nome_servico, icone_servico) VALUES ('Mecânico', 'icon ion-wrench'); */
INSERT INTO SERVICO(nome_servico, icone_servico) VALUES ('Eletricista', 'icon ion-flash');
/*INSERT INTO SERVICO(nome_servico, icone_servico) VALUES ('Chaveiro', 'icon ion-key'); */
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Silas', 'Garcia', 40173586830, 49383012, '03/12/1989', 'teste', 11968613451, 199565959, '45645664', 'teste123');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Silas', 'Garcia', 40173586830, 49383012, '03/12/1989', 'silas.garcia@faculdadeimpacta.com.br', 11968613451, 199565959, '45645664', 'teste123');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Vanderlei','Silva', 40173586830, 49383012, '03/12/1975', 'vanderlei.silva@faculdadeimpacta.com.br', 11968613451, 199565959, '45645664', 'teste123');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Motorista Doidão','Silva', 40173586830, 49383012, '03/12/1975', 'prestador@gmail.com', 11968613451, 1199565959, '45645664', 'teste123');
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES (1,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES (1,2);

/*
INSERT INTO PERFIL_SERVICO (perfil_id, servico_id) VALUES (2,2);
INSERT INTO PERFIL_SERVICO (perfil_id, servico_id) VALUES (2,3);
*/
INSERT INTO PERFIL_SERVICO (perfil_id, servico_id) VALUES (2,1);


INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Vanderlei', 'Silva', 40173586830, 49383012, '03/12/1989', 'teste@gmail.com', 11968613451, 199565959, '45645664', '$2a$10$AhQIn9jaavzlc/j3F4/CYu9iOp.Q9I/T8Voa0qJqMV/wXa28Speva');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Vanderlei', 'Silva', 40173586830, 49383012, '03/12/1989', 'teste3@gmail.com', 11968613451, 199565959, '45645664', '$2a$10$AhQIn9jaavzlc/j3F4/CYu9iOp.Q9I/T8Voa0qJqMV/wXa28Speva');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Vanderlei', 'Silva', 40173586830, 49383012, '03/12/1989', 'teste4@gmail.com', 11968613451, 199565959, '45645664', '$2a$10$AhQIn9jaavzlc/j3F4/CYu9iOp.Q9I/T8Voa0qJqMV/wXa28Speva');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Vanderlei', 'Silva', 40173586830, 49383012, '03/12/1989', 'teste5@gmail.com', 11968613451, 199565959, '45645664', '$2a$10$AhQIn9jaavzlc/j3F4/CYu9iOp.Q9I/T8Voa0qJqMV/wXa28Speva');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Vanderlei', 'Silva', 40173586830, 49383012, '03/12/1989', 'teste6@gmail.com', 11968613451, 199565959, '45645664', '$2a$10$AhQIn9jaavzlc/j3F4/CYu9iOp.Q9I/T8Voa0qJqMV/wXa28Speva');
INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Vanderlei', 'Silva', 40173586830, 49383012, '03/12/1989', 'teste7@gmail.com', 11968613451, 199565959, '45645664', '$2a$10$AhQIn9jaavzlc/j3F4/CYu9iOp.Q9I/T8Voa0qJqMV/wXa28Speva');


INSERT INTO CURSO(nome, categoria) VALUES('Spring boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Html5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 1);



INSERT INTO AUTOMOVEL(modelo, ano, marca, renavam, cor, placa) VALUES ('ONIX LTZ', 2018, 'CHEVROLET', 46516156, 'PRETO', 'FFE-0021');

INSERT INTO CHAMADO(descricao, cep, mensagem, data_criacao, status, valor, cliente_id) VALUES('CARRO QUEBRADO', '02013050', 'meu carroq quebrou', '2019-05-05 20:33', 'NAO_RESPONDIDO',200.0, 1);
/* INSERT INTO CHAMADO(descricao, cep, mensagem, data_criacao, status, valor, cliente_id) VALUES('Perdi Minha Chave', '02013050', 'meu carroq quebrou', '2019-05-05 20:33', 'NAO_RESPONDIDO',200.0, 1); */
INSERT INTO CHAMADO(descricao, cep, mensagem, data_criacao, status, valor, cliente_id) VALUES('Perdi Minha Chave', '02013050', 'meu carroq quebrou', '2019-05-05 20:33', 'NAO_RESPONDIDO',200.0, 2);
/* INSERT INTO CHAMADO(descricao, cep, mensagem, data_criacao, status, valor, cliente_id) VALUES('Perdi Minha Chave', '02013050', 'meu carroq quebrou', '2019-05-05 20:33', 'NAO_RESPONDIDO',150.0, 2); */

