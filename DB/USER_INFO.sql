CREATE TABLE `USER_INFO` (
  `USER_ID` bigint NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(256) COLLATE utf8mb4_0900_as_cs NOT NULL,
  `USERNAME` varchar(100) COLLATE utf8mb4_0900_as_cs NOT NULL,
  `CREATE_AT` datetime NOT NULL,
  `CREATE_BY` varchar(100) COLLATE utf8mb4_0900_as_cs NOT NULL,
  `UPDATE_AT` datetime NOT NULL,
  `UPDATE_BY` varchar(100) COLLATE utf8mb4_0900_as_cs NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs