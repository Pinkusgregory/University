<?php

class CustomFormValidation extends FormValidation {

    public function __construct() {
        $this->rules['fullname'] = ['isNotEmpty'];
        $this->rules['1st-question'] = ['isNotEmpty', 'isInteger'];
        $this->rules['3rd-question'] = ['isNotEmpty'];
        $this->rules['topic'] = ['isNotEmpty'];
        $this->rules['checkbox1'] = ['isNotEmpty'];
        $this->rules['checkbox2'] = ['isNotEmpty'];
        $this->rules['checkbox3'] = ['isNotEmpty'];
    }

}