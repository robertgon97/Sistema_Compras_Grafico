/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : sistemainventario

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-02-19 01:29:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cajero
-- ----------------------------
DROP TABLE IF EXISTS `cajero`;
CREATE TABLE `cajero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(250) NOT NULL,
  `motivo` varchar(250) NOT NULL,
  `dinero` float NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cajero
-- ----------------------------
INSERT INTO `cajero` VALUES ('1', 'Egreso', 'Precio Compra', '2748', '2018-01-21');
INSERT INTO `cajero` VALUES ('2', 'Ingreso', 'Precio Venta', '3447', '2018-01-21');

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL,
  `tipo` varchar(250) NOT NULL,
  `descuento` float NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of clientes
-- ----------------------------
INSERT INTO `clientes` VALUES ('1', 'Nafis', 'Islam', 'Normal', '16', '10000');
INSERT INTO `clientes` VALUES ('2', 'Himel', 'Hafizul Islam', 'Gold', '10', '10001');
INSERT INTO `clientes` VALUES ('3', 'Anik', 'Chowdhury', 'Gold', '10', '10002');
INSERT INTO `clientes` VALUES ('4', 'Faiza', 'Omar', 'Gold', '10', '10003');
INSERT INTO `clientes` VALUES ('5', 'Sajid', 'Ahmed', 'Silver', '7', '10004');
INSERT INTO `clientes` VALUES ('7', 'Nikita', 'Nuzhat', 'Silver', '7', '10006');
INSERT INTO `clientes` VALUES ('8', 'Redwan', 'Ur Rahman', 'Silver', '7', '10007');
INSERT INTO `clientes` VALUES ('9', 'Swapnil', 'Biswas', 'Silver', '7', '10008');
INSERT INTO `clientes` VALUES ('10', 'Debosree', 'Mukherjee', 'Silver', '7', '10009');
INSERT INTO `clientes` VALUES ('11', 'Sajid', 'Mahbub', 'Silver', '7', '10010');
INSERT INTO `clientes` VALUES ('12', 'Salehin', 'Merchant', 'Silver', '7', '10011');
INSERT INTO `clientes` VALUES ('13', 'Titli', 'Sk Tasbiha', 'Silver', '7', '10012');
INSERT INTO `clientes` VALUES ('14', 'Ahmed Shahriar ', 'Adnan', 'Silver', '7', '10013');
INSERT INTO `clientes` VALUES ('15', 'Sarah', 'Nuzhat Khan ', 'Silver', '7', '10014');
INSERT INTO `clientes` VALUES ('16', 'Tulon', 'Sayeeda ', 'Gold', '10', '10015');
INSERT INTO `clientes` VALUES ('17', 'Samiul', 'Alam', 'Silver', '7', '10016');
INSERT INTO `clientes` VALUES ('18', 'Joyti ', 'Roy', 'Silver', '7', '10017');
INSERT INTO `clientes` VALUES ('19', 'Mitu', 'Naznin', 'Gold', '10', '10018');
INSERT INTO `clientes` VALUES ('20', 'Mahtab ', 'Hossain', 'Silver', '7', '10019');
INSERT INTO `clientes` VALUES ('21', 'Smita ', 'Jahan', 'Silver', '7', '10020');
INSERT INTO `clientes` VALUES ('22', 'Ansary', 'Shah Siam ', 'Silver', '7', '10021');
INSERT INTO `clientes` VALUES ('23', 'Jebin', 'Tasnim', 'Gold', '10', '10022');
INSERT INTO `clientes` VALUES ('24', 'Arnob', 'Tr', 'Gold', '10', '10023');
INSERT INTO `clientes` VALUES ('25', 'Dontu', 'ak', 'Silver', '7', '10024');
INSERT INTO `clientes` VALUES ('26', 'Munna', 'Sanoyar', 'Silver', '7', '10025');
INSERT INTO `clientes` VALUES ('27', 'Siam', 'Hasan', 'Silver', '7', '10026');
INSERT INTO `clientes` VALUES ('31', 'aba', 'aba', 'Silver', '7', '10027');
INSERT INTO `clientes` VALUES ('32', 'Ethan', 'Ron', 'Platinam', '15', '10028');
INSERT INTO `clientes` VALUES ('33', 'Aria', 'Stark', 'Platinam', '15', '10029');
INSERT INTO `clientes` VALUES ('34', 'nafis', 'alim', 'Platinam', '15', '10025');
INSERT INTO `clientes` VALUES ('35', 'Boos', 'bal', 'Silver', '7', '10042');
INSERT INTO `clientes` VALUES ('36', '1', '1', 'Normal', '0', '1');
INSERT INTO `clientes` VALUES ('37', '1', '1', 'Normal', '0', '1');
INSERT INTO `clientes` VALUES ('40', 'lol', 'this', 'Normal', '0', '122');

-- ----------------------------
-- Table structure for empleados
-- ----------------------------
DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL,
  `tipo` varchar(250) DEFAULT NULL,
  `salario` float NOT NULL,
  `itra` date DEFAULT NULL,
  `ftra` date DEFAULT NULL,
  `itiempo` time DEFAULT NULL,
  `ftiempo` time DEFAULT NULL,
  `horas` float DEFAULT NULL,
  `contraseña` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empleados
-- ----------------------------
INSERT INTO `empleados` VALUES ('1', 'Himel', 'Hafizul Islam', 'Manager', '250', null, null, '20:41:00', null, '12', '9876');
INSERT INTO `empleados` VALUES ('2', 'Nafis', 'Islam', 'Manager', '350', null, null, '01:38:00', null, '36', '33398002');
INSERT INTO `empleados` VALUES ('3', 'MItu', 'Naznin', 'Manager', '200', null, null, '13:43:00', null, '15', '1234');
INSERT INTO `empleados` VALUES ('4', 'Faiza', 'Omar', 'Security mal', '185', null, null, '14:59:00', '20:32:00', '41', '1234');
INSERT INTO `empleados` VALUES ('5', 'Anima', 'Azad', 'Supplier', '150', null, null, '21:55:00', '21:55:00', '0', '1234');
INSERT INTO `empleados` VALUES ('6', 'Topu', 'Azad', 'sales', '127', null, null, '20:41:00', null, '16', '1234');
INSERT INTO `empleados` VALUES ('7', 'Anik', 'Che', 'Sales Executive', '115', null, null, '21:24:00', null, '12', '1234');
INSERT INTO `empleados` VALUES ('8', 'Rayan ', 'Alam', 'Cleaner', '70', null, null, '14:59:00', null, '9', '4567');
INSERT INTO `empleados` VALUES ('9', 'Marilyn', 'Zambrano', 'Manager', '15000', null, null, null, null, '3', '1');

-- ----------------------------
-- Table structure for fechaventa
-- ----------------------------
DROP TABLE IF EXISTS `fechaventa`;
CREATE TABLE `fechaventa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tiempo` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of fechaventa
-- ----------------------------
INSERT INTO `fechaventa` VALUES ('1', 'sellno2', '0', '0', '0', '2018-01-20 06:50:56');
INSERT INTO `fechaventa` VALUES ('2', 'sellno2', '1', '165', '160', '2018-01-20 06:51:14');
INSERT INTO `fechaventa` VALUES ('3', 'sellno3', '9', '2840', '2171', '2018-01-21 03:57:03');
INSERT INTO `fechaventa` VALUES ('4', 'sellno4', '2', '390', '380', '2018-01-21 04:30:48');
INSERT INTO `fechaventa` VALUES ('5', 'sellno7', '2', '400', '390', '2018-01-21 04:51:09');
INSERT INTO `fechaventa` VALUES ('6', 'sellno8', '2', '40', '36', '2018-01-21 04:52:22');
INSERT INTO `fechaventa` VALUES ('7', 'sellno9', '1', '12', '1', '2018-01-21 04:53:33');
INSERT INTO `fechaventa` VALUES ('8', 'sellno10', '2', '330', '320', '2018-01-21 05:03:36');
INSERT INTO `fechaventa` VALUES ('9', 'sellno11', '2', '390', '300', '2018-01-21 05:05:43');
INSERT INTO `fechaventa` VALUES ('10', 'sellno12', '33', '825', '660', '2018-01-21 05:09:17');
INSERT INTO `fechaventa` VALUES ('11', 'sellno13', '3', '402', '392', '2018-01-21 05:18:58');
INSERT INTO `fechaventa` VALUES ('12', 'sellno14', '3', '525', '470', '2018-01-21 05:19:28');
INSERT INTO `fechaventa` VALUES ('13', 'sellno15', '2', '390', '380', '2018-01-21 05:22:14');
INSERT INTO `fechaventa` VALUES ('14', 'sellno16', '1', '200', '195', '2018-01-21 05:27:57');
INSERT INTO `fechaventa` VALUES ('15', 'sellno17', '2', '400', '390', '2018-01-21 05:33:06');
INSERT INTO `fechaventa` VALUES ('16', 'sellno18', '0', '0', '0', '2018-01-21 05:34:58');
INSERT INTO `fechaventa` VALUES ('17', 'sellno19', '0', '0', '0', '2018-01-21 05:42:04');
INSERT INTO `fechaventa` VALUES ('18', 'sellno20', '2', '400', '390', '2018-01-21 06:06:21');
INSERT INTO `fechaventa` VALUES ('19', 'sellno21', '5', '845', '810', '2018-01-21 06:10:09');
INSERT INTO `fechaventa` VALUES ('20', 'sellno22', '2', '330', '320', '2018-01-21 06:14:46');
INSERT INTO `fechaventa` VALUES ('21', 'sellno23', '2', '200', '180', '2018-01-21 06:27:41');
INSERT INTO `fechaventa` VALUES ('22', 'sellno24', '2', '200', '180', '2018-01-21 06:31:50');
INSERT INTO `fechaventa` VALUES ('23', 'sellno25', '2', '200', '180', '2018-01-21 06:35:30');
INSERT INTO `fechaventa` VALUES ('24', 'ventan26', '6', '825', '801', '2018-02-16 10:50:15');
INSERT INTO `fechaventa` VALUES ('25', 'ventan27', '4', '370', '356', '2018-02-16 10:50:58');
INSERT INTO `fechaventa` VALUES ('26', 'ventan28', '4', '450', '430', '2018-02-16 10:52:48');
INSERT INTO `fechaventa` VALUES ('27', 'ventan29', '4', '590', '560', '2018-02-16 10:55:02');
INSERT INTO `fechaventa` VALUES ('28', 'ventan30', '2', '220', '213', '2018-02-16 11:01:37');

-- ----------------------------
-- Table structure for historialinv
-- ----------------------------
DROP TABLE IF EXISTS `historialinv`;
CREATE TABLE `historialinv` (
  `eid` varchar(255) DEFAULT NULL,
  `inid` varchar(255) DEFAULT NULL,
  `operacion` varchar(255) DEFAULT NULL,
  `tiempo` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `cantidad_antes` varchar(255) DEFAULT NULL,
  `cantidad_nueva` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of historialinv
-- ----------------------------
INSERT INTO `historialinv` VALUES ('1', '27', 'updated', '2018-01-20 13:50:46', '86', '98');
INSERT INTO `historialinv` VALUES ('1', '34', 'updated', '2018-01-20 13:51:26', '71', '115');
INSERT INTO `historialinv` VALUES ('1', '33', 'updated', '2018-01-20 13:51:46', '91', '94');
INSERT INTO `historialinv` VALUES ('1', '33', 'updated', '2018-01-20 13:51:59', '94', '188');
INSERT INTO `historialinv` VALUES ('1', '33', 'updated', '2018-01-20 13:52:10', '188', '132');
INSERT INTO `historialinv` VALUES ('1', '12', 'updated', '2018-01-20 15:22:36', '0', '33');
INSERT INTO `historialinv` VALUES ('1', '16', 'updated', '2018-01-20 18:15:48', '62', '124');
INSERT INTO `historialinv` VALUES ('1', '33', 'updated', '2018-01-20 18:18:38', '132', '264');
INSERT INTO `historialinv` VALUES ('1', '37', 'inserted', '2018-01-20 18:19:39', '0', '2');
INSERT INTO `historialinv` VALUES ('1', '38', 'inserted', '2018-01-20 18:19:48', '0', '2');
INSERT INTO `historialinv` VALUES ('1', '39', 'inserted', '2018-02-16 23:04:24', '0', '2');
INSERT INTO `historialinv` VALUES ('1', '37', 'updated', '2018-02-16 23:05:46', '1', '34');

-- ----------------------------
-- Table structure for pagoempleados
-- ----------------------------
DROP TABLE IF EXISTS `pagoempleados`;
CREATE TABLE `pagoempleados` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `empid` int(11) NOT NULL,
  `money` float NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pagoempleados
-- ----------------------------

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL,
  `tipo` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `peso` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio_compra` float DEFAULT NULL,
  `codigo` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of productos
