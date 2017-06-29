<?php
include('proteger.php');
protect();
include('conexao.php');

$idPessoa = $_POST['idPessoa'];
$idUniversidade = $_POST['idUniversidade'];

$sql_inserir_vinculo = "INSERT INTO vinculoUniversidade VALUES ('$idUniversidade', '$idPessoa')";
//$sql_execute = $mysqli->query($sql_inserir_vinculo) or die($mysqli->error);

if($mysqli->query($sql_inserir_vinculo)){
    echo("
            <script>
                location.href='cadastroVinculoUniversidade.php';
            </script>
        ");
}else{
    echo("
        <script>
        alert('O usuário ".$idPessoa." já está cadastrado');
            location.href='cadastroVinculoUniversidade.php';
        </script>

    ");
}

?>