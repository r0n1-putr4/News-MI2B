<?php

require_once "config.php";

$koneksi = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);

if (!$koneksi) {
    response(false, "Koneksi database gagal", null);
    exit;
}

?>