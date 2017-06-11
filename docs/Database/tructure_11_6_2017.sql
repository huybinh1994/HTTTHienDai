/*
Navicat SQL Server Data Transfer

Source Server         : .
Source Server Version : 130000
Source Host           : .:1433
Source Database       : card_processing
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 130000
File Encoding         : 65001

Date: 2017-06-11 09:25:16
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
-- Table structure for devices
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
-- Table structure for masters
-- ----------------------------
DROP TABLE [dbo].[masters]
GO
CREATE TABLE [dbo].[masters] (
[id] int NOT NULL IDENTITY(1,1) ,
[master_name] nvarchar(200) NULL 
)


GO

-- ----------------------------
-- Records of masters
-- ----------------------------
SET IDENTITY_INSERT [dbo].[masters] ON
GO
INSERT INTO [dbo].[masters] ([id], [master_name]) VALUES (N'1', N'Dong A')
GO
INSERT INTO [dbo].[masters] ([id], [master_name]) VALUES (N'2', N'Vietcombank');
GO
SET IDENTITY_INSERT [dbo].[masters] OFF
GO

-- ----------------------------
-- Table structure for merchant_type
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
INSERT INTO [dbo].[merchant_type] ([id], [TenLoai]) VALUES (N'1', N'Shop Quan Ao')
GO
GO
INSERT INTO [dbo].[merchant_type] ([id], [TenLoai]) VALUES (N'2', N'Quan An')
GO
GO
SET IDENTITY_INSERT [dbo].[merchant_type] OFF
GO

-- ----------------------------
-- Table structure for merchants
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
[type_id] int NULL ,
[level_id] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[merchants]', RESEED, 3)
GO

-- ----------------------------
-- Records of merchants
-- ----------------------------
SET IDENTITY_INSERT [dbo].[merchants] ON
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id], [level_id]) VALUES (N'1', N'M0001A000001S000001M0000000001', N'Cua hang A', N'123', N'123', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'2017-06-08 22:34:18.063', N'2017-06-08 22:34:18.063', N'1', N'1', N'1', N'1', null)
GO
GO
INSERT INTO [dbo].[merchants] ([id], [merchant_code], [merchant_name], [merchant_phone_call], [tax_code], [master_id], [agent_id], [sub_agent_id], [address], [district], [province], [ward], [zip_code], [first_active_date], [last_active_date], [auther_id], [invite_id], [status], [type_id], [level_id]) VALUES (N'3', N'M0001A000001S000001M0000000002', null, N'AAA', N'123', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'1', N'2017-06-08 22:34:18.063', N'2017-06-08 22:34:18.063', N'1', N'1', N'1', N'1', null)
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
-- Table structure for thongbao
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
-- Table structure for tokens
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
INSERT INTO [dbo].[tokens] ([id], [auther_id], [token], [expire]) VALUES (N'1', N'1', N'123456                                                          ', N'2017-06-30 23:07:00.000')
GO
GO
SET IDENTITY_INSERT [dbo].[tokens] OFF
GO

-- ----------------------------
-- Table structure for transactions
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
[merchant_code] char(30) NULL ,
[product_id] int NULL ,
[product_quantity] int NULL ,
[product_price] decimal(18) NULL ,
[file_source] varchar(255) NULL ,
[batch_number] varchar(255) NULL ,
[status] int NULL ,
[transaction_type] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[transactions]', RESEED, 3)
GO

-- ----------------------------
-- Records of transactions
-- ----------------------------
SET IDENTITY_INSERT [dbo].[transactions] ON
GO
INSERT INTO [dbo].[transactions] ([id], [transaction_id], [transaction_date], [record_type], [acctid], [amount], [card_type], [card_number], [csv], [card_exp_month], [card_exp_year], [merchant_code], [product_id], [product_quantity], [product_price], [file_source], [batch_number], [status], [transaction_type]) VALUES (N'1', N'21498', N'2017-03-08 12:33:40.700', N'ns_quicksale_preauth', N'TEST0', N'1644187', N'4', N'1489005285118790', N'410', N'3', N'2020', N'M0001A000001S000001M0000000001', N'82', N'7', N'872026', null, null, N'1', N'1')
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
INSERT INTO [dbo].[users] ([username], [password], [fullname], [flag], [id]) VALUES (N'admin', N'admin', N'admin', N'1', N'1')
GO
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO

-- ----------------------------
-- Procedure structure for sp_sel_list_searMerchant
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
-- Procedure structure for sp_sel_list_Transaction_By_MerchantInfo
-- ----------------------------
DROP PROCEDURE [dbo].[sp_sel_list_Transaction_By_MerchantInfo]
GO
CREATE PROC [dbo].[sp_sel_list_Transaction_By_MerchantInfo]
@Search varchar(max)='',
@MerchantType int = 0,
@Region nvarchar(max) ='',
@Level int =0,
@code int = 0,
@TuNgay datetime,
@DenNgay datetime
AS
BEGIN
DECLARE @TblTemp table(KeyID int)
DECLARE  @v_iIndex int =CHARINDEX(',',@Region)
IF(@v_iIndex=0)
BEGIN
		INSERT INTO @TblTemp(KeyID) VALUES(@Region)
		
END
ELSE
BEGIN
WHILE(ISNULL(@v_iIndex,0)>0)
 BEGIN

         INSERT INTO @TblTemp(KeyID) VALUES(SUBSTRING(@Region,0,CHARINDEX(',',@Region)))
         SET @Region = SUBSTRING(@Region,@v_iIndex+1,LEN(@Region)-1)
		 SET @v_iIndex =CHARINDEX(',',@Region)
		 IF(@v_iIndex=0)
		 BEGIN
		    INSERT INTO @TblTemp(KeyID) VALUES(@Region)
		 END
 END
END
DECLARE @TblBanHang table(id int , mearchant_name nvarchar(max),merchant_code nvarchar(max),total_quantity_sale int, total_amout_sale float)
DECLARE @TblTraHang table(id int , mearchant_name nvarchar(max),merchant_code nvarchar(max),total_quantity_return int, total_amout_return float)

---1 MASTER
if(@Level=1)
begin
--------ban hang
insert into @TblBanHang(id,merchant_code,mearchant_name,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.master_id = @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id
--------------------------------------tra hang-------------------
insert into @TblTraHang(id,merchant_code,mearchant_name,total_quantity_return,total_amout_return)
SELECT A.id, A.merchant_code,A.merchant_name,ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.master_id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id
end
--2 AGENT
if(@Level=2)
begin
--------ban hang
insert into @TblBanHang(id,merchant_code,mearchant_name,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.agent_id= @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id
--------------------------------------tra hang-------------------
insert into @TblTraHang(id,merchant_code,mearchant_name,total_quantity_return,total_amout_return)
SELECT A.id, A.merchant_code,A.merchant_name,ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.agent_id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id
end
--3 SUB AGETN
if(@Level=3)
begin
insert into @TblBanHang(id,merchant_code,mearchant_name,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.sub_agent_id = @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id
--------------------------------------tra hang-------------------
insert into @TblTraHang(id,merchant_code,mearchant_name,total_quantity_return,total_amout_return)
SELECT A.id, A.merchant_code,A.merchant_name,ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.sub_agent_id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id
end
--4 MERCHATN
if(@Level=4)
begin
insert into @TblBanHang(id,merchant_code,mearchant_name,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.id = @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id
--------------------------------------tra hang-------------------
insert into @TblTraHang(id,merchant_code,mearchant_name,total_quantity_return,total_amout_return)
SELECT A.id, A.merchant_code,A.merchant_name,ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id
end
---join bang
SELECT bh.id, BH.mearchant_name,BH.merchant_code,BH.total_quantity_sale,TH.total_quantity_return,
bh.total_amout_sale,TH.total_amout_return
FROM @TblBanHang AS BH JOIN @TblTraHang AS TH ON BH.id = TH.id
--END
END


GO

-- ----------------------------
-- Procedure structure for sp_sel_list_Transaction_By_Merchantinfo_Cardtype
-- ----------------------------
DROP PROCEDURE [dbo].[sp_sel_list_Transaction_By_Merchantinfo_Cardtype]
GO
CREATE PROC [dbo].[sp_sel_list_Transaction_By_Merchantinfo_Cardtype]
@Search varchar(max)='',
@MerchantType int = 0,
@Region nvarchar(max) ='',
@Level int =0,
@Code int =0,
@TuNgay datetime,
@DenNgay datetime
AS
BEGIN
DECLARE @TblTemp table(KeyID int)
DECLARE  @v_iIndex int =CHARINDEX(',',@Region)
IF(@v_iIndex=0)
BEGIN
		INSERT INTO @TblTemp(KeyID) VALUES(@Region)
		
END
ELSE
BEGIN
WHILE(ISNULL(@v_iIndex,0)>0)
 BEGIN

         INSERT INTO @TblTemp(KeyID) VALUES(SUBSTRING(@Region,0,CHARINDEX(',',@Region)))
         SET @Region = SUBSTRING(@Region,@v_iIndex+1,LEN(@Region)-1)
		 SET @v_iIndex =CHARINDEX(',',@Region)
		 IF(@v_iIndex=0)
		 BEGIN
		    INSERT INTO @TblTemp(KeyID) VALUES(@Region)
		 END
 END
END
DECLARE @TblBanHang table(id int , mearchant_name nvarchar(max),merchant_code nvarchar(max), card_type int,total_quantity_sale int, total_amout_sale float)
DECLARE @TblTraHang table(id int , mearchant_name nvarchar(max),merchant_code nvarchar(max),card_type int,total_quantity_return int, total_amout_return float)

---1 MASTER
if(@Level=1)
begin
--------ban hang
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,B.card_type, isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.master_id = @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
--------------------------------------tra hang-------------------
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT A.id, A.merchant_code,A.merchant_name,B.card_type,ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.master_id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
end
--2 AGENT
if(@Level=2)
begin
--------ban hang
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,B.card_type,isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.agent_id= @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
--------------------------------------tra hang-------------------
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT A.id, A.merchant_code,A.merchant_name,B.card_type,ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.agent_id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
end
--3 SUB AGETN
if(@Level=3)
begin
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,B.card_type,isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.sub_agent_id = @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
--------------------------------------tra hang-------------------
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT A.id, A.merchant_code,A.merchant_name,B.card_type,ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.sub_agent_id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
end
--4 MERCHATN
if(@Level=4)
begin
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT  A.id, A.merchant_code,A.merchant_name,B.card_type,isnull(sum( b.product_quantity),0) as total_quantity,isnull(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.id = @code
and B.transaction_type =1
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
--------------------------------------tra hang-------------------
insert into @TblBanHang(id,merchant_code,mearchant_name,card_type,total_quantity_sale,total_amout_sale)
SELECT A.id, A.merchant_code,A.merchant_name,B.card_type,  ISNULL(sum( b.product_quantity),0) as total_quantity,ISNULL(sum(b.product_price*b.product_quantity),0) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region='')
and (type_id = @MerchantType OR @MerchantType=0)
AND A.id = @code
and B.transaction_type = 2
GROUP BY A.merchant_code,A.merchant_name,A.id,B.card_type
end
---join bang
SELECT A.*, b.total_quantity_return,b.total_amout_return
FROM @TblBanHang AS A LEFT JOIN @TblTraHang AS B ON  A.id = B.id
END



GO

-- ----------------------------
-- Procedure structure for SP_TEST
-- ----------------------------
DROP PROCEDURE [dbo].[SP_TEST]
GO
CREATE PROC [dbo].[SP_TEST]
@SEARCH VARCHAR(50)
AS
BEGIN
SELECT * FROM merchants AS A
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='') 
END
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
-- Indexes structure for table merchant_type
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table merchant_type
-- ----------------------------
ALTER TABLE [dbo].[merchant_type] ADD PRIMARY KEY ([id])
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
-- Indexes structure for table parameters
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table parameters
-- ----------------------------
ALTER TABLE [dbo].[parameters] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table thongbao
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table thongbao
-- ----------------------------
ALTER TABLE [dbo].[thongbao] ADD PRIMARY KEY ([id])
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
-- Indexes structure for table transactions
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table transactions
-- ----------------------------
ALTER TABLE [dbo].[transactions] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [dbo].[users] ADD PRIMARY KEY ([id])
GO
