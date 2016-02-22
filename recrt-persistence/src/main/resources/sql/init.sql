DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS app_user_role;
DROP TABLE IF EXISTS bank_account;

CREATE TABLE app_user (
	id BIGINT PRIMARY KEY AUTO_INCREMENT ,
  email VARCHAR(64) NOT NULL,
  username VARCHAR(32) NOT NULL,
  password VARCHAR(32) NOT NULL
);

CREATE TABLE app_user_role (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	app_user_id BIGINT NOT NULL REFERENCES app_user,
	name VARCHAR(32)
);

CREATE TABLE bank_account (
  	iban VARCHAR(34) PRIMARY KEY,
  	bic VARCHAR(11) NOT NULL,
    app_user_id BIGINT NOT NULL REFERENCES app_user
);


INSERT INTO app_user VALUES (null, 'user1@smava.de', 'user1', '1111');
INSERT INTO app_user VALUES (null, 'user2@smava.de', 'user2', '2222');
INSERT INTO app_user VALUES (null, 'user3@smava.de', 'user3', '3333');

INSERT INTO app_user_role VALUES (null, (SELECT id FROM app_user WHERE username='user1'), 'ROLE_USER');
INSERT INTO app_user_role VALUES (null, (SELECT id FROM app_user WHERE username='user2'), 'ROLE_USER');
INSERT INTO app_user_role VALUES (null, (SELECT id FROM app_user WHERE username='user3'), 'ROLE_USER');

INSERT INTO bank_account VALUES ('TESTIBAN0', 'TESTBIC0', (SELECT id FROM app_user WHERE username='user2'));