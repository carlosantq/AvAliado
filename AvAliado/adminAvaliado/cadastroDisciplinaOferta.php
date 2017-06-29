<?php
include('proteger.php');
protect();
include ('conexao.php');


$sql_code = "SELECT * FROM usuario WHERE matricula = '$_SESSION[admin]'";
$sql_query = $mysqli->query($sql_code) or die ($mysqli->error);
$row = $sql_query->fetch_assoc();



$sql_select_disciplina = "SELECT * FROM disciplina";
$sql_exec_consulta = $mysqli->query($sql_select_disciplina) or die ($mysqli->error);

$sql_select_professor = "SELECT * FROM pessoa WHERE tipoid = 0";
$sql_exec_professor = $mysqli->query($sql_select_professor) or die ($mysqli->error);

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
                    <a href="#" class="brand-logo right">Admin</a>
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
        <!--<div class="col s3 leftRow">
            <ul class="collection">
                <li class="collection-item"><a href="opainel.php">Cadastrar Disciplina</a></li>
                <li class="collection-item"><a href="cadastroaluno.php">Cadastrar Aluno</a></li>
                <li class="collection-item"><a href="cadastroprofessora.php">Cadastrar Professor</a></li>
                <li class="collection-item"><a href="cadastrouniversidade.php">Cadastrar Universidade</a></li>
                <li class="collection-item"><a href="cadastrocurso.php">Cadastrar Curso</a></li>
                <li class="collection-item"><a href="cadastroOfertaDisciplina.php">Cadastrar Oferta de Disciplina</a></li>
                <li class="collection-item"><a href="cadastroVinculo.php">Cadastrar Vinculo de Aluno/Professor com Universidade</a></li>
                <li class="collection-item active"><a href="cadastroDisciplinaOferta.php">Cadastrar Oferta de Disciplina</a></li>
                <li class="collection-item active"><a href="cadastroVinculoCurso.php">Cadastrar Vínculo com Cursos</a></li> 
            </ul>
        </div>-->
        <br>
        <div class="col s9">
            <div class="row">
                <form class="col s12" name="formCadastroCont" action="insertDisciplinaOferta.php" method="POST">
               <div class="input-field col s12">
                    <select name = "idDisciplina" id="idDisciplina" required>
                        <option value="" disabled selected>Escolha a Disciplina</option>

                        <?php
                        while($exec_curso = $sql_exec_consulta->fetch_assoc()){
                            echo ("
                            <option value=".$exec_curso['id'].">".$exec_curso['nome']."</option>
                            ");
                        }
                        ?>
                    </select>
                    <label>Selecionar a Disciplina</label>
                </div>
                <div class="input-field col s12">
                    <select name="professor" id="professor" required>
                        <option value="" disabled selected>Escolha o Professor</option>

                        <?php
                        while($exec_prof = $sql_exec_professor->fetch_assoc()){
                            echo ("
                            <option value=".$exec_prof['matricula'].">".$exec_prof['nome']."</option>
                            ");
                        }
                        ?>
                    </select>
                    <label>Selecionar o Professor</label>
                </div>
                <div class="row">
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