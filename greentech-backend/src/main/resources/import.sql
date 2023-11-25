-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO familia (nome, caracteristicas)
VALUES ('Asteraceae', 'Folhas geralmente alternas, simples ou compostas, inteiriças, dentadas ou lobadas. Flores dispostas em capítulos, geralmente com lígulas externas e flósculos internos.');

INSERT INTO familia (nome, caracteristicas)
VALUES ('Brassicaceae', 'Folhas geralmente alternas, simples ou compostas. Flores dispostas em cachos ou racemos, com quatro pétalas e quatro sépalas.');


INSERT INTO tiposolo (nome, classificacao)
VALUES ('Argiloso', 3);

INSERT INTO tiposolo (nome, classificacao)
VALUES ('Arenoso', 2);

INSERT INTO tiposolo (nome, classificacao)
VALUES ('Textura média', 1);


INSERT INTO especie (nome, caracteristicas, id_familia)
VALUES ('Alface Crespa', 'Folhas verdes escuras e crespas, com sabor ligeiramente adocicado.', 1);

INSERT INTO especie (nome, caracteristicas, id_familia)
VALUES ('Brócolis Rapa', 'Florescências verdes e compactas, com sabor levemente amargo.', 2);

INSERT INTO especie (nome, caracteristicas, id_familia)
VALUES ('Cebola Branca', 'Bulbos brancos e esféricos, com sabor pungente.', 2);

INSERT INTO especie (nome, caracteristicas, id_familia)
VALUES ('Morango Paulista', 'Frutos vermelhos e suculentos, com sabor doce e levemente ácido.', 1);

INSERT INTO especie (nome, caracteristicas, id_familia)
VALUES ('Tomate Cereja', 'Frutos vermelhos e pequenos, com sabor doce e ácido.', 2);



INSERT INTO planta (nome , nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Alface', 'alface.jpg', '2023-10-20', 'Planta hortícola de folhas verdes e crocantes, rica em vitaminas e minerais.', 1, 1);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Brócolis', 'brocolis.jpg', '2023-11-15', 'Planta hortícola rica em vitamina C e sulforafano, um composto bioativo com propriedades anticancerígenas.', 2, 2);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Cebola', 'cebola.jpg', '2023-08-10', 'Planta hortícola com sabor pungente e aroma característico, rica em vitamina A e enxofre.', 3, 3);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Morango', 'morango.jpg', '2023-05-20', 'Fruta vermelha suculenta e doce, rica em vitamina C e potássio.', 2, 4);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Tomate' , 'tomate.jpg', '2023-10-30', 'Fruta vermelha versátil, rica em vitamina A e licopeno, um antioxidante com propriedades anticancerígenas.', 1, 5);