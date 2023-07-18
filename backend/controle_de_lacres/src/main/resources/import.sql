INSERT INTO tb_user (nome, registro, password, cargo_Enum ) VALUES ('Thiago Barbosa', '11741', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 0);
INSERT INTO tb_user (nome, registro, password, cargo_Enum) VALUES ('Rita', '00001', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 1);
INSERT INTO tb_user (nome, registro, password, cargo_Enum) VALUES ('Deivisson', '00002', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG',2);
INSERT INTO tb_user (nome, registro, password, cargo_Enum) VALUES ('Xavier', '00003', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 3);
INSERT INTO tb_user (nome, registro, password, cargo_Enum) VALUES ('Ivan', '00004', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 4);


INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_APOIO');
INSERT INTO tb_role (authority) VALUES ('ROLE_SUPERVISOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_LIDER');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPP');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 4);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 5);