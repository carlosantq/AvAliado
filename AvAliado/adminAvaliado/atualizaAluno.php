<?php
include('proteger.php');
protect();
include ('conexao.php');
include ('headerSelectUser.php');

$pessoa = $_POST['matricula'];

$sql_select_pessoa = "SELECT * FROM aluno WHERE matricula = '$pessoa'";
$sql_exec_select_pessoa = $mysqli->query($sql_select_pessoa) or die($mysqli->error);
$row_pessoa = $sql_exec_select_pessoa->fetch_assoc();

?>
<!DOCTYPE>
<html>
    <?php
        include('head.php');
    ?>
    <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right">Atualização de Aluno</a>
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
                <form class="col s12" name="formCadastroCont" action="updateAluno.php" method="POST">
                     <div class="input-field col s12">
                        <input  id="matricula" name="matricula" type="text" class="validate" disabled required value="<?php echo ($row_pessoa['matricula']); ?>" >
                        <input type="hidden" id="matricula" name="matricula" type="text" class="validate" value="<?php echo ($row_pessoa['matricula']); ?>" >   
                        <label for="matricula">Matricula</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="periodo" name="email" type="text" class="validate" required value="<?php echo ($row_pessoa['periodo']); ?>" >
                    <label for="periodo">Período</label>
                    </div>
                    <button type='submit' class='waves-effect waves-light btn right' value='Login'>Atualizar</button>
                </form>
                <a href="selectAluno.php" class="waves-effect waves-light btn">Voltar</a>
            </div>
        </div>
    </div>
</html>