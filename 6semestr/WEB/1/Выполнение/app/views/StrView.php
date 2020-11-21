<div class='container'>
    <h2 class='section-title'>Str</h2>
    <form action="/Str/create" method="POST">
        <button class="btn btn-primary" type="submit">Отправить</button>
    </form>
    <?php
    if (isset($data['reviews']) && count($data['reviews']) > 0) {
        foreach ($data['reviews'] as $review) {
            echo "
                        <div class='reviews-block__item'>
                                <b>$review</b>
                        </div>
                        <div class='reviews-block__item'>
                                <b>$review</b>
                        </div>
                        <div class='reviews-block__item'>
                                <b>$review</b>
                        </div>
                    ";
        }
    }
    ?>
</div>

<script src='../public/js/time.js' type='text/javascript'></script>