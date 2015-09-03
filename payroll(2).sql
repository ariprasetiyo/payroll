-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 03, 2015 at 11:00 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `payroll`
--

-- --------------------------------------------------------

--
-- Table structure for table `coba`
--

CREATE TABLE IF NOT EXISTS `coba` (
  `id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `coba`
--

INSERT INTO `coba` (`id`) VALUES
(0001);

-- --------------------------------------------------------

--
-- Table structure for table `data_gaji`
--

CREATE TABLE IF NOT EXISTS `data_gaji` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id_gaji` varchar(15) NOT NULL,
  `id_karyawan` varchar(15) NOT NULL,
  `id_karyawan_history` varchar(15) NOT NULL,
  `id_absensi` varchar(15) NOT NULL,
  `user_created` varchar(300) NOT NULL,
  `user_updated` varchar(300) NOT NULL,
  `tanggal_updated` datetime NOT NULL,
  `tanggal_created` datetime NOT NULL,
  PRIMARY KEY (`id_gaji`),
  UNIQUE KEY `no_2` (`no`),
  KEY `tanggal_created` (`tanggal_created`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=140 ;

--
-- Dumping data for table `data_gaji`
--

INSERT INTO `data_gaji` (`no`, `id_gaji`, `id_karyawan`, `id_karyawan_history`, `id_absensi`, `user_created`, `user_updated`, `tanggal_updated`, `tanggal_created`) VALUES
(117, 'DG20151', 'BSP201521', '60', '172', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(126, 'DG201510', 'BSP201512', '51', '181', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(127, 'DG201511', 'BSP201511', '50', '182', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(128, 'DG201512', 'BSP201510', '49', '183', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(129, 'DG201513', 'BSP20159', '48', '184', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(130, 'DG201514', 'BSP20158', '47', '185', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(131, 'DG201515', 'BSP20157', '46', '186', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(132, 'DG201516', 'BSP20156', '45', '187', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(133, 'DG201517', 'BSP20155', '44', '188', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(134, 'DG201518', 'BSP20154', '43', '189', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(135, 'DG201519', 'BSP20153', '42', '190', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(118, 'DG20152', 'BSP201520', '59', '173', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(136, 'DG201520', 'BSP20152', '61', '191', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(137, 'DG201521', 'BSP20151', '40', '192', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:11', '2015-08-23 04:01:11'),
(138, 'DG201522', 'BSP201522', '63', '193', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-24 13:56:40', '2015-08-24 13:56:40'),
(139, 'DG201523', 'BSP201523', '65', '194', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-25 19:08:42', '2015-08-25 19:08:42'),
(119, 'DG20153', 'BSP201519', '58', '174', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(120, 'DG20154', 'BSP201518', '57', '175', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(121, 'DG20155', 'BSP201517', '56', '176', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(122, 'DG20156', 'BSP201516', '55', '177', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(123, 'DG20157', 'BSP201515', '54', '178', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(124, 'DG20158', 'BSP201514', '53', '179', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06'),
(125, 'DG20159', 'BSP201513', '52', '180', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:01:06', '2015-08-23 04:01:06');

-- --------------------------------------------------------

--
-- Table structure for table `payroll_master_karyawan`
--

CREATE TABLE IF NOT EXISTS `payroll_master_karyawan` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id_pelamar` varchar(15) NOT NULL,
  `id_karyawan` varchar(15) NOT NULL,
  `nama` varchar(300) NOT NULL,
  `ibu` varchar(300) NOT NULL,
  `kelahiran_tanggal` date NOT NULL,
  `kelahiran_tempat` varchar(50) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `jenis_kelamin` int(1) NOT NULL,
  `status_nikah` int(1) NOT NULL,
  `agama` int(1) NOT NULL,
  `darah` int(1) NOT NULL,
  `kewarganegaraan` varchar(50) NOT NULL,
  `no_ktp` varchar(40) NOT NULL,
  `no_sim` varchar(40) NOT NULL,
  `alamat` varchar(500) NOT NULL,
  `alamat_asal` varchar(500) NOT NULL,
  `kode_pos` int(10) NOT NULL,
  `no_telphone` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `status_tempat_tinggal` int(2) NOT NULL,
  `hobby` varchar(100) NOT NULL,
  `status_karyawan` varchar(1) NOT NULL COMMENT 'status_pelamar',
  `riwayat_pendidikan` text NOT NULL,
  `pendidikan_non_formal` text NOT NULL,
  `key_no` int(11) NOT NULL,
  `periode_bulan` varchar(20) NOT NULL,
  `tahun` year(4) NOT NULL,
  `user_created` varchar(50) DEFAULT NULL,
  `user_updated` varchar(50) DEFAULT NULL,
  `tanggal_dibuat` datetime NOT NULL,
  `tanggal_update` datetime NOT NULL,
  PRIMARY KEY (`id_karyawan`),
  UNIQUE KEY `id_pelamar` (`id_pelamar`),
  KEY `no` (`no`),
  KEY `user_created` (`user_created`),
  KEY `user_updated` (`user_updated`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=101 ;

--
-- Dumping data for table `payroll_master_karyawan`
--

INSERT INTO `payroll_master_karyawan` (`no`, `id_pelamar`, `id_karyawan`, `nama`, `ibu`, `kelahiran_tanggal`, `kelahiran_tempat`, `jabatan`, `jenis_kelamin`, `status_nikah`, `agama`, `darah`, `kewarganegaraan`, `no_ktp`, `no_sim`, `alamat`, `alamat_asal`, `kode_pos`, `no_telphone`, `email`, `status_tempat_tinggal`, `hobby`, `status_karyawan`, `riwayat_pendidikan`, `pendidikan_non_formal`, `key_no`, `periode_bulan`, `tahun`, `user_created`, `user_updated`, `tanggal_dibuat`, `tanggal_update`) VALUES
(77, 'MP201510', 'BSP20151', 'Ayuning ', 'x@dsd.com', '2015-08-17', 'x@dsd.com', 'Presiden Direktur', 0, 0, 0, 0, 'x@dsd.com', '111111111111', '111111111111', '111111111111', '111111111111', 11111111, '098877663', '111111111111@sasa', 0, '111111111111', '1', '111111111111', '111111111111', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-22 22:19:53', '2015-08-22 22:20:28'),
(87, 'MP201512', 'BSP201510', 'Cecep', '23456789011', '2015-08-18', '23456789011', 'Mechanic', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 234567, '23456789011', '23456789011@asa', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:18', '2015-08-23 03:32:18'),
(88, 'MP201511', 'BSP201511', 'Joni', 'xxxx', '2015-08-17', 'xxx', 'Staff Logistik', 1, 0, 0, 0, '111111111111', '111111111111', '111111111111', '111111111111', '111111111111', 1111111, '08766366421', '111111111111@dsd', 0, '111111111111', '1', '111111111111', '111111111111', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:24', '2015-08-23 03:32:24'),
(89, 'MP20157', 'BSP201512', 'Yuno', 'xxx', '2015-08-18', 'xxx', 'Staff Logistik', 1, 0, 0, 0, 'xxx', '0218886634', '2121212', 'xxxxx', 'xxxxx', 121212, '0218886634', '21212@dsd', 0, '1212', '1', 's', 's', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:35', '2015-08-23 03:32:35'),
(90, 'MP20159', 'BSP201513', 'Giring', 'x@dsd.com', '2015-08-10', 'x@dsd.com', 'Staff IT', 1, 0, 0, 0, 'x@dsd.com', '111111111111', '111111111111', '1111111111', '11111111111', 111111111, '099887722122', 'x@dsd.com', 0, 'x@dsd.com', '1', 'x@dsd.com', 'x@dsd.com', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:43', '2015-08-23 03:32:43'),
(91, 'MP20156', 'BSP201514', 'Mujiyono', 'xxxxx', '2015-08-17', 'xx', 'Mechanic', 1, 0, 0, 0, 'xx', '11111111111', '1111111111', 'xxxx', 'xxxx', 11111, '08766388741', 'a@ds', 0, 'x', '1', 'x', 'x', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:48', '2015-08-23 03:32:48'),
(92, 'MP20155', 'BSP201515', 'Rudi Mamat', 'xxx', '2015-08-11', 'xx', 'Staff HRD', 1, 0, 0, 0, 'xx', '1111111111', '1111111111', 'xxxx', 'xxx', 121212212, '086789222999', 'sas@asa.com', 0, 'x', '1', 'x', 'x', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:53', '2015-08-23 03:32:53'),
(93, 'MP20154', 'BSP201516', 'Wulan', 'xxx', '2015-08-18', 'x', 'Presiden Direktur', 0, 0, 0, 0, 'x', '111111111111', '111111111111', 'x', 'x', 111111, '085981999666', 'x@d.c', 0, 'x', '1', 'x', 'x', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:58', '2015-08-23 03:32:58'),
(94, 'MP20153', 'BSP201517', 'Rudi', 'Enci', '2015-08-10', 'x', 'Outlet Development', 1, 0, 0, 0, 'x', '213243434343', '4343434343434', 'x', 'x', 11111111, '02189641773', '1111111@gmail.com', 0, 'x', '1', 'x', 'x', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:33:05', '2015-08-23 03:33:05'),
(95, 'MP20152', 'BSP201518', 'Suyono', 'Sumarni', '1992-01-31', 'Klateb', 'Manager IT', 1, 0, 0, 0, 'Indonesia', '12345678911', '123456788898', 'x', 'x', 12345545, '11212122332', 'halo@gmail.om', 2, 'Bola', '1', '1. SD N 2 Bendo<br>2. SMP N 3 Pedan', '', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:33:10', '2015-08-23 03:33:10'),
(96, 'MP20151', 'BSP201519', 'Ari Sutrisno', 'Pademi', '1994-07-01', 'Klaten', 'Staff IT', 1, 0, 0, 3, 'Indonesia', '0288664858832', '118837654885', 'Kelapa Gading Bukit Indah Blok G 26/27', 'Polaman, Beji, Pedan, Klaten, Jawa Tengh', 568476, '085777611141', 'prasetiyooo@gmail.com', 2, 'Sepak Bola', '1', '1. SD N 1 Beji<br>2. SMP N 1 Pedan<br>3. SMA N 1 CAWAS', 'Lembaga Pendidikan Magistra Utama Solo', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:33:18', '2015-08-23 03:33:18'),
(79, 'MP201521', 'BSP20152', 'Ari Prasetiyo', 'Pademi', '1992-01-31', 'Klaten', 'Staff IT', 1, 0, 0, 3, 'Indonesia', '223334445456679', '328876611232212', 'Kelapa Gading Bukit Indah Blok G 26 27', 'Polaman, Beji, Pedan, Klaten, Jawa Tengah', 5544321, '085777611141', 'prasetiyooo@gmail.com', 0, 'Football', '1', '1. SD N 2 BEJI<br>2. SMP N 1 PEDAN<br>3. SMA N 1 CAWAS<br><br>', '1. LEMBAGA PENDIDIKAN MAGISTRA UTAMA', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:30:57', '2015-08-23 03:30:57'),
(97, 'MP201520', 'BSP201520', 'sulasih', 'xxxxx', '2015-08-10', 'xxx', 'staff Accounting', 1, 0, 0, 0, 'xxxxx', '11111111111', '111111111111', '11111', '11111111111', 111111, '1111111111', '1111111111111@sdsd', 0, '1111', '3', 'x', 'x', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:35:06', '2015-09-02 10:00:37'),
(98, 'MP201522', 'BSP201521', 'Junaidi', 'xxx', '2015-08-11', 'x', 'Oultet Head', 1, 0, 0, 3, 'xxx', '1111111111', '11111111111', 'xxxxx', 'xxxxxxxxxxxx', 11111, '0921212111', 'asa@asddsd', 0, '12212', '1', 'sas', 'sas', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:35:15', '2015-08-23 03:41:48'),
(99, 'MP201523', 'BSP201522', 'Yunidd', 'Sarah', '1992-08-21', 'klaten', 'staff Accounting', 1, 0, 0, 0, 'Indonesia', '11111111111', '111111111111', 'Jakarta', 'Klaten, Jawa Tengah', 212121212, '085777611141', 'yuni@gmail.oom', 2, 'Tenis', '1', '1. SDN<br>2.SMP', 'tidak ada', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-24 13:42:19', '2015-09-02 11:37:31'),
(100, 'MP201524', 'BSP201523', 'Rudi Ssssssssssss', 'sulistiya', '1992-08-02', 'Solo', 'staff Accounting', 1, 0, 0, 0, 'Indonesia', '1234567890', '987654321', 'Kelapa gading', 'Klaten jawa', 12345, '085777611141', 'rudi@gmail.com', 2, 'Football', '1', '<span style="font-weight: bold;">1. SD<br>2. SMP</span><div><span style="font-weight: bold;">3. SMA<br></span><br>fgfg<br></div>', 'tidak ada', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-25 19:00:58', '2015-09-02 10:19:02'),
(80, 'MP201519', 'BSP20153', 'Candara', '23456789011', '2015-08-12', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@dsadsd', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:10', '2015-08-23 03:31:10'),
(81, 'MP201518', 'BSP20154', 'Suliswati', '23456789011', '2015-08-10', '23456789011', 'Presiden Direktur', 0, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@dsds', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:18', '2015-08-23 03:31:18'),
(82, 'MP201517', 'BSP20155', 'Maya', '23456789011', '2015-08-18', '23456789011', 'staff Accounting', 0, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@dsd', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:24', '2015-08-23 03:31:24'),
(83, 'MP201516', 'BSP20156', 'Koko', '23456789011', '2015-08-11', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@sa', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:33', '2015-08-23 03:31:33'),
(84, 'MP201515', 'BSP20157', 'Tono Mardina', '23456789011', '2015-08-10', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 234567, '23456789011', '23456789011@dsd', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:39', '2015-08-23 03:31:39'),
(85, 'MP201514', 'BSP20158', 'Luci', '23456789011', '2015-08-18', '23456789011', 'Manager Logistik', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 2345678, '23456789011', '23456789011@dsds', 2, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:48', '2015-08-23 03:31:48'),
(86, 'MP201513', 'BSP20159', 'Mardin', '23456789011', '2015-08-18', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 1121212, '23456789011', '23456789011@asas', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', 2015, NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:55', '2015-08-23 03:31:55');

-- --------------------------------------------------------

--
-- Table structure for table `payroll_master_karyawan_detail`
--

CREATE TABLE IF NOT EXISTS `payroll_master_karyawan_detail` (
  `nomor` int(11) NOT NULL AUTO_INCREMENT,
  `id_karyawan` varchar(15) NOT NULL,
  `area` varchar(1) DEFAULT '',
  `nama_cabang` varchar(500) NOT NULL,
  `cuti_tahunan` int(2) NOT NULL DEFAULT '0',
  `cuti_5_tahunan` int(2) NOT NULL DEFAULT '0',
  `jabatan` varchar(100) NOT NULL,
  `sts_pegawai` varchar(1) NOT NULL DEFAULT '0',
  `gaji` int(10) NOT NULL DEFAULT '0',
  `t_kerajinan` int(10) NOT NULL DEFAULT '0',
  `t_operational` int(10) NOT NULL DEFAULT '0',
  `t_bpjs_ketenagakerjaan` int(10) NOT NULL DEFAULT '0',
  `t_bpjs_kesehatan` int(10) NOT NULL DEFAULT '0',
  `t_lainnya` int(10) NOT NULL DEFAULT '0',
  `t_kesehatan` int(10) NOT NULL DEFAULT '0',
  `t_penepatan` int(10) NOT NULL DEFAULT '0',
  `t_transport` int(10) NOT NULL DEFAULT '0',
  `t_makan` int(10) NOT NULL DEFAULT '0',
  `t_jabatan` int(10) NOT NULL DEFAULT '0',
  `p_pinjaman_karyawan` int(10) NOT NULL DEFAULT '0',
  `p_bpjs_ketenagakerjaan` int(10) NOT NULL DEFAULT '0',
  `p_bpjs_kesehatan` int(10) NOT NULL DEFAULT '0',
  `p_asr_kesehatan` int(10) NOT NULL DEFAULT '0',
  `p_denda_kedisiplinan` int(10) NOT NULL DEFAULT '0',
  `p_pajak` int(10) NOT NULL DEFAULT '0',
  `e_periode` date NOT NULL DEFAULT '0000-00-00',
  `s_periode` date NOT NULL DEFAULT '0000-00-00',
  `user_created` varchar(150) DEFAULT NULL,
  `user_updated` varchar(150) DEFAULT NULL,
  `tanggal_dibuat` datetime NOT NULL,
  `tanggal_update` datetime NOT NULL,
  `sts_insert_or_not` int(11) NOT NULL,
  PRIMARY KEY (`nomor`),
  KEY `id_karyawan` (`id_karyawan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=66 ;

--
-- Dumping data for table `payroll_master_karyawan_detail`
--

INSERT INTO `payroll_master_karyawan_detail` (`nomor`, `id_karyawan`, `area`, `nama_cabang`, `cuti_tahunan`, `cuti_5_tahunan`, `jabatan`, `sts_pegawai`, `gaji`, `t_kerajinan`, `t_operational`, `t_bpjs_ketenagakerjaan`, `t_bpjs_kesehatan`, `t_lainnya`, `t_kesehatan`, `t_penepatan`, `t_transport`, `t_makan`, `t_jabatan`, `p_pinjaman_karyawan`, `p_bpjs_ketenagakerjaan`, `p_bpjs_kesehatan`, `p_asr_kesehatan`, `p_denda_kedisiplinan`, `p_pajak`, `e_periode`, `s_periode`, `user_created`, `user_updated`, `tanggal_dibuat`, `tanggal_update`, `sts_insert_or_not`) VALUES
(40, 'BSP20151', '', '', 0, 0, 'Presiden Direktur', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-22', '2015-08-22', NULL, ' Ari Prasetiyo ', '2015-08-22 22:19:53', '2015-08-22 22:19:53', 0),
(41, 'BSP20152', '', '', 0, 0, 'Staff IT', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:30:57', '2015-08-23 03:30:57', 0),
(42, 'BSP20153', '', '', 0, 0, 'Presiden Direktur', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:10', '2015-08-23 03:31:10', 0),
(43, 'BSP20154', '', '', 0, 0, 'Presiden Direktur', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:18', '2015-08-23 03:31:18', 0),
(44, 'BSP20155', '', '', 0, 0, 'staff Accounting', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:24', '2015-08-23 03:31:24', 0),
(45, 'BSP20156', '', '', 0, 0, 'Presiden Direktur', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:33', '2015-08-23 03:31:33', 0),
(46, 'BSP20157', '', '', 0, 0, 'Presiden Direktur', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:39', '2015-08-23 03:31:39', 0),
(47, 'BSP20158', '', '', 0, 0, 'Manager Logistik', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:48', '2015-08-23 03:31:48', 0),
(48, 'BSP20159', '', '', 0, 0, 'Presiden Direktur', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:31:55', '2015-08-23 03:31:55', 0),
(49, 'BSP201510', '', '', 0, 0, 'Mechanic', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:18', '2015-08-23 03:32:18', 0),
(50, 'BSP201511', '', '', 0, 0, 'Staff Logistik', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:24', '2015-08-23 03:32:24', 0),
(51, 'BSP201512', '', '', 0, 0, 'Staff Logistik', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:35', '2015-08-23 03:32:35', 0),
(52, 'BSP201513', '5', 'Sidakarya', 25, 12, 'Staff IT', '1', 3000000, 100000, 0, 0, 0, 0, 0, 0, 100000, 0, 0, 0, 75000, 0, 0, 0, 90000, '2019-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:43', '2015-08-23 03:48:46', 1),
(53, 'BSP201514', '', '', 0, 0, 'Mechanic', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:48', '2015-08-23 03:32:48', 0),
(54, 'BSP201515', '', '', 0, 0, 'Staff HRD', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:53', '2015-08-23 03:32:53', 0),
(55, 'BSP201516', '', '', 0, 0, 'Presiden Direktur', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:32:58', '2015-08-23 03:32:58', 0),
(56, 'BSP201517', '', '', 0, 0, 'Outlet Development', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:33:05', '2015-08-23 03:33:05', 0),
(57, 'BSP201518', '', '', 0, 0, 'Manager IT', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:33:10', '2015-08-23 03:33:10', 0),
(58, 'BSP201519', '4', 'Gejayen', 25, 12, 'Staff IT', '1', 2500000, 100000, 0, 0, 0, 0, 0, 0, 100000, 0, 0, 0, 75000, 0, 0, 0, 90000, '2020-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:33:18', '2015-08-23 03:46:51', 1),
(59, 'BSP201520', '1', 'Kelapa Gading', 12, 25, 'staff Accounting', '1', 2500000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90000, '2020-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:35:06', '2015-08-23 03:45:29', 1),
(60, 'BSP201521', '1', 'Sukapura', 12, 25, 'Oultet Head', '1', 2000000, 100000, 0, 0, 0, 300000, 0, 0, 0, 0, 100000, 0, 90000, 0, 0, 0, 55000, '2020-08-23', '2015-08-23', NULL, ' Ari Prasetiyo ', '2015-08-23 03:35:15', '2015-08-23 03:44:14', 1),
(61, 'BSP20152', '1', 'Kelapa Gading', 12, 25, 'Staff IT', '1', 5000000, 100000, 50000, 0, 0, 0, 0, 0, 150000, 0, 0, 0, 0, 125000, 0, 0, 75000, '2020-08-23', '2015-08-23', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-23 00:00:00', '2015-08-23 03:40:56', 1),
(62, 'BSP201522', '', '', 0, 0, 'staff Accounting', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-24', '2015-08-24', NULL, ' Ari Prasetiyo ', '2015-08-24 13:42:19', '2015-08-24 13:42:19', 0),
(63, 'BSP201522', '1', 'Kelapa Gading', 12, 25, 'staff Accounting', '1', 5000000, 200000, 0, 0, 0, 0, 0, 0, 0, 300000, 0, 0, 0, 100000, 100000, 0, 100000, '2020-08-24', '2015-08-24', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-24 00:00:00', '2015-08-24 13:44:21', 1),
(64, 'BSP201523', '', '', 0, 0, 'staff Accounting', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2015-08-25', '2015-08-25', NULL, ' Ari Prasetiyo ', '2015-08-25 19:00:58', '2015-08-25 19:00:58', 0),
(65, 'BSP201523', '1', 'Kelapa gading', 25, 12, 'staff Accounting', '1', 50000000, 200000, 0, 0, 0, 0, 0, 0, 0, 300000, 0, 0, 0, 100000, 10000, 0, 100000, '2020-08-25', '2015-08-25', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-25 00:00:00', '2015-09-02 09:24:28', 1);

-- --------------------------------------------------------

--
-- Table structure for table `payroll_master_pelamar`
--

CREATE TABLE IF NOT EXISTS `payroll_master_pelamar` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `ibu` varchar(50) NOT NULL,
  `kelahiran_tanggal` date NOT NULL,
  `kelahiran_tempat` varchar(50) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  `jenis_kelamin` int(1) NOT NULL,
  `status_nikah` int(1) NOT NULL,
  `agama` int(1) NOT NULL,
  `darah` int(1) NOT NULL,
  `kewarganegaraan` varchar(50) NOT NULL,
  `no_ktp` varchar(40) NOT NULL,
  `no_sim` varchar(40) NOT NULL,
  `alamat` varchar(300) NOT NULL,
  `alamat_asal` varchar(300) NOT NULL,
  `kode_pos` int(7) NOT NULL,
  `no_telphone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `status_tempat_tinggal` int(1) NOT NULL,
  `hobby` varchar(100) NOT NULL,
  `status_pelamar` varchar(1) NOT NULL,
  `riwayat_pendidikan` text NOT NULL,
  `pendidikan_non_formal` text NOT NULL,
  `key_no` int(11) NOT NULL,
  `periode_bulan` varchar(20) NOT NULL,
  `tanggal_dibuat` datetime NOT NULL,
  `tanggal_update` date NOT NULL,
  `tahun` year(4) NOT NULL,
  `user_created` varchar(50) DEFAULT NULL,
  `user_updated` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tanggal_update` (`tanggal_update`),
  KEY `no` (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=931 ;

--
-- Dumping data for table `payroll_master_pelamar`
--

INSERT INTO `payroll_master_pelamar` (`no`, `id`, `nama`, `ibu`, `kelahiran_tanggal`, `kelahiran_tempat`, `jabatan`, `jenis_kelamin`, `status_nikah`, `agama`, `darah`, `kewarganegaraan`, `no_ktp`, `no_sim`, `alamat`, `alamat_asal`, `kode_pos`, `no_telphone`, `email`, `status_tempat_tinggal`, `hobby`, `status_pelamar`, `riwayat_pendidikan`, `pendidikan_non_formal`, `key_no`, `periode_bulan`, `tanggal_dibuat`, `tanggal_update`, `tahun`, `user_created`, `user_updated`) VALUES
(907, 'MP20151', 'Ari Sutrisno', 'Pademi', '1994-07-01', 'Klaten', 'Staff IT', 1, 0, 0, 3, 'Indonesia', '0288664858832', '118837654885', 'Kelapa Gading Bukit Indah Blok G 26/27', 'Polaman, Beji, Pedan, Klaten, Jawa Tengh', 568476, '085777611141', 'prasetiyooo@gmail.com', 2, 'Sepak Bola', '1', '1. SD N 1 Beji<br>2. SMP N 1 Pedan<br>3. SMA N 1 CAWAS', 'Lembaga Pendidikan Magistra Utama Solo', 1, '82015', '2015-08-22 21:54:34', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(916, 'MP201510', 'Ayuning ', 'x@dsd.com', '2015-08-17', 'x@dsd.com', 'Presiden Direktur', 0, 0, 0, 0, 'x@dsd.com', '111111111111', '111111111111', '111111111111', '111111111111', 11111111, '098877663', '111111111111@sasa', 0, '111111111111', '1', '111111111111', '111111111111', 1, '82015', '2015-08-22 22:19:32', '2015-08-22', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(917, 'MP201511', 'Joni', 'xxxx', '2015-08-17', 'xxx', 'Staff Logistik', 1, 0, 0, 0, '111111111111', '111111111111', '111111111111', '111111111111', '111111111111', 1111111, '08766366421', '111111111111@dsd', 0, '111111111111', '1', '111111111111', '111111111111', 1, '82015', '2015-08-22 22:21:28', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(918, 'MP201512', 'Cecep', '23456789011', '2015-08-18', '23456789011', 'Mechanic', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 234567, '23456789011', '23456789011@asa', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:37:31', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(919, 'MP201513', 'Mardin', '23456789011', '2015-08-18', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 1121212, '23456789011', '23456789011@asas', 0, '23456789011', '2', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:47:36', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(920, 'MP201514', 'Luci', '23456789011', '2015-08-18', '23456789011', 'Manager Logistik', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 2345678, '23456789011', '23456789011@dsds', 2, '23456789011', '1', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:49:08', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(921, 'MP201515', 'Tono Mardina', '23456789011', '2015-08-10', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 234567, '23456789011', '23456789011@dsd', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:50:36', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(922, 'MP201516', 'Koko', '23456789011', '2015-08-11', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@sa', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:52:58', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(923, 'MP201517', 'Maya', '23456789011', '2015-08-18', '23456789011', 'staff Accounting', 0, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@dsd', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:54:16', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(924, 'MP201518', 'Suliswati', '23456789011', '2015-08-10', '23456789011', 'Presiden Direktur', 0, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@dsds', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:55:30', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(925, 'MP201519', 'Candara', '23456789011', '2015-08-12', '23456789011', 'Presiden Direktur', 1, 0, 0, 0, '23456789011', '23456789011', '23456789011', '23456789011', '23456789011', 111111, '23456789011', '23456789011@dsadsd', 0, '23456789011', '1', '23456789011', '23456789011', 1, '82015', '2015-08-22 22:58:21', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(908, 'MP20152', 'Suyono', 'Sumarni', '1992-01-31', 'Klateb', 'Manager IT', 1, 0, 0, 0, 'Indonesia', '12345678911', '123456788898', 'x', 'x', 12345545, '11212122332', 'halo@gmail.om', 2, 'Bola', '1', '1. SD N 2 Bendo<br>2. SMP N 3 Pedan', '', 1, '82015', '2015-08-22 21:56:47', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(926, 'MP201520', 'sulasih', 'xxxxx', '2015-08-10', 'xxx', 'staff Accounting', 1, 0, 0, 0, 'xxxxx', '11111111111', '111111111111', '11111', '11111111111', 111111, '1111111111', '1111111111111@sdsd', 0, '1111', '3', 'x', 'x', 1, '82015', '2015-08-23 03:21:36', '2015-09-02', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(927, 'MP201521', 'Ari Prasetiyo', 'Pademi', '1992-01-31', 'Klaten', 'Staff IT', 1, 0, 0, 3, 'Indonesia', '223334445456679', '328876611232212', 'Kelapa Gading Bukit Indah Blok G 26 27', 'Polaman, Beji, Pedan, Klaten, Jawa Tengah', 5544321, '085777611141', 'prasetiyooo@gmail.com', 0, 'Football', '1', '1. SD N 2 BEJI<br>2. SMP N 1 PEDAN<br>3. SMA N 1 CAWAS<br><br>', '1. LEMBAGA PENDIDIKAN MAGISTRA UTAMA', 1, '82015', '2015-08-23 03:27:50', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(928, 'MP201522', 'Junaidi', 'xxx', '2015-08-11', 'x', 'Oultet Head', 1, 0, 0, 3, 'xxx', '1111111111', '11111111111', 'xxxxx', 'xxxxxxxxxxxx', 11111, '0921212111', 'asa@asddsd', 0, '12212', '1', 'sas', 'sas', 1, '82015', '2015-08-23 03:34:33', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(929, 'MP201523', 'Yunidd', 'Sarah', '1992-08-21', 'klaten', 'staff Accounting', 1, 0, 0, 0, 'Indonesia', '11111111111', '111111111111', 'Jakarta', 'Klaten, Jawa Tengah', 212121212, '085777611141', 'yuni@gmail.oom', 2, 'Tenis', '1', '1. SDN<br>2.SMP', 'tidak ada', 1, '82015', '2015-08-24 13:41:46', '2015-09-02', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(930, 'MP201524', 'Rudi Ssssssssssss', 'sulistiya', '1992-08-02', 'Solo', 'staff Accounting', 1, 0, 0, 0, 'Indonesia', '1234567890', '987654321', 'Kelapa gading', 'Klaten jawa', 12345, '085777611141', 'rudi@gmail.com', 2, 'Football', '1', '<span style="font-weight: bold;">1. SD<br>2. SMP</span><div><span style="font-weight: bold;">3. SMA<br></span><br>fgfg<br></div>', 'tidak ada', 1, '82015', '2015-08-25 19:00:12', '2015-09-02', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(909, 'MP20153', 'Rudi', 'Enci', '2015-08-10', 'x', 'Outlet Development', 1, 0, 0, 0, 'x', '213243434343', '4343434343434', 'x', 'x', 11111111, '02189641773', '1111111@gmail.com', 0, 'x', '1', 'x', 'x', 1, '82015', '2015-08-22 21:58:35', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(910, 'MP20154', 'Wulan', 'xxx', '2015-08-18', 'x', 'Presiden Direktur', 0, 0, 0, 0, 'x', '111111111111', '111111111111', 'x', 'x', 111111, '085981999666', 'x@d.c', 0, 'x', '1', 'x', 'x', 1, '82015', '2015-08-22 22:01:42', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(911, 'MP20155', 'Rudi Mamat', 'xxx', '2015-08-11', 'xx', 'Staff HRD', 1, 0, 0, 0, 'xx', '1111111111', '1111111111', 'xxxx', 'xxx', 121212212, '086789222999', 'sas@asa.com', 0, 'x', '1', 'x', 'x', 1, '82015', '2015-08-22 22:04:09', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(912, 'MP20156', 'Mujiyono', 'xxxxx', '2015-08-17', 'xx', 'Mechanic', 1, 0, 0, 0, 'xx', '11111111111', '1111111111', 'xxxx', 'xxxx', 11111, '08766388741', 'a@ds', 0, 'x', '1', 'x', 'x', 1, '82015', '2015-08-22 22:05:58', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(913, 'MP20157', 'Yuno', 'xxx', '2015-08-18', 'xxx', 'Staff Logistik', 1, 0, 0, 0, 'xxx', '0218886634', '2121212', 'xxxxx', 'xxxxx', 121212, '0218886634', '21212@dsd', 0, '1212', '1', 's', 's', 1, '82015', '2015-08-22 22:14:18', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(914, 'MP20158', 'Bahir', 'xxx', '2015-08-10', 'x', 'Staff IT', 1, 0, 0, 0, 'x', '11111111111111', '11111111', '1111111', '111111', 111111, '087665522344', 'x@dsd', 0, 'x@dsd', '0', 'x@dsd', 'x@dsd', 1, '82015', '2015-08-22 22:17:18', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo '),
(915, 'MP20159', 'Giring', 'x@dsd.com', '2015-08-10', 'x@dsd.com', 'Staff IT', 1, 0, 0, 0, 'x@dsd.com', '111111111111', '111111111111', '1111111111', '11111111111', 111111111, '099887722122', 'x@dsd.com', 0, 'x@dsd.com', '1', 'x@dsd.com', 'x@dsd.com', 1, '82015', '2015-08-22 22:18:26', '2015-08-23', 2015, ' Ari Prasetiyo ', ' Ari Prasetiyo ');

-- --------------------------------------------------------

--
-- Table structure for table `presensi_absensi`
--

CREATE TABLE IF NOT EXISTS `presensi_absensi` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id_absensi` varchar(15) NOT NULL,
  `id_karyawan` varchar(15) NOT NULL,
  `nama` varchar(300) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `area` varchar(1) NOT NULL,
  `cabang` varchar(500) NOT NULL,
  `status_pegawai` int(1) NOT NULL,
  `status_karyawan` int(2) NOT NULL,
  `masuk` int(2) DEFAULT '0',
  `absen` int(2) DEFAULT '0',
  `masuk_terlambat` int(2) DEFAULT '0',
  `pulang_lebih_awal` int(2) DEFAULT '0',
  `sakit` int(2) NOT NULL DEFAULT '0',
  `cuti` int(2) DEFAULT '0',
  `lembur` int(2) DEFAULT '0',
  `periode` date NOT NULL,
  `user_created` varchar(300) NOT NULL,
  `user_updated` varchar(300) NOT NULL,
  `tanggal_dibuat` datetime NOT NULL,
  `tanggal_update` datetime NOT NULL,
  KEY `no` (`no`),
  KEY `periode` (`periode`),
  KEY `id_absensi` (`id_absensi`),
  KEY `tanggal_dibuat` (`tanggal_dibuat`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=195 ;

--
-- Dumping data for table `presensi_absensi`
--

INSERT INTO `presensi_absensi` (`no`, `id_absensi`, `id_karyawan`, `nama`, `jabatan`, `area`, `cabang`, `status_pegawai`, `status_karyawan`, `masuk`, `absen`, `masuk_terlambat`, `pulang_lebih_awal`, `sakit`, `cuti`, `lembur`, `periode`, `user_created`, `user_updated`, `tanggal_dibuat`, `tanggal_update`) VALUES
(172, 'kosong', 'BSP201521', 'Junaidi', 'Oultet Head', '1', 'Sukapura', 1, 1, 20, 0, 0, 0, 0, 1, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(173, 'kosong', 'BSP201520', 'sulasih', 'staff Accounting', '1', 'Kelapa Gading', 1, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(174, 'kosong', 'BSP201519', 'Ari Sutrisno', 'Staff IT', '4', 'Gejayen', 1, 1, 20, 0, 0, 0, 1, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(175, 'kosong', 'BSP201518', 'Suyono', 'Manager IT', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(176, 'kosong', 'BSP201517', 'Rudi', 'Outlet Development', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(177, 'kosong', 'BSP201516', 'Wulan', 'Presiden Direktur', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(178, 'kosong', 'BSP201515', 'Rudi Mamat', 'Staff HRD', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(179, 'kosong', 'BSP201514', 'Mujiyono', 'Mechanic', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(180, 'kosong', 'BSP201513', 'Giring', 'Staff IT', '5', 'Sidakarya', 1, 1, 21, 0, 0, 0, 0, 0, 1, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(181, 'kosong', 'BSP201512', 'Yuno', 'Staff Logistik', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(182, 'kosong', 'BSP201511', 'Joni', 'Staff Logistik', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(183, 'kosong', 'BSP201510', 'Cecep', 'Mechanic', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(184, 'kosong', 'BSP20159', 'Mardin', 'Presiden Direktur', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(185, 'kosong', 'BSP20158', 'Luci', 'Manager Logistik', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:46', '2015-08-23 03:59:46'),
(186, 'kosong', 'BSP20157', 'Tono Mardina', 'Presiden Direktur', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:47', '2015-08-23 03:59:47'),
(187, 'kosong', 'BSP20156', 'Koko', 'Presiden Direktur', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:47', '2015-08-23 03:59:47'),
(188, 'kosong', 'BSP20155', 'Maya', 'staff Accounting', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:47', '2015-08-23 03:59:47'),
(189, 'kosong', 'BSP20154', 'Suliswati', 'Presiden Direktur', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:47', '2015-08-23 03:59:47'),
(190, 'kosong', 'BSP20153', 'Candara', 'Presiden Direktur', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:47', '2015-08-23 03:59:47'),
(191, 'kosong', 'BSP20152', 'Ari Prasetiyo', 'Staff IT', '', '', 0, 1, 18, 0, 0, 0, 0, 3, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 03:59:47', '2015-08-23 03:59:47'),
(192, 'kosong', 'BSP20151', 'Ayuning ', 'Presiden Direktur', '', '', 0, 1, 21, 0, 0, 0, 0, 0, 0, '2015-08-23', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-23 04:00:12', '2015-08-23 04:00:12'),
(193, 'kosong', 'BSP201522', 'Yuni', 'staff Accounting', '', '', 0, 1, 20, 1, 1, 1, 0, 0, 0, '2015-08-24', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-24 13:54:38', '2015-08-24 13:54:38'),
(194, 'kosong', 'BSP201523', 'Rudi', 'staff Accounting', '', '', 0, 1, 9, 2, 2, 2, 0, 10, 1, '2015-08-25', ' Ari Prasetiyo', ' Ari Prasetiyo', '2015-08-25 19:08:15', '2015-08-25 19:08:15');

-- --------------------------------------------------------

--
-- Table structure for table `presensi_izin`
--

CREATE TABLE IF NOT EXISTS `presensi_izin` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id_cuti` varchar(15) NOT NULL,
  `id_karyawan` varchar(15) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `jenis_izin_cuti` int(1) NOT NULL,
  `jum_cuti` int(2) NOT NULL,
  `tanggal_dimulai_cuti` date NOT NULL,
  `tanggal_selesai_cuti` date NOT NULL,
  `jenis_izin` varchar(1) NOT NULL,
  `keterangan` text NOT NULL,
  `user_created` varchar(150) NOT NULL,
  `user_updated` varchar(150) NOT NULL,
  `tanggal_dibuat` datetime NOT NULL,
  `tanggal_update` datetime NOT NULL,
  PRIMARY KEY (`id_cuti`),
  KEY `tanggal_update` (`tanggal_update`),
  KEY `id_karyawan` (`id_karyawan`),
  KEY `no` (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- Dumping data for table `presensi_izin`
--

INSERT INTO `presensi_izin` (`no`, `id_cuti`, `id_karyawan`, `jabatan`, `jenis_izin_cuti`, `jum_cuti`, `tanggal_dimulai_cuti`, `tanggal_selesai_cuti`, `jenis_izin`, `keterangan`, `user_created`, `user_updated`, `tanggal_dibuat`, `tanggal_update`) VALUES
(43, 'ICT20151', 'BSP20152', 'Staff IT', 0, 3, '2015-08-24', '2015-08-26', '0', 'Persiapan Sidang', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-23 03:51:58', '2015-08-23 03:51:58'),
(44, 'ICT20152', 'BSP201521', 'Oultet Head', 0, 1, '2015-08-24', '2015-08-25', '0', 'Wisaata', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-23 03:53:32', '2015-08-23 03:53:32'),
(46, 'ICT20153', 'BSP201523', 'staff Accounting', 0, 10, '2015-08-03', '2015-08-14', '0', 'cuti', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-25 19:05:22', '2015-08-25 19:05:22'),
(47, 'ICT20154', 'BSP20151', 'Presiden Direktur', 0, 0, '2015-08-19', '2015-08-19', '0', '2121212', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-31 19:08:08', '2015-08-31 19:08:08'),
(48, 'ICT20155', 'BSP20152', 'Staff IT', 0, 1, '2015-08-26', '2015-08-07', '0', 'asassas', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-31 19:14:19', '2015-08-31 19:14:19'),
(45, 'IS20151', 'BSP201519', 'Staff IT', 9, 1, '2015-08-24', '2015-08-24', '1', 'Sakit Perut', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-23 03:54:24', '2015-08-23 03:54:24');

-- --------------------------------------------------------

--
-- Table structure for table `presensi_lembur`
--

CREATE TABLE IF NOT EXISTS `presensi_lembur` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id_lembur` varchar(15) NOT NULL,
  `id_karyawan` varchar(15) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `katagori_lembur` int(1) NOT NULL,
  `jum_lembur` int(3) NOT NULL,
  `tanggal_dimulai_lembur` date NOT NULL,
  `tanggal_selesai_lembur` date NOT NULL,
  `keterangan` text NOT NULL,
  `user_created` varchar(150) NOT NULL,
  `user_updated` varchar(150) NOT NULL,
  `tanggal_dibuat` datetime NOT NULL,
  `tanggal_update` datetime NOT NULL,
  PRIMARY KEY (`id_lembur`),
  KEY `id_karyawan` (`id_karyawan`),
  KEY `no` (`no`),
  KEY `tanggal_update` (`tanggal_update`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `presensi_lembur`
--

INSERT INTO `presensi_lembur` (`no`, `id_lembur`, `id_karyawan`, `jabatan`, `katagori_lembur`, `jum_lembur`, `tanggal_dimulai_lembur`, `tanggal_selesai_lembur`, `keterangan`, `user_created`, `user_updated`, `tanggal_dibuat`, `tanggal_update`) VALUES
(19, 'LEM20151', 'BSP201513', 'Staff IT', 8, 1, '2015-08-23', '2015-08-23', 'Hari Minggu, Urgent kerjaan jaringan internet Sitepat Monang - Maning mati', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-23 03:55:56', '2015-08-23 03:55:56'),
(20, 'LEM20152', 'BSP201523', 'staff Accounting', 8, 1, '2015-08-02', '2015-08-02', 'keterangan', ' Ari Prasetiyo ', ' Ari Prasetiyo ', '2015-08-25 19:06:44', '2015-08-25 19:06:44');

-- --------------------------------------------------------

--
-- Table structure for table `so`
--

CREATE TABLE IF NOT EXISTS `so` (
  `id` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20150004 ;

--
-- Dumping data for table `so`
--

INSERT INTO `so` (`id`, `name`) VALUES
(001, 'asassasas'),
(002, 'asassasas'),
(20150001, 'asassasas'),
(20150002, 'asassasas'),
(20150003, 'asassasas');

-- --------------------------------------------------------

--
-- Table structure for table `sys_menu`
--

CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` int(3) NOT NULL DEFAULT '0',
  `nama_menu` varchar(255) NOT NULL,
  `sub_link` int(10) NOT NULL,
  `level_menu` int(1) NOT NULL,
  `aktiv` int(1) NOT NULL,
  `level_user` int(1) NOT NULL,
  `href` varchar(255) DEFAULT NULL,
  `menu_by_asc` varchar(10) NOT NULL,
  `tag` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sys_menu`
--

INSERT INTO `sys_menu` (`id`, `nama_menu`, `sub_link`, `level_menu`, `aktiv`, `level_user`, `href`, `menu_by_asc`, `tag`) VALUES
(0, 'Master', 1, 1, 1, 1, '#', 'a', '1'),
(1, 'Presensi', 1, 1, 1, 1, '#', 'b', '1'),
(2, 'Pengajian', 1, 1, 1, 1, 'coba.html', 'c', '1'),
(7, 'Izin / Lembur', 0, 11, 1, 1, 'presensi_izin_lembur.ari', 'bb', '2'),
(8, 'Absensi', 0, 11, 1, 1, 'presensi_absensi.ari', 'bc', '4'),
(9, 'Data Gaji', 0, 11, 1, 1, 'payroll_data.ari', 'ca', '9'),
(15, 'Pelamar', 0, 11, 1, 1, 'master_pelamar.ari', 'aa', '2'),
(16, 'Karyawan', 0, 11, 1, 1, 'master_karyawan.ari', 'ab', '4');

-- --------------------------------------------------------

--
-- Table structure for table `sys_user`
--

CREATE TABLE IF NOT EXISTS `sys_user` (
  `name` varchar(100) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(300) NOT NULL,
  `join_at` date NOT NULL,
  `expired` date NOT NULL,
  `status_aktiv` int(1) NOT NULL,
  `aktiv_date` date DEFAULT NULL,
  `level_user` int(1) NOT NULL,
  `count_false_login` int(1) NOT NULL,
  `lastlogin` datetime NOT NULL,
  `update` datetime NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sys_user`
--

INSERT INTO `sys_user` (`name`, `username`, `password`, `join_at`, `expired`, `status_aktiv`, `aktiv_date`, `level_user`, `count_false_login`, `lastlogin`, `update`) VALUES
('ari prasetiyo', 'ari', '0144712dd81be0c3d9724f5e56ce6685', '2015-02-07', '2019-02-07', 1, NULL, 1, 4, '2015-02-07 15:41:41', '2015-02-07 15:41:41');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payroll_master_karyawan`
--
ALTER TABLE `payroll_master_karyawan`
  ADD CONSTRAINT `payroll_master_karyawan_ibfk_1` FOREIGN KEY (`id_pelamar`) REFERENCES `payroll_master_pelamar` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `payroll_master_karyawan_detail`
--
ALTER TABLE `payroll_master_karyawan_detail`
  ADD CONSTRAINT `payroll_master_karyawan_detail_ibfk_1` FOREIGN KEY (`id_karyawan`) REFERENCES `payroll_master_karyawan` (`id_karyawan`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
