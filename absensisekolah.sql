-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 25 Nov 2015 pada 22.00
-- Versi Server: 5.5.27
-- Versi PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `absensisekolah`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `absensisiswa`
--

CREATE TABLE IF NOT EXISTS `absensisiswa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NISS` varchar(7) NOT NULL,
  `Nama` varchar(125) NOT NULL,
  `KelJur` varchar(16) NOT NULL,
  `keterangan` varchar(128) NOT NULL,
  `Tanggal` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `NISS` (`NISS`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Dumping data untuk tabel `absensisiswa`
--

INSERT INTO `absensisiswa` (`id`, `NISS`, `Nama`, `KelJur`, `keterangan`, `Tanggal`) VALUES
(34, 'NISS012', 'Farid', 'afsaf', 'IZIN', '2015-11-26');

-- --------------------------------------------------------

--
-- Struktur dari tabel `absensistaff`
--

CREATE TABLE IF NOT EXISTS `absensistaff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NIGS` varchar(7) NOT NULL,
  `Nama` varchar(125) NOT NULL,
  `Jabatan` varchar(64) NOT NULL,
  `keterangan` varchar(128) NOT NULL,
  `Tanggal` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `NIGS` (`NIGS`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dblogin`
--

CREATE TABLE IF NOT EXISTS `dblogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Usrnm` varchar(16) NOT NULL,
  `Passwd` varchar(16) NOT NULL,
  `Nama` varchar(128) NOT NULL,
  `typeUser` varchar(2) NOT NULL,
  `Created` date NOT NULL DEFAULT '0000-00-00',
  `Keterangan` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Usrnm` (`Usrnm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `guru`
--

CREATE TABLE IF NOT EXISTS `guru` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NIP` varchar(64) NOT NULL,
  `NIGS` varchar(7) NOT NULL,
  `Nama_Guru` varchar(125) NOT NULL,
  `Jabatan` varchar(64) NOT NULL,
  `Tempat_Lahir` varchar(125) NOT NULL,
  `Tanggal_Lahir` date NOT NULL DEFAULT '0000-00-00',
  `JenKel` varchar(12) NOT NULL,
  `pendidikan` varchar(128) NOT NULL,
  `Agama` varchar(32) NOT NULL,
  `Alamat` tinytext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NIP` (`NIGS`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data untuk tabel `guru`
--

INSERT INTO `guru` (`id`, `NIP`, `NIGS`, `Nama_Guru`, `Jabatan`, `Tempat_Lahir`, `Tanggal_Lahir`, `JenKel`, `pendidikan`, `Agama`, `Alamat`) VALUES
(8, 'NIP003', 'NIGS003', 'Ibran', 'Guru', 'Sulawesi', '1994-11-02', 'LAKI-LAKI', 'S1 Teknik Informatika', 'ISLAM', 'Kp. JATI1'),
(9, 'NIP004', 'NIGS004', 'Silvia', 'Guru', 'Bogor', '1980-11-02', 'PEREMPUAN', 'S1 Sastra Jepang', 'ISLAM', 'Kp. JATI2'),
(10, 'NIP005', 'NIGS005', 'Muhammad Ibran', 'Guru', 'Bogor', '2015-11-04', 'LAKI-LAKI', 'S1 Biologi', 'ISLAM', 'Kp. Jati 03');

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE IF NOT EXISTS `siswa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NISN` varchar(32) NOT NULL,
  `NISS` varchar(7) NOT NULL,
  `Nama_Siswa` varchar(125) NOT NULL,
  `KelJur` varchar(16) NOT NULL,
  `Tempat_Lahir` varchar(125) NOT NULL,
  `Tanggal_Lahir` date NOT NULL DEFAULT '0000-00-00',
  `JenKel` varchar(12) NOT NULL,
  `asal_sekolah` varchar(128) NOT NULL,
  `Agama` varchar(32) NOT NULL,
  `Alamat` tinytext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NISS` (`NISS`),
  UNIQUE KEY `NISS_2` (`NISS`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`id`, `NISN`, `NISS`, `Nama_Siswa`, `KelJur`, `Tempat_Lahir`, `Tanggal_Lahir`, `JenKel`, `asal_sekolah`, `Agama`, `Alamat`) VALUES
(3, 'NISN0001', 'NISS012', 'Nisma Soleha', 'afsaf', 'Bogor', '1992-09-09', 'Perempuan', '--', 'ISLAM', 'asdad'),
(4, 'NISN0001', 'NISS013', 'Nisma Soleha', '12AG2', 'Bandung', '1992-09-09', 'Perempuan', '--', 'ISLAM', 'asdad'),
(5, 'NISN0014', 'NISS014', 'Ibran', '12AG1', 'Jakarta', '1994-02-02', 'LAKI-LAKI', '--', 'ISLAM', 'Negeri Seribu Mimpi');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
