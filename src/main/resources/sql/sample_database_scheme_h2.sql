/* Drop Tables */

DROP TABLE ADDRESS;
DROP TABLE EMAIL;
DROP TABLE MEMBERSHIP;
DROP TABLE GRP;
DROP TABLE USR;




/* Create Tables */

-- 住所
CREATE TABLE ADDRESS
(
    -- ユーザID
    USER_ID bigint NOT NULL,
    -- 郵便番号
    ZIP_CODE varchar(8),
    -- 住所
    ADDRESS varchar,
    -- バージョン
    VER int,
    -- 最終更新日時
    LAST_UPDATED_AT timestamp,
    PRIMARY KEY (USER_ID)
);


-- メール
CREATE TABLE EMAIL
(
    -- ユーザID
    USER_ID bigint NOT NULL,
    -- メール番号
    EMAIL_NO bigint NOT NULL,
    -- メールアドレス
    EMAIL varchar,
    -- バージョン
    VER int,
    -- 最終更新日時
    LAST_UPDATED_AT timestamp,
    PRIMARY KEY (USER_ID, EMAIL_NO),
    UNIQUE (USER_ID, EMAIL_NO)
);


-- グループ
CREATE TABLE GRP
(
    -- グループID
    GROUP_ID bigint NOT NULL,
    -- グループ名
    GROUP_NAME varchar,
    -- バージョン
    VER int,
    -- 最終更新日時
    LAST_UPDATED_AT timestamp,
    PRIMARY KEY (GROUP_ID)
);


-- 所属
CREATE TABLE MEMBERSHIP
(
    -- ユーザID
    USER_ID bigint NOT NULL,
    -- グループID
    GROUP_ID bigint NOT NULL,
    -- バージョン
    VER int,
    -- 最終更新日時
    LAST_UPDATED_AT timestamp,
    PRIMARY KEY (USER_ID, GROUP_ID),
    UNIQUE (USER_ID, GROUP_ID)
);


-- ユーザ
CREATE TABLE USR
(
    -- ユーザID
    USER_ID bigint NOT NULL,
    -- 名前
    FIRST_NAME varchar,
    -- 苗字
    FAMILY_NAME varchar,
    -- ログインID
    LOGIN_ID varchar UNIQUE,
    -- ログイン中
    IS_LOGIN boolean,
    -- バージョン
    VER int,
    -- 最終更新日時
    LAST_UPDATED_AT timestamp,
    PRIMARY KEY (USER_ID)
);



/* Create Foreign Keys */

ALTER TABLE MEMBERSHIP
    ADD FOREIGN KEY (GROUP_ID)
        REFERENCES GRP (GROUP_ID)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
;


ALTER TABLE ADDRESS
    ADD FOREIGN KEY (USER_ID)
        REFERENCES USR (USER_ID)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
;


ALTER TABLE EMAIL
    ADD FOREIGN KEY (USER_ID)
        REFERENCES USR (USER_ID)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
;


ALTER TABLE MEMBERSHIP
    ADD FOREIGN KEY (USER_ID)
        REFERENCES USR (USER_ID)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
;