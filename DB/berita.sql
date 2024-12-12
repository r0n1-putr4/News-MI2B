-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2024 at 09:00 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_berita`
--

-- --------------------------------------------------------

--
-- Table structure for table `berita`
--

CREATE TABLE `berita` (
  `id` int(11) NOT NULL,
  `judul` varchar(250) NOT NULL,
  `isi_berita` text NOT NULL,
  `gambar_berita` varchar(100) NOT NULL,
  `tgl_berita` datetime NOT NULL,
  `rating` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `berita`
--

INSERT INTO `berita` (`id`, `judul`, `isi_berita`, `gambar_berita`, `tgl_berita`, `rating`) VALUES
(1, 'Rekor di Piala AFF yang Sulit Dipecahkan', 'Jakarta - Sejak pertama kali digelar pada 1996, Piala AFF sudah mencatatkan beberapa rekor. Berikut rekor yang tampaknya sulit untuk dipecahkan!\r\nThailand menjadi tim yang paling sukses di Piala AFF. Tim \"Gajah Perang\" itu sudah menjadi juara tujuh kali setelah mencapai final 10 kali.\r\n\r\nLegenda Thailand, Kiatisuk Senamuang, merupakan sosok yang paling sukes di Piala AFF. Dia tiga kali merasakan juara sebagai pemain dan dua kali juara sebagai pelatih.', 'trofi-piala-aff_169.jpeg', '2024-12-11 11:29:35', 2),
(2, 'Peluang Terakhir Atalanta Nyaris Bikin Real Madrid Gigit Jari', 'Jakarta - Sejak pertama kali digelar pada 1996, Piala AFF sudah mencatatkan beberapa rekor. Berikut rekor yang tampaknya sulit untuk dipecahkan!\r\nThailand menjadi tim yang paling sukses di Piala AFF. Tim \"Gajah Perang\" itu sudah menjadi juara tujuh kali setelah mencapai final 10 kali.\r\n\r\nLegenda Thailand, Kiatisuk Senamuang, merupakan sosok yang paling sukes di Piala AFF. Dia tiga kali merasakan juara sebagai pemain dan dua kali juara sebagai pelatih.', 'atalanta-real-madrid-mateo-retegui_169.jpeg', '2024-12-11 11:29:35', 4.5),
(3, 'Darwin Nunez Masih Merana di Girona', 'Girona - Darwin Nunez melanjutkan periode seret golnya kala Liverpool hadapi Girona. Arne Slot bilang strikernya itu baru sekadar jadi ancaman, belum mampu koyak gawang lawan.\r\nNunez kembali menjadi starter saat Liverpool tandang ke Girona, Rabu (11/12/2024) dini hari WIB tadi, pada Matchday 6 Liga Champions. Ia bermain 71 menit sampai digantikan oleh Cody Gakpo.\r\n\r\nSelama 71 menit berada di lapangan, Nunez mencatatkan tiga percobaan dengan dua yang mengarah ke gawang. Ia melewatkan sejumlah situasi bagus dan cuma menyentuh bola 17 kali, yang kian mempertajam sorotan kepadanya.\r\n', 'darwin-nunez_169.jpeg', '2024-12-11 16:28:03', 0),
(4, 'Darwin Nunez Masih Merana di Girona', 'Girona - Darwin Nunez melanjutkan periode seret golnya kala Liverpool hadapi Girona. Arne Slot bilang strikernya itu baru sekadar jadi ancaman, belum mampu koyak gawang lawan.\r\nNunez kembali menjadi starter saat Liverpool tandang ke Girona, Rabu (11/12/2024) dini hari WIB tadi, pada Matchday 6 Liga Champions. Ia bermain 71 menit sampai digantikan oleh Cody Gakpo.\r\n\r\nSelama 71 menit berada di lapangan, Nunez mencatatkan tiga percobaan dengan dua yang mengarah ke gawang. Ia melewatkan sejumlah situasi bagus dan cuma menyentuh bola 17 kali, yang kian mempertajam sorotan kepadanya.\r\n', 'trofi-aff-cup-trofi-piala-aff-piala-aff-2022-2_169.jpeg', '2024-12-11 16:28:03', 0),
(5, 'Darwin Nunez Masih Merana di Girona', 'Girona - Darwin Nunez melanjutkan periode seret golnya kala Liverpool hadapi Girona. Arne Slot bilang strikernya itu baru sekadar jadi ancaman, belum mampu koyak gawang lawan.\r\nNunez kembali menjadi starter saat Liverpool tandang ke Girona, Rabu (11/12/2024) dini hari WIB tadi, pada Matchday 6 Liga Champions. Ia bermain 71 menit sampai digantikan oleh Cody Gakpo.\r\n\r\nSelama 71 menit berada di lapangan, Nunez mencatatkan tiga percobaan dengan dua yang mengarah ke gawang. Ia melewatkan sejumlah situasi bagus dan cuma menyentuh bola 17 kali, yang kian mempertajam sorotan kepadanya.\r\n', 'darwin-nunez_169.jpeg', '2024-12-11 16:28:03', 0),
(6, 'Darwin Nunez Masih Merana di Girona', 'Girona - Darwin Nunez melanjutkan periode seret golnya kala Liverpool hadapi Girona. Arne Slot bilang strikernya itu baru sekadar jadi ancaman, belum mampu koyak gawang lawan.\r\nNunez kembali menjadi starter saat Liverpool tandang ke Girona, Rabu (11/12/2024) dini hari WIB tadi, pada Matchday 6 Liga Champions. Ia bermain 71 menit sampai digantikan oleh Cody Gakpo.\r\n\r\nSelama 71 menit berada di lapangan, Nunez mencatatkan tiga percobaan dengan dua yang mengarah ke gawang. Ia melewatkan sejumlah situasi bagus dan cuma menyentuh bola 17 kali, yang kian mempertajam sorotan kepadanya.\r\n', 'darwin-nunez_169.jpeg', '2024-12-11 16:28:03', 0),
(7, 'Darwin Nunez Masih Merana di Girona', 'Girona - Darwin Nunez melanjutkan periode seret golnya kala Liverpool hadapi Girona. Arne Slot bilang strikernya itu baru sekadar jadi ancaman, belum mampu koyak gawang lawan.\r\nNunez kembali menjadi starter saat Liverpool tandang ke Girona, Rabu (11/12/2024) dini hari WIB tadi, pada Matchday 6 Liga Champions. Ia bermain 71 menit sampai digantikan oleh Cody Gakpo.\r\n\r\nSelama 71 menit berada di lapangan, Nunez mencatatkan tiga percobaan dengan dua yang mengarah ke gawang. Ia melewatkan sejumlah situasi bagus dan cuma menyentuh bola 17 kali, yang kian mempertajam sorotan kepadanya.\r\n', 'girona-liverpool-alisson_169.jpeg', '2024-12-11 16:28:03', 0),
(14, 'Dortmund Vs Barcelona: Drama 5 Gol, Ferran Torres Cs Menang 3-2', 'Dortmund - Drama lima gol tercipta saat Borussia Dortmund menjamu Barcelona dalam lanjutan Liga Champions. Duel dimenangkan Los Cules 3-2 berkat brace Ferran Torres.Borussia Dortmund vs Barcelona digelar di Signal Iduna Park, Kamis (12/12/2024) dini hari WIB. Jual beli serangan tersaji sejak awal pertandingan.Sama-sama tampil menyerang, Dortmund dan Barcelona gagal memecah kebuntuan hingga memasuki jeda. Banjir gol baru tercipta selepas turun minum.', 'ferran-torres_169.jpeg', '2024-12-12 08:50:07', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `berita`
--
ALTER TABLE `berita`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `berita`
--
ALTER TABLE `berita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
