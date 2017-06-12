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

Date: 2017-06-12 05:37:19
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
-- Table structure for masters
-- ----------------------------
DROP TABLE [dbo].[masters]
GO
CREATE TABLE [dbo].[masters] (
[id] int NOT NULL IDENTITY(1,1) ,
[master_name] nvarchar(200) NULL ,
[auther_id] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[masters]', RESEED, 2)
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
[master_id] int NULL ,
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

-- ----------------------------
-- Table structure for notes
-- ----------------------------
DROP TABLE [dbo].[notes]
GO
CREATE TABLE [dbo].[notes] (
[id] int NOT NULL IDENTITY(1,1) ,
[tieude] nvarchar(250) NULL ,
[noidung] nvarchar(MAX) NULL ,
[nguoi_goi] int NULL ,
[nguoi_nhan] int NULL ,
[level_nguoi_goi] int NULL ,
[level_nguoi_nhan] int NULL ,
[ngaytao] datetime NULL 
)


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
[transaction_type] int NULL DEFAULT '' 
)


GO
DBCC CHECKIDENT(N'[dbo].[transactions]', RESEED, 100000)
GO

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE [dbo].[users]
GO
CREATE TABLE [dbo].[users] (
[username] varchar(50) NULL ,
[password] varchar(64) NULL ,
[fullname] varchar(50) NULL ,
[flag] int NULL ,
[id] int NOT NULL IDENTITY(1,1) ,
[active] int NULL 
)


GO

-- ----------------------------
-- Procedure structure for sp_sel_list_Transaction_By_MerchantInfo
-- ----------------------------
DROP PROCEDURE [dbo].[sp_sel_list_Transaction_By_MerchantInfo]
GO
Create PROC [dbo].[sp_sel_list_Transaction_By_MerchantInfo]
@Search varchar(max)='',
@MerchantType int = 0,
@Region nvarchar(max) =0,
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
---1 MASTER
if(@Level=1)
begin
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType OR @MerchantType=0)
AND A.master_id = @code
GROUP BY A.merchant_code,A.merchant_name
end
--2 AGENT
if(@Level=2)
begin
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType OR @MerchantType=0)
and a.agent_id=@code
GROUP BY A.merchant_code,A.merchant_name
end
--3 SUB AGETN
if(@Level=3)
begin
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType OR @MerchantType=0)
AND A.sub_agent_id= @code
GROUP BY A.merchant_code,A.merchant_name
end
--4 MERCHATN
if(@Level=4)
begin
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType OR @MerchantType=0)
AND A.id = @code
GROUP BY A.merchant_code,A.merchant_name
end

--END
END

GO

-- ----------------------------
-- Procedure structure for sp_sel_list_Transaction_By_Merchantinfo_Cardtype
-- ----------------------------
DROP PROCEDURE [dbo].[sp_sel_list_Transaction_By_Merchantinfo_Cardtype]
GO
Create PROC [dbo].[sp_sel_list_Transaction_By_Merchantinfo_Cardtype]
@Search varchar(max)='',
@MerchantType int = 0,
@Region nvarchar(max) =0,
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
--if 1 master
if(@Level=1)
BEGIN
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name, b.card_type as card_type,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType or @MerchantType =0)
and A.master_id = @Code
GROUP BY A.merchant_code,A.merchant_name,B.card_type
END
IF(@Level =2)
BEGIN
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name, b.card_type as card_type,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType or @MerchantType =0)
and A.agent_id = @Code
GROUP BY A.merchant_code,A.merchant_name,B.card_type
END
IF(@Level =3)
BEGIN
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name, b.card_type as card_type,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType or @MerchantType =0)
and A.sub_agent_id = @Code
GROUP BY A.merchant_code,A.merchant_name,B.card_type
END
IF(@Level =4)
BEGIN
SELECT  ROW_NUMBER()OVER(ORDER BY sum(b.product_price*b.product_quantity) DESC ) as STT, A.merchant_code,A.merchant_name, b.card_type as card_type,sum( b.product_quantity) as total_quantity,sum(b.product_price*b.product_quantity) as total_amount
FROM merchants AS A LEFT JOIN transactions AS B ON A.merchant_code = B.merchant_code
WHERE (A.merchant_name like '%'+@Search+'%' OR @Search='')
OR (A.merchant_code like '%'+@Search+'%' OR @Search='')
AND (a.province IN (SELECT KeyID from @TblTemp) or @Region = 0)
and (type_id = @MerchantType or @MerchantType =0)
and A.id = @Code
GROUP BY A.merchant_code,A.merchant_name,B.card_type
END
--END
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
-- Indexes structure for table notes
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table notes
-- ----------------------------
ALTER TABLE [dbo].[notes] ADD PRIMARY KEY ([id])
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
