USE [Workshop2]
GO
/****** Object:  Table [dbo].[tbl_Mobile]    Script Date: 16/04/2024 1:54:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Mobile](
	[mobileId] [varchar](10) NOT NULL,
	[description] [nvarchar](max) NULL,
	[price] [float] NULL,
	[mobileName] [varchar](20) NOT NULL,
	[yearOfProduction] [int] NULL,
	[quantity] [int] NULL,
	[notSale] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[mobileId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Users]    Script Date: 16/04/2024 1:54:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Users](
	[userId] [varchar](20) NOT NULL,
	[password] [int] NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[role] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'12', N'Samsung Galaxy Note 20 Ultra được chế tác từ những vật liệu cao cấp hàng đầu hiện nay, với sự tỉ mỉ và chất lượng gia công thượng thừa, tạo nên chiếc điện thoại đẹp hơn những gì bạn có thể tưởng tượng.', 140, N'galaxy KKK', 2022, 12, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'20', N'RedMi 15 - Chiế điện thoại chụp hình cực đẹp', 25, N'REDMI 151', 2003, 20, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'3', N'OPPO Reno4 - Chiếc điện thoại với cấu hình mạnh mẽ và công nghệ sạc siêu nhanh sẽ giúp bạn có được hiệu suất cao để trải nghiệm những điều thú vị trong cuộc sống, nhất là trên bộ tứ camera đẳng cấp cùng thiết kế từ nhà OPPO mà ai cũng phải ngước nhìn.

', 1230, N'oppo find x series', 2024, 60, NULL)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'4', N'OPPO Reno4 - Chiếc điện thoại với cấu hình mạnh mẽ và công nghệ sạc siêu nhanh sẽ giúp bạn có được hiệu suất cao để trải nghiệm những điều thú vị trong cuộc sống, nhất là trên bộ tứ camera đẳng cấp cùng thiết kế từ nhà OPPO mà ai cũng phải ngước nhìn.

', 120, N'oppo find x series', 2002, 60, NULL)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'5', N'OPPO Reno4 - Chiếc điện thoại với cấu hình mạnh mẽ và công nghệ sạc siêu nhanh sẽ giúp bạn có được hiệu suất cao để trải nghiệm những điều thú vị trong cuộc sống, nhất là trên bộ tứ camera đẳng cấp cùng thiết kế từ nhà OPPO mà ai cũng phải ngước nhìn.

', 140, N'oppo find x series', 2014, 60, NULL)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'6', N'OPPO Reno4 - Chiếc điện thoại với cấu hình mạnh mẽ và công nghệ sạc siêu nhanh sẽ giúp bạn có được hiệu suất cao để trải nghiệm những điều thú vị trong cuộc sống, nhất là trên bộ tứ camera đẳng cấp cùng thiết kế từ nhà OPPO mà ai cũng phải ngước nhìn.

', 200, N'oppo find x series', 2024, 60, NULL)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'7', N'OPPO Reno4 - Chiếc điện thoại với cấu hình mạnh mẽ và công nghệ sạc siêu nhanh sẽ giúp bạn có được hiệu suất cao để trải nghiệm những điều thú vị trong cuộc sống, nhất là trên bộ tứ camera đẳng cấp cùng thiết kế từ nhà OPPO mà ai cũng phải ngước nhìn.

', 222, N'oppo find x series', 2015, 60, NULL)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'8', N'Samsung Galaxy Note 20 Ultra được chế tác từ những vật liệu cao cấp hàng đầu hiện nay, với sự tỉ mỉ và chất lượng gia công thượng thừa, tạo nên chiếc điện thoại đẹp hơn những gì bạn có thể tưởng tượng.', 10, N'Galaxy Z series', 2005, 12, NULL)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'9', N'Cáº§m náº¯m nhá» gá»n, mÃ¡y ÄÃ¡p á»©ng nhu cáº§u dÃ¹ng hÃ¬nh cá»§a mÃ¬nh cá»±c tá»t', 301, N'Iphone 154', 2004, 12, 0)
GO
INSERT [dbo].[tbl_Users] ([userId], [password], [fullName], [role]) VALUES (N'U001', 1, N'Lương Quốc Triệu', 1)
INSERT [dbo].[tbl_Users] ([userId], [password], [fullName], [role]) VALUES (N'U002', 1, N'Nguyễn Lâm Bảo Uyên', 2)
INSERT [dbo].[tbl_Users] ([userId], [password], [fullName], [role]) VALUES (N'U003', 1, N'Trần Thành Đạt', 0)
INSERT [dbo].[tbl_Users] ([userId], [password], [fullName], [role]) VALUES (N'U004', 1, N'Trần Thị Như Hương', 1)
GO
