INSERT INTO PERMISSIONS(id, permission_name, description) VALUES(1, '*', 'Wildcard permission');
INSERT INTO PERMISSIONS(id, permission_name, description) VALUES(2, 'lightsaber:*', 'Everything with a lightsaber');
INSERT INTO PERMISSIONS(id, permission_name, description) VALUES(3, 'winnebago:drive:eagle5', 'allowed to drive the winnebago with plate eagle5');

INSERT INTO USERS (id, user_name, password, logged_in) VALUES(1, 'root', 'secret', 0);
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(2, 'guest', 'guest', 0);
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(3, 'presidentskroob', '12345', 0);
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(4, 'darkhelmet', 'ludicrousspeed',0 );
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(5, 'lonestarr', 'vespa', 0);

INSERT INTO ROLES (id, role_name, description) VALUES(1, 'admin', 'role has all permissions, indicated by the wildcard "*"');
INSERT INTO ROLES (id, role_name, description) VALUES(2, 'schwartz', 'The "schwartz" role can do anything (*) with any lightsaber');
INSERT INTO ROLES (id, role_name, description) VALUES(3, 'goodguy', 'The "goodguy" role is allowed to "drive" (action) the winnebago (type) with license plate "eagle5" (instance specific id)');

INSERT INTO USERS_ROLES (user_id, role_id) VALUES(1, 1);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES(4, 2);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES(5, 2);
INSERT INTO USERS_ROLES (user_id, role_id) VALUES(5, 3);

INSERT INTO ROLES_PERMISSIONS(role_id, permission_id) VALUES(1, 1);
INSERT INTO ROLES_PERMISSIONS(role_id, permission_id) VALUES(2, 2);
INSERT INTO ROLES_PERMISSIONS(role_id, permission_id) VALUES(3, 3);
