<?php
include('proteger.php');
protect();
include ('conexao.php');
include ('headerSelectUser.php');

$iddisciplina = $_POST['iddisciplina'];

$sql_select_disciplina = "SELECT * FROM disciplina WHERE id = '$iddisciplina'";
$sql_exec_select_disciplina = $mysqli->query($sql_select_disciplina);
$row_disciplina = $sql_exec_select_disciplina->fetch_assoc();


/*$sql_select_nome_curso = "SELECT nome FROM curso WHERE id IN (SELECT cursoID FROM disciplina WHERE cursoID = '$iddisciplina')";
$sql_exec_select_nome_curso = $mysqli->query($sql_select_nome_curso);*/
$row_curso = $sql_exec_select_disciplina->fetch_assoc();

?>
<!DOCTYPE>
<html>
    <?php
        include('head.php');
    ?>
    <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right">Atualização de Disciplina</a>
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
                <form class="col s12" name="formCadastroCont" action="updateDisciplina.php" method="POST">
                     <div class="input-field col s12">
                        <input  id="disciplina" name="disciplina" type="text" class="validate" disabled required value="<?php echo ($row_disciplina['id']." - " .$row_disciplina['nome']); ?>" >
                        <input type="hidden" id="disciplina" name="disciplina" type="text" class="validate" value="<?php echo ($row_disciplina['id']); ?>" >   
                        <label for="disciplina">Disciplina</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="nome" name="nome" type="text" class="validate" required value="<?php echo ($row_disciplina['nome']); ?>" >
                    <label for="nome">Nome</label>
                    </div>
                    </div>
                    <button type='submit' class='waves-effect waves-light btn right' value='Login'>Atualizar</button>
                </form>
                <a href="selectDisciplina.php" class="waves-effect waves-light btn">Voltar</a>
            </div>
        </div>
</html>