<?php
include('proteger.php');
protect();
include('conexao.php');

$nome_universidade = $_POST['nome'];
$endereco_universidade = $_POST['endereco'];
$sigla_universidade = $_POST['sigla'];
$telefone_universidade = $_POST['telefone'];

$sql_cadastro = "INSERT INTO universidade(nome, sigla, endereco, telefone, notaEstrutura, notaVidaCultural, notaAuxilios) VALUES ('$nome_universidade', '$sigla_universidade', '$endereco_universidade',  '$telefone_universidade', NULL, NULL, NULL)";
//$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);


$sql_compare = "SELECT * FROM UNIVERSIDADE";
$sql_exec_compare = $mysqli->query($sql_compare);
//$row_exec = $sql_exec_compare->fetch_assoc();
while ($row_exec = $sql_exec_compare->fetch_assoc()){
    if (strtoupper($row_exec['nome']) == strtoupper($nome_universidade)){
        echo ("
            <script>
                alert('A instituição ".$nome_universidade." já existe em nossa base de dados');
                location.href='cadastrouniversidade.php';
            </script>
        ");
    }else{
        if($mysqli->query($sql_cadastro)){
            echo("
                <script>
                    location.href='cadastrouniversidade.php';
                </script>
            ");
            break;
        }
    }
}


?>