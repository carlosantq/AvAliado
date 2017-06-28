<?php
include('proteger.php');
protect();
include('conexao.php');

$nome_disciplina = $_POST['nomeDisciplina'];
$sigla = $_POST['sigla'];
$id_curso = $_POST['idCurso'];


$sql_cadastro = "INSERT INTO disciplina VALUES ('$sigla', '$nome_disciplina', '$id_curso')";
$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);
echo("
        <script>
            location.href='cadastroprofessora.php';
        </script>
    ");
?>