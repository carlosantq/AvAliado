<?php
include('proteger.php');
protect();
include('conexao.php');

$idDisciplina = $_POST['idDisciplina'];
$idProfessor = $_POST['idProfessor'];
$idAluno = $_POST['idAluno'];
$ano = $_POST['ano'];
$semestre = $_POST['semestre'];

$sql_teste_tem_vinculo = "SELECT * FROM vinculouniversidade WHERE pessoaID='$idAluno' and universidadeID = (SELECT distinct(universidadeid) FROM Disciplinaoferta JOIN Disciplina JOIN Curso where DisciplinaOferta.id = Disciplina.id AND Disciplina.cursoID = curso.id AND DisciplinaOferta.id = '$idDisciplina')";

if($mysqli->query($sql_teste_tem_vinculo)){
    $sql_insert_vinculo = "INSERT INTO vinculoAlunoDisciplinaOferta VALUES ('$idDisciplina', '$idProfessor', '$ano', '$semestre', '$idAluno')";
    $sql_exec_insert_vinculo = $mysqli->query($sql_insert_vinculo);
    echo("
        <script>
            location.href='cadastrovinculoAlunoDisciplinaOferta.php';
        </script>
    ");
}else{
    echo("
        <script>
        alert('O usuário ".$idAluno." já possui vínculo');
            location.href='cadastrovinculoAlunoDisciplinaOferta.php';
        </script>

    ");
}




?>