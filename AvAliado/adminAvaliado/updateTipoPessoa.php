<?php

include('proteger.php');
protect();
include('conexao.php');

$tipoID = $_POST['tipoPessoa'];
$nome = $_POST['nome'];
$telefone = $_POST['telefone'];
$email = $_POST['email'];
$matricula = $_POST['matricula'];

/*echo($tipoID);
echo($nome);
echo($telefone);
echo($email);
echo($matricula);*/

$sql_update = "UPDATE PESSOA SET tipoid = '$tipoID', nome = '$nome', telefone = '$telefone', email = '$email' WHERE matricula = '$matricula'";
//$sql_exec_update = $mysqli->query($sql_update);
$sql_update_usuario = "UPDATE USUARIO SET tipoid = '$tipoID' WHERE matricula = '$matricula'";

if($mysqli->query($sql_update) && $mysqli->query($sql_update_usuario)){
    echo ("
        <script>
            alert('Dados alterados com sucesso');
            location.href='selectTipoPessoa.php';
        </script>

    ");
}else{
    echo ("
        <script>
            alert('Erro de execução');
            location.href='selectTipoPessoa.php';
        </script>

    ");
}




?>