<?php
include('proteger.php');
protect();
include ('conexao.php');
include ('headerSelectUser.php');


$sql_select_disciplinas_oferta = "SELECT nome, id FROM Disciplina WHERE id IN (Select id FROM DisciplinaOferta)";
$sql_exec_select_disciplinas_oferta = $mysqli->query($sql_select_disciplinas_oferta) or die ($mysqli->error);

$sql_select_professores = "SELECT nome, matricula FROM pessoa WHERE matricula IN (SELECT matricula FROM PROFESSOR)";
$sql_exec_select_professores = $mysqli->query($sql_select_professores) or die ($mysqli->error);

$sql_select_alunos = "SELECT nome, matricula FROM pessoa WHERE matricula IN (SELECT matricula FROM aluno)";
$sql_exec_select_alunos = $mysqli->query($sql_select_alunos) or die ($mysqli->error);


?>

<html>
 <meta charset="UTF-8">
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!--<script type="text/javascript" src="materialize/js/materialize.min.js"></script>-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
        <link rel="stylesheet" href="admincss/admincss.css">
         <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script>
            $(document).ready(function() {
                $('select').material_select();
            });
        </script>
    </head>
    <body class="test">
    <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right">Cadastro de Aluno em Disciplina Ofertada</a>
                    <!--<a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>-->
                    <div id="nav-mobile" class="left hide-on-med-and-down">
                        <div class="active"><a href="#"><img class="circle responsive-img" src="img/avatar1.png" alt="avatar"><?php echo ("Bem Vindo, ".$row['matricula']."!"); ?></a>      <a href='logout.php'>Sair</a></div>
                    </div>
                </div>
            </nav>
        </div>   
    
    <div class="row ">
    <?php
        include ('leftMenu.php');
        ?>
        <br>
        <div class="col s9">
            <div class="row">
                <form class="col s12" name="formCadastroCont" action="insertVinculoAlunoDisciplinaOferta.php" method="POST">
                <div class="input-field col s12">
                    <select name = "idDisciplina" id = "idDisciplina" required>
                        <option value="" disabled selected>Escolha a Disciplina</option>

                        <?php
                        while($exec_disciplina = $sql_exec_select_disciplinas_oferta->fetch_assoc()){
                            echo ("
                            <option value=".$exec_disciplina['id'].">".$exec_disciplina['id']. ' - ' . $exec_disciplina['nome']."</option>
                            ");
                        }
                        ?>
                    </select>
                    <label>Selecionar Disciplina</label>
                </div>
                <div class="input-field col s12">
                    <select name = "idProfessor" id = "idProfessor" required>
                        <option value="" disabled selected>Escolha o Professor</option>

                        <?php
                        while($exec_professor = $sql_exec_select_professores->fetch_assoc()){
                            echo ("
                            <option value=".$exec_professor['matricula'].">".$exec_professor['nome']."</option>
                            ");
                        }
                        ?>
                    </select>
                    <label>Selecionar Professor</label>
                </div>
                <div class="input-field col s12">
                    <select name = "idAluno" id = "idAluno" required>
                        <option value="" disabled selected>Escolha o Aluno</option>

                        <?php
                        while($exec_aluno = $sql_exec_select_alunos->fetch_assoc()){
                            echo ("
                            <option value=".$exec_aluno['matricula'].">".$exec_aluno['nome']."</option>
                            ");
                        }
                        ?>
                    </select>
                    <label>Selecionar Aluno</label>
                    <div class="input-field col s2">
                    <input  id="ano" name="ano" type="text" class="validate" required>
                    <label for="ano">Ano</label>
                    </div>
                    <div class="input-field col s2">
                    <select name="semestre" id="semestre" required>
                        <option value="" disabled selected>Escolha o Semestre   </option>

                        
                            <option value="1">1</option>
                            <option value="2">2</option>
                            
                    </select>
                    <label>Selecionar o Semestre</label>
                </div>
                </div>

                <button type='submit' class='waves-effect waves-light btn right' value='Login'>Cadastrar</button>
                </form>
            </div>
        </div>
    
    </body>
</html>