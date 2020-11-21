<?php

class EditBlogController extends Controller {
    function __construct() {
        $this->model = new EditBlogModel();
        $this->view = new View();
    }

    function indexAction() {
        $result = $this->model->getPosts($_GET);
        $this->view->render('EditBlogView.php', 'Редактор блога', $result);
    }

    function addAction() {
        if (!empty($_POST)) {
                $this->model->addPost($_POST, $_FILES);
                $_POST = array();

            $result = $this->model->getPosts($_GET);
            $result['errors'] = [];
            $this->view->render('EditBlogView.php', 'Редактор блога', $result);
        } else {
            $this->view->render('EditBlogView.php', 'Редактор блога');
        }
    }
}