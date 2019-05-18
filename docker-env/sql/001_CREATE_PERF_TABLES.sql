 USE perfDB;
 
 CREATE TABLE `TB_PKONLY` (
  `id` bigint(20) NOT NULL,
  `field1` char(30) DEFAULT NULL,
  `field2` bigint(20) DEFAULT NULL,
  `field3` datetime DEFAULT NULL,
  `field4` char(30) DEFAULT NULL,
  `field5` double NOT NULL,
  `field6` char(30) DEFAULT NULL,
  `field7` char(30) DEFAULT NULL,
  `field8` bigint(20) DEFAULT NULL,
  `field9` char(30) DEFAULT NULL,
  `field10` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TB_TenIdx` (
  `id` bigint(20) NOT NULL,
  `field1` char(30) DEFAULT NULL,
  `field2` bigint(20) DEFAULT NULL,
  `field3` datetime DEFAULT NULL,
  `field4` char(30) DEFAULT NULL,
  `field5` double NOT NULL,
  `field6` char(30) DEFAULT NULL,
  `field7` char(30) DEFAULT NULL,
  `field8` bigint(20) DEFAULT NULL,
  `field9` char(30) DEFAULT NULL,
  `field10` datetime DEFAULT NULL,
  CONSTRAINT `PK_TenIdx` PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE INDEX ten_idx1 ON TB_TenIdx (field2, field4) USING BTREE;
CREATE INDEX ten_idx2 ON TB_TenIdx (field1, field4, field6, field7) USING BTREE;
CREATE INDEX ten_idx3 ON TB_TenIdx (field10, field9, field7) USING BTREE;
CREATE INDEX ten_idx4 ON TB_TenIdx (field3, field10) USING BTREE;
CREATE INDEX ten_idx5 ON TB_TenIdx (field7) USING BTREE;
CREATE INDEX ten_idx6 ON TB_TenIdx (field3, field4) USING BTREE;
CREATE INDEX ten_idx7 ON TB_TenIdx (field7, field6, field4, field1) USING BTREE;
CREATE INDEX ten_idx8 ON TB_TenIdx (field5, field6, field7) USING BTREE;
CREATE INDEX ten_idx9 ON TB_TenIdx (field8, field2, field10) USING BTREE;
CREATE INDEX ten_idx10 ON TB_TenIdx (field10) USING BTREE;