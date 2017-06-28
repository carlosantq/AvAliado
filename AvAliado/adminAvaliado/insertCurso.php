<?php
include('proteger.php');
protect();
include('conexao.php');

$id_universidade = $_POST['idUniversidade'];
$nome_curso = $_POST['nome'];

$sql_cadastro = "INSERT INTO curso(nome, universidadeid, notaDificuldade, notaFlexibilidade, notamercadodetrabalho) VALUES ('$nome_curso', '$id_universidade', NULL, NULL, NULL)";
$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);
echo("
        <script>
            location.href='cadastrocurso.php';
        </script>
    ")
?>