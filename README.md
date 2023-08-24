# microservice

#Kafka <br>
#hlebalbau/kafka-manager <br>
#Microservice <br>
#Docker <br>

Link Swagger:<br>

- Sale-service: http://localhost:9002/swagger-ui/index.html<br>
- Stock-service: http://localhost:9003/swagger-ui/index.html<br>

Hướng dẫn setting:<br>

docker-compose up -d <br>

DB Stock-Serivce:<br>
INSERT INTO `stock_total` (`id`, `status`, `category_id`, `category_name`, `product_id`, `product_name`, `product_variant_id`, `product_variant_name`, `quantity`) VALUES
(1, 1, 3, '2', 1, '1', 1, '1', 2);
DB Sale-Service<br>

INSERT INTO `category` (`id`, `status`, `code`, `level`, `name`, `parent_id`) VALUES
(1, 1, 'ROOT', 1, 'ROOT', NULL),
(2, 1, 'C68717650511', 2, 'Giảm mỡ', 1),
(3, 1, 'C23525745866', 2, 'Sữa tăng cân', 1),
(4, 1, 'C23049760326', 3, 'Tăng cân nhanh', 3),
(5, 1, 'C10778611526', 3, 'Tăng cân nạc ít mỡ', 3);

---

INSERT INTO `product` (`id`, `status`, `code`, `description`, `name`, `category`) VALUES
(1, 1, 'P83899915167', NULL, 'Mass Fusion 12lbs 5.4kg', 3),
(2, 1, 'P61814025102', NULL, 'Up Your Mass XXXL 1350 12lbs', 3);

---

## -- Đang đổ dữ liệu cho bảng `product_variant`

INSERT INTO `product_variant` (`id`, `status`, `code`, `name`, `price`, `product_id`) VALUES
(1, 1, NULL, '12lbs 5.4kg', '1650000.00', 1),
(2, 1, NULL, '6lbs 2.7kg', '900000.00', 1),
(3, 1, NULL, '12lbs', '1459000.00', 2),
(4, 1, NULL, '6lbs', '750000.00', 2);

---

--
-- Đang đổ dữ liệu cho bảng `sale_order`
--

INSERT INTO `sale_order` (`id`, `status`, `product_id`, `product_variant`, `amount`, `discount`, `price`, `quantity`, `total_price`, `order_date`, `order_number`, `customer_address`, `customer_name`, `customer_phone`, `description`, `order_status`, `sale_order_details`, `note`) VALUES
(29, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:31:20.000000', '9827288495', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(30, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:33:12.000000', '30321084060', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(31, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:33:42.000000', '35118237117', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(32, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:45:05.000000', '44530637756', 'string', 'string', 'string', 'string', 'PENDING', NULL, NULL),
(33, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:45:38.000000', '63471191109', 'string', 'string', 'string', 'string', 'PENDING', NULL, NULL),
(34, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:51:23.000000', '79602923846', 'string', 'string', 'string', 'string', 'PENDING', NULL, NULL),
(35, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:51:31.000000', '95988722309', 'string', 'string', 'string', 'string', 'PENDING', NULL, NULL),
(36, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:53:38.000000', '29291691788', 'string', 'string', 'string', 'string', 'PENDING', NULL, NULL),
(37, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:53:52.000000', '48120939193', 'string', 'string', 'string', 'string', 'PENDING', NULL, NULL),
(38, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:55:38.000000', '12161297529', 'string', 'string', 'string', 'Sản phẩm Mass Fusion 12lbs 5.4kg 12lbs 5.4kg đã hết trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(39, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:56:01.000000', '43800683272', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(40, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:58:59.000000', '24705365089', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(41, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 01:59:26.000000', '62460167356', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(42, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 02:04:01.000000', '92856404407', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(43, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 02:05:50.000000', '33839755120', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(44, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 02:06:07.000000', '33951230737', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(45, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 02:13:27.000000', '27802250765', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(46, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-16 02:13:35.000000', '80523514856', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(47, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-17 22:11:45.000000', '56392078660', 'string', 'string', 'string', 'Sản phẩm Up Your Mass XXXL 1350 12lbs 12lbs không tồn tại trong kho', 'CANCEL_BY_SYSTEM', NULL, NULL),
(48, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-17 22:14:37.000000', '63671882819', 'string', 'string', 'string', 'string', 'APRROVE', NULL, NULL),
(49, 1, NULL, NULL, '3109000.00', '0.00', '3109000.00', 2, '3109000.00', '2023-08-17 22:14:49.000000', '55083349622', 'string', 'string', 'string', 'string', 'APRROVE', NULL, NULL);

---

## -- Đang đổ dữ liệu cho bảng `sale_order_detail`

INSERT INTO `sale_order_detail` (`id`, `status`, `amount`, `discount`, `price`, `quantity`, `total_price`, `product_id`, `product_variant`, `product_variant_id`, `sale_order_id`) VALUES
(1, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 29),
(2, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 29),
(3, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 30),
(4, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 30),
(5, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 31),
(6, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 31),
(7, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 32),
(8, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 32),
(9, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 33),
(10, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 33),
(11, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 34),
(12, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 34),
(13, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 35),
(14, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 35),
(15, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 36),
(16, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 36),
(17, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 37),
(18, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 37),
(19, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 38),
(20, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 38),
(21, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 39),
(22, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 39),
(23, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 40),
(24, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 40),
(25, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 41),
(26, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 41),
(27, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 42),
(28, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 42),
(29, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 43),
(30, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 43),
(31, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 44),
(32, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 44),
(33, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 45),
(34, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 45),
(35, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 46),
(36, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 46),
(37, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 47),
(38, 1, '1459000.00', '0.00', '1459000.00', 1, '1459000.00', 2, NULL, 3, 47),
(39, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 48),
(40, 1, '1650000.00', '0.00', '1650000.00', 1, '1650000.00', 1, NULL, 1, 49);
