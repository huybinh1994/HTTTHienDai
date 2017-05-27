/*
Navicat SQL Server Data Transfer

Source Server         : SQL SERVER
Source Server Version : 110000
Source Host           : DESKTOP-OC938N0\SQLEXPRESS:1433
Source Database       : card_processing
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2017-05-27 07:57:29
*/


-- ----------------------------
-- Table structure for device_status
-- ----------------------------
DROP TABLE [dbo].[device_status]
GO
CREATE TABLE [dbo].[device_status] (
[id] int NOT NULL IDENTITY(1,1) ,
[date] datetime NULL ,
[status] int NULL ,
[merchant_id] int NULL ,
[device_id] int NULL 
)


GO

-- ----------------------------
-- Records of device_status
-- ----------------------------
SET IDENTITY_INSERT [dbo].[device_status] ON
GO
SET IDENTITY_INSERT [dbo].[device_status] OFF
GO

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE [dbo].[devices]
GO
CREATE TABLE [dbo].[devices] (
[device_type] int NOT NULL ,
[device_name] nvarchar(50) NULL ,
[device_no] char(10) NULL ,
[id] int NOT NULL IDENTITY(1,1) 
)


GO

-- ----------------------------
-- Records of devices
-- ----------------------------
SET IDENTITY_INSERT [dbo].[devices] ON
GO
SET IDENTITY_INSERT [dbo].[devices] OFF
GO

-- ----------------------------
-- Table structure for masters
-- ----------------------------
DROP TABLE [dbo].[masters]
GO
CREATE TABLE [dbo].[masters] (
[id] int NOT NULL IDENTITY(1,1) ,
[master_name] nvarchar(MAX) NULL 
)


GO

-- ----------------------------
-- Records of masters
-- ----------------------------
SET IDENTITY_INSERT [dbo].[masters] ON
GO
SET IDENTITY_INSERT [dbo].[masters] OFF
GO

-- ----------------------------
-- Table structure for merchants
-- ----------------------------
DROP TABLE [dbo].[merchants]
GO
CREATE TABLE [dbo].[merchants] (
[id] int NOT NULL IDENTITY(1,1) ,
[merchant_code] char(30) NULL ,
[merchant_name] nvarchar(100) SPARSE NULL ,
[merchant_phone_call] varchar(15) NULL ,
[tax_code] varchar(15) NULL ,
[master_id] int NULL ,
[agent_id] int NULL ,
[sub_agent_id] int NULL ,
[address_1] nvarchar(100) NULL ,
[address_2] nvarchar(100) NULL ,
[address_3] nvarchar(100) NULL ,
[city] int NULL ,
[province] int NULL ,
[zip_code] int NULL ,
[country] int NULL ,
[first_active_date] datetime NULL ,
[last_active_date] datetime NULL ,
[status] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[merchants]', RESEED, 5)
GO

-- ----------------------------
-- Records of merchants
-- ----------------------------
SET IDENTITY_INSERT [dbo].[merchants] ON
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address_1], [address_2], [address_3], [city], [province], [zip_code], [country], [first_active_date], [last_active_date], [status]) VALUES (N'3', N'M0001A000001S000001M0000000001', N'B''mark', N'0812345678', N'1000412345810', N'1', N'1', N'1', N'227, Nguyễn Văn Cừ', N'', null, null, null, null, null, null, null, N'1')
GO
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address_1], [address_2], [address_3], [city], [province], [zip_code], [country], [first_active_date], [last_active_date], [status]) VALUES (N'4', N'M0001A000001S000001M0000000002', N'CritcleK', N'0812345679', N'1000412345812', N'1', N'1', N'1', N'228, Nguyễn Văn Cừ', N'', null, null, null, null, null, null, null, N'1')
GO
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address_1], [address_2], [address_3], [city], [province], [zip_code], [country], [first_active_date], [last_active_date], [status]) VALUES (N'5', N'M0001A000001S000002M0000000001', N'Family Mark', N'0812454512', N'1021212112121', N'1', N'1', N'2', N'229, Nguyễn Văn Cừ', null, null, null, null, null, null, null, null, N'1')
GO
GO
SET IDENTITY_INSERT [dbo].[merchants] OFF
GO

