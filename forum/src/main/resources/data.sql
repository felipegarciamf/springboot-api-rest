INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'alunoe@email.com', '123456');

INSERT INTO CURSO(nome, categoria) VALUES('Spring boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Html5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 20:33', 'NAO_RESPONDIDO', 1, 1);

INSERT INTO SERVICO(nome_servico) VALUES ('Mecânico');
INSERT INTO SERVICO(nome_servico) VALUES ('Eletricista');
INSERT INTO SERVICO(nome_servico) VALUES ('Cabelereiro');