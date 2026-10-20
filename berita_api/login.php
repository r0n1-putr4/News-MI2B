<?php

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type");

require_once "koneksi.php";
require_once "helpers.php";

$username = $_POST['username'] ?? '';
$password = $_POST['password'] ?? '';

if ($username == '' || $password == '') {
    response(false, "Username dan Password wajib diisi", null);
}

$query = mysqli_query($koneksi, "SELECT * FROM table_users WHERE username='$username'");

if (mysqli_num_rows($query) == 0) {
    response(false, "User tidak ditemukan", null);
}

$user = mysqli_fetch_assoc($query);

if (password_verify($password, $user['password'])) {

    unset($user['password']); // jangan kirim password

    response(true, "Login berhasil", $user);

} else {
    response(false, "Password salah", null);
}

?>