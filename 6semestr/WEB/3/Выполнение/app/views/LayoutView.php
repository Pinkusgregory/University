<!DOCTYPE html>
<html lang='en'>
<head>
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'>
    <meta charset='UTF-8'>
    <link href='../public/css/style.css' rel='stylesheet'>
    <link href='../../public/css/style.css' rel='stylesheet'>
    <link href='../public/css/lightbox.min.css' rel='stylesheet'>
    <link href='../../public/css/lightbox.min.css' rel='stylesheet'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src='../public/js/historyForEachPage.js' type='text/javascript'></script>
    <script src='../../public/js/historyForEachPage.js' type='text/javascript'></script>

    <title><?php echo $title; ?></title>
</head>
<body>
<div class='page-header'>
    <ul class='header-nav clearfix'>
        <li>
            <a href='/'>Главная</a>
        </li>
        <li>
            <a href='/About'>Обо мне</a>
        </li>
        <li>
            <a href='/Hobby'>Интересы</a>
        </li>
        <li>
            <a href='/Studies'>Учеба</a>
        </li>
        <li>
            <a href='/Photo'>Фотоальбом</a>
        </li>
        <li>
            <a href='/Contact'>Контакт</a>
        </li>
        <li>
            <a href='/Test'>Тест</a>
        </li>
        <li>
            <a href='/History'>История</a>
        </li>
        <li>
            <a href='/GuestBook'>Гостевая книга</a>
        </li>
        <li>
            <a href='/Blog'>Блог</a>
        </li>
    </ul>
    <ul class="header-nav clearfix">
        <li class="nav-item">
            <?php
            if(!empty($_SESSION['isUser'])) {
                if ($_SESSION['isUser']) {
                    ?>
                    <div class="nav-link active">Пользователь: <?= $_SESSION['userFullname'] ?></div>
                    <?php
                }
            } else {
                ?>
                <a class="nav-link <?php if ($title == "Вход") echo('menu-link-active') ?>" href="/Auth/signin">Вход</a>
                <?php
            }
            ?>
        </li>
        <li class="nav-item">
            <?php
            if(!empty($_SESSION['isUser'])) {
                if ($_SESSION['isUser']) {
                    ?>
                    <a class="nav-link <?php if ($title == "Выход") echo('menu-link-active') ?>" href="/Auth/logout">Выход</a>
                    <?php
                }
            } else {
                ?>
                <a class="nav-link <?php if ($title == "Регистрация") echo('menu-link-active') ?>" href="/Auth/signup">Регистрация</a>
                <?php
            }
            ?>
        </li>
    </ul>
</div>

<div class='main'>
    <?php
    include 'app/views/' . $content_view;
    ?>
</div>
<div class='page-footer'>
    <div class='container'>
        <div class='clearfix'>
            <h3>Черняев Labs © 2019</h3>
        </div>
    </div>
</div>
</body>
</html>