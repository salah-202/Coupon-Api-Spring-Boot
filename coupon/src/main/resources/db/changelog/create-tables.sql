-- liquibase formatted sql

-- changeset liquibase:1
create table IF NOT EXISTS coupon (coupon_code bigint NOT NULL,
created_date DATETIME NOT NULL,
expiry_date DATETIME NOT NULL,
max_usages int NOT NULL,
current_usages int,
is_valid Bool Not NULL,
is_percentage BOOL NOT NULL,
coupon_value float NOT NULL,
PRIMARY KEY (coupon_code));

create table IF NOT EXISTS coupon_history(
	id INT AUTO_INCREMENT PRIMARY KEY,
    coupon_code bigint NOT NULL,
    order_id bigint NOT NULL,
	usage_date DATETIME NOT NULL,
    FOREIGN KEY (coupon_code) REFERENCES coupon(coupon_code)
);