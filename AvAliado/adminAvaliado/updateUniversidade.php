<?php

include('proteger.php');
protect();
include('conexao.php');

$idUniversidade = $_POST['idUniversidade'];
$nome = $_POST['nome'];
$sigla = $_POST['sigla'];
$endereco = $_POST['endereco'];
$telefone = $_POST['telefone'];

/*echo($idUniversidade);
echo($nome);
echo($sigla);
echo($endereco);
echo($telefone);*/

$sql_update = "UPDATE universidade SET nome = '$nome', sigla = '$sigla', endereco = '$endereco', telefone = '$telefone' WHERE id = '$idUniversidade'";
$sql_exec = $mysqli->query($sql_update);
if($sql_exec){
    echo ("
        <script>
            alert('Dados alterados com sucesso');
            location.href='selectUniversidade.php';
        </script>

    ");
}else{
    echo ("
        <script>
            alert('Erro de execução');
            location.href='selectUniversidade.php';
        </script>

    ");
}


?>