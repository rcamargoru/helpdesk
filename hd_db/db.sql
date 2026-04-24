USE [master]
GO
/****** Object:  Database [JRHD_SSAS]    Script Date: 31/10/2025 9:40:23 a. m. ******/
CREATE DATABASE [JRHD_SSAS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JRHD_SSAS', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\DB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'JRHD_SSAS_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\DB_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [JRHD_SSAS] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JRHD_SSAS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JRHD_SSAS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET ARITHABORT OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JRHD_SSAS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JRHD_SSAS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [JRHD_SSAS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JRHD_SSAS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET RECOVERY FULL 
GO
ALTER DATABASE [JRHD_SSAS] SET  MULTI_USER 
GO
ALTER DATABASE [JRHD_SSAS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JRHD_SSAS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JRHD_SSAS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JRHD_SSAS] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [JRHD_SSAS] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [JRHD_SSAS] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'JRHD_SSAS', N'ON'
GO
ALTER DATABASE [JRHD_SSAS] SET QUERY_STORE = ON
GO
ALTER DATABASE [JRHD_SSAS] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [JRHD_SSAS]
GO
/****** Object:  Table [dbo].[GnConfiguracionCorreo]    Script Date: 31/10/2025 9:40:23 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GnConfiguracionCorreo](
	[idCfgCorreo] [bigint] IDENTITY(1,1) NOT NULL,
	[servidorSmtp] [varchar](255) NOT NULL,
	[puerto] [int] NOT NULL,
	[usuario] [varchar](255) NOT NULL,
	[contra] [varchar](255) NOT NULL,
	[usaSsl] [bit] NOT NULL,
	[creadoPor] [bigint] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[actualizadoPor] [bigint] NOT NULL,
	[fechaActualizacion] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idCfgCorreo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GnRol]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GnRol](
	[idRol] [bigint] IDENTITY(1,1) NOT NULL,
	[nombreRol] [varchar](100) NOT NULL,
	[descripcionRol] [varchar](100) NOT NULL,
	[estado] [bit] NOT NULL,
	[creadoPor] [bigint] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[actualizadoPor] [bigint] NOT NULL,
	[fechaActualizacion] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[nombreRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GnUsuario]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GnUsuario](
	[idUsuario] [bigint] IDENTITY(1,1) NOT NULL,
	[apellido] [varchar](100) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[nombreUsuario] [varchar](100) NOT NULL,
	[password] [varchar](max) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[telefono] [bigint] NOT NULL,
	[isLdap] [bit] NOT NULL,
	[ldapLogin] [varchar](100) NOT NULL,
	[ldapTitle] [varchar](100) NOT NULL,
	[creadoPor] [bigint] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[actualizadoPor] [bigint] NOT NULL,
	[fechaActualizacion] [datetime] NULL,
	[estado] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[nombreUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GnUsuarioRol]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GnUsuarioRol](
	[idUsuarioRol] [bigint] IDENTITY(1,1) NOT NULL,
	[rol] [bigint] NOT NULL,
	[usuario] [bigint] NOT NULL,
	[creadoPor] [bigint] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[actualizadoPor] [bigint] NOT NULL,
	[fechaActualizacion] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idUsuarioRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdArea]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdArea](
	[idArea] [bigint] IDENTITY(1,1) NOT NULL,
	[nombreArea] [varchar](50) NOT NULL,
	[descripcion] [varchar](255) NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[fechaActualizacion] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idArea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[nombreArea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdAreaCategoria]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdAreaCategoria](
	[idAreaCategoria] [bigint] IDENTITY(1,1) NOT NULL,
	[area] [bigint] NOT NULL,
	[categoria] [bigint] NOT NULL,
	[creadoPor] [bigint] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[actualizadoPor] [bigint] NOT NULL,
	[fechaActualizacion] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idAreaCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdAuditEstTkt]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdAuditEstTkt](
	[idAuditoriaEst] [bigint] IDENTITY(1,1) NOT NULL,
	[ticket] [bigint] NOT NULL,
	[estadoAnterior] [int] NOT NULL,
	[estadoNuevo] [int] NOT NULL,
	[fechaCambio] [datetime] NULL,
	[cambioPor] [bigint] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[fechaActualizacion] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idAuditoriaEst] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdCategoria]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdCategoria](
	[idCategoria] [bigint] IDENTITY(1,1) NOT NULL,
	[nombreCategoria] [varchar](50) NOT NULL,
	[descripcion] [varchar](255) NOT NULL,
	[categoriaPadre] [int] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[fechaActualizacion] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[nombreCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdEstadoTicket]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdEstadoTicket](
	[idEstadoTicket] [bigint] IDENTITY(1,1) NOT NULL,
	[nombreEstadoTicket] [varchar](50) NOT NULL,
	[descripcion] [varchar](255) NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[fechaActualizacion] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idEstadoTicket] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[nombreEstadoTicket] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdHistoTicket]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdHistoTicket](
	[idHistoTicket] [bigint] IDENTITY(1,1) NOT NULL,
	[ticket] [bigint] NOT NULL,
	[fechaAccion] [datetime] NULL,
	[detalleAccion] [text] NOT NULL,
	[fechaActualizacion] [datetime] NULL,
	[fechaCreacion] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idHistoTicket] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdMensaje]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdMensaje](
	[idMensaje] [bigint] IDENTITY(1,1) NOT NULL,
	[historicoTicket] [bigint] NOT NULL,
	[destinatario] [varchar](255) NOT NULL,
	[asunto] [varchar](255) NOT NULL,
	[cuerpo] [text] NOT NULL,
	[fechaEnvio] [datetime] NULL,
	[exitoso] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idMensaje] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdPrioridad]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdPrioridad](
	[idPrioridad] [bigint] IDENTITY(1,1) NOT NULL,
	[nombrePrioridad] [varchar](50) NOT NULL,
	[descripcion] [varchar](255) NOT NULL,
	[nivel] [int] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[fechaActualizacion] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idPrioridad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[nombrePrioridad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdTicket]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdTicket](
	[idTicket] [bigint] IDENTITY(1,1) NOT NULL,
	[titulo] [varchar](255) NOT NULL,
	[descripcion] [varchar](max) NOT NULL,
	[usuarioCreador] [bigint] NOT NULL,
	[agente] [bigint] NOT NULL,
	[prioridad] [bigint] NOT NULL,
	[categoria] [bigint] NOT NULL,
	[area] [bigint] NOT NULL,
	[estado] [bigint] NOT NULL,
	[fechaCreacion] [datetime] NULL,
	[fechaActualizacion] [datetime] NULL,
	[fechaCierre] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
	[fechaUltimaMod] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idTicket] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HdTicketAdjunto]    Script Date: 31/10/2025 9:40:24 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HdTicketAdjunto](
	[idTicketAdjunto] [bigint] IDENTITY(1,1) NOT NULL,
	[ticket] [bigint] NOT NULL,
	[nombreArchivoc] [varchar](255) NOT NULL,
	[tipoArchivo] [varchar](50) NOT NULL,
	[rutaArchivo] [varchar](255) NOT NULL,
	[tamArchivo] [bigint] NOT NULL,
	[fechaSubida] [datetime] NULL,
	[fechaCreacion] [datetime] NULL,
	[fechaActualizacion] [datetime] NULL,
	[creadoPor] [bigint] NOT NULL,
	[actualizadoPor] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idTicketAdjunto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdAreaCategoria_area]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdAreaCategoria_area] ON [dbo].[HdAreaCategoria]
(
	[area] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdAreaCategoria_categoria]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdAreaCategoria_categoria] ON [dbo].[HdAreaCategoria]
(
	[categoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdAuditEstTkt_fechaCambio]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdAuditEstTkt_fechaCambio] ON [dbo].[HdAuditEstTkt]
(
	[fechaCambio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdAuditEstTkt_idAuditoriaEst]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdAuditEstTkt_idAuditoriaEst] ON [dbo].[HdAuditEstTkt]
(
	[idAuditoriaEst] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [idx_HdCategoria_nombreCategoria]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdCategoria_nombreCategoria] ON [dbo].[HdCategoria]
(
	[nombreCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [idx_HdEstadoTicket_nombreEstadoTicket]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdEstadoTicket_nombreEstadoTicket] ON [dbo].[HdEstadoTicket]
(
	[nombreEstadoTicket] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdHistoTicket_fechaAccion]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdHistoTicket_fechaAccion] ON [dbo].[HdHistoTicket]
(
	[fechaAccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdHistoTicket_idHistoTicket]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdHistoTicket_idHistoTicket] ON [dbo].[HdHistoTicket]
(
	[idHistoTicket] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [HdPrioridad_nombrePrioridad]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [HdPrioridad_nombrePrioridad] ON [dbo].[HdPrioridad]
(
	[nombrePrioridad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdTticket_agente]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdTticket_agente] ON [dbo].[HdTicket]
(
	[agente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdTticket_categoria]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdTticket_categoria] ON [dbo].[HdTicket]
(
	[categoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdTticket_estado]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdTticket_estado] ON [dbo].[HdTicket]
(
	[estado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdTticket_fechaCreacion]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdTticket_fechaCreacion] ON [dbo].[HdTicket]
(
	[fechaCreacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdTticket_prioridad]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdTticket_prioridad] ON [dbo].[HdTicket]
(
	[prioridad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdTticket_usuarioCreador]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdTticket_usuarioCreador] ON [dbo].[HdTicket]
(
	[usuarioCreador] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_HdTicketAdjunto_idTicketAdjunto]    Script Date: 31/10/2025 9:40:24 a. m. ******/
CREATE NONCLUSTERED INDEX [idx_HdTicketAdjunto_idTicketAdjunto] ON [dbo].[HdTicketAdjunto]
(
	[idTicketAdjunto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[GnRol] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[GnRol] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[GnUsuario] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[GnUsuario] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[GnUsuarioRol] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[GnUsuarioRol] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdArea] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdArea] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdAreaCategoria] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdAreaCategoria] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdAuditEstTkt] ADD  DEFAULT (getdate()) FOR [fechaCambio]
