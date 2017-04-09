CREATE DATABASE QuanLyNhanVien
GO
USE QuanLyNhanVien
GO
CREATE TABLE nhanvien
(
	id INT PRIMARY KEY IDENTITY,
	manv VARCHAR(50),
	hoten NVARCHAR(50),
	diachi NVARCHAR(100),
	email VARCHAR(50),
	luong money
)