<?php

class StrController extends Controller {
    function __construct() {
        $this->view = new View();
        $this->model = new StrModel();
    }

    function indexAction() {
        $this->view->render('StrView.php', 'Str');
    }

    function createAction() {

            $reviews = $this->model->strArray;
            $vars = [ 'errors' => [], 'reviews' => $reviews ];

            $this->view->render('StrView.php', 'Str', $vars);
        }
}