<?php
include('proteger.php');
protect();
include('conexao.php');

$disciplina = $_POST['disciplina'];
$nome = $_POST['nome'];


$sql_update = "UPDATE disciplina SET nome = '$nome' WHERE id = '$disciplina'";

$sql_exec = $mysqli->query($sql_update);

if ($sql_exec){
    echo ("
        <script>
            alert('Dados alterados com sucesso');
            location.href='selectDisciplina.php';
        </script>

    ");
}else{
    echo ("
        <script>
            alert('Erro de execução');
            location.href='selectDisciplina.php';
        </script>

    ");
}

?>