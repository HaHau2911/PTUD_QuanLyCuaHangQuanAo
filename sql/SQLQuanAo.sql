create database [QuanLyCuaHangQuanAo]

USE [QuanLyCuaHangQuanAo]
GO
/**/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[TaiKhoan](
	[maNV] [nvarchar](10) NOT NULL,
	[pass] [nvarchar](50) NOT NULL,
  CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tour]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [nvarchar](10) NOT NULL,
	[tenNCC] [nvarchar](50) NOT NULL,
	[noiSX] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tour]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [nvarchar](10) NOT NULL,
	[tenKH] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[soDT] [nvarchar](50) NOT NULL,
	[cmnd] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tour]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiNhanVien](
	[maLoaiNV] [nvarchar](10) NOT NULL,
	[tenLoaiNV] [nvarchar](50) NOT NULL,
	[mucLuong] [float] NOT NULL,
 CONSTRAINT [PK_LoaiNhanVien] PRIMARY KEY CLUSTERED 
(
	[maLoaiNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tour]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](10) NOT NULL,
	[tenNV] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[soDT] [nvarchar](50) NOT NULL,
	[cmnd] [nvarchar](50) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[maLoaiNV] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ve]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[maLoaiSP] [nvarchar](10) NOT NULL,
	[tenLoaiSP] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[maLoaiSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tour]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSP] [nvarchar](10) NOT NULL,
	[tenSP] [nvarchar](50) NOT NULL,
	[gia] [float] NOT NULL,
	[moTa] [nvarchar](max) NULL,
	[trangThai] [bit] NOT NULL,
	[hinhAnh] [nvarchar](100) NULL,
	[maLoaiSP] [nvarchar](10) NOT NULL,
	[soLuong] [int]NOT NULL,
	[maNCC] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ve]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](10) NOT NULL,
	[maNV] [nvarchar](10) NOT NULL,
	[maKH] [nvarchar](10) NOT NULL,
	[ngayLap] [date] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tour]    Script Date: 5/23/2021 2:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHD] [nvarchar](10) NOT NULL,
	[maSP] [nvarchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
 PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

insert into [dbo].[LoaiNhanVien] ([maLoaiNV], [tenLoaiNV], [mucLuong]) values (N'LNV001',N'Quản Lý',12000000)
insert into [dbo].[LoaiNhanVien] ([maLoaiNV], [tenLoaiNV], [mucLuong]) values (N'LNV002',N'Thu Ngân',8500000)
insert into [dbo].[LoaiNhanVien] ([maLoaiNV], [tenLoaiNV], [mucLuong]) values (N'LNV003',N'Giao hàng',9000000)


insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV001',N'Lê Thị Thanh Thư',N'thanhthu@gmail.com',N'4/Nguyễn Văn Bảo/Gò Vấp',N'0969177841',N'255652631',1,0,N'LNV001')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV002',N'Nguyễn Văn Bằng',N'vanbang@gmail.com',N'45/5 Nguyễn Hữu Trí',N'0362154123',N'285611621',1,1,N'LNV003')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV003',N'Phạm Thuý Anh',N'thuyanh@gmail.com',N'639 Nơ Trang Long',N'077862623',N'265631633',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV004',N'Phương Lý Bảo Hân',N'baohan@gmail.com',N'96/2 Phan Đăng Lưu',N'0965478213',N'274166311',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV005',N'Phạm Hà Nhị Hùng',N'nhihung@gmail.com',N'78/1/5 Nguyễn Kiệm',N'0333965842',N'296445444',1,1,N'LNV003')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV006',N'Phương Thị Lan Hương',N'lanhuong@gmail.com',N'55 Võ Chí Công',N'0396541258',N'231663664',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV007',N'Lê Thị Kim Ngân',N'kimngan@gmail.com',N'175/25/2 Lạc Long Quân',N'077236985',N'244664632',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV008',N'Vũ Ngọc Tú',N'ngoctu@gmail.com',N'15 Cách Mạng T8',N'0362952962',N'299663667',1,1,N'LNV001')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV009',N'Trần Thị Phương Vy',N'phuongvy@gmail.com',N'115 Trích Sài',N'0963336331',N'258625652',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV010',N'Nguyễn Trần Quốc Bảo',N'quocbao@gmail.com',N'85/99/3 Nguyễn Văn Huyên',N'0772564123',N'285697631',1,1,N'LNV003')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV011',N'Trương Tuấn Kiệt',N'tuankiet@gmail.com',N'7 Chùa Hà',N'0965214862',N'213556879',1,1,N'LNV003')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV012',N'Bùi Phúc Nguyên',N'phucnguyen@gmail.com',N'81 Nguyễn Đỗ Cung',N'0326999541',N'256997449',1,1,N'LNV003')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV013',N'Liên Ngọc Nhi',N'ngocnhi@gmail.com',N'559/3/6 Trần Đăng Ninh',N'0312547895',N'235641978',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV014',N'Thạch Thị Thanh Thảo',N'thanhthao@gmail.com',N'78 Dịch Vọng',N'0399552555',N'278963145',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV015',N'Nguyễn Thị Kim Ngọc',N'kimngoc@gmail.com',N'15 Tô Ký',N'0362626258',N'288635974',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV016',N'Lương Trung Nguyên',N'trungnguyen@gmail.com',N'99/9/6 Trần Thái Tông',N'0778563254',N'298663145',1,1,N'LNV003')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV017',N'Phạm Thanh Phương',N'thanhphuong@gmail.com',N'18 Xuân Thuỷ',N'0981456741',N'271236457',1,1,N'LNV003')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV018',N'Võ Nguyễn Hoàng Ngọc',N'hoangngoc@gmail.com',N'88/5 Phạm Hùng',N'0952652622',N'249631754',1,0,N'LNV002')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV019',N'Bùi Thục Đoan',N'thucdoan@gmail.com',N'2 Trần Bình',N'0377445885',N'298654325',1,0,N'LNV001')
insert into [dbo].[NhanVien] ([maNV], [tenNV], [email], [diaChi], [soDT], [cmnd], [trangThai], [gioiTinh], [maLoaiNV]) values (N'NV020',N'Lê Ngọc Vân',N'ngocvan@gmail.com',N'71/5 Nguyễn Hoàng',N'0963666111',N'215634789',1,0,N'LNV001')



insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV001',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV002',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV003',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV004',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV005',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV006',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV007',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV008',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV009',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV010',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV011',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV012',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV013',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV014',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV015',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV016',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV017',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV018',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV019',N'123456')
insert into [dbo].[TaiKhoan] ([maNV], [pass]) values (N'NV020',N'123456')



insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC001',N'Louis Vuitton',N'Pháp')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC002',N'Dior',N'Pháp')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC003',N'BOBUI',N'Việt Nam')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC004',N'Gucci',N'Ý')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC005',N'Prada',N'Ý')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC006',N'Burberry',N'USA')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC007',N'Dolce & Gabbana',N'Ý')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC008',N'VietTien',N'Việt Nam')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC009',N'Grimm DC ',N'Việt Nam')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC010',N'ClownZ ',N'Việt Nam')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC011',N'GORI',N'Việt Nam')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC012',N'Freakers',N'Việt Nam')
insert into [dbo].[NhaCungCap] ([maNCC], [tenNCC], [noiSX]) values (N'NCC013',N'Celeb Store',N'Việt Nam')



insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00001',N'Hà Thị Nhân Hậu',N'nhanhau@gmail.com',N'118 đường số 20 P5 Gò Vấp',N'0778500760',N'285652622',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00002',N'Lê Văn Đức Anh',N'ducanh@gmail.com',N'12 Nguyễn Văn Vảo',N'0956325874',N'265935877',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00003',N'Lù Gia Bảo',N'giabao@gmail.com',N'225 Trường Chinh',N'0969177458',N'265963125',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00004',N'Huỳnh Thị Trang Đài',N'trangdai@gmail.com',N'285 Quang Trung',N'077562365',N'295684123',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00005',N'Nguyễn Thành Đạt',N'thanhdat@gmail.com',N'265/45 Lê Đức Thọ',N'0985625412',N'225632125',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00006',N'Phạm Đào Cao',N'daocao@gmail.com',N'256/4/ Lý Chính Thắng',N'0778563152',N'215698742',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00007',N'Nguyễn Võ Thiên Hà',N'thienha@gmail.com',N'25/45/2 Nam Kỳ Khởi Nghĩa',N'0963852147',N'225639874',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00008',N'Phan Thanh Hậu',N'thanhhau@gmail.com',N'77 Lê Lợi',N'0978523614',N'295631478',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00009',N'Trịnh Quốc Hoàng',N'quochoang@gmail.com',N'45/1/28 Dương Quảng Hàm',N'0963963632',N'236547852',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00010',N'Nguyễn Thị Huyền',N'nguyenhuyen@gmail.com',N'256 QL1A',N'0778965234',N'265256266',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00011',N'Võ Thị Thuỳ Trang',N'thuytrang@gmail.com',N'22/1 Lạc Long Quân',N'0356921456',N'285632631',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00012',N'Phạm Hữu Thẩm',N'huutham@gmail.com',N'25/25/8 Võ Chí Công',N'0312965874',N'285632633',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00013',N'Nguyễn Đặng Hoàng Thi',N'hoangthi@gmail.com',N'56 Xuân La',N'0321987456',N'285632644',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00014',N'Hoàng Ngọc Thuỵ',N'ngocthuy@gmail.com',N'96 Nguyễn Hoàng Tôn',N'0369698542',N'285631699',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00015',N'Đoàn Bá Tiên',N'batien@gmail.com',N'6/256/3 Phạm Ngũ Lão',N'0975624123',N'285634677',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00016',N'Nguyễn Ngọc Hân',N'ngochan@gmail.com',N'1 Nguyễn Văn Lượng',N'0968562311',N'285695699',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00017',N'Nguyễn Chí Tôn',N'chiton@gmail.com',N'15 Nguyễn Văn Công',N'0369232255',N'285633641',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00018',N'Bùi Bình Minh',N'binhminh@gmail.com',N'256 đường số 20',N'0332665669',N'296322355',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00019',N'Đặng Trần Nghiêm',N'trannghiem@gmail.com',N'15 đường số 7',N'0966551558',N'296322355',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00020',N'Võ Đỗ Hoàng Nhật',N'hoangnhat@gmail.com',N'85 Đông Ngạc',N'077966554',N'296351369',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00021',N'Nguyễn Thị Hải Duyên',N'haiduyen@gmail.com',N'5 Tân Xuân',N'0326666363',N'296354355',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00022',N'Lê Tấn Phúc',N'tanphuc@gmail.com',N'55 Dịch Vọng',N'0325589993',N'296388388',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00023',N'Nguyễn Thị Lan Anh',N'lananh@gmail.com',N'79/56/8 Hồ Tùng Mậu',N'0766333636',N'296344378',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00024',N'Lê Minh Khôi',N'minhkhoi@gmail.com',N'85/1/9/78 Hàm Nghi',N'0362626353',N'296355367',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00025',N'Phạm Hoàng Gia Khôi',N'giakhoi@gmail.com',N'97 Nguyễn Hoàng',N'0369963354',N'296351399',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00026',N'Đoàn Tuấn Vỹ',N'tuanvy@gmail.com',N'77/7 Xuân Thuỷ',N'0785552663',N'296381832',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00027',N'Lưu Hoàng Vương',N'hoangvuong@gmail.com',N'25 Cầu Giấy',N'0369696526',N'225332332',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00028',N'Nguyễn Anh Tuấn',N'anhtuan@gmail.com',N'66/3 Thành Thái',N'0963333222',N'225366321',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00029',N'Lê Ngọc Thuỵ',N'ngocthuy@gmail.com',N'45/12 Dương Đình Nghệ',N'0985685625',N'225363397',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00030',N'Trần Thanh Tịnh',N'thanhtinh@gmail.com',N'23 Hoa Băng',N'077563365',N'225398399',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00031',N'Phạm Hồng Thái',N'hongthai@gmail.com',N'8 Nguyễn Chánh',N'03287789856',N'225399399',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00032',N'Phạm Hữu Thẩm',N'huutham@gmail.com',N'8/8/15 La Thành',N'03425698658',N'225365378',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00033',N'Ngô Đức Tài',N'ductai@gmail.com',N'18 Trúc Khê',N'0933225223',N'225314344',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00034',N'Hồ Tất Minh Tâm',N'minhtam@gmail.com',N'75 Thái Hà',N'0347478854',N'225378388',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00035',N'Nguyễn Duy Thạch',N'duythach@gmail.com',N'15/15/9 Lương Thế Vinh',N'0395685965',N'225398378',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00036',N'Hoàng Văn Duy Sang',N'duysang@gmail.com',N'9/9/9 Lê Quang Đạo',N'0325748715',N'225314375',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00037',N'Phạm Trung Sơn',N'trungson@gmail.com',N'2 Quang Tiến',N'0985271496',N'22599398',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00038',N'Đỗ Trương Vỹ Kỳ',N'vyky@gmail.com',N'5 Phương Canh',N'0369697961',N'225987966',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00039',N'Dương Đình Hùng',N'dinhhung@gmail.com',N'7 Thanh Lâm',N'0715932145',N'241633699',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00040',N'Lê Thị Huyền',N'lehuyen@gmail.com',N'17/7 Tôn Quang Phiệt',N'0376985142',N'241556553',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00041',N'Hoàng Văn Hiếu',N'hoanghieu@gmail.com',N'88/9 Phạm Tuấn Tài',N'03556265987',N'241533521',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00042',N'Trần Văn Sỹ',N'transy@gmail.com',N'15/2 Tôn Đức Thắng',N'0963362214',N'241256258',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00043',N'Đoàn Mạnh Duy',N'manhduy@gmail.com',N'17/9/36 Đường 3/2',N'0388559558',N'241397399',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00044',N'Nguyễn Thị Chúc Duyên',N'chucduyen@gmail.com',N'6 Lý Chính Thắng',N'0752369852',N'241388389',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00045',N'Lưu Thị Yến Nhi',N'yennhi@gmail.com',N'23 Lý Thái Tổ',N'0715236459',N'241359395',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00046',N'Lê Thị Ánh Tuyết',N'anhtuyet@gmail.com',N'255 Lê Hồng Phong',N'0369528145',N'241366563',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00047',N'Huỳnh Công Hữu',N'conghuu@gmail.com',N'115/25/9 Điện Biên Phủ',N'0366225228',N'241123563',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00048',N'Nguyễn Văn Hùng',N'vanhung@gmail.com',N'18 Trần Quang Diệu',N'0315229741',N'241896754',1)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00049',N'Nguyễn Thị Trà My',N'tramy@gmail.com',N'9 Ngọc Khánh',N'0965888553',N'241186523',0)
insert into [dbo].[KhachHang] ([maKH], [tenKH], [email], [diaChi], [soDT], [cmnd], [gioiTinh]) values (N'KH00050',N'Hà Trọng Nhân',N'trongnhan@gmail.com',N'10/5 Giảng Võ',N'0363225974',N'241532987',1)


insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP01',N'Áo Khoác')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP02',N'Áo Thun')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP03',N'Áo Sơ Mi')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP04',N'Quần Jeans')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP05',N'Quần Tây')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP06',N'Quần Short')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP07',N'Váy')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP08',N'Chân Váy')
insert into [dbo].[LoaiSanPham] ([maLoaiSP], [tenLoaiSP]) values (N'LSP09',N'Quần thun')



insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP001',N'Áo sơ mi lụa crepe GG',36000000,N'Có chất liệu bằng lụa nhân tạo',1,N'hinhAnh\\1.Ao-so-mi-lua.png',N'LSP03',10,N'NCC004')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP002',N'DIORALPS ZIPPED JACKET',39200000,N'Được chế tác trong áo kỹ thuật Dior Oblique màu đen, áo lót kỹ thuật trượt tuyết được phân biệt bởi hình dáng vừa vặn ',1,N'hinhAnh\\2.DIORALPS-ZIPPED-JACKET.png',N'LSP01',7,N'NCC002')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP003',N'QUẦN THỂ THAO *ANGEL* THÊU',650000,N'100% cotton - sợi bông, phong cách đường phố, hoạ tiết thiên thần thêu vi tính',1,N'hinhAnh\\3.QUẦN-THỂ-THAO-ANGEL-THÊU.png',N'LSP09',20,N'NCC012')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP004',N'ÁO PULL CHỮ V CỔ CHỮ V QUÁ KHỔ',35000000,N'50% nylon, 38% Viscose, 12% len,Kích thước quá khổ',1,N'hinhAnh\\4.ÁO-PULL-CHỮ-V-CỔ-CHỮ-V-QUÁ-KHỔ.png',N'LSP02',15,N'NCC003')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP005',N'Cady váy lông vũ',35600000,N'nổi bật với đường nét lai của nó. Các lực đẩy trên ngực và vai tạo nên một hình bóng mạnh mẽ kết hợp với cảm giác linh hoạt của vải, tạo ra một thiết kế sáng tạo. Phần cổ được trang trí bằng những chiếc đính lông vũ gợi lại nét thẩm mỹ thời trang cao cấp cho một nét tinh xảo.',1,N'hinhAnh\\5.Cady-váy-lông-vũ.png',N'LSP07',12,N'NCC005')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP006',N'Áo phông quá khổ Oak Leaf Crest Cotton',10500000,N'Áo thun đen ',1,N'hinhAnh\\6.Áo-phông-quá-khổ-Oak-Leaf-Crest-Cotton.png',N'LSP02',25,N'NCC009')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP007',N'Áo khoác jersey kỹ thuật hai bên ngực',27700000,N'Tỷ lệ, khối lượng và đường thẳng là những khái niệm chính của bộ sưu tập này',1,N'hinhAnh\\7.Áo-khoác-jersey-kỹ-thuật-hai-bên-ngực.png',N'LSP01',5,N'NCC006')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP008',N'ÁO VEST 8G9016CT2 / B12',2340000,N'giúp quý ông luôn lịch lãm, chuyên nghiệp, sang trọng và thoải mái khi gặp gỡ hoặc tham dự các sự kiện trang trọng.',1,N'hinhAnh\\8.ÁO-VEST-8G9016CT2.png',N'LSP01',30,N'NCC008')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP009',N'Flex shorts // Black',340000,N'100% sợi tổng hợp Polyester với công nghệ dệt sợi dọc,Co giãn cực tốt, mỏng nhưng không xuyên thấu, nhẹ nhưng vẫn đứng form, thấm hút mồ hôi tốt.',1,N'hinhAnh\\9.Flex-shorts.png',N'LSP06',25,N'NCC012')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP010',N'CLOWNZ LEOPARD PUFFER JACKET',699000,N'Chất gió chần bông,Cảm hứng thiết kế: Hoạ tiết da báo với phối màu bắt mặt. Chữ CLOWNZ được in chuyển nhiệt ở mặt trước và sau. Hình thêu C-Star ở mặt trong phù hợp mặc cả hai mặt.',1,N'hinhAnh\\10.CLOWNZ-LEOPARD-PUFFER-JACKET.png',N'LSP02',35,N'NCC003')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP011',N'Basic Tee / Trắng',153000,N'Basic Trắng',1,N'hinhAnh\\11.Basic Tee.png',N'LSP02',35,N'NCC003')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP012',N'WAIFU T - ÁO SƠ MI',380000,N'Áo Sơ mi trắng waifi',1,N'hinhAnh\\12.WAIFU-T-ÁO-SƠ-MI.png',N'LSP02',20,N'NCC013')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP013',N'Áo Vest Nam Màu Xanh Đậm 9VC15',1200000,N'Áo Vest Nam Màu Xanh Đậm 9VC15.Màu Sắc: Xanh.Size: M, L, XL, XXL.',1,N'hinhAnh\\13.Áo-Vest-Nam-Màu-Xanh-Đậm-9VC15.png',N'LSP01',12,N'NCC008')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP014',N'Áo sơ mi vải tuyn và ren',39000000,N'Chiếc áo sơ mi này được làm bằng vải tuyn và ren đen mờ với đường viền cổ cao thanh lịch và tay áo phồng.',1,N'hinhAnh\\14.Áo-sơ-mi-vải-tuyn-và-ren.png',N'LSP03',5,N'NCC005')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP015',N'MŨ TRÙM ĐẦU KỸ THUẬT TẦN SỐ LV',49000000,N'hiếc áo blouson có mũ trùm đầu không thấm nước, được dán băng đầy đủ',1,N'hinhAnh\\15.MŨ-TRÙM-ĐẦU-KỸ-THUẬT-TẦN-SỐ-LV.png',N'LSP01',7,N'NCC001')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP016',N'ÁO TAY NGẮN',41000000,N'Chiếc áo sơ mi ngắn tay được tô điểm bằng toàn bộ bản in CD Étoile, tái hiện lại một trong những biểu tượng được yêu mến của Dior.',1,N'hinhAnh\\16.ÁO-TAY-NGẮN.png',N'LSP02',25,N'NCC003')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP017',N'Áo Hoodie Monogram Motif Cotton',12900000,N'Một chiếc áo hoodie cổ điển có chất liệu cotton quấn ngược hữu cơ, có in họa tiết Monogram nổi lên.',1,N'hinhAnh\\17.Áo-Hoodie-Monogram-Motif-Cotton.png',N'LSP01',20,N'NCC003')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP018',N'Váy jersey kỹ thuật với vải tuyn xù',2650000,N'Những bộ trang phục với sự quyến rũ hiện đại, chẳng hạn như chiếc váy jersey kỹ thuật vừa vặn với lớp vải tuyn xù này, sẽ mang đến cho bạn vẻ ngoài cá tính không thể nhầm lẫn.',1,N'hinhAnh\\18.Váy-jersey-kỹ-thuật-với-vải-tuyn-xù.png',N'LSP07',10,N'NCC001')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP019',N'Áo len cổ lọ bông',29000000,N'Chiếc áo len cotton cắt xén này có kiểu dáng hiện đại, linh hoạt. Logo hình tam giác intarsia nổi bật ở mặt trước.',1,N'hinhAnh\\19.Áo-len-cổ-lọ-bông.png',N'LSP02',12,N'NCC005')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP020',N'IDENTITY BIG POCKET SHORT (ĐEN)',350000,N'Sản phẩm nằm trong bộ sưu tập mini mùa thu 2022 - “IDENTITY”..Chất liệu: gió, lưới.Form rộng rãi, thoải mái.Bên trong quần áo 2 có khóa kéo, túi bên dưới có dây rút, tiện để cất đồ.Logo Indetity thêu nổi',1,N'hinhAnh\\20.IDENTITY-BIG-POCKET-SHORT(ĐEN).png',N'LSP06',20,N'NCC012')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP021',N'Flex pants // Beige',390000,N'Flexible bên trong, flexin’ bên ngoài.sử dụng trong mọi tình huống. Thể thao trên sân. Bay nhảy ngoài trời. Vội vã trong nhà.',1,N'hinhAnh\\21.Flex-pants.png',N'LSP09',15,N'NCC012')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP022',N'ÁO KHOÁC DÂY KÉO *ANGEL* THÊU',750000,N'100% COTTON – SỢI BÔNG.HỌA TIẾT THIÊN THẦN THÊU VI TÍNH.DÂY KÉO NHỰA HKK',1,N'hinhAnh\\22.ÁO-KHOÁC-DÂY-KÉO-ANGEL-THÊU.png',N'LSP01',22,N'NCC012')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP023',N'LEOPARD CAMO MIX SHIRT - BROWN',399000,N'Chất liệu: vải Kate mịn.Form dáng: Relax Fit.Hoạ tiết da báo và camo được phối màu và mix theo từng mảng có chủ ý tạo điểm nhấn.',1,N'hinhAnh\\23.LEOPARD-CAMO-MIX-SHIRT-BROWN.png',N'LSP03',9,N'NCC010')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP024',N'Flannel / Đỏ Mới',261000,N'Ao sơ mi đỏ hàng chính hãng',1,N'hinhAnh\\24.Flannel-Đỏ-Mới.png',N'LSP03',22,N'NCC011')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP025',N'adidas x Gucci jersey dress',28000000,N'chiếc váy jersey này có thêu hình Trefoil của Gucci. adidas và Gucci liên doanh với nhau trong một bộ sưu tập, trong đó Web kết hợp với ba sọc trắng và chữ lồng GG kết hợp với trefoil',1,N'hinhAnh\\25.adidas-x-Gucci-jersey-dress.png',N'LSP07',6,N'NCC004')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP026',N'D-RING TROMPE LOEIL SWEATER DRESS',39500000,N'Được làm từ chất liệu cashmere mềm mại và lộng lẫy trong hình bóng loeil trompe với áo cổ lọ dài tay rộng thùng thình và váy vừa vặn tối giản',1,N'hinhAnh\\26.D-RING-TROMPE-LOEIL-SWEATER-DRESS.png',N'LSP01',5,N'NCC001')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP027',N'ÁO KHOÁC CÓ MŨ TRÙM ĐẦU DIORALPS',25500000,N'Được chế tác bằng vải kỹ thuật chần bông phản quang tông màu bạc, nó có họa tiết Ngôi sao Dior với dải CHRISTIAN DIOR ở mặt sau.',1,N'hinhAnh\\27.ÁO-KHOÁC-CÓ-MŨ-TRÙM-ĐẦU-DIORALPS.png',N'LSP01',8,N'NCC002')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP028',N'Sọc bên cổ điển Kiểm tra quần dài cotton',91000000,N'Quần dài cotton sọc bên màu bee',1,N'hinhAnh\\28.Sọc-bên-cổ-điển-Kiểm-tra-quần-dài-cotton.png',N'LSP09',9,N'NCC006')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP029',N'Áo Sơ Mi Nam Tay Dài Lụa Màu Đỏ 9M21',220000,N'Áo sơ mi nam trắng của CELEB được làm từ lụa tơ tằm Chất liệu vải có bề mặt rất mỏng, mịn',1,N'hinhAnh\\29.Áo-Sơ-Mi-Nam-Tay-Dài-Lụa-Màu-Đỏ-9M21.png',N'LSP03',14,N'NCC011')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP030',N'Áo len có in Gianpiero DAlessandro',29000000,N'áo phông, áo nỉ và hàng dệt kim của chúng tôi, được tạo ra để thể hiện khái niệm gia đình, tình yêu và tất cả các giá trị',1,N'hinhAnh\\30.Áo-len-có-in-Gianpiero-DAlessandro.png',N'LSP01',7,N'NCC007')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP031',N'Áo khoác đôi cắt và áo khoác hoodie nylon',38000000,N'chiếc áo khoác hoodie áo đôi này được đặc trưng bởi sự quyến rũ kỹ thuật của chi tiết nylon ở mặt trước. Viền dây rút hoàn thiện thiết kế.',1,N'hinhAnh\\31.Áo-khoác-đôi-cắt-và-áo-khoác-hoodie-nylon.png',N'LSP01',15,N'NCC005')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP032',N'Áo sơ mi New York // Màu xám kim loại',440000,N'Vải dày, CHỐNG tia cực tím (Anti-UV) tuyệt đối và đứng form.',1,N'hinhAnh\\32.Áo-sơ-mi-New-York-Màu-xám-kim-loại.png',N'LSP03',10,N'NCC011')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP033',N'QUẦN JEAN THẲNG C-STAR',549000,N'Chất liệu: Jeans.Form dáng: Quần ống suông.Logo C-Star được thêu tỉ mỉ, pattern mặt trong gấu quần được xử lý in chuyển nhiệt .Quần bò basic mặc được hai kiểu, phối với nhiều phong cách thời trang',1,N'hinhAnh\\33.QUẦN-JEAN-THẲNG-C-STAR.png',N'LSP04',12,N'NCC010')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP034',N'QUẦN TÂY 8N4161NT5 / QT0D',580000,N'Màu than củi phù hợp cho văn phòng, đi chơi, tiệc',1,N'hinhAnh\\34.QUẦN-TÂY-8N4161NT5.png',N'LSP05',10,N'NCC008')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP035',N'Hoodie GC New - Nâu',522000,N'Áo hoodie màu nâu, chất liệu cotton',1,N'hinhAnh\\35.Hoodie-GC-New-Nâu.png',N'LSP01',20,N'NCC003')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP036',N'GORECYCLE Tay dài / Đen',405000,N'Áo gorecycle tay dài, màu đen, phù hợp cho mùa đông',1,N'hinhAnh\\36.GORECYCLE-Tay-dài-Đen.png',N'LSP02',6,N'NCC011')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP037',N'Quần chạy bộ Cashmere Blend',17900000,N'Quần thun chạy bộ, màu be, co giãn phù hợp cho vận động',1,N'hinhAnh\\37.Quần-chạy-bộ-Cashmere-Blend.png',N'LSP09',9,N'NCC007')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP038',N'ÁO KHOÁC DA SANG TRỌNG LV TẦN SỐ',18300000,N'Chiếc áo blouson da mềm mại sang trọng này được phân biệt với chữ ký LV Frequency được thêu ở mặt trước và trên tay áo bên trái, có túi có khóa kéo',1,N'hinhAnh\\38.ÁO-KHOÁC-DA-SANG-TRỌNG-LV-TẦN SỐ.png',N'LSP01',4,N'NCC001')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP039',N'Quần rawD - The First (Cam)',550000,N'Là lời cổ vũ tinh thần đến rawD và những ai cũng có cách sống rawD – chân thật và giản đơn trong cuộc sống thường nhật, nhưng khi bước vào thế giới thuộc về mình thì luôn bùng cháy và điên khùng hết nấc.',1,N'hinhAnh\\39.Quần-rawD-The First-(Cam).png',N'LSP09',13,N'NCC009')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP040',N'Váy không tay Re-Nylon có túi',15000000,N' Chiếc áo không tay với phần cổ cạp có kiểu dáng đẹp, đương đại, kiểu dáng lai đặc trưng của linh hồn Prada.',1,N'hinhAnh\\40.Váy-không-tay-Re-Nylon-có-túi.png',N'LSP07',7,N'NCC005')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP041',N'VÁY NGẮN LOE',65000000,N'Chiếc váy ngắn kết hợp những mã của sự thanh lịch với một tinh thần thoải mái.',1,N'hinhAnh\\41.VÁY-NGẮN-LOE.png',N'LSP08',8,N'NCC002')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP042',N'SKORT WITH CD BUTTON',53900000,N'Được làm thủ công bằng len và lụa nhẹ màu đen, thiết kế có đường cắt tràng hoa được tô điểm bằng nút CD màu đen ở thắt lưng và một túi vá phía sau',1,N'hinhAnh\\42.SKORT-WITH-CD-BUTTON.png',N'LSP08',10,N'NCC002')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP043',N'Quần Jean Nam Xám Lông Chuột Rách SlimFit QJBA04',580000,N'Quần Jean Nam  Xám Lông Chuột Rách SlimFit QJBA04',1,N'hinhAnh\\43.Quần-Jean-Nam-Xám-Lông-Chuột-Rách-SlimFit-QJBA04.png',N'LSP04',15,N'NCC003')
--insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP044',N'ÁO KHOÁC HUẤN LUYỆN VIÊN CÓ MŨ TRÙM ĐẦU CLOWNZ MONOGRAM CAMO',629000,N'Chất liệu vải gió.Dáng xuông.Chống thấm nước khi đi mưa',1,N'hinhAnh\\44.ÁO-KHOÁC-HUẤN-LUYỆN-VIÊN-CÓ-MŨ-TRÙM-ĐẦU-CLOWNZ-MONOGRAM-CAMO.png',N'LSP01',15,N'NCC003')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP045',N'Áo sơ mi Hawaii lụa với hình in graffiti phun sơn',16300000,N'đường nét được tạo ra từ các loại vải kỹ thuật, bản in graffiti và chi tiết logo toàn bộ.',1,N'hinhAnh\\45.Áo-sơ-mi-Hawaii-lụa-với-hình-in-graffiti-phun-sơn.png',N'LSP03',12,N'NCC009')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP046',N'ÁO SƠ MI DÀI TÂY 8N2591BT5',580000,N'Áo sơ mi trơn tay dài Việt Tiến phom Regular, chất liệu Bamboo - Spun có các tính năng như ít dễ uốn, tạo màu, thấm hút tốt, mềm mại và thoải mái, phù hợp với môi trường hiện đại.',1,N'hinhAnh\\46.ÁO-SƠ-MI-DÀI-TÂY-8N2591BT5.png',N'LSP03',20,N'NCC008')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP047',N'Áo khoác Lamé Intarsia sọc',46500000,N'Chiếc áo khoác hai lớp này được làm thủ công từ vải sọc lamé intarsia nhiều màu và có kết cấu bằng vải bạt hoàn toàn.',1,N'hinhAnh\\47.Áo-khoác-Lamé-Intarsia-sọc.png',N'LSP01',12,N'NCC006')
--insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP048',N'Áo khoác bomber dệt kim và áo khoác bomber Re-Nylon quá khổ',69300000,N'chiếc áo khoác bomber này có tông màu ấm áp và hấp dẫn nhờ họa tiết hình học và sự thoải mái của dệt kim jacquard gợi lại niềm vui của xúc giác',1,N'hinhAnh\\48.Áo-khoác-bomber-dệt-kim-và-áo-khoác-bomber-Re-Nylon-quá-khổ.png',N'LSP01',17,N'NCC005')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP049',N'Váy jersey một vai với chi tiết tay áo rời',20650000,N'với sự quyến rũ hiện đại, chẳng hạn như chiếc váy măng tô jersey kỹ thuật với đường viền cổ bất đối xứng này, sẽ mang đến cho bạn vẻ ngoài cá tính không thể nhầm lẫn.',1,N'hinhAnh\\49.Váy-jersey-một-vai-với-chi-tiết-tay-áo-rời.png',N'LSP07',8,N'NCC004')
insert into [dbo].[SanPham] ([maSP], [tenSP], [gia], [moTa], [trangThai], [hinhAnh], [maLoaiSP], [soLuong], [maNCC]) values (N'SP050',N'Váy thêu lụa duchesse',22500000,N' Chiếc váy sa tanh đen này thể hiện nét quyến rũ cổ điển với độ dài ở giữa và đường xẻ phía trước.',1,N'hinhAnh\\50.Váy-thêu-lụa-duchesse.png',N'LSP08',9,N'NCC002')



insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD001',N'NV001',N'KH00001',CAST(N'2021-10-12' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD002',N'NV003',N'KH00009',CAST(N'2021-01-01' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD003',N'NV004',N'KH00039',CAST(N'2020-02-25' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD004',N'NV006',N'KH00038',CAST(N'2022-03-15' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD005',N'NV007',N'KH00042',CAST(N'2022-04-01' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD006',N'NV008',N'KH00039',CAST(N'2021-05-23' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD007',N'NV009',N'KH00040',CAST(N'2020-06-30' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD008',N'NV013',N'KH00041',CAST(N'2022-07-25' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD009',N'NV014',N'KH00012',CAST(N'2021-08-07' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD010',N'NV015',N'KH00037',CAST(N'2020-09-09' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD011',N'NV018',N'KH00005',CAST(N'2021-10-10' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD012',N'NV019',N'KH00010',CAST(N'2022-11-17' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD013',N'NV020',N'KH00036',CAST(N'2020-12-19' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD014',N'NV001',N'KH00014',CAST(N'2020-01-21' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD015',N'NV003',N'KH00002',CAST(N'2021-02-12' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD016',N'NV004',N'KH00004',CAST(N'2021-03-01' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD017',N'NV006',N'KH00015',CAST(N'2020-04-06' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD018',N'NV007',N'KH00032',CAST(N'2022-05-19' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD019',N'NV008',N'KH00031',CAST(N'2020-06-25' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD020',N'NV009',N'KH00003',CAST(N'2021-07-27' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD021',N'NV013',N'KH00035',CAST(N'2021-08-03' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD022',N'NV014',N'KH00025',CAST(N'2021-09-08' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD023',N'NV015',N'KH00016',CAST(N'2022-10-10' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD024',N'NV018',N'KH00049',CAST(N'2021-11-13' AS Date))
--insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD025',N'NV019',N'KH00024',CAST(N'2022-12-14' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD026',N'NV020',N'KH00050',CAST(N'2020-01-29' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD027',N'NV001',N'KH00005',CAST(N'2020-02-05' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD028',N'NV003',N'KH00006',CAST(N'2022-03-26' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD029',N'NV004',N'KH00036',CAST(N'2022-04-17' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD030',N'NV006',N'KH00042',CAST(N'2022-05-07' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD031',N'NV007',N'KH00018',CAST(N'2020-06-07' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD032',N'NV008',N'KH00031',CAST(N'2020-07-29' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD033',N'NV009',N'KH00017',CAST(N'2020-08-26' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD034',N'NV013',N'KH00033',CAST(N'2021-09-28' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD035',N'NV014',N'KH00019',CAST(N'2022-10-11' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD036',N'NV015',N'KH00034',CAST(N'2022-11-19' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD037',N'NV018',N'KH00032',CAST(N'2020-12-08' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD038',N'NV019',N'KH00007',CAST(N'2022-01-07' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD039',N'NV020',N'KH00048',CAST(N'2021-02-08' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD040',N'NV001',N'KH00008',CAST(N'2021-03-06' AS Date))
--insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD041',N'NV003',N'KH00020',CAST(N'2022-04-23' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD042',N'NV004',N'KH00033',CAST(N'2022-05-27' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD043',N'NV006',N'KH00043',CAST(N'2022-06-13' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD044',N'NV007',N'KH00042',CAST(N'2021-07-14' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD045',N'NV008',N'KH00042',CAST(N'2021-08-26' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD046',N'NV009',N'KH00031',CAST(N'2022-09-16' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD047',N'NV013',N'KH00030',CAST(N'2022-10-14' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD048',N'NV014',N'KH00014',CAST(N'2021-11-18' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD049',N'NV015',N'KH00021',CAST(N'2021-12-25' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD050',N'NV018',N'KH00047',CAST(N'2022-01-08' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD051',N'NV019',N'KH00013',CAST(N'2020-02-15' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD052',N'NV020',N'KH00014',CAST(N'2020-03-09' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD053',N'NV001',N'KH00022',CAST(N'2020-04-07' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD054',N'NV018',N'KH00028',CAST(N'2020-05-19' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD055',N'NV019',N'KH00044',CAST(N'2021-06-28' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD056',N'NV013',N'KH00036',CAST(N'2022-07-27' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD057',N'NV018',N'KH00023',CAST(N'2020-08-16' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD058',N'NV003',N'KH00024',CAST(N'2020-09-07' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD059',N'NV009',N'KH00034',CAST(N'2021-10-11' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD060',N'NV008',N'KH00010',CAST(N'2022-11-14' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD061',N'NV006',N'KH00009',CAST(N'2021-12-16' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD062',N'NV001',N'KH00029',CAST(N'2022-01-29' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD063',N'NV015',N'KH00028',CAST(N'2021-02-22' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD064',N'NV020',N'KH00045',CAST(N'2020-03-28' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD065',N'NV018',N'KH00027',CAST(N'2022-04-24' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD066',N'NV019',N'KH00025',CAST(N'2022-05-23' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD067',N'NV004',N'KH00011',CAST(N'2020-06-03' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD068',N'NV006',N'KH00012',CAST(N'2022-07-05' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD069',N'NV018',N'KH00046',CAST(N'2022-08-06' AS Date))
insert into [dbo].[HoaDon] ([maHD], [maNV], [maKH], [ngayLap]) values (N'HD070',N'NV014',N'KH00026',CAST(N'2020-09-07' AS Date))


insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD001',N'SP006',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD002',N'SP008',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD003',N'SP015',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD004',N'SP026',5)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD005',N'SP035',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD006',N'SP042',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD007',N'SP002',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD008',N'SP009',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD009',N'SP014',5)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD010',N'SP036',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD011',N'SP025',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD012',N'SP001',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD013',N'SP027',6)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD014',N'SP016',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD015',N'SP023',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD016',N'SP011',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD017',N'SP029',5)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD018',N'SP017',6)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD019',N'SP024',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD020',N'SP003',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD021',N'SP028',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD022',N'SP001',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD023',N'SP005',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD024',N'SP038',1)
--insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong], [thanhTien]) values (N'HD025',N'SP048',2,2*69300000)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD026',N'SP037',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD027',N'SP025',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD028',N'SP004',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD029',N'SP029',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD030',N'SP009',5)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD031',N'SP039',6)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD032',N'SP049',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD033',N'SP029',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD034',N'SP040',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD035',N'SP005',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD036',N'SP006',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD037',N'SP049',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD038',N'SP036',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD039',N'SP014',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD040',N'SP018',2)
--insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong], [thanhTien]) values (N'HD041',N'SP044',1,1*629000)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD042',N'SP050',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD043',N'SP019',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD044',N'SP030',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD045',N'SP045',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD046',N'SP043',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD047',N'SP007',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD048',N'SP006',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD049',N'SP010',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD050',N'SP027',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD051',N'SP045',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD052',N'SP013',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD053',N'SP007',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD054',N'SP033',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD055',N'SP041',3)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD056',N'SP013',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD057',N'SP031',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD058',N'SP032',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD059',N'SP033',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD060',N'SP047',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD061',N'SP050',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD062',N'SP020',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD063',N'SP039',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD064',N'SP027',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD065',N'SP046',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD066',N'SP022',1)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD067',N'SP034',2)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD068',N'SP012',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD069',N'SP021',4)
insert into [dbo].[ChiTietHoaDon]([maHD], [maSP], [soLuong]) values (N'HD070',N'SP011',5)

select *from ChiTietHoaDon
select maHD, s.[maSP], c.[soLuong], [gia], thanhtienHD=c.soLuong*gia
from ChiTietHoaDon c join SanPham s on c.maSP=s.maSP

GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([maNV])
REFERENCES [dbo].[TaiKhoan] ([maNV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_LoaiNhanVien] FOREIGN KEY([maLoaiNV])
REFERENCES [dbo].[LoaiNhanVien] ([maLoaiNV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_LoaiNhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([maLoaiSP])
REFERENCES [dbo].[LoaiSanPham] ([maLoaiSP])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO