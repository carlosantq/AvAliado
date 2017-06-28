<?php
include('proteger.php');
protect();
include('conexao.php');

$matricula_professor = $_POST['matricula'];
$nome_professor = $_POST['nome'];
$email = $_POST['email'];
$telefone = $_POST['telefone'];


$sql_cadastro = "INSERT INTO pessoa(matricula, tipoid, nome, telefone, email) VALUES ('$matricula_professor', 0, '$nome_professor', '$telefone', '$email')";
$sql_usuario = "INSERT INTO usuario(matricula, senha, tipoid) VALUES ('$matricula_professor', 123, 0)";
$sql_professor = "INSERT INTO professor(matricula, notaDidatica, notaProvas, notaPersonalidade) VALUES ('$matricula_professor', NULL, NULL, NULL)";
$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);
$sql_execute = $mysqli->query($sql_usuario) or die($mysqli->error);
$sql_execute = $mysqli->query($sql_professor) or die($mysqli->error);
echo("
        <script>
            location.href='cadastroprofessora.php';
        </script>
    ")
?>