-- Inserts Role
INSERT INTO security.role(id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO security.role(id, name) VALUES (2, 'ROLE_GESTOR');
INSERT INTO security.role(id, name) VALUES (3, 'ROLE_USER');
INSERT INTO security.role(id, name) VALUES (4, 'ROLE_LEITOR');

-- User
INSERT INTO security.user(id, username, email, password, role_id, enabled) VALUES (1, 'ADMIN', 'nalomysouza@gmail.com', '$2a$10$8/lyKSjKTbEKRBHkVfoIgud6hTUAc9aXzcMg39ImKobbnW4ZMOfK2', 1, true);

--  user_role
INSERT INTO security.user_role(user_id, role_id) VALUES (1, 1);

-- sequence tables security
SELECT setval('security.seq_user', COALESCE((SELECT MAX(id) + 1 FROM security.user), 1), false);
SELECT setval('security.seq_role', COALESCE((SELECT MAX(id) + 1 FROM security.role), 1), false);