-- ----------------------------
INSERT INTO `productos` VALUES ('3', 'Elit Choco Eggy', '268', '448', 'Chocolate', 'each', '440', '');
INSERT INTO `productos` VALUES ('7', 'milk', '52', '20', 'Bev', '200 ml', '18', '25698');
INSERT INTO `productos` VALUES ('12', 'BRAC Chicken Sausage', '8', '200', 'Frozen Snacks', '10 pcs', '195', '');
INSERT INTO `productos` VALUES ('13', 'Rich Chicken Sausage', '52', '195', 'Frozen Snacks', '340 gm', '190', '');
INSERT INTO `productos` VALUES ('18', 'Rich Frozen Chicken Nuggets', '81', '165', 'Frozen Snacks', '300 gm', '160', '');
INSERT INTO `productos` VALUES ('24', 'Gatorade Lemon Lime Drink', '75', '130', 'Soft Drinks', '500 ml', '120', '2569');
INSERT INTO `productos` VALUES ('27', 'Coca Cola', '89', '100', 'Soft Drinks', '2 l', '90', '2891260');
INSERT INTO `productos` VALUES ('28', 'Data Structures', '195', '195', 'Book', '150 gm', '150', '287963');
INSERT INTO `productos` VALUES ('30', 'Igloo icecrem', '60', '25', 'Ice Cream', '25 gm', '20', '2891261');
INSERT INTO `productos` VALUES ('31', 'Optimum nutrition whey protein', '54', '2500', 'Sports Nutrition', '900 gm', '1850', '2891257');
INSERT INTO `productos` VALUES ('36', 'agua', '11', '12', '12', '21', '1', '');
INSERT INTO `productos` VALUES ('37', '2', '34', '200', '2', '2', '2', '2');
INSERT INTO `productos` VALUES ('38', '2', '1', '2', '2', '2', '2', '2');
INSERT INTO `productos` VALUES ('39', '2', '2', '2', '2', '2', '2', '2');

