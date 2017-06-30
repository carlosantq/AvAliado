<?php
include('proteger.php');
protect();
include('conexao.php');

$matricula = $_POST['matricula'];
$periodo = $_POST['periodo'];

$sql_update = "UPDATE aluno SET periodo = '$periodo' WHERE matricula = '$matricula'";

$sql_exec = $mysqli->query($sql_update);

if ($sql_exec){
    if ($sql_exec){
    echo ("
        <script>
            alert('Dados alterados com sucesso');
            location.href='selectAluno.php';
        </script>

    ");
}else{
    echo ("
        <script>
            alert('Erro de execução');
            location.href='selectAluno.php';
        </script>

    ");
}

?>

