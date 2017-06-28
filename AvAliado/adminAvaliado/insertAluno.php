<?php
include('proteger.php');
protect();
include('conexao.php');

$matricula_aluno = $_POST['matricula'];
$nome_aluno = $_POST['nome'];
$email = $_POST['email'];
$telefone = $_POST['telefone'];
$periodo = $_POST['periodo'];


$sql_cadastro = "INSERT INTO pessoa(matricula, tipoid, nome, telefone, email) VALUES ('$matricula_aluno', 0, '$nome_aluno', '$telefone', '$email')";
$sql_usuario = "INSERT INTO usuario(matricula, senha, tipoid) VALUES ('$matricula_aluno', 123, 0)";
$sql_aluno = "INSERT INTO aluno VALUES ('$matricula_aluno', '$periodo')";
$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);
$sql_execute = $mysqli->query($sql_usuario) or die($mysqli->error);
$sql_execute = $mysqli->query($sql_aluno) or die($mysqli->error);
echo("
        <script>
            location.href='cadastroaluno.php';
        </script>
    ")
?>