-- ----------------------------
-- Table structure for ventan26
-- ----------------------------
DROP TABLE IF EXISTS `ventan26`;
CREATE TABLE `ventan26` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(250) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `pprecio` float NOT NULL,
  `valor` varchar(250) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tipo` varchar(250) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventan26
-- ----------------------------
INSERT INTO `ventan26` VALUES ('1', 'milk', '2', '20', '0%', '40', '18', 'Bev');
INSERT INTO `ventan26` VALUES ('2', 'Rich Chicken Sausage', '3', '195', '0%', '585', '190', 'Frozen Snacks');
INSERT INTO `ventan26` VALUES ('3', 'BRAC Chicken Sausage', '1', '200', '0%', '200', '195', 'Frozen Snacks');

-- ----------------------------
-- Table structure for ventan27
-- ----------------------------
DROP TABLE IF EXISTS `ventan27`;
CREATE TABLE `ventan27` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(250) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `pprecio` float NOT NULL,
  `valor` varchar(250) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tipo` varchar(250) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventan27
-- ----------------------------
INSERT INTO `ventan27` VALUES ('1', 'milk', '2', '20', '0%', '40', '18', 'Bev');
INSERT INTO `ventan27` VALUES ('2', 'Rich Frozen Chicken Nuggets', '2', '165', '0%', '330', '160', 'Frozen Snacks');

