<?php
include('proteger.php');
protect();
include('conexao.php');

$idCurso = $_POST['idCurso'];
$idPessoa = $_POST['idPessoa'];

$sql_cadastro = "INSERT INTO vinculocurso VALUES ('$idCurso', '$idPessoa')";
//$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);

if ($mysqli->query($sql_cadastro)){
echo("
        <script>
            location.href='cadastroVinculoCurso.php';
        </script>
    ");
}else{
echo("
        <script>
        alert('O usuário ".$idPessoa." já possui vínculo com este curso');
            location.href='cadastroVinculoCurso.php';
        </script>
    ");
}

/*echo("
        <script>
            location.href='cadastroVinculoCurso.php';
        </script>
    ")*/
?>