CREATE TABLE `CM_FILE_NET` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `FILE_TYPE` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `SIZE` int DEFAULT NULL,
  `STATUS` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `STORAGE_TYPE` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `MIME_TYPE` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `FILE_UUID` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `PATH` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `SHA512` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `DATA` mediumblob,
  `CREATED_AT` datetime NOT NULL,
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `UPDATED_AT` datetime NOT NULL,
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `ARTICLAL_INFO_ID` FOREIGN KEY (`ID`) REFERENCES `ARTICAL_INFO` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs