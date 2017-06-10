/*
Navicat SQL Server Data Transfer

Source Server         : SQLSever
Source Server Version : 110000
Source Host           : .\SQLEXPRESS:1433
Source Database       : card_processing
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2017-06-10 14:30:52
*/


-- ----------------------------
-- Table structure for [dbo].[device_status]
-- ----------------------------
DROP TABLE [dbo].[device_status]
GO
CREATE TABLE [dbo].[device_status] (
[id] int NOT NULL IDENTITY(1,1) ,
[date] datetime NULL ,
[status] int NULL ,
[merchant_id] int NULL ,
[device_id] int NOT NULL 
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
-- Table structure for [dbo].[devices]
-- ----------------------------
DROP TABLE [dbo].[devices]
GO
CREATE TABLE [dbo].[devices] (
[device_type] int NULL ,
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
-- Table structure for [dbo].[masters]
-- ----------------------------
DROP TABLE [dbo].[masters]
GO
CREATE TABLE [dbo].[masters] (
[id] int NOT NULL IDENTITY(1,1) ,
[master_name] nvarchar(200) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[masters]', RESEED, 2)
GO

-- ----------------------------
-- Records of masters
-- ----------------------------
SET IDENTITY_INSERT [dbo].[masters] ON
GO
INSERT INTO [dbo].[masters] ([id], [master_name]) VALUES (N'1', N'Dong A');
GO
INSERT INTO [dbo].[masters] ([id], [master_name]) VALUES (N'2', N'Vietcombank');
GO
SET IDENTITY_INSERT [dbo].[masters] OFF
GO

-- ----------------------------
-- Table structure for [dbo].[merchant_type]
-- ----------------------------
DROP TABLE [dbo].[merchant_type]
GO
CREATE TABLE [dbo].[merchant_type] (
[id] int NOT NULL IDENTITY(1,1) ,
[TenLoai] nvarchar(250) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[merchant_type]', RESEED, 2)
GO

-- ----------------------------
-- Records of merchant_type
-- ----------------------------
SET IDENTITY_INSERT [dbo].[merchant_type] ON
GO
INSERT INTO [dbo].[merchant_type] ([id], [TenLoai]) VALUES (N'1', N'Shop Quan Ao');
GO
INSERT INTO [dbo].[merchant_type] ([id], [TenLoai]) VALUES (N'2', N'Quan An');
GO
SET IDENTITY_INSERT [dbo].[merchant_type] OFF
GO

-- ----------------------------
-- Table structure for [dbo].[merchants]
-- ----------------------------
DROP TABLE [dbo].[merchants]
GO
CREATE TABLE [dbo].[merchants] (
[id] int NOT NULL IDENTITY(1,1) ,
[merchant_code] varchar(30) NULL ,
[merchant_name] nvarchar(100) SPARSE NULL ,
[merchant_phone_call] varchar(15) NULL ,
[tax_code] varchar(15) NULL ,
[master_id] int NOT NULL ,
[agent_id] int NULL ,
[sub_agent_id] int NULL ,
[address] nvarchar(200) NULL ,
[district] int NULL ,
[province] int NULL ,
[ward] int NULL ,
[zip_code] int NULL ,
[first_active_date] datetime NULL ,
[last_active_date] datetime NULL ,
[auther_id] int NULL ,
[invite_id] int NULL ,
[status] int NULL ,
[type_id] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[merchants]', RESEED, 18)
GO

-- ----------------------------
-- Records of merchants
-- ----------------------------
SET IDENTITY_INSERT [dbo].[merchants] ON
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'1', N'123', N'Cua hang A', N'123', N'123', N'1', N'5', N'1', N'1', N'1', N'1', N'1', N'1', N'2017-06-08 22:34:18.630', N'2017-06-08 22:34:18.630', N'1', N'1', N'1', N'4');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'5', null, N'Agent 1', N'09012345678', null, N'1', null, null, null, null, null, null, null, null, null, null, null, null, N'2');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'6', null, N'Cua hang B', N'456', N'123', N'1', null, null, null, null, null, null, null, null, null, null, null, null, N'4');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'7', null, N'Sub Agent 1', null, null, N'1', N'5', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'8', null, N'Agent 2', null, null, N'1', null, null, null, null, null, null, null, null, null, null, null, null, N'2');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'9', null, N'Agent 3', null, null, N'2', null, null, null, null, null, null, null, null, null, null, null, null, N'2');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'10', null, N'Agent 4', null, null, N'2', null, null, null, null, null, null, null, null, null, null, null, null, N'2');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'11', null, N'Sub Agent 2', null, null, N'1', N'5', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'13', null, N'Sub Agent 3', null, null, N'1', N'8', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'14', null, N'Sub Agent 4', null, null, N'1', N'8', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'15', null, N'Sub Agent 5', null, null, N'2', N'9', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'16', null, N'Sub Agent 6', null, null, N'2', N'9', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'17', null, N'Sub Agent 7', null, null, N'2', N'10', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id]) VALUES (N'18', null, N'Sub Agent 8', null, null, N'2', N'10', null, null, null, null, null, null, null, null, null, null, null, N'3');
GO
SET IDENTITY_INSERT [dbo].[merchants] OFF
GO

-- ----------------------------
-- Table structure for [dbo].[parameters]
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
-- Table structure for [dbo].[sysdiagrams]
-- ----------------------------
DROP TABLE [dbo].[sysdiagrams]
GO
CREATE TABLE [dbo].[sysdiagrams] (
[name] sysname NOT NULL ,
[principal_id] int NOT NULL ,
[diagram_id] int NOT NULL IDENTITY(1,1) ,
[version] int NULL ,
[definition] varbinary(MAX) NULL 
)


GO

