<?php
include('proteger.php');
protect();
include ('conexao.php');
include ('headerSelectUser.php');

$sql_select_curso = "SELECT * FROM CURSO";
$sql_exec_select_curso = $mysqli->query($sql_select_curso);
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
                <form class="col s12" name="formCadastroCont" action="atualizaCurso.php" method="POST">
                <div class="input-field col s12">
                <select name = "curso" id = "curso" required>
                        
                        <option value="" disabled selected>Selecionar Curso</option>
                        
                        <?php
                        while($exec_curso = $sql_exec_select_curso->fetch_assoc()){
                            echo ("
                            <option value=".$exec_curso['id'].">".$exec_curso['nome']."</option>
                            ");
                        }
                        ?>
                    </select>
                    <label>Selecionar Curso</label>
                </div>
                <button type='submit' class='waves-effect waves-light btn right' value='Login'>Selecionar</button>

                </form>
            </div>
        </div>
</html>