<div class='container'>
    <h2 class='section-title'>Тест</h2>
    <form action='/Test/check' class='test-form' id='form' method='post'>
        <div class='validation-error' id='error'>
            <?php
            if (isset($data['errors'])) {
                foreach ($data['errors'] as $key => $item) {
                    echo "<p class='result-block__item error'>$item</p>";
                }
            } elseif (isset($data['result'])) {
                $result = $data['result'];
                echo "<p class='result-block__item'>Вы ответили верно на $result из 3 вопросов!</p>";
            }
            ?>
        </div>
        <div class='feedback-form-group'>
            <label for='fullname'>ФИО:</label>
            <input id='fullname' name='fullname' type='text'>
        </div>
        <div class='test-form-group'>
            <label for='topic'>Группа</label>
            <select id='topic' name='topic'>
                <option value='1'>1 курс 1 группа</option>
                <option value='2'>1 курс 2 группа</option>
                <option value='3'>2 курс 1 группа</option>
                <option value='4'>2 курс 2 группа</option>
                <option value='5'>3 курс 1 группа</option>
                <option value='6'>3 курс 2 группа</option>
                <option value='7'>4 курс 1 группа</option>
            </select>
        </div>
        <div class='test-form-group'>
            <label for='1st-question'>1 вопрос</label>
            <input id='1st-question' name='1st-question' type='text'>
        </div>
        <div class='checkbox-area'>
            <label for=''>2 вопрос</label>
            <label>
                <input id='Choice1' name='checkbox1' type='checkbox' value='2nd-question-1st-answer'>
                Ответ 1
            </label>
            <label>
                <input id='Choice2' name='checkbox2' type='checkbox' value='2nd-question-2nd-answer'>
                Ответ 2
            </label>
            <label>
                <input id='Choice3' name='checkbox3' type='checkbox' value='2nd-question-3rd-answer'>
                Ответ 3
            </label>
        </div>
        <div class='test-form-group'>
            <label for='3rd-question'>Вопрос 3</label>
            <select id='3rd-question' name='3rd-question'>
                <option value='1'>Ответ 1</option>
                <option value='2'>Ответ 2</option>
                <option value='3'>Ответ 3</option>
                <option value='4'>Ответ 4</option>
                <option value='5'>Ответ 5</option>
                <option value='6'>Ответ 6</option>
                <option value='7'>Ответ 7</option>
            </select>
        </div>
        <button class='btn' type='submit'>Отправить</button>
        <button class='btn' type='reset'>Очистить</button>
    </form>
</div>