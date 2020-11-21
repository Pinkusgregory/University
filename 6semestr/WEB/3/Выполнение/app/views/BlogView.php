<div class='container'>
    <h2 class="section-title">Блог</h2>
    <div class='posts-block'>
        <?php
        if (isset($data['posts']) && count($data['posts']) > 0) {
            foreach ($data['posts'] as $post) {
                echo '
                        <div class="card mb-3">
                            <div class="row no-gutters">
                                <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">'.$post['title'].'</h5>
                                    <p class="card-text">'.$post['text'].'</p>
                                    <p class="card-text"><small class="text-muted">'.$post['date'].'</small></p>
                                </div>
                                </div>
                            </div>
                        </div>
                    ';
            }
        } else {
            echo "<div class='font-italic'>Тем нет</div>";
        }
        ?>
    </div>
    <nav class="mt-3 <?= $data['total_pages'] == 0 ? 'd-none' : '' ?>">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a
                    class="page-link"
                    href="/Blog/Index/?page=<?= $data['current_page'] - 1 == 0 ? 1 : $data['current_page'] - 1?>"
                >
                    Предыдущая
                </a>
            </li>
            <?php
            for ($i = 1; $i <= $data['total_pages']; $i++) {
                if (!($i == $data['current_page'])) {
                    echo '
                            <li class="page-item">
                                <a class="page-link" href="/Blog/Index/?page='.$i.'">'.$i.'</a>
                            </li>
                        ';
                } else {
                    echo '
                            <li class="page-item active">
                                <a class="page-link" href="/Blog/Index/?page='.$i.'">'.$i.'</a>
                            </li>
                        ';
                }
            }
            ?>
            <li class="page-item">
                <a
                    class="page-link"
                    href="/Blog/Index/?page=<?= $data['current_page'] + 1 > $data['total_pages'] ? $data['total_pages'] : $data['current_page'] + 1 ?>"
                >
                    Следующая
                </a>
            </li>
        </ul>
    </nav>
</div>