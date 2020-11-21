<div class='container'>
    <h2 class='section-title'>Фотоальбом</h2>
    <div class='photo-wrap' id='gallery'>
        <?php
        foreach($data as $row) {
            echo '<a href="'.$row['images'].'" title="'.$row['title'].'" data-lightbox="miphotos">
                    <img src="'.$row['images'].'">
                </a>';
        }
        ?>
    </div>
</div>

<script src='../public/js/lightbox-plus-jquery.min.js' type='text/javascript'></script>