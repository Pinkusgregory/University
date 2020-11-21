<?php

require_once 'app/models/admin/AdminEditBlogModel.php';
require_once "app/core/AdminController.php";

class AdminEditBlogController extends AdminController {
    function __construct() {
        $this->model = new AdminEditBlogModel();
        $this->view = new View();
    }

    function indexAction() {
        $this->checkIsAuth();
        $result = $this->model->getPosts($_GET);
        $this->view->render('AdminEditBlogView.php', 'Редактор блога', $result, 'AdminLayoutView.php');
    }

    function addAction() {
        $this->checkIsAuth();
        if (!empty($_POST)) {
            $this->model->validator->validate($_POST);
            $errors = $this->model->validator->getErrors();

            if (empty($errors)) {
                $this->model->addPost($_POST, $_FILES);
                $_POST = array();
            }

            $result = $this->model->getPosts($_GET);
            $result['errors'] = $errors;
            $this->view->render('AdminEditBlogView.php', 'Редактор блога', $result, 'AdminLayoutView.php');
        } else {
            $this->view->render('AdminEditBlogView.php', 'Редактор блога', null, 'AdminLayoutView.php');
        }
    }
}