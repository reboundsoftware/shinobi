INSERT INTO PERMISSIONS(id, permission_name, description) VALUES(1, '*', 'Wildcard permission');
INSERT INTO PERMISSIONS(id, permission_name, description) VALUES(2, 'lightsaber:*', 'Everything with a lightsaber');
INSERT INTO PERMISSIONS(id, permission_name, description) VALUES(3, 'winnebago:drive:eagle5', 'allowed to drive the winnebago with plate eagle5');

INSERT INTO USERS (id, user_name, password, logged_in) VALUES(1, 'root', '$shiro1$SHA-256$500000$grF8m/snWFRHE1uvJ7gz3A==$N1CZAcGCtDSG1BcQg/q+7t2VVYBMecFjlQ4bGSw6mnw=', 0); -- pw: secret
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(2, 'guest', '$shiro1$SHA-256$500000$IvAXNJEolpMvdMcgyLY+qw==$lxAyECA1QIKwB3w78ldRd5G8u8c5DLcVloI/0o2ZGBs=', 0); -- pw: guest
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(3, 'presidentskroob', '$shiro1$SHA-256$500000$NsedS0ahfxsrVzsHGUg/FA==$CFzhtL46/ycpdgvam45R11czGXEG4wuO/M0oRvNJqr0=', 0); -- pw: 12345
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(4, 'darkhelmet', '$shiro1$SHA-256$500000$WDco//DaNSl5nxG1MggKiA==$ARdh1aOHDJj4puJILeGSMUBaTpL6ey+SrU4fC74CxkE=', 0); -- pw: ludicrousspeed
INSERT INTO USERS (id, user_name, password, logged_in) VALUES(5, 'lonestarr', '$shiro1$SHA-256$500000$pA2XXipOtb+ylDzZ9LGaDw==$RADIqt6ZdmhXQlbzF9nYN6BpUarNV91Mwpt0BboCjCQ=', 0); -- pw: vespa

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
