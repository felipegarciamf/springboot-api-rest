INSERT INTO USUARIO(nome, sobrenome, cpf, rg, data_nascimento, email, telefone, celular, cnh, senha) VALUES('Sileira', 'Garcia', 40173586830, 49383012, '03/12/1989', 'teste@gmail.com', 11968613451, 199565959, '45645664', 'teste123');

INSERT INTO CURSO(nome, categoria) VALUES('Spring boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Html5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO SERVICO(nome_servico, icone_servico) VALUES ('Mecânico', 'icon ion-wrench');
INSERT INTO SERVICO(nome_servico, icone_servico) VALUES ('Eletricista', 'icon ion-flash');
INSERT INTO SERVICO(nome_servico, icone_servico) VALUES ('Chaveiro', 'icon ion-key');

INSERT INTO AUTOMOVEL(modelo, ano, marca, renavam, cor, placa) VALUES ('ONIX LTZ', 2018, 'CHEVROLET', 46516156, 'PRETO', 'FFE-0021');