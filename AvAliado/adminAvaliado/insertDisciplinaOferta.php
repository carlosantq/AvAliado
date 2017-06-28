<?php
include('proteger.php');
protect();
include('conexao.php');

$disciplina = $_POST['idDisciplina'];
$professor = $_POST['professor'];
$ano = $_POST['ano'];
$semestre = $_POST['semestre'];


$sql_cadastro = "INSERT INTO DisciplinaOferta(id, professorID, ano, semestre) VALUES 
('$disciplina', '$professor', '$ano', '$semestre')";

$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);

echo("
        <script>
            location.href='cadastroDisciplinaOferta.php';
        </script>
    ")
?>