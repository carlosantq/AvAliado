<?php
//https://www.youtube.com/watch?v=Zjz4hy6iG1o
    //echo "entrou";
    include("conexao.php");

    if(isset($_POST['usuario']) && strlen($_POST['usuario']) > 0){
        //echo "isset user && strlen > 0";
        if(!isset($_SESSION))
            session_start();
            //echo "session start";

        $_SESSION['usuario'] = $mysqli->escape_string($_POST['usuario']);
        //$_SESSION['senha'] = md5($_POST['senha']);
        $_SESSION['senha'] = $_POST['senha'];
        //echo "session user session senha";
        $sql_code = "SELECT * FROM Avaliado.Pessoa WHERE Pessoa.matricula = '$_SESSION[usuario]'";
        $sql_query = $mysqli->query($sql_code) or die ($mysqli->error);
        $dado = $sql_query->fetch_assoc();
        $total = $sql_query->num_rows;
        if($total == 0){
            $erro[] = "opa. esse usuario nao pertence a nenhum admin";
        }else{
            $sql_pass = "SELECT * FROM avaliado.usuario WHERE usuario.matricula = '$_SESSION[usuario]'";
            $sql_query_pass = $mysqli->query($sql_pass) or die ($mysqli->error);
            $pass_exec = $sql_query_pass->fetch_assoc();
            if ($pass_exec['senha'] == $_SESSION['senha']){
                $_SESSION['admin'] =  $pass_exec['matricula'];
                //echo "senha dado == senha session";
            }else{
                $erro[] = "senha incorreta";
            }
        }
        if (!isset($erro)){
            echo "<script>location.href = 'opainel.php';</script>"; 
        }
    }
?>
<!DOCTYPE>
<html>
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="admincss/adminCss.css">
        <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
    <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <div class="body_login">
            <div class="row">
                <form class="col s12" name="formLogin" method="POST" action="">
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">account_circle</i>
                            <input id="icon_prefix" type="text" class="validate" name="usuario" required>
                            <label for="icon_prefix">Login</label>
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">vpn_key</i>
                            <input id="vpn_key" type="password" class="validate" name="senha">
                            <label for="vpn_key">Senha</label>
                        </div>
                    </div>
                    <button type='submit' class='waves-effect waves-light btn right' value='Login'>Login</button>
                </form>
            </div>
        </div>
    </body>
</html>

