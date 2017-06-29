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

//$sql_execute = $mysqli->query($sql_cadastro) or die($mysqli->error);

if($mysqli->query($sql_cadastro)){
    echo("
        <script>
            location.href='cadastroDisciplinaOferta.php';
        </script>
    ");
}else{
    echo ("<script>
    alert('Essa disciplina já está sendo ofertada para o período selecionado');
            location.href='cadastroDisciplinaOferta.php';
        </script>
        ");
}

?>