-- ----------------------------
-- Table structure for parameters
-- ----------------------------
DROP TABLE [dbo].[parameters]
GO
CREATE TABLE [dbo].[parameters] (
[id] int NOT NULL IDENTITY(1,1) ,
[param_name] varchar(50) NULL ,
[param_value] text NULL ,
[param_type] varchar(255) NULL ,
[param_status] int NULL 
)


GO

-- ----------------------------
-- Records of parameters
-- ----------------------------
SET IDENTITY_INSERT [dbo].[parameters] ON
GO
SET IDENTITY_INSERT [dbo].[parameters] OFF
GO

-- ----------------------------
-- Table structure for tokens
-- ----------------------------
DROP TABLE [dbo].[tokens]
GO
CREATE TABLE [dbo].[tokens] (
[id] int NOT NULL IDENTITY(1,1) ,
[auther_id] int NULL ,
[token] char(64) NULL ,
[expire] datetime NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[tokens]', RESEED, 5)
GO

-- ----------------------------
-- Records of tokens
-- ----------------------------
SET IDENTITY_INSERT [dbo].[tokens] ON
GO
SET IDENTITY_INSERT [dbo].[tokens] OFF
GO

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE [dbo].[transaction]
GO
CREATE TABLE [dbo].[transaction] (
[id] int NOT NULL IDENTITY(1,1) ,
[transaction_id] nvarchar(20) NULL ,
[transaction_date] datetime NULL ,
[record_type] nvarchar(20) NULL ,
[acctid] nvarchar(20) NULL ,
[amount] decimal(18) NULL ,
[card_type] int NULL ,
[card_number] varchar(16) NULL ,
[csv] varchar(5) NULL ,
[card_exp_month] nvarchar(2) NULL ,
[card_exp_year] nvarchar(5) NULL ,
[merchant_code] char(30) NULL ,
[product_id] int NULL ,
[product_quantity] int NULL ,
[product_price] decimal(18) NULL ,
[file_source] varchar(255) NULL ,
[batch_number] varchar(255) NULL ,
[status] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[transaction]', RESEED, 25)
GO

-- ----------------------------
-- Records of transaction
-- ----------------------------
SET IDENTITY_INSERT [dbo].[transaction] ON
GO
SET IDENTITY_INSERT [dbo].[transaction] OFF
GO

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE [dbo].[users]
GO
CREATE TABLE [dbo].[users] (
[username] varchar(50) NULL ,
[password] varchar(50) NULL ,
[fullname] varchar(50) NULL ,
[flag] int NULL ,
[id] int NOT NULL IDENTITY(1,1) 
)


GO

-- ----------------------------
-- Records of users
-- ----------------------------
SET IDENTITY_INSERT [dbo].[users] ON
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO

-- ----------------------------
-- Indexes structure for table device_status
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table device_status
-- ----------------------------
ALTER TABLE [dbo].[device_status] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table devices
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table devices
-- ----------------------------
ALTER TABLE [dbo].[devices] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table masters
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table masters
-- ----------------------------
ALTER TABLE [dbo].[masters] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table merchants
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table merchants
-- ----------------------------
ALTER TABLE [dbo].[merchants] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Uniques structure for table merchants
-- ----------------------------
ALTER TABLE [dbo].[merchants] ADD UNIQUE ([merchant_code] ASC)
GO

-- ----------------------------
-- Indexes structure for table parameters
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table parameters
-- ----------------------------
ALTER TABLE [dbo].[parameters] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table tokens
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table tokens
-- ----------------------------
ALTER TABLE [dbo].[tokens] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table transaction
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table transaction
-- ----------------------------
ALTER TABLE [dbo].[transaction] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [dbo].[users] ADD PRIMARY KEY ([id])
GO
