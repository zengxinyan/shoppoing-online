/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/10 16:20:48                           */
/*==============================================================*/
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists admin;

drop table if exists cart;

drop table if exists cart_goods;

drop table if exists goods;

drop table if exists message;

drop table if exists ordered;

drop table if exists order_goods;

drop table if exists user;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   id                   int not null AUTO_INCREMENT,
   loginname            varchar(50) not null,
   password             varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: cart                                                  */
/*==============================================================*/
create table cart
(
   id                   int not null AUTO_INCREMENT,
   user_id              int,
   quantity             int,
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
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   id                   int not null AUTO_INCREMENT,
   name                 varchar(50),
   price                decimal(10,2),
   description          varchar(100),
   category             varchar(50),
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
   id                   int not null AUTO_INCREMENT,
   user_id              int,
   msg                  varchar(1000),
   primary key (id)
);

/*==============================================================*/
/* Table: "ordered"                                               */
/*==============================================================*/
create table ordered
(
   id                   int not null AUTO_INCREMENT,
   user_id              int,
   quantity             int,
   money                decimal(10,2),
   address              varchar(100),
   status               varchar(50),
   orderDate            timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: order_goods                                           */
/*==============================================================*/
create table order_goods
(
   order_id             int not null,
   goods_id             int not null,
   quantity             int,
   primary key (order_id, goods_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null AUTO_INCREMENT,
   cart_id              int,
   message_id           int,
   loginname            varchar(50) not null,
   password             varchar(50) not null,
   name                 varchar(50),
   email                varchar(50),
   phone                varchar(50),
   picture              varchar(100),
   birthday             date,
   sex                  varchar(10),
   primary key (id)
);

alter table cart add constraint FK_Relationship_2 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table cart_goods add constraint FK_Relationship_6 foreign key (cart_id)
      references cart (id) on delete restrict on update restrict;

alter table cart_goods add constraint FK_Relationship_7 foreign key (goods_id)
      references goods (id) on delete restrict on update restrict;

alter table message add constraint FK_Relationship_8 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table ordered add constraint FK_Relationship_3 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table order_goods add constraint FK_Relationship_4 foreign key (order_id)
      references ordered (id) on delete restrict on update restrict;

alter table order_goods add constraint FK_Relationship_5 foreign key (goods_id)
      references goods (id) on delete restrict on update restrict;

alter table user add constraint FK_Relationship_1 foreign key (cart_id)
      references cart (id) on delete restrict on update restrict;

alter table user add constraint FK_Relationship_9 foreign key (message_id)
      references message (id) on delete restrict on update restrict;

SET FOREIGN_KEY_CHECKS = 1;

