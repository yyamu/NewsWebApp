DROP VIEW IF EXISTS v_user_role;
DROP TABLE IF EXISTS t_user_role;
DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_role;

CREATE TABLE t_user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(25) NOT NULL,
	password VARCHAR(25) NOT NULL
);

CREATE TABLE t_role (
	id INT AUTO_INCREMENT PRIMARY KEY,
	rolename VARCHAR(25) NOT NULL
);

CREATE TABLE t_user_role (
	id INT AUTO_INCREMENT PRIMARY KEY,
	userid INT NOT NULL,
	roleid INT NOT NULL,
	FOREIGN KEY (userid) REFERENCES t_user(id),
	FOREIGN KEY (roleid) REFERENCES t_role(id)
);

CREATE VIEW v_user_role AS
SELECT DISTINCT u.username, r.rolename
FROM t_user u INNER JOIN t_user_role ur ON u.id = ur.userid
              INNER JOIN t_role r ON ur.roleid = r.id;

INSERT INTO t_user (username, password) VALUES ('newsadmin', 'topsecret');
INSERT INTO t_user (username, password) VALUES ('newsuser', 'topsecret');

INSERT INTO t_role (rolename) VALUES ('NewsAdminRole');
INSERT INTO t_role (rolename) VALUES ('NewsUserRole');

INSERT INTO t_user_role (userid, roleid) VALUES (1, 1);
INSERT INTO t_user_role (userid, roleid) VALUES (2, 2);
