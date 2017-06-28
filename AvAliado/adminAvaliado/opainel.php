<?php
include('proteger.php');
protect();
include ('conexao.php');


$sql_code = "SELECT * FROM usuario WHERE matricula = '$_SESSION[admin]'";
$sql_query = $mysqli->query($sql_code) or die ($mysqli->error);
$row = $sql_query->fetch_assoc();
/*
$sql_code_new = "SELECT * FROM noticias.noticias WHERE id_admin = '$_SESSION[admin]'";
$sql_code_new_query = $mysqli->query($sql_code_new) or die ($mysqli->error);



if(array_key_exists("id", $_GET)){
    $sql_update = "UPDATE noticias.noticias SET publica = false WHERE id_noticias = '$_GET[id]'";
    $sql_query_update = $mysqli->query($sql_update) or die ($msqli->error);
    echo "<script>location.href = 'opainel.php';</script>";
}

if(array_key_exists("id_update", $_GET)){
    $sql_update = "UPDATE noticias.noticias SET publica = true WHERE id_noticias = '$_GET[id_update]'";
    $sql_query_update = $mysqli->query($sql_update) or die ($msqli->error);
    echo "<script>location.href = 'opainel.php';</script>";
}
*/

?>

<html>
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!--<script type="text/javascript" src="materialize/js/materialize.min.js"></script>-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
        <link rel="stylesheet" href="admincss/admincss.css">
         <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
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
        <div class="col s3 leftRow">
            <ul class="collection">
                <li class="collection-item active"><a href="opainel.php">Cadastrar Disciplina</a></li>
                <li class="collection-item"><a href="cadastroaluno.php">Cadastrar Aluno</a></li>
                <li class="collection-item"><a href="cadastroprofessora.php">Cadastrar Professor</a></li>
                <li class="collection-item"><a href="cadastrouniversidade.php">Cadastrar Universidade</a></li>
                <li class="collection-item"><a href="cadastrocurso.php">Cadastrar Curso</a></li>
                <li class="collection-item"><a href="cadastroOfertaDisciplina.php">Cadastrar Oferta de Disciplina</a></li>
                <!--<li class="collection-item"><a href="">Sobre</a></li>-->
            </ul>
        </div>
        <div class="col s9">
            <?php 
            echo("<table class='highlightresponsive-table'><thead>
          <tr>
              <th>Título</th>
              <th class='center2'>Noticia</th>
              <th>Ações</th>
          </tr>
        </thead>");
            echo("<tbody>");
                while ($noticias = $sql_code_new_query->fetch_assoc()){
                    echo (' <tr>
                                <td>'.$noticias['titulo'].'</td>
                                <td>'.$noticias['noticias'].'</td>');

                                if ($noticias['publica']){
                                    echo("<td><div id='imagem'><a href='opainel.php?id=".$noticias['id_noticias']."'><i class='small material-icons'>thumb_up</i></a></div></td>");
                                }else{
                                    echo("<td><div id='imagem'><a href='opainel.php?id_update=".$noticias['id_noticias']."'><i class='small material-icons'>thumb_down</i></a></div></td>");
                                }
                                
                            echo("</tr>");

                            
                }
            echo ('</tbody></table>');
             ?>
             <div class='center2'><i class='small material-icons' >thumb_up</i>: Matéria Publicada
            <i class='small material-icons'>thumb_down</i>: Matéria Escondida</div>
        </div>
    </div>
    
    </body>
</html>