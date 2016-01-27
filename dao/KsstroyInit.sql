USE ksstroy;
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `ID`           INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `PROJECT_NAME` VARCHAR(64)      NOT NULL,
  `DESCRIPTION`  VARCHAR(512),
  `ID_GROUP`     INT(10) UNSIGNED
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (33, 'Cool Project', 'Very cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (34, 'Another Cool Project', 'Super cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (35, 'Not Cool Project', 'Not cool', '1');


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `NAME`     VARCHAR(64)      NOT NULL,
  `PASSWORD` VARCHAR(64)      NOT NULL,
  `ROLE`     VARCHAR(32)      NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `users` (`ID`, `NAME`, `PASSWORD`, `ROLE`) VALUES (1, 'admin', 'nimda', 'admin');


DROP TABLE IF EXISTS `user_project_rel`;
CREATE TABLE `user_project_rel` (
  `project` INT(10),
  `user`    INT(10)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `user_project_rel` (`project`, `user`) VALUES (33, 1);
INSERT INTO `user_project_rel` (`project`, `user`) VALUES (34, 1);


DROP TABLE IF EXISTS `zones`;
CREATE TABLE `zones` (
  `id`                   BIGINT(10)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`                 VARCHAR(50)     NOT NULL,
  `width`                DOUBLE UNSIGNED NOT NULL,
  `height`               DOUBLE UNSIGNED NOT NULL,
  `mesure_name`          VARCHAR(50)     NOT NULL,
  `parent_group_id`      INT(10) UNSIGNED,
  `surplus_for_zones_id` INT(10) UNSIGNED, #have value only if the zonegroup is surplus
  `addit_for_zones_id`   INT(10) UNSIGNED #have value only if the zonegroup is additional
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `zones` VALUES (1, 'pol1', 10.0, 10.0, 'M2', 4, NULL, NULL);
INSERT INTO `zones` VALUES (2, 'stenaA', 6.0, 3.0, 'M2', 5, NULL, NULL);
INSERT INTO `zones` VALUES (3, 'potolok', 10.0, 10.0, 'M2', 5, NULL, NULL);
INSERT INTO `zones` VALUES (4, 'stenaB', 7.0, 3.5, 'M2', 6, NULL, NULL);
INSERT INTO `zones` VALUES (5, 'otkosi1', 5.0, 5.0, 'M2', NULL, NULL, 1);
INSERT INTO `zones` VALUES (6, 'otkosi2', 3.0, 2.0, 'M2', NULL, NULL, 2);
INSERT INTO `zones` VALUES (7, 'pamyatnikLenina', 2.0, 2.0, 'M2', NULL, NULL, 3);
INSERT INTO `zones` VALUES (8, 'pamyatnikDartVeyderu', 10.0, 4.0, 'M2', NULL, NULL, 4);
INSERT INTO `zones` VALUES (9, 'dver1', 2.0, 1.0, 'M2', NULL, 1, NULL);
INSERT INTO `zones` VALUES (10, 'dver2', 3.0, 2.0, 'M2', NULL, 2, NULL);
INSERT INTO `zones` VALUES (11, 'okno1', 3.0, 1.25, 'M2', NULL, 3, NULL);
INSERT INTO `zones` VALUES (12, 'okno2', 2.0, 1.35, 'M2', NULL, 4, NULL);


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `group_id`  BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(50),
  `parent_id` BIGINT(20)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `groups` VALUES (1, 'Kvartira', NULL);
INSERT INTO `groups` VALUES (2, 'Penthaus', NULL);
INSERT INTO `groups` VALUES (3, 'Dacha', NULL);
INSERT INTO `groups` VALUES (4, 'Kuhnya', 1);
INSERT INTO `groups` VALUES (5, 'Spalnya', 1);
INSERT INTO `groups` VALUES (6, 'Tualet', 1);
INSERT INTO `groups` VALUES (7, 'Vannaya', 2);
INSERT INTO `groups` VALUES (8, 'Prihozhaya', 2);


DROP TABLE IF EXISTS `worktypes`;
CREATE TABLE `worktypes` (
  `worktype_id`     BIGINT(10)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`            VARCHAR(50),
  `description`     VARCHAR(512),
  `measure_name`    VARCHAR(50) NOT NULL,
  `unit_price`      DOUBLE,
  `parent_group_id` INT(10) UNSIGNED
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `worktypes` VALUES (1, 'worktype_1', 'worktype_1_descr.', 'L', 3.45, 2);
INSERT INTO `worktypes` VALUES (2, 'worktype_2', 'worktype_2_descr.', 'L', 3.45, 2);
INSERT INTO `worktypes` VALUES (3, 'worktype_3', 'worktype_3_descr.', 'L', 3.45, 3);
INSERT INTO `worktypes` VALUES (4, 'worktype_4', 'worktype_4_descr.', 'L', 3.45, 3);
INSERT INTO `worktypes` VALUES (5, 'worktype_5', 'worktype_5_descr.', 'L', 3.45, 4);
INSERT INTO `worktypes` VALUES (6, 'worktype_6', 'worktype_6_descr.', 'L', 3.45, 4);
INSERT INTO `worktypes` VALUES (7, 'worktype_7', 'worktype_7_descr.', 'L', 3.45, 5);
INSERT INTO `worktypes` VALUES (8, 'worktype_8', 'worktype_8_descr.', 'L', 3.45, 5);
INSERT INTO `worktypes` VALUES (9, 'worktype_9', 'worktype_9_descr.', 'L', 3.45, 6);
INSERT INTO `worktypes` VALUES (10, 'worktype_10', 'worktype_10_descr.', 'L', 3.45, 6);
INSERT INTO `worktypes` VALUES (11, 'worktype_11', 'worktype_11_descr.', 'L', 3.45, 7);
INSERT INTO `worktypes` VALUES (12, 'worktype_12', 'worktype_12_descr.', 'L', 3.45, 7);


DROP TABLE IF EXISTS `worktype_groups`;
CREATE TABLE `worktype_groups` (
  `group_id`  BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(50),
  `parent_id` BIGINT(20)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `worktype_groups` VALUES (1, 'root_worktype_group', NULL);
INSERT INTO `worktype_groups` VALUES (2, 'group_level_1A', 1);
INSERT INTO `worktype_groups` VALUES (3, 'group_level_1B', 1);
INSERT INTO `worktype_groups` VALUES (4, 'group_level_2A', 2);
INSERT INTO `worktype_groups` VALUES (5, 'group_level_2B', 2);
INSERT INTO `worktype_groups` VALUES (6, 'group_level_2C', 3);
INSERT INTO `worktype_groups` VALUES (7, 'group_level_2D', 3);


DROP TABLE IF EXISTS `material_type_group`;
CREATE TABLE `material_type_group` (
  `id`          INT(11)     NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(50) NOT NULL,
  `description` VARCHAR(512)         DEFAULT NULL,
  `parent_id`   BIGINT(20),
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `material_type_group` VALUES (1, 'root_material_type_group', 'root_material_type_group_descr.', NULL);
INSERT INTO `material_type_group` VALUES (2, 'OBSHE STROITELNIE MATERIALY', 'vse materiali, kotorie ne voshli v drugie gruppy.', 1);
INSERT INTO `material_type_group` VALUES (3, 'OBORYDOVANIE', 'santeshnika, dveri, podokonniky, furnitura', 1);
INSERT INTO `material_type_group` VALUES (4, 'FINISHNIE POKRITIYA', 'oblizovochnie materialy.', 1);
/*INSERT INTO `material_type_group` VALUES (5, 'material_type_group_level_2B', 'material_type_group_2B_descr.', 2);
INSERT INTO `material_type_group` VALUES (6, 'material_type_group_level_2C', 'material_type_group_2C_descr.', 3);
INSERT INTO `material_type_group` VALUES (7, 'material_type_group_level_2D', 'material_type_group_2D_descr.', 3);
*/

DROP TABLE IF EXISTS `material_type`;
CREATE TABLE `material_type` (
  `id`             INT(11)     NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(50) NOT NULL,
  `description`    VARCHAR(512)         DEFAULT NULL,
  `price_per_unit` DOUBLE      NOT NULL,
  `unit_name`      VARCHAR(50) NOT NULL,
  `parent_id`      BIGINT(20),
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `material_type` VALUES (1, 'shpaklevka finish', 'material_type_1_descr.', '110', 'unit_name_1', '2');
INSERT INTO `material_type` VALUES (2, 'shpaklevka start', 'material_type_2_descr.', '110', 'unit_name_2', '2');
INSERT INTO `material_type` VALUES (3, 'gruntovka', 'material_type_3_descr.', '20', 'unit_name_3', '2');
INSERT INTO `material_type` VALUES (4, 'vanna', 'material_type_4_descr.', '3200', 'unit_name_4', '3');
INSERT INTO `material_type` VALUES (5, 'unitaz', 'material_type_5_descr.', '1500', 'unit_name_5', '3');
INSERT INTO `material_type` VALUES (6, 'umivalnik', 'material_type_6_descr.', '1000', 'unit_name_6', '3');
INSERT INTO `material_type` VALUES (7, 'plitka na steny', 'material_type_7_descr.', '200', 'unit_name_7', '4');
INSERT INTO `material_type` VALUES (8, 'plitka na pol', 'material_type_8_descr.', '300', 'unit_name_8', '4');
INSERT INTO `material_type` VALUES (9, 'kvarzeviy grunt', 'material_type_9_descr.', '500', 'unit_name_9', '4');


DROP TABLE IF EXISTS `materials`;
CREATE TABLE `materials` (
  `id`                          INT(8)      NOT NULL AUTO_INCREMENT,
  `units_per_work_zone_measure` DOUBLE  ,
  `planed_cost`                 DOUBLE      ,
  `deal_cost`                   DOUBLE      ,
  `closed_cost`                 DOUBLE      ,
  `material_type_id`          INT(8),
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



INSERT INTO `materials` VALUES (1, '2', '10.0', '3.0', '4.2', '1');
INSERT INTO `materials` VALUES (2, '2', '10.0', '3.0', '4.2', '2');
INSERT INTO `materials` VALUES (3, '2', '10.0', '3.0', '4.2', '3');
INSERT INTO `materials` VALUES (4, '2', '10.0', '3.0', '4.2', '4');
INSERT INTO `materials` VALUES (5, '2', '10.0', '3.0', '4.2', '5');

DROP TABLE IF EXISTS `worktype_material_rel`;
CREATE TABLE `worktype_material_rel` (
  `worktype_id` INT(10),
  `material_id`    INT(10)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (1, 1);
INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (1, 2);
INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (2, 1);
INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (2, 2);



DROP TABLE IF EXISTS `works`;
CREATE TABLE `works` (
  `work_id`          BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`             VARCHAR(50),
  `work_type_id`     BIGINT(11),
  `zone_id`     	 BIGINT(11),
  `planed_cost`      DOUBLE,
  `perspective_cost` DOUBLE,
  `closed_cost`      DOUBLE,
  `deal_cost`        DOUBLE,
  `parent_group_id`  BIGINT(11)
);

INSERT INTO `works` VALUES (1, 'work_1', 1, 1, 2, 3, 4, 4, 4);
INSERT INTO `works` VALUES (2, 'work_2', 2, 2, 2, 3, 4, 4, 4);
INSERT INTO `works` VALUES (3, 'work_3', 2, 2, 2, 3, 4, 4, 4);
INSERT INTO `works` VALUES (4, 'work_4', 3, 3, 2, 3, 4, 5, 5);
INSERT INTO `works` VALUES (5, 'work_5', 3, 3, 2, 3, 4, 5, 5);
INSERT INTO `works` VALUES (6, 'work_6', 3, 3, 2, 3, 4, 6, 5);

/*DROP TABLE IF EXISTS `work_zone_rel`;
CREATE TABLE `work_zone_rel` (
  `id`      BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `work_id` BIGINT(11),
  `zone_id` BIGINT(11)
);

INSERT INTO `work_zone_rel` VALUES (1, 1, 1);
INSERT INTO `work_zone_rel` VALUES (2, 2, 1);
INSERT INTO `work_zone_rel` VALUES (3, 3, 2);
INSERT INTO `work_zone_rel` VALUES (4, 4, 4);
INSERT INTO `work_zone_rel` VALUES (5, 5, 5);
INSERT INTO `work_zone_rel` VALUES (6, 6, 6);


INSERT INTO `work_zone_rel` VALUES ();*/

DROP TABLE IF EXISTS `adjustments`;
CREATE TABLE `adjustments` (
  `id`          BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `value`       DOUBLE,
  `is_absolute` TINYINT,
  `work_id`     BIGINT(11)
);

INSERT INTO `adjustments` VALUES (1, 23, 1, 1);
INSERT INTO `adjustments` VALUES (2, 23, 1, 2);
INSERT INTO `adjustments` VALUES (3, 23, 1, 3);
INSERT INTO `adjustments` VALUES (4, 23, 1, 4);
INSERT INTO `adjustments` VALUES (5, 23, 1, 5);
INSERT INTO `adjustments` VALUES (6, 23, 1, 6);

DROP TABLE IF EXISTS `covers`;
CREATE TABLE `covers` (
  `id`          BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `value`       DOUBLE,
  `date`        VARCHAR(20),
  `description` VARCHAR(20),
  `work_id`     BIGINT(11)
);

INSERT INTO `covers` VALUES (1, 12, '12', 'cover1', 1);
INSERT INTO `covers` VALUES (2, 12, '12', 'cover2', 2);
INSERT INTO `covers` VALUES (3, 12, '12', 'cover3', 3);
INSERT INTO `covers` VALUES (4, 12, '12', 'cover4', 4);
INSERT INTO `covers` VALUES (5, 12, '12', 'cover5', 5);
INSERT INTO `covers` VALUES (6, 12, '12', 'cover6', 6);

DROP TABLE IF EXISTS `work_groups`;
CREATE TABLE `work_groups` (
  `id`        BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(20),
  `parent_id` BIGINT(11),
  `work_type_id` BIGINT(11)
);

INSERT INTO `work_groups` VALUES (1, 'root_group', NULL, 1);
INSERT INTO `work_groups` VALUES (2, 'PROJECT_WORK_1', 1, 1);
INSERT INTO `work_groups` VALUES (3, 'PROJECT_WORK_2', 1, 1);
INSERT INTO `work_groups` VALUES (4, 'PROJECT_WORK_3', 2, 2);
INSERT INTO `work_groups` VALUES (5, 'PROJECT_WORK_4', 2, 2);

