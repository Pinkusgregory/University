<!DOCTYPE html>
<html lang='en'>
<head>
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'>
    <meta charset='UTF-8'>
    <link href='../public/css/style.css' rel='stylesheet'>
    <link href='../../public/css/style.css' rel='stylesheet'>
    <link href='../../../public/css/style.css' rel='stylesheet'>
    <link href='../public/css/lightbox.min.css' rel='stylesheet'>
    <link href='../../public/css/lightbox.min.css' rel='stylesheet'>
    <link href='../../../public/css/lightbox.min.css' rel='stylesheet'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src='../public/js/historyForEachPage.js' type='text/javascript'></script>
    <script src='../../public/js/historyForEachPage.js' type='text/javascript'></script>
    <script src='../../../public/js/historyForEachPage.js' type='text/javascript'></script>

    <title><?php echo $title; ?></title>
</head>

<body>
<div class='page-header'>
    <ul class='header-nav clearfix'>
        <li class="nav-item">
            <a class="nav-link <?php if ($title == "Редактор блога") echo('menu-link-active') ?>" href="/admin/EditBlog">Редактор блога</a>
        </li>
        <li class="nav-item">
            <a class="nav-link <?php if ($title == "Загрузка отзывов") echo('menu-link-active') ?>" href="/admin/UploadReviews">Загрузка отзывов</a>
        </li>
        <li class="nav-item">
            <a class="nav-link <?php if ($title == "Загрузка постов блога") echo('menu-link-active') ?>" href="/admin/UploadPosts">Загрузка постов блога</a>
        </li>
        <li class="nav-item">
            <a class="nav-link <?php if ($title == "Статистика посещений") echo('menu-link-active') ?>" href="/admin/Statistics">Статистика посещений</a>
        </li>
        <li class="nav-item">
            <?php
            if (isset($_SESSION['isAdmin'])) {
                ?>
                <a class="nav-link" href="/admin/Auth/logout">Выход</a>
                <?php
            } else {
                ?>
                <a class="nav-link <?php if ($title == "Вход") echo('menu-link-active') ?>" href="/admin/Auth">Вход</a>
                <?php
            }
            ?>
        </li>
    </ul>
</div>

<?php
include 'app/views/admin/' . $content_view;
?>
</body>

</html>