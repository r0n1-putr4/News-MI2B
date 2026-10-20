<?php
// Aktifkan error reporting untuk melacak error
error_reporting(E_ALL);
ini_set('display_errors', 1);

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type");

require_once "koneksi.php";
require_once "helpers.php";

// Ambil input dengan aman
$username = $_POST['username'] ?? '';
$email    = $_POST['email'] ?? '';
$password = $_POST['password'] ?? '';
$fullname = $_POST['fullname'] ?? '';

// Validasi basic
if ($username == '' || $email == '' || $password == '' || $fullname == '') {
    if (function_exists('response')) {
        response(false, "Semua field wajib diisi", null);
    } else {
        echo json_encode(["status" => false, "message" => "Semua field wajib diisi"]);
    }
    exit;
}

// Keamanan: Mencegah SQL Injection
$username = mysqli_real_escape_string($koneksi, $username);
$email    = mysqli_real_escape_string($koneksi, $email);
$fullname = mysqli_real_escape_string($koneksi, $fullname);

$passwordHash = password_hash($password, PASSWORD_DEFAULT);

// Cek username atau email sudah digunakan
$cek = mysqli_query($koneksi, "SELECT * FROM table_users WHERE username='$username' OR email='$email'");

if (!$cek) {
    die("Gagal mengecek database: " . mysqli_error($koneksi));
}

if (mysqli_num_rows($cek) > 0) {
    if (function_exists('response')) {
        response(false, "Username atau Email sudah digunakan", null);
    } else {
        echo json_encode(["status" => false, "message" => "Username atau Email sudah digunakan"]);
    }
    exit;
}

// Insert data
$query = "INSERT INTO table_users (username, email, password, fullname, tgl_daftar) 
          VALUES ('$username', '$email', '$passwordHash', '$fullname', NOW())";

$insert = mysqli_query($koneksi, $query);

if ($insert) {
    if (function_exists('response')) {
        response(true, "Registrasi berhasil", null);
    } else {
        echo json_encode(["status" => true, "message" => "Registrasi berhasil"]);
    }
} else {
    if (function_exists('response')) {
        response(false, "Registrasi gagal: " . mysqli_error($koneksi), null);
    } else {
        echo json_encode(["status" => false, "message" => "Registrasi gagal: " . mysqli_error($koneksi)]);
    }
}
?>