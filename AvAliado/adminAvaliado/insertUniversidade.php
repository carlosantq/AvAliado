<?php
include('proteger.php');
protect();
include('conexao.php');

$nome_universidade = $_POST['nome'];
$endereco_universidade = $_POST['endereco'];
$sigla_universidade = $_POST['sigla'];
$telefone_universidade = $_POST['telefone'];

$sql_cadastro = "INSERT INTO universidade(nome, sigla, endereco, telefone, notaEstrutura, notaVidaCultural, notaAuxilios) VALUES ('$nome_universidade', '$sigla_universidade', '$endereco_universidade',  '$telefone_universidade', NULL, NULL, NULL)";
$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);
echo("
        <script>
            location.href='cadastrouniversidade.php';
        </script>
    ")
?>