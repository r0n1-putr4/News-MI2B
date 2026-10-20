<?php
require_once "koneksi.php";
require_once "helpers.php";

$judul       = $_POST['judul'] ?? '';
$isi_berita  = $_POST['isi_berita'] ?? '';
$tgl_berita  = $_POST['tgl_berita'] ?? date('Y-m-d H:i:s');

$folder_gambar = "gambar/";

if ($judul == '' || $isi_berita == '') {
    response(false, "Judul dan isi berita wajib diisi", null);
}

if(isset($_FILES['gambar_berita'])){
    $nama_gambar = $_FILES['gambar_berita']['name'];//nama_file.jpg
    $tmp_gambar = $_FILES['gambar_berita']['tmp_name'];
    if(move_uploaded_file($tmp_gambar, $folder_gambar . $nama_gambar)){
        // insert berita
        $query = "INSERT INTO table_berita (judul, isi_berita, gambar_berita, tgl_berita) 
          VALUES ('$judul', '$isi_berita', '$nama_gambar', '$tgl_berita')";
        $insert = mysqli_query($koneksi, $query);

        if ($insert) {
            response(true, "Berita berhasil ditambahkan", null);
        } else {
            response(false, "Gagal menambahkan berita", null);
        }
    } else {
        response(false, "Gagal mengupload gambar berita", null);
    }
}
else {
    response(false, "Gambar berita wajib diupload", null);
}



?>
