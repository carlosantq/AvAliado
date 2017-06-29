<?php
include('proteger.php');
protect();
include ('conexao.php');

/*
$sql_code = "SELECT * FROM usuario WHERE matricula = '$_SESSION[admin]'";
$sql_query = $mysqli->query($sql_code) or die ($mysqli->error);
$row = $sql_query->fetch_assoc();*/

$sql_select_universidade = "SELECT * FROM universidade";
$sql_exec_consulta = $mysqli->query($sql_select_universidade) or die ($mysqli->error);
//$exec_universidade = $sql_exec_consulta->fetch_assoc();
?>
<!DOCTYPE>
<html>
    <?php
        include('head.php');
    ?>
    <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right">Cadastro de Curso</a>
                    <!--<a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>-->
                    <div id="nav-mobile" class="left hide-on-med-and-down">
                        <div class="active"><a href="#"><img class="circle responsive-img" src="img/avatar1.png" alt="avatar"><?php echo ("Bem Vindo, "./*$row['matricula']*/$_SESSION['admin']."!"); ?></a>      <a href='logout.php'>Sair</a></div>
                    </div>
                </div>
            </nav>
        </div>   
    
    <div class="row ">
    <?php
        include ('leftMenu.php');
        ?>
        <div class="col s9">
            <div class="row">
                <form class="col s12" name="formCadastroCont" action="insertCurso.php" method="POST">
                <div class="row">
                    <div class="input-field col s6">
                    <input  id="nome" name="nome" type="text" class="validate" required>
                    <label for="nome">Nome do Curso</label>
                    </div>
                </div>
                <div class="input-field col s12">
                    <select name = "idUniversidade" id = "idUniversidade" required>
                        <option value="" disabled selected>Escolha a Universidade</option>

                        <?php
                        while($exec_universidade = $sql_exec_consulta->fetch_assoc()){
                            echo ("
                            <option value=".$exec_universidade['id'].">".$exec_universidade['nome']." - ".$exec_universidade['sigla']."</option>
                            ");
                        }
                        ?>
                    </select>
                    <label>Selecionar Universidade</label>
                </div>
                <button type='submit' class='waves-effect waves-light btn right' value='Login'>Cadastrar</button>
                </form>
            </div>
        </div>
</html>