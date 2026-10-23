<?php
// updateBerita.php
require_once "koneksi.php";

$sql = "SELECT * FROM table_berita ORDER BY id DESC";
$result = mysqli_query($koneksi, $sql);

if ($result && mysqli_num_rows($result) > 0) {
}else{
    
}

?>