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


-- Pragas 


-- Famílias
INSERT INTO familia (nome, caracteristicas)
VALUES ('Aphididae', 'Insectos pequenos, de corpo mole e geralmente de coloração verde, amarela ou preta. Possuem um aparelho sugador que utilizam para se alimentar da seiva das plantas.'),
       ('Lepidoptera', 'Insectos com corpo alongado e coberto por escamas ou pelos. Possuem quatro asas, que são membranosas e geralmente de coloração brilhante.'),
       ('Acari', 'Artrópodes de corpo pequeno e de forma oval ou redonda. Possuem quatro pares de patas e geralmente são de coloração avermelhada ou marrom.'),
       ('Coccus', 'Insectos pequenos, de corpo mole e coberto por uma camada cerosa. Possuem um aparelho sugador que utilizam para se alimentar da seiva das plantas.'),
       ('Gastropoda', 'Moluscos de corpo mole e alongado. Possuem uma concha externa, que pode ser ausente ou reduzida.');

-- Espécies
INSERT INTO especie (nome, caracteristicas, id_familia)
VALUES ('Pulgão-verde-do-feijoeiro', 'Pulgão de coloração verde claro, que se alimenta da seiva das folhas, caules e vagens do feijoeiro. Causa danos às plantas, provocando o amarelecimento e a queda das folhas.', 3),
       ('Lagarta-da-batata', 'Lagarta de coloração verde, que se alimenta das folhas e caules da batata. Causa danos às plantas, provocando o amarelecimento e a queda das folhas.', 4),
       ('Ácaro-rajado-do-algodão', 'Ácaro de coloração avermelhada, que se alimenta das folhas do algodão. Causa danos às plantas, provocando o amarelecimento e a queda das folhas.', 5),
       ('Conchonilha-branca-do-quisqualo', 'Conchonilha de coloração branca, que se alimenta das folhas e caules do quisqualo. Causa danos às plantas, provocando o amarelecimento e a queda das folhas.', 6),
       ('Lesma-do-tomateiro', 'Lesma de coloração marrom, que se alimenta das folhas, caules e frutos do tomateiro. Causa danos às plantas, provocando o amarelecimento e a queda das folhas.', 7);



