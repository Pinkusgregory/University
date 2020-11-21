<div class='container'>
    <h2 class="mb-4">Редактор блога</h2>
    <form action="/EditBlog/add" method="POST" class="feedback-form" enctype="multipart/form-data">
        <div class="feedback-form-group">
            <input type="text" class="form-control tooltip-input" name="title" value="<?if (isset($_POST["title"])) echo $_POST["title"];?>"
                   placeholder="Тема сообщения" autocomplete="off">
        </div>
        <div class="feedback-form-group">
            <input type="text" class="form-control tooltip-input" name="author" value="<?if (isset($_POST["title"])) echo $_POST["title"];?>"
                   placeholder="Автор сообщения" autocomplete="off">
        </div>
        <div class="feedback-form-group">
            <textarea class="form-control" name="message" rows="4" placeholder="Введите сообщение"><?if (isset($_POST["message"])) echo $_POST["message"];?></textarea>
        </div>
        <button class="btn btn-primary" type="submit">Добавить</button>
    </form>
    <div class='result-block mb-4'>
        <?php
        if (isset($data['errors'])) {
            if (count($data['errors']) > 0) {
                foreach ($data['errors'] as $key => $item) {
                    echo "<p class='result-block__item error'>$item</p>";
                }
            } else {
                echo "<p class='result-block__item success'>Форма была отправлена</p>";
            }
        }
        ?>
    </div>
    <div class='posts-block'>
        <h5 class='mb-3'>Темы:</h5>
        <?php
        if (isset($data['posts']) && count($data['posts']) > 0) {
            foreach ($data['posts'] as $post) {
                echo '
                        <div class="card mb-3">
                            <div class="row no-gutters">
                                <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">'.$post['title'].'</h5>
                                    <p class="card-text">'.$post['author'].'</p>
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
                    href="/EditBlog/index/?page=<?= $data['current_page'] - 1 == 0 ? 1 : $data['current_page'] - 1?>"
                >
                    Предыдущая
                </a>
            </li>
            <?php
            for ($i = 1; $i <= $data['total_pages']; $i++) {
                if (!($i == $data['current_page'])) {
                    echo '
                            <li class="page-item">
                                <a class="page-link" href="/EditBlog/index/?page='.$i.'">'.$i.'</a>
                            </li>
                        ';
                } else {
                    echo '
                            <li class="page-item active">
                                <a class="page-link" href="/EditBlog/index/?page='.$i.'">'.$i.'</a>
                            </li>
                        ';
                }
            }
            ?>
            <li class="page-item">
                <a
                    class="page-link"
                    href="/EditBlog/index/?page=<?= $data['current_page'] + 1 > $data['total_pages'] ? $data['total_pages'] : $data['current_page'] + 1 ?>"
                >
                    Следующая
                </a>
            </li>
        </ul>
    </nav>
    <script>
        const inputFile = document.getElementById("uploadInput");
        const inputLabel = document.getElementsByClassName("custom-file-label")[0];
        inputFile.addEventListener("change", e => {
            inputLabel.innerHTML = e.target.files[0].name;
        });
    </script>
</div>