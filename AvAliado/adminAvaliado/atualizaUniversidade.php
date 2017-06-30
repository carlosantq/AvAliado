<?php
include('proteger.php');
protect();
include ('conexao.php');
include ('headerSelectUser.php');

$universidade = $_POST['idUniversidade'];

$sql_select_universidade = "SELECT * FROM universidade WHERE id = '$universidade'";
$sql_exec_select_universidade = $mysqli->query($sql_select_universidade) or die($mysqli->error);
$row_universidade = $sql_exec_select_universidade->fetch_assoc();

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
                <form class="col s12" name="formCadastroCont" action="updateUniversidade.php" method="POST">
                     <div class="input-field col s12">
                        <input  id="idUniversidade" name="idUniversidade" type="text" class="validate" disabled required value="<?php echo ($row_universidade['id']); ?>" >
                        <input type="hidden" id="idUniversidade" name="idUniversidade" type="text" class="validate" value="<?php echo ($row_universidade['id']); ?>" >   
                        <label for="idUniversidade">Universidade</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="nome" name="nome" type="text" class="validate" required value="<?php echo ($row_universidade['nome']); ?>" >
                    <label for="periodo">Nome</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="sigla" name="sigla" type="text" class="validate" required value="<?php echo ($row_universidade['sigla']); ?>" >
                    <label for="periodo">Sigla</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="endereco" name="endereco" type="text" class="validate" required value="<?php echo ($row_universidade['endereco']); ?>" >
                    <label for="endereco">Endereco</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="telefone" name="telefone" type="text" class="validate" required value="<?php echo ($row_universidade['telefone']); ?>" >
                    <label for="telefone">Telefone</label>
                    </div>
                    <button type='submit' class='waves-effect waves-light btn right' value='Login'>Atualizar</button>
                </form>
                <a href="selectUniversidade.php" class="waves-effect waves-light btn">Voltar</a>
            </div>
        </div>
    </div>
</html>