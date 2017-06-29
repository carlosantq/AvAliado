<?php
include('proteger.php');
protect();
include('conexao.php');

$nome_disciplina = $_POST['nomeDisciplina'];
$sigla = $_POST['sigla'];
$id_curso = $_POST['idCurso'];


$sql_cadastro = "INSERT INTO disciplina VALUES ('$sigla', '$nome_disciplina', '$id_curso')";
//$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);
if ($mysqli->query($sql_cadastro)){
    echo("
        <script>
            location.href='cadastroDisciplina.php';
        </script>
    ");
}else{
    echo("
    <script>
        alert('Essa disciplina ".$nome_disciplina. " - " . $sigla . " já existe em nossa base de dados.');
        location.href='opainel.php';
        </script>
    ");
}

?>