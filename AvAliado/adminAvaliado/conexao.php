<?php

$host = 'localhost';
$username = 'root';
$password = '';
$banco = 'avaliado';
//https://www.youtube.com/watch?v=Zjz4hy6iG1o
$mysqli = new mysqli($host, $username, $password, $banco);

if ($mysqli->connect_errno){
    echo "erro na conexão: (".$mysqli->connect_errno.") ". $mysqli->connect_error ; 
}
//echo "conectou";


?>