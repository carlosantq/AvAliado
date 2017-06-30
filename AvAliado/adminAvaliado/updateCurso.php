<?php
include('proteger.php');
protect();
include('conexao.php');

$curso = $_POST['curso'];
$nome = $_POST['nome'];


$sql_update = "UPDATE curso SET nome = '$nome' WHERE id = '$curso'";

$sql_exec = $mysqli->query($sql_update);

if ($sql_exec){
    echo ("
        <script>
            alert('Dados alterados com sucesso');
            location.href='selectCurso.php';
        </script>

    ");
}else{
    echo ("
        <script>
            alert('Erro de execução');
            location.href='selectCurso.php';
        </script>

    ");
}

?>