<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/main/main.css">
    <link rel="stylesheet" href="styles/paginasDados.css">
    <title>FoodExpress</title>
    <link rel="icon" type="image/png" href="imgs/icon.png" />
</head>
<body>
<main>
    <h1>Oh não!</h1>
    <p>
        Você perdeu a sua senha! Mas não se preocupe, estamos aqui para te ajudar. Insira o endereço
        de e-mail associado a sua conta para confirmarmos que realmente é você. Depois, insira uma nova
        senha e guarde-a em algum lugar que você não irá esquecer.
    </p>

    <div id="input-container">
        <label for="email">E-mail</label>
        <input type="text" name="email" id="email">
    </div>

    <button>
        <input type="submit" id="enviar" value="ENVIAR">
    </button>
</main>

<script src="scripts/jquery/jquery.js"></script>


</body>
</html>
