<?php
include('proteger.php');
protect();
include ('conexao.php');
include ('headerSelectUser.php');

$pessoa = $_POST['matricula'];

$sql_select_pessoa = "SELECT * FROM PESSOA WHERE matricula = '$pessoa'";
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
                    <a href="#" class="brand-logo right">Cadastro de Aluno</a>
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
                <form class="col s12" name="formCadastroCont" action="updateTipoPessoa.php" method="POST">
                     <div class="input-field col s12">
                        <input  id="matricula" name="matricula" type="text" class="validate" disabled required value="<?php echo ($row_pessoa['matricula']); ?>" >
                        <input type="hidden" id="matricula" name="matricula" type="text" class="validate" value="<?php echo ($row_pessoa['matricula']); ?>" >   
                        <label for="matricula">Matricula</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="nome" name="nome" type="text" class="validate" required value="<?php echo ($row_pessoa['nome']); ?>" >
                    <label for="nome">Nome</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="telefone" name="telefone" type="text" class="validate" required value="<?php echo ($row_pessoa['telefone']); ?>" >
                    <label for="telefone">Telefone</label>
                    </div>
                    <div class="input-field col s6">
                        <input  id="email" name="email" type="text" class="validate" required value="<?php echo ($row_pessoa['email']); ?>" >
                    <label for="email">Email</label>
                    </div>
                    <div class="input-field col s12">
                    <?php
                    if($row_pessoa['tipoid'] == 0){
                        echo ("<script>alert(entrou em 0)</script>");
                        echo("
                            <p>
                            <input name='tipoPessoa' value = '1' type='radio' id='1' />
                            <label for='1'>Aluno</label>

                            <input name='tipoPessoa' type='radio' value='0' id='0' checked />
                            <label for='0'>Professor</label>

                            <input name='tipoPessoa' type='radio' value='3' id='3' />
                            <label for='3'>Administrador</label>
                        </p>
                        
                        ");
                    }else if($row_pessoa['tipoid'] == 1){
                          echo ("<script>alert(entrou em 1)</script>");
                        echo("
                            <p>
                            <input name='tipoPessoa' type='radio' id='1' value='1' checked/>
                            <label for='1'>Aluno</label>

                            <input name='tipoPessoa' type='radio' id='0' value='0' />
                            <label for='0'>Professor</label>

                            <input name='tipoPessoa' type='radio' id='3' value='3' />
                            <label for='3'>Administrador</label>
                        </p>
                        
                        ");
                    }else if($row_pessoa['tipoid'] == 3){
                          echo ("<script>alert(entrou em 3)</script>");
                        echo("
                            <p>
                            <input name='tipoPessoa' type='radio' id='1' value='1' />
                            <label for='1'>Aluno</label>

                            <input name='tipoPessoa' type='radio' id='0' value='0' />
                            <label for='0'>Professor</label>

                            <input name='tipoPessoa' type='radio' id='3' value='3' checked />
                            <label for='3'>Administrador</label>
                        </p>
                        
                        ");
                    }
                    ?>
                    </div>
                    
                    </div>
                    <button type='submit' class='waves-effect waves-light btn right' value='Login'>Atualizar</button>
                </form>
                <a href="selectTipoPessoa.php" class="waves-effect waves-light btn">Voltar</a>
            </div>
        </div>
    </div>
</html>