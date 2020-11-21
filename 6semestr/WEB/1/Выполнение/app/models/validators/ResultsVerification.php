<?php

require 'app/models/validators/CustomFormValidation.php';

class ResultsVerification extends CustomFormValidation {
    private $result = 0;
    public $answers = [
        '1st-question' => '20',
        '3rd-question' => '2'
    ];

    public function __construct() {
        parent::__construct();
    }

    public function checkAns($post_array) {
        foreach ($this->answers as $key => $value) {
            if ($post_array[$key] == $value) {
                $this->result++;
            }
        }
        if (isset($post_array['checkbox1']) && !isset($post_array['checkbox2']) && isset($post_array['checkbox3'])) {
            $this->result++;
         } 
    }

    public function getResult() {
        return $this->result;
    }
}