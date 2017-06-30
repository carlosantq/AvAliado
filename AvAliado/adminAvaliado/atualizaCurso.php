<?php
include('proteger.php');
protect();
include ('conexao.php');
include ('headerSelectUser.php');

$curso = $_POST['curso'];

$sql_select_curso = "SELECT * FROM curso WHERE id = '$curso'";
$sql_exec_select_curso = $mysqli->query($sql_select_curso) or die($mysqli->error);
$row_curso = $sql_exec_select_curso->fetch_assoc();

?>
<!DOCTYPE>
<html>
    <?php
        include('head.php');
    ?>
    <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right">Atualização de Curso</a>
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
                <form class="col s12" name="formCadastroCont" action="updateCurso.php" method="POST">
                     <div class="input-field col s12">
                        <input  id="curso" name="curso" type="text" class="validate" disabled required value="<?php echo ($row_curso['id']); ?>" >
                        <input type="hidden" id="curso" name="curso" type="text" class="validate" value="<?php echo ($row_curso['id']); ?>" >   
                        <label for="curso">Curso</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="nome" name="nome" type="text" class="validate" required value="<?php echo ($row_curso['nome']); ?>" >
                    <label for="nome">Nome</label>
                    </div>
                    </div>
                    <button type='submit' class='waves-effect waves-light btn right' value='Login'>Atualizar</button>
                </form>
                <a href="selectAluno.php" class="waves-effect waves-light btn">Voltar</a>
            </div>
        </div>
    </div>
</html>