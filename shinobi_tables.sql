CREATE TABLE PERMISSIONS 
(
    id INTEGER NOT NULL,
    permission_name VARCHAR(30) NOT NULL, 
    description VARCHAR(255), 
    PRIMARY KEY (id)
);

CREATE TABLE ROLES 
(
    id INTEGER NOT NULL,
    role_name VARCHAR(20) NOT NULL, 
    description VARCHAR(255), 
    PRIMARY KEY (id)
);

CREATE TABLE ROLES_PERMISSIONS 
(
    role_id INTEGER NOT NULL, 
    permission_id INTEGER NOT NULL
);

CREATE TABLE USERS 
(
    id INTEGER NOT NULL,
    user_name VARCHAR(255) NOT NULL, 
    password VARCHAR(255) NOT NULL, 
    PRIMARY KEY (id)
);

CREATE TABLE USERS_ROLES 
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL
);

ALTER TABLE ROLES_PERMISSIONS add constraint RP_1 foreign key (role_id) references ROLES (id);
ALTER TABLE ROLES_PERMISSIONS add constraint RP_2 foreign key (permission_id) references PERMISSIONS (id);
ALTER TABLE USERS_ROLES add constraint UR_1 foreign key (user_id) references USERS (id);
ALTER TABLE USERS_ROLES add constraint UR_2 foreign key (role_id) references ROLES (id);