-- ----------------------------
-- Table structure for ventan28
-- ----------------------------
DROP TABLE IF EXISTS `ventan28`;
CREATE TABLE `ventan28` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(250) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `pprecio` float NOT NULL,
  `valor` varchar(250) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tipo` varchar(250) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventan28
-- ----------------------------
INSERT INTO `ventan28` VALUES ('1', 'BRAC Chicken Sausage', '2', '200', '0%', '400', '195', 'Frozen Snacks');
INSERT INTO `ventan28` VALUES ('2', 'Igloo icecrem', '2', '25', '0%', '50', '20', 'Ice Cream');

-- ----------------------------
-- Table structure for ventan29
-- ----------------------------
DROP TABLE IF EXISTS `ventan29`;
CREATE TABLE `ventan29` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(250) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `pprecio` float NOT NULL,
  `valor` varchar(250) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tipo` varchar(250) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventan29
-- ----------------------------
INSERT INTO `ventan29` VALUES ('1', 'Coca Cola', '2', '100', '0%', '200', '90', 'Soft Drinks');
INSERT INTO `ventan29` VALUES ('2', 'Rich Chicken Sausage', '2', '195', '0%', '390', '190', 'Frozen Snacks');

-- ----------------------------
-- Table structure for ventan30
-- ----------------------------
DROP TABLE IF EXISTS `ventan30`;
CREATE TABLE `ventan30` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(250) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `pprecio` float NOT NULL,
  `valor` varchar(250) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tipo` varchar(250) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventan30
-- ----------------------------
INSERT INTO `ventan30` VALUES ('1', 'BRAC Chicken Sausage', '1', '200', '0%', '200', '195', 'Frozen Snacks');
INSERT INTO `ventan30` VALUES ('2', 'milk', '1', '20', '0%', '20', '18', 'Bev');

-- ----------------------------
-- Table structure for ventanumero
-- ----------------------------
DROP TABLE IF EXISTS `ventanumero`;
CREATE TABLE `ventanumero` (
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventanumero
-- ----------------------------
INSERT INTO `ventanumero` VALUES ('30');

-- ----------------------------
-- Table structure for ventas
-- ----------------------------
DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(250) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `pprecio` float NOT NULL,
  `valor` varchar(250) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tipo` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventas
