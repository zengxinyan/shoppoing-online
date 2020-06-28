/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/10 16:20:48                           */
/*==============================================================*/

mysql -uroot -proot

drop database if exists springboot_demo; -- 数据库名不能用中划线-
create database springboot_demo;
use springboot_demo;

SET FOREIGN_KEY_CHECKS = 0;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/11 18:12:38                           */
/*==============================================================*/


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/12 10:33:35                           */
/*==============================================================*/


drop table if exists admin;

drop table if exists cart;

drop table if exists cart_goods;

drop table if exists category;

drop table if exists goods;

drop table if exists message;

drop table if exists ordered;

drop table if exists ordered_goods;

drop table if exists receive;

drop table if exists user;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
    id                   int not null auto_increment,
    loginname            varchar(50) not null,
    password             varchar(50) not null,
    primary key (id)
);

/*==============================================================*/
/* Table: cart                                                  */
/*==============================================================*/
create table cart
(
    id                   int not null auto_increment,
    user_id              int,
    quantity             int,
    total                decimal(10,2),
    primary key (id)
);

/*==============================================================*/
/* Table: cart_goods                                            */
/*==============================================================*/
create table cart_goods
(
    cart_id              int not null,
    goods_id             int not null,
    quantity             int,
    primary key (cart_id, goods_id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
    id                   int not null auto_increment,
    name                 varchar(50),
    description          varchar(100),
    primary key (id)
);

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
    id                   int not null auto_increment,
    category_id          int,
    no                   numeric(20,0),
    name                 varchar(50),
    price                decimal(10,2),
    disprice                decimal(10,2),
    description          varchar(100),
    image                varchar(100),
    onsale               int,
    sold                 int,
    isHot                bool,
    isDiscount           bool,
    primary key (id)
);

/*==============================================================*/
/* Table: message                                               */
/*==============================================================*/
create table message
(
    id                   int not null auto_increment,
    msg                  varchar(1000),
    date                 date,
    primary key (id)
);

/*==============================================================*/
/* Table: ordered                                               */
/*==============================================================*/
create table ordered
(
    id                   int not null auto_increment,
    user_id              int,
    receive_id           int,
    no                   numeric(20,0),
    total                decimal(10,2),
    status               varchar(50),
    orderDate            timestamp,
    primary key (id)
);

/*==============================================================*/
/* Table: ordered_goods                                         */
/*==============================================================*/
create table ordered_goods
(
    ordered_id           int not null,
    goods_id             int not null,
    quantity             int,
    primary key (ordered_id, goods_id)
);

/*==============================================================*/
/* Table: receive                                               */
/*==============================================================*/
create table receive
(
    id                   int not null auto_increment,
    user_id              int,
    ordered_id           int,
    name                 varchar(50),
    phone                varchar(50),
    address              varchar(100),
    primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
    id                   int not null auto_increment,
    cart_id              int,
    loginname            varchar(50) not null,
    password             varchar(50) not null,
    name                 varchar(50),
    sex                  varchar(10),
    birthday             date,
    email                varchar(50),
    phone                varchar(50),
    image                varchar(100),
    secret               varchar(100),
    answer               varchar(100),
    primary key (id)
);

alter table cart add constraint FK_Relationship_2 foreign key (user_id)
    references user (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table cart_goods add constraint FK_Relationship_6 foreign key (cart_id)
    references cart (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table cart_goods add constraint FK_Relationship_7 foreign key (goods_id)
    references goods (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table goods add constraint FK_Relationship_11 foreign key (category_id)
    references category (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table ordered add constraint FK_Relationship_3 foreign key (user_id)
    references user (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table ordered add constraint FK_Relationship_9 foreign key (receive_id)
    references receive (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table ordered_goods add constraint FK_Relationship_4 foreign key (ordered_id)
    references ordered (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table ordered_goods add constraint FK_Relationship_5 foreign key (goods_id)
    references goods (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table receive add constraint FK_Relationship_10 foreign key (ordered_id)
    references ordered (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table receive add constraint FK_Relationship_8 foreign key (user_id)
    references user (id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user add constraint FK_Relationship_1 foreign key (cart_id)
    references cart (id) ON DELETE CASCADE ON UPDATE CASCADE;

SET FOREIGN_KEY_CHECKS = 1;

