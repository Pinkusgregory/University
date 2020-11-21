<?php

class FormValidation {
    public $errors = [];
    public $rules = [
        'fullname' => [
			'isNotEmpty'
		],
		'phone' => [
			'isNotEmpty',
			'isPhone'
		],
		'message' => [
			'isNotEmpty'
		],
        'birthDate' => [
            'isNotEmpty'
        ],
		'email' => [
			'isEmail'
        ],
        'topic' => [
            'isNotEmptySelect'
        ],
        'subscription' => [
            'isNotEmptySelect'
        ],
        'review' => [
            'isNotEmpty'
        ],
        'title' => [
            'isNotEmpty'
        ],
        'login' => [
            'isNotEmpty'
        ],
        'password' => [
            'isNotEmpty'
        ]
    ];

    public function getErrors() {
        return $this->errors;
    }

    public function validate($post_array) {
        $post_array;
        foreach ($post_array as $key => $item) {
            if ($this->rules[$key]) {
                foreach ($this->rules[$key] as $rule) {
                    $this->$rule($item, $key);
                }
            }
        }
    }

    public function isNotEmptySelect($data, $key) {
		if ($data == 'Выберите ответ') {
			array_push($this->errors, "Поле $key не должно быть пустым");
		}
		return true;
    }

    public function isNotEmpty($data, $key) {
        if (empty($data)) {
            if ($key == "fullname") {
                $resultKey = "ФИО";
            } elseif ($key == "group") {
                $resultKey = "Группа";
            } elseif ($key == "login") {
                $resultKey = "Логин";
            } elseif ($key == "password") {
                $resultKey = "Пароль";
            } elseif ($key == "message") {
                $resultKey = "Сообщение";
            } elseif ($key == "title") {
                $resultKey = "Тема";
            } elseif ($key == "review") {
                $resultKey = "Отзыв";
            } elseif ($key == "phone") {
                $resultKey = "Телефон";
            } elseif ($key == "date") {
                $resultKey = "Дата";
            } elseif ($key == "1st-question") {
                $resultKey = "Вопрос 3";
            }
            array_push($this->errors, "Поле $resultKey не должно быть пустым");
        }
        return true;
    }
    
    public function isInteger($data, $key = null, $value = null) {
		if (!ctype_digit($data)) {
			array_push($this->errors, "Поле $key должно содержать число");
		}
		return false;
    }
    
    public function isLess($data, $key, $value = null){
		if ($this->isInteger($data) && ((int)$this->isInteger($data) >= $value)) {
			array_push($this->errors, "Поле $key слишком длинное");
		}
		return true;
	}

	public function isGreater($data, $key, $value = null){
		if ($this->isInteger($data) && ((int)$this->isInteger($data) <= $value)) {
			array_push($this->errors, "Поле $key слишком короткое");
		}
		return true;
    }
    
    public function isEmail($data, $key, $value = null) {
		if (preg_match('/^((([0-9A-Za-z]{1}[-0-9A-z\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\.){1,2}[-A-Za-z]{2,})$/u', $data)) {
			return true;
		}
		array_push($this->errors, "В поле $key неверно введена почта");
	}

	public function isPhone($data, $key, $value = null) {
		if (preg_match('/^(\+7|\+3)([0-9]{8,10})$/', $data)) {
			return true;
		}
		array_push($this->errors, "В поле $key неверно введен номер телефона");
	}
}