-- ----------------------------
-- Records of sysdiagrams
-- ----------------------------
SET IDENTITY_INSERT [dbo].[sysdiagrams] ON
GO
SET IDENTITY_INSERT [dbo].[sysdiagrams] OFF
GO

-- ----------------------------
-- Table structure for [dbo].[tokens]
-- ----------------------------
DROP TABLE [dbo].[tokens]
GO
CREATE TABLE [dbo].[tokens] (
[id] int NOT NULL IDENTITY(1,1) ,
[auther_id] int NOT NULL ,
[token] char(64) NULL ,
[expire] datetime NULL 
)


GO

-- ----------------------------
-- Records of tokens
-- ----------------------------
SET IDENTITY_INSERT [dbo].[tokens] ON
GO
INSERT INTO [dbo].[tokens] ([id], [auther_id], [token], [expire]) VALUES (N'1', N'1', N'123                                                             ', N'2017-06-10 12:08:00.740');
GO
SET IDENTITY_INSERT [dbo].[tokens] OFF
GO

-- ----------------------------
-- Table structure for [dbo].[thongbao]
-- ----------------------------
DROP TABLE [dbo].[thongbao]
GO
CREATE TABLE [dbo].[thongbao] (
[id] int NOT NULL IDENTITY(1,1) ,
[tieude] nvarchar(250) NULL ,
[noidung] nvarchar(MAX) NULL ,
[ngaytao] datetime NULL DEFAULT (getdate()) ,
[nguoitao] int NULL ,
[nguoinhan] int NULL 
)


GO

-- ----------------------------
-- Records of thongbao
-- ----------------------------
SET IDENTITY_INSERT [dbo].[thongbao] ON
GO
SET IDENTITY_INSERT [dbo].[thongbao] OFF
GO

-- ----------------------------
-- Table structure for [dbo].[transactions]
-- ----------------------------
DROP TABLE [dbo].[transactions]
GO
CREATE TABLE [dbo].[transactions] (
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
[merchant_code] varchar(30) NULL ,
[product_id] int NULL ,
[product_quantity] int NULL ,
[product_price] decimal(18) NULL ,
[file_source] varchar(255) NULL ,
[batch_number] varchar(255) NULL ,
[status] int NULL 
)


GO

-- ----------------------------
-- Records of transactions
-- ----------------------------
SET IDENTITY_INSERT [dbo].[transactions] ON
GO
SET IDENTITY_INSERT [dbo].[transactions] OFF
GO

-- ----------------------------
-- Table structure for [dbo].[users]
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
INSERT INTO [dbo].[users] ([username], [password], [fullname], [flag], [id]) VALUES (N'admin', N'admin', N'admin', N'1', N'1');
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO

-- ----------------------------
-- Procedure structure for [dbo].[get_master_agent_sub_agent]
-- ----------------------------
DROP PROCEDURE [dbo].[get_master_agent_sub_agent]
GO
CREATE proc [dbo].[get_master_agent_sub_agent] AS
begin
select ma.master_id as master_id, ma.master_name as master_name,
ma.agent_id as agent_id, ma.agent_name as agent_name,
s.id as sub_agent_id, s.merchant_name as sub_agent_name
from merchants s,
(select m.id as master_id, m.master_name as master_name, a.id as agent_id, a.merchant_name as agent_name
from masters m, merchants a
where m.id = a.master_id
and a.type_id = 2) as ma
where s.type_id = 3
AND s.agent_id = ma.agent_id
end

GO

-- ----------------------------
-- Procedure structure for [dbo].[sp_sel_list_searMerchant]
-- ----------------------------
DROP PROCEDURE [dbo].[sp_sel_list_searMerchant]
GO
CREATE PROC [dbo].[sp_sel_list_searMerchant]
@Name nvarchar(250)='0',
@Type int =0,
@Provice int = 0,
@District int =0,
@Ward int =0
AS
BEGIN
 SELECT * FROM merchants  AS A
 WHERE (A.merchant_name LIKE @Name+'%' OR @Name='0')
 AND (A.[type_id] = @Type OR @Type = 0)
 AND (A.province =@Provice OR @Provice=0)
 AND (A.district = @District OR @District=0)
 AND (A.ward = @Ward OR @Ward = 0)
END

GO

-- ----------------------------
-- Indexes structure for table device_status
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[device_status]
-- ----------------------------
ALTER TABLE [dbo].[device_status] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table devices
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[devices]
-- ----------------------------
ALTER TABLE [dbo].[devices] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table masters
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[masters]
-- ----------------------------
ALTER TABLE [dbo].[masters] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table merchant_type
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[merchant_type]
-- ----------------------------
ALTER TABLE [dbo].[merchant_type] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table merchants
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[merchants]
-- ----------------------------
ALTER TABLE [dbo].[merchants] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table parameters
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[parameters]
-- ----------------------------
ALTER TABLE [dbo].[parameters] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table sysdiagrams
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[sysdiagrams]
-- ----------------------------
ALTER TABLE [dbo].[sysdiagrams] ADD PRIMARY KEY ([diagram_id])
GO

-- ----------------------------
-- Uniques structure for table [dbo].[sysdiagrams]
-- ----------------------------
ALTER TABLE [dbo].[sysdiagrams] ADD UNIQUE ([principal_id] ASC, [name] ASC)
GO

-- ----------------------------
-- Indexes structure for table tokens
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[tokens]
-- ----------------------------
ALTER TABLE [dbo].[tokens] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table thongbao
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[thongbao]
-- ----------------------------
ALTER TABLE [dbo].[thongbao] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table transactions
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[transactions]
-- ----------------------------
ALTER TABLE [dbo].[transactions] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[users]
-- ----------------------------
ALTER TABLE [dbo].[users] ADD PRIMARY KEY ([id])
GO
