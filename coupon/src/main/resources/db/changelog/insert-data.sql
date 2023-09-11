INSERT INTO coupon (coupon_code, created_date, expiry_date, max_usages, current_usages, is_valid, is_percentage, coupon_value)
VALUES
    (1, '2023-09-09 18:25:45', '2023-09-10 23:59:59', 10, 0, true, true, 10.0),
    (2, '2023-09-10 14:30:00', '2023-09-11 23:59:59', 5, 0, true, false, 100.0),
    (3, '2023-09-11 09:15:00', '2023-09-12 23:59:59', 3, 0, true, true, 15.0),
    (4, '2023-09-12 20:00:00', '2023-09-13 23:59:59', 2, 0, true, true, 30.0),
    (5, '2023-09-13 12:00:00', '2023-09-14 23:59:59', 8, 0, true, false, 200.0);
