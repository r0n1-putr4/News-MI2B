    <?php

    function response($success, $message, $data) {
        header("Content-Type: application/json");

        echo json_encode([
            "is_success" => $success,
            "message" => $message,
            "data" => $data
        ]);

        exit;
    }

    ?>