/*
Navicat SQL Server Data Transfer

Source Server         : sql
Source Server Version : 120000
Source Host           : :1433
Source Database       : NhanVien
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 120000
File Encoding         : 65001

Date: 2017-04-09 10:07:04
*/


-- ----------------------------
-- Table structure for NhanVien
-- ----------------------------
DROP TABLE [dbo].[NhanVien]
GO
CREATE TABLE [dbo].[NhanVien] (
[id] int NOT NULL IDENTITY(1,1) ,
[manv] varchar(50) NULL ,
[hoten] varchar(50) NULL ,
[diachi] varchar(50) NULL ,
[email] varchar(50) NULL ,
[luong] money NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[NhanVien]', RESEED, 33)
GO

-- ----------------------------
-- Indexes structure for table NhanVien
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table NhanVien
-- ----------------------------
ALTER TABLE [dbo].[NhanVien] ADD PRIMARY KEY ([id])
GO