INSERT INTO planta (nome , nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Alface', 'https://scfoods.fbitsstatic.net/img/p/alface-crespa-higienizada-250g-72022/258671.jpg?w=800&h=800&v=no-change&qs=ignore', '2023-10-20', 'Planta hortícola de folhas verdes e crocantes, rica em vitaminas e minerais.', 1, 1);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Brócolis', 'https://static.escolakids.uol.com.br/2019/04/brocolis.jpg', '2023-11-15', 'Planta hortícola rica em vitamina C e sulforafano, um composto bioativo com propriedades anticancerígenas.', 2, 2);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Cebola', 'https://media.istockphoto.com/id/513920379/pt/foto/l%C3%A2mpadas-de-cebola.jpg?s=612x612&w=0&k=20&c=AdQY9DJ1pGrCAEnVGVnNWm6EBcWFXKW2SWuPOPIfTdI=', '2023-08-10', 'Planta hortícola com sabor pungente e aroma característico, rica em vitamina A e enxofre.', 3, 3);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Morango', 'https://images.squarespace-cdn.com/content/v1/5b8edfa12714e508f756f481/1538676993194-2GX4EPL3XZ83FEFGA5GY/morango.jpg?format=1000w', '2023-05-20', 'Fruta vermelha suculenta e doce, rica em vitamina C e potássio.', 2, 4);

INSERT INTO planta (nome, nomeimagem, tempocolheita, descricao, id_tipo_solo, id_especie)
VALUES ('Tomate' , 'https://teravirt.s3-accelerate.amazonaws.com/uploads/sites/95/2021/06/TOMATE-ESPECIAL.jpg', '2023-10-30', 'Fruta vermelha versátil, rica em vitamina A e licopeno, um antioxidante com propriedades anticancerígenas.', 1, 5);

INSERT INTO Dica (nome, nomeImagem, descricao, id_planta)
VALUES ('Dica 1', 'https://marketingpoliticohoje.com.br/wp-content/uploads/2019/03/dicas-para-quem-esta%CC%81-comec%CC%A7ando-no-marketing-poli%CC%81tico.jpg', 'Dica de cuidado para sua planta.', 1);

INSERT INTO Dica (nome, nomeImagem, descricao, id_planta)
VALUES ('Dica 2', 'https://marketingpoliticohoje.com.br/wp-content/uploads/2019/03/dicas-para-quem-esta%CC%81-comec%CC%A7ando-no-marketing-poli%CC%81tico.jpg', 'Dica de adubação para sua planta.', 2);

INSERT INTO Dica (nome, nomeImagem, descricao, id_planta)
VALUES ('Dica 3', 'https://marketingpoliticohoje.com.br/wp-content/uploads/2019/03/dicas-para-quem-esta%CC%81-comec%CC%A7ando-no-marketing-poli%CC%81tico.jpg', 'Dica de como combater pragas e doenças em sua planta.', 3);

INSERT INTO Dica (nome, nomeImagem, descricao, id_planta)
VALUES ('Dica 4', 'https://marketingpoliticohoje.com.br/wp-content/uploads/2019/03/dicas-para-quem-esta%CC%81-comec%CC%A7ando-no-marketing-poli%CC%81tico.jpg', 'Dica de como fazer a poda correta de sua planta.', 4);

INSERT INTO Dica (nome, nomeImagem, descricao, id_planta)
VALUES ('Dica 5', 'https://marketingpoliticohoje.com.br/wp-content/uploads/2019/03/dicas-para-quem-esta%CC%81-comec%CC%A7ando-no-marketing-poli%CC%81tico.jpg', 'Dica de como transplantar sua planta.', 5);


INSERT INTO Praga (nome, nomeImagem, descricao, id_especie)
VALUES ('Pulgão', 'https://blog.aegro.com.br/wp-content/uploads/2020/05/combate-ao-pulgao.jpg',
 'O pulgão é um inseto pequeno, de corpo mole, que se alimenta da seiva das plantas. É uma praga importante na agricultura e na jardinagem, pois pode causar grandes danos às plantações.', 6);

INSERT INTO Praga (nome, nomeImagem, descricao, id_especie)
VALUES ('Lagarta', 'https://terramagna.com.br/wp-content/uploads/2022/08/Lagarta-verde-folha.jpg',
 'Lagartas são a forma larval de borboletas, mariposas e algumas espécies de besouros. Elas são uma praga importante na agricultura e na jardinagem, pois podem causar grandes danos às plantações.', 7);

INSERT INTO Praga (nome, nomeImagem, descricao, id_especie)
VALUES ('Ácaro', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Rust_Mite%2C_Aceria_anthocoptes.jpg/1200px-Rust_Mite%2C_Aceria_anthocoptes.jpg',
 'Ácaros são aracnídeos microscópicos que se alimentam da seiva das plantas. Eles são uma praga importante na agricultura e na jardinagem, pois podem causar grandes danos às plantações.', 8);

INSERT INTO Praga (nome, nomeImagem, descricao, id_especie)
VALUES ('Cochonilha', 'https://terramagna.com.br/wp-content/uploads/2022/05/praga-cochonilha-branca.png',
 'A cochonilha é um inseto sugador da ordem Hemiptera, que se alimenta da seiva das plantas. É uma praga importante na agricultura e na jardinagem, pois pode causar grandes danos às plantações.', 9);

INSERT INTO Praga (nome, nomeImagem, descricao, id_especie)
VALUES ('Lesma', 'https://meusbichos.com.br/wp-content/uploads/2022/02/COMBATE-84-1024x576.jpg',
 'Lesmas são moluscos gastrópodes terrestres que não possuem concha externa. Lesmas são animais de hábito noturno e se alimentam de uma grande variedade de plantas, incluindo hortaliças, frutas, verduras e plantas ornamentais.', 10);


INSERT INTO Video (nome, urlVideo, descricao)
VALUES ('Como Reregar Suas Plantas', 'https://www.youtube.com/embed/4aj5IDEJh_I', 'Neste vídeo, aprenda como regar corretamente suas plantas e manter suas folhas verdes e saudáveis.');

INSERT INTO Video (nome, urlVideo, descricao)
VALUES ('Como Adubar Suas Plantas', 'https://www.youtube.com/embed/4aj5IDEJh_I', 'Neste vídeo, descubra como escolher os adubos certos para suas plantas e como aplicá-los para um crescimento saudável.');

INSERT INTO Video (nome, urlVideo, descricao)
VALUES ('Como Combater Pragas e Doenças em Suas Plantas', 'https://www.youtube.com/embed/4aj5IDEJh_I', 'Neste vídeo, aprenda a identificar e combater pragas e doenças comuns que podem afetar suas plantas.');

INSERT INTO Video (nome, urlVideo, descricao)
VALUES ('Como Poda Corretamente Suas Plantas', 'https://www.youtube.com/embed/4aj5IDEJh_I', 'Neste vídeo, aprenda técnicas de poda adequadas para diferentes tipos de plantas, estimulando seu crescimento e mantendo-as bonitas.');

INSERT INTO Video (nome, urlVideo, descricao)
VALUES ('Como Transplantar Suas Plantas', 'https://www.youtube.com/embed/4aj5IDEJh_I', 'Neste vídeo, aprenda como transplantar suas plantas com segurança e sucesso, garantindo um ambiente propício para seu crescimento.');



INSERT INTO planta_praga (id_planta, id_praga)
VALUES (1,1);

INSERT INTO planta_praga (id_planta, id_praga)
VALUES (1,2);

INSERT INTO planta_praga (id_planta, id_praga)
VALUES (1,3);


INSERT INTO planta_praga (id_planta, id_praga)
VALUES (2,4);


INSERT INTO planta_praga (id_planta, id_praga)
VALUES (2,5);


INSERT INTO planta_praga (id_planta, id_praga)
VALUES (3,3);



INSERT INTO planta_praga (id_planta, id_praga)
VALUES (3,1);



INSERT INTO planta_praga (id_planta, id_praga)
VALUES (4,2);



INSERT INTO planta_praga (id_planta, id_praga)
VALUES (4,5);



INSERT INTO planta_praga (id_planta, id_praga)
VALUES (5,3);



INSERT INTO planta_praga (id_planta, id_praga)
VALUES (5,2);


INSERT INTO planta_praga (id_planta, id_praga)
VALUES (5,1);



INSERT INTO planta_praga (id_planta, id_praga)
VALUES (4,3);