-- ----------------------------
INSERT INTO `ventas` VALUES ('1', 'Rich Frozen Chicken Nuggets', '7', '165', '', '660', '160', 'Frozen Snacks');
INSERT INTO `ventas` VALUES ('2', 'BRAC Chicken Sausage', '11', '200', '', '1400', '195', 'Frozen Snacks');
INSERT INTO `ventas` VALUES ('3', 'milk', '10', '20', '', '180', '18', 'Bev');
INSERT INTO `ventas` VALUES ('4', 'Optimum nutrition whey protein', '1', '2500', '', '2500', '1850', 'Sports Nutrition');
INSERT INTO `ventas` VALUES ('5', 'Rich Chicken Sausage', '9', '195', '', '975', '190', 'Frozen Snacks');
INSERT INTO `ventas` VALUES ('6', 'agua', '1', '12', '', '12', '1', '12');
INSERT INTO `ventas` VALUES ('7', 'Data Structures', '3', '195', '', '585', '150', 'Book');
INSERT INTO `ventas` VALUES ('8', 'Igloo icecrem', '35', '25', '', '850', '20', 'Ice Cream');
INSERT INTO `ventas` VALUES ('9', '2', '1', '2', '', '2', '2', '2');
INSERT INTO `ventas` VALUES ('10', 'Gatorade Lemon Lime Drink', '2', '130', '', '260', '120', 'Soft Drinks');
INSERT INTO `ventas` VALUES ('11', 'Coca Cola', '8', '100', '', '500', '90', 'Soft Drinks');

-- ----------------------------
-- Table structure for ventash
-- ----------------------------
DROP TABLE IF EXISTS `ventash`;
CREATE TABLE `ventash` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(255) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL,
  `precio_compra` float NOT NULL,
  `tipo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ventash
-- ----------------------------
INSERT INTO `ventash` VALUES ('21', 'a', '0', '0', '0', 'NULL', '2018-02-16');
INSERT INTO `ventash` VALUES ('22', 'Coca Cola', '2', '100', '90', 'Soft Drinks', '2018-02-16');
INSERT INTO `ventash` VALUES ('23', 'Rich Chicken Sausage', '2', '195', '190', 'Frozen Snacks', '2018-02-16');
INSERT INTO `ventash` VALUES ('24', 'BRAC Chicken Sausage', '1', '200', '195', 'Frozen Snacks', '2018-02-16');
INSERT INTO `ventash` VALUES ('25', 'milk', '1', '20', '18', 'Bev', '2018-02-16');
