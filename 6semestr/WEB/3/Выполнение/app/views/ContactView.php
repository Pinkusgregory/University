<div class='container'>
    <h2 class='section-title'>Контакт</h2>
    <form action='/Contact/check' class='feedback-form' id='form' method='POST' name='contact-form'>
        <div class='validation-error'>
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
        <div class='feedback-form-group popup' onclick='popupFunction(1)'>
            <span class='popuptext' id='myPopup1'>Обязательно 3 слова</span>
            <label for='fullname'>ФИО:</label>
            <input id='fullname' name='fullname' type='text'>
        </div>
        <div class='clearfix feedback-form-group popup' onclick='popupFunction(2)'>
            <span class='popuptext' id='myPopup2'>Не должно быть пустым</span>
            <label for='email'>Электронная почта:</label>
            <input id='email' name='email' type='text'>
        </div>
        <div class='clearfix feedback-form-group popup' onclick='popupFunction(3)'>
            <span class='popuptext' id='myPopup3'>11 цифр и начинается с +7</span>
            <label for='phone'>Номер телефона:</label>
            <input id='phone' name='phone' type='text'>
        </div>
        <div class='radio-area'>
            <label>
                <input id='Choice1' name='subscription' type='radio' value='Man'>
                Мужчина
            </label>
            <label>
                <input id='Choice2' name='subscription' type='radio' value='Woman'>
                Женщина
            </label>
        </div>
        <div class='feedback-form-group popup' onclick='popupFunction(4)'>
            <span class='popuptext' id='myPopup4'>Выберете что то одно</span>
            <label for='topic'>Возраст</label>
            <select id='topic' name='topic'>
                <option value='1'>Достиг совершеннолетия(&gt;18)</option>
                <option value='2'>Не достиг совершеннолетия(&lt;18)</option>
            </select>
        </div>
        <div class='feedback-form-group popup' onclick='popupFunction(5)'>
            <span class='popuptext' id='myPopup5'>Напишите что то</span>
            <label for='message'>Текст обращения:</label>
            <textarea id='message' name='message'></textarea>
        </div>
        <div class='feedback-form-group calendar'>
            <label for='birthDate'>Дата рождения:</label>
            <br>
            <input id='calendar-text' name='birthDate' type='text'>
            <select id='calendar-year'></select>
            <select id='calendar-month'></select>
            <table class='table' id='calendar-table'></table>
        </div>
        <button class='btn' type='submit'>Отправить</button>
        <button class='btn' type='reset'>Очистить</button>
    </form>
</div>

<script>
    function popupFunction(i) {
        var popup = document.getElementById("myPopup"+i);
        popup.classList.toggle("show");
    }
</script>
<script src='../public/js/calendar.js' type='text/javascript'></script>