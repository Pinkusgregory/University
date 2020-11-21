<div class='container'>
    <h2 class='section-title'>Интересы</h2>
    <?php
    foreach($data as $row) {
        echo '
                    <div class="interest-dropdown">
                        <button class="interest-dropbtn">'.$row['id'].'</button>
                                <div class="interest-dropdown-content">
                ';
        foreach ($row['desc'] as $l) {
            echo '
                <a href="#'.$l['id'].'">'.$l['desc'].'</a>
            ';
        };
        echo '
                </div>
            </div>
        ';
    };
    ?>

    <?php
    foreach ($data as $row) {
        echo '
            <h3 class="bigtext" id="' . $row['idh'] . '">' . $row['texth'] . '</h3>
                <ul id="' . $row['id'] . '">
        ';
        foreach ($row['desc'] as $l) {
            echo '
                <li id="' . $l['id'] . '">
                    <p>' . $l['desc'] . '</p>
                </li>
          ';
        };
        echo '</ul>';
    };
    ?>
</div>