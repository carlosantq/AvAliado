<?php
if (!function_exists("protect")){
    function protect(){
        if (!isset($_SESSION)){
            session_start();
        }
        if (!isset($_SESSION['admin']) || !is_numeric($_SESSION['admin'])){
            header("Location: index.php");
        }
    }
}
?>