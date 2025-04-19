INSERT INTO Post (id, title, description, content, created_at, updated_at) VALUES
(1, 'Cách học lập trình hiệu quả', 'Hướng dẫn từng bước để học lập trình', 'Nội dung chi tiết ', '2025-04-10 10:00:00', '2025-04-10 10:00:00'),
(2, 'Xu hướng công nghệ 2025', 'Những công nghệ sẽ thay đổi thế giới', 'AI, blockchain, quantum computing ', '2025-03-22 15:30:00', '2025-03-25 08:45:00'),
(3, 'Phỏng vấn lập trình viên', 'Các câu hỏi phỏng vấn phổ biến', 'Danh sách các câu hỏi ', '2025-04-01 09:00:00', '2025-04-01 10:00:00'),
(4, 'Tạo website cá nhân', 'Hướng dẫn làm website với HTML/CSS', 'Từng bước xây dựng ', '2025-02-14 12:00:00', '2025-02-14 12:00:00'),
(5, 'Hiểu rõ Git và GitHub', 'Quản lý mã nguồn với Git', 'Git là công cụ mạnh mẽ ', '2025-01-30 08:00:00', '2025-01-30 09:00:00');


INSERT INTO Comment (id, name, email, body,created_at, updated_at,post_id,status) VALUES
(1, 'Nguyễn Văn A', 'a.nguyen@example.com', 'Bài viết',  '2025-04-10 11:00:00', '2025-04-10 11:00:00',1,'R'),
(2, 'Trần Thị B', 'b.tran@example.com', 'Tôi thấy phần', '2025-04-11 08:45:00', '2025-04-11 08:45:00',2,'R'),
(3, 'Lê Văn C', 'c.le@example.com', 'Cảm ơn tác giả đã ', '2025-04-12 10:30:00', '2025-04-12 10:30:00',3,'R'),
(4, 'Phạm Thị D', 'd.pham@example.com', 'Tôi không đồng ',  '2025-04-12 13:15:00', '2025-04-12 13:20:00',3,'R'),
(5, 'Hoàng Văn E', 'e.hoang@example.com', 'Mong có ',  '2025-04-13 14:00:00', '2025-04-13 14:00:00',2,'R');

INSERT INTO Role (type, created_at, updated_at) VALUES
('ADMIN', '2025-01-01 00:00:00', '2025-01-01 00:00:00'),
('EMPLOYEE', '2025-01-20 00:00:00', '2025-01-20 00:00:00');