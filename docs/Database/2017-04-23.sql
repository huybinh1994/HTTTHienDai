/*
Navicat SQL Server Data Transfer

Source Server         : SQLSERVER
Source Server Version : 110000
Source Host           : DESKTOP-OCG5DRO\SQLEXPRESS:1433
Source Database       : card_processing
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2017-04-23 07:09:13
*/
create database card_processing
GO
use card_processing
GO

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
-- Table structure for merchants
-- ----------------------------
DROP TABLE [dbo].[merchants]
GO
CREATE TABLE [dbo].[merchants] (
[id] int NOT NULL IDENTITY(1,1) ,
[merchant_code] char(20) NULL ,
[merchant_name] int NULL ,
[merchant_phone_call] int NULL ,
[tax_code] int NULL ,
[master_id] int NULL ,
[agent_id] int NULL ,
[sub_agent_id] int NULL ,
[address_1] nvarchar(100) NULL ,
[address_2] nvarchar(100) NOT NULL ,
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
[merchant_id] int NULL ,
[product_id] int NULL ,
[product_quality] int NULL ,
[product_price] decimal(18) NULL ,
[file_source] varchar(255) NULL ,
[batch_number] varchar(255) NULL ,
[status] int NULL
)


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
-- Indexes structure for table parameters
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table parameters
-- ----------------------------
ALTER TABLE [dbo].[parameters] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table transaction
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table transaction
-- ----------------------------
ALTER TABLE [dbo].[transaction] ADD PRIMARY KEY ([id])
GO