GO
ALTER TABLE [dbo].[HdAuditEstTkt] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdAuditEstTkt] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdCategoria] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdCategoria] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdEstadoTicket] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdEstadoTicket] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdHistoTicket] ADD  DEFAULT (getdate()) FOR [fechaAccion]
GO
ALTER TABLE [dbo].[HdHistoTicket] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdHistoTicket] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdMensaje] ADD  DEFAULT (getdate()) FOR [fechaEnvio]
GO
ALTER TABLE [dbo].[HdPrioridad] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdPrioridad] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdTicket] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdTicket] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[HdTicket] ADD  DEFAULT (getdate()) FOR [fechaCierre]
GO
ALTER TABLE [dbo].[HdTicket] ADD  DEFAULT (getdate()) FOR [fechaUltimaMod]
GO
ALTER TABLE [dbo].[HdTicketAdjunto] ADD  DEFAULT (getdate()) FOR [fechaSubida]
GO
ALTER TABLE [dbo].[HdTicketAdjunto] ADD  DEFAULT (getdate()) FOR [fechaCreacion]
GO
ALTER TABLE [dbo].[HdTicketAdjunto] ADD  DEFAULT (getdate()) FOR [fechaActualizacion]
GO
ALTER TABLE [dbo].[GnConfiguracionCorreo]  WITH CHECK ADD  CONSTRAINT [FK_GnConfiguracionCorreo_GnUsuario] FOREIGN KEY([creadoPor])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[GnConfiguracionCorreo] CHECK CONSTRAINT [FK_GnConfiguracionCorreo_GnUsuario]
GO
ALTER TABLE [dbo].[GnUsuarioRol]  WITH CHECK ADD  CONSTRAINT [FK_GnUsuarioRol_GnRol] FOREIGN KEY([rol])
REFERENCES [dbo].[GnRol] ([idRol])
GO
ALTER TABLE [dbo].[GnUsuarioRol] CHECK CONSTRAINT [FK_GnUsuarioRol_GnRol]
GO
ALTER TABLE [dbo].[GnUsuarioRol]  WITH CHECK ADD  CONSTRAINT [FK_GnUsuarioRol_GnUsuario] FOREIGN KEY([usuario])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[GnUsuarioRol] CHECK CONSTRAINT [FK_GnUsuarioRol_GnUsuario]
GO
ALTER TABLE [dbo].[HdAreaCategoria]  WITH CHECK ADD  CONSTRAINT [FK_HdAreaCategoria_HdArea] FOREIGN KEY([area])
REFERENCES [dbo].[HdArea] ([idArea])
GO
ALTER TABLE [dbo].[HdAreaCategoria] CHECK CONSTRAINT [FK_HdAreaCategoria_HdArea]
GO
ALTER TABLE [dbo].[HdAreaCategoria]  WITH CHECK ADD  CONSTRAINT [FK_HdAreaCategoria_HdCategoria] FOREIGN KEY([categoria])
REFERENCES [dbo].[HdCategoria] ([idCategoria])
GO
ALTER TABLE [dbo].[HdAreaCategoria] CHECK CONSTRAINT [FK_HdAreaCategoria_HdCategoria]
GO
ALTER TABLE [dbo].[HdAuditEstTkt]  WITH CHECK ADD  CONSTRAINT [FK_HdAuditEstTkt_HdTicket] FOREIGN KEY([ticket])
REFERENCES [dbo].[HdTicket] ([idTicket])
GO
ALTER TABLE [dbo].[HdAuditEstTkt] CHECK CONSTRAINT [FK_HdAuditEstTkt_HdTicket]
GO
ALTER TABLE [dbo].[HdHistoTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdHistoTicket_HdTicket] FOREIGN KEY([ticket])
REFERENCES [dbo].[HdTicket] ([idTicket])
GO
ALTER TABLE [dbo].[HdHistoTicket] CHECK CONSTRAINT [FK_HdHistoTicket_HdTicket]
GO
ALTER TABLE [dbo].[HdMensaje]  WITH CHECK ADD  CONSTRAINT [FK_HdHistoTicket] FOREIGN KEY([historicoTicket])
REFERENCES [dbo].[HdHistoTicket] ([idHistoTicket])
GO
ALTER TABLE [dbo].[HdMensaje] CHECK CONSTRAINT [FK_HdHistoTicket]
GO
ALTER TABLE [dbo].[HdPrioridad]  WITH CHECK ADD  CONSTRAINT [FK_HdPrioridad_GnUsuario] FOREIGN KEY([creadoPor])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[HdPrioridad] CHECK CONSTRAINT [FK_HdPrioridad_GnUsuario]
GO
ALTER TABLE [dbo].[HdPrioridad]  WITH CHECK ADD  CONSTRAINT [FK_HdPrioridad_GnUsuario1] FOREIGN KEY([actualizadoPor])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[HdPrioridad] CHECK CONSTRAINT [FK_HdPrioridad_GnUsuario1]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_GnUsuario] FOREIGN KEY([usuarioCreador])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_GnUsuario]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_GnUsuario1] FOREIGN KEY([agente])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_GnUsuario1]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_GnUsuario2] FOREIGN KEY([creadoPor])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_GnUsuario2]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_GnUsuario3] FOREIGN KEY([actualizadoPor])
REFERENCES [dbo].[GnUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_GnUsuario3]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_HdArea] FOREIGN KEY([area])
REFERENCES [dbo].[HdArea] ([idArea])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_HdArea]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_HdCategoria] FOREIGN KEY([categoria])
REFERENCES [dbo].[HdCategoria] ([idCategoria])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_HdCategoria]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_HdEstadoTicket] FOREIGN KEY([estado])
REFERENCES [dbo].[HdEstadoTicket] ([idEstadoTicket])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_HdEstadoTicket]
GO
ALTER TABLE [dbo].[HdTicket]  WITH CHECK ADD  CONSTRAINT [FK_HdTicket_HdPrioridad] FOREIGN KEY([prioridad])
REFERENCES [dbo].[HdPrioridad] ([idPrioridad])
GO
ALTER TABLE [dbo].[HdTicket] CHECK CONSTRAINT [FK_HdTicket_HdPrioridad]
GO
ALTER TABLE [dbo].[HdTicketAdjunto]  WITH CHECK ADD  CONSTRAINT [FK_HdTicketAdjunto_HdTicket] FOREIGN KEY([ticket])
REFERENCES [dbo].[HdTicket] ([idTicket])
GO
ALTER TABLE [dbo].[HdTicketAdjunto] CHECK CONSTRAINT [FK_HdTicketAdjunto_HdTicket]
GO
USE [master]
GO
ALTER DATABASE [JRHD_SSAS] SET  READ_WRITE 
GO
