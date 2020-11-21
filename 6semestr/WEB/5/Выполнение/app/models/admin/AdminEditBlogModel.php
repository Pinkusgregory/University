<?php

class AdminEditBlogModel extends Model {
    public function __construct() {
        parent::__construct();
        static::$tablename = 'blog';
        static::$dbfields = array('title', 'author', 'text', 'date');
    }

    public function getPosts($get_array) {
        $countOfPosts = $this->getCount();
        $rowsPerPage = 3;
        $totalPages = ceil($countOfPosts / $rowsPerPage);

        if (isset($get_array['page']) && is_numeric($get_array['page'])) {
            $currentPage = (int) $get_array['page'];
        } else {
            $currentPage = 1;
        }

        if ((int) $currentPage > (int) $totalPages) {
            $currentPage = $totalPages;
        }

        if ((int) $currentPage < 1) {
            $currentPage = 1;
        }

        $offset = ($currentPage - 1) * $rowsPerPage;

        $posts = $this->findByPage($offset, $rowsPerPage);

        $comments = [];
        foreach ($posts as $post) {
            $sql = "SELECT * FROM comments WHERE title_post='".$post['title']."' ORDER BY date DESC";
            array_push($comments, $this->executeSQL($sql));
        }

        $result = [
            "posts" => $posts,
            "comments" => $comments,
            "current_page" => $currentPage,
            "total_pages" => $totalPages
        ];

        return $result;
    }

    public function addPost($post_array) {
        $data = [
            "title" => $post_array["title"],
            "author" => $post_array["author"],
            "text" => $post_array["message"]
        ];

        array_push($data, date('Y-m-d H:i:s'));

        $this->save($data);
    }

    public function editPost($post_array) {
        $sql = "
            UPDATE blog 
            SET 
                text = '".$post_array["message"]."'
            WHERE 
                title = '".$post_array["title"]."'
        ";
        $this->executeSQL($sql);
    }
}