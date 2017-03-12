-- auto Generated on 2017-03-10 08:29:45 
-- DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `age` INT (11) NOT NULL DEFAULT -1 COMMENT 'age',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user`';

INSERT INTO `user` (name, age) VALUES ('test' , 1);
