<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type");
require_once "koneksi.php";
require_once "helpers.php";

$sql = "SELECT * FROM table_berita ORDER BY id DESC";
$result = mysqli_query($koneksi, $sql);

$data = [];

if ($result && mysqli_num_rows($result) > 0) {

    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    response(true, "Berhasil Menampilkan Berita", $data);

} else {
    response(false, "Data berita kosong", []);
}

?>