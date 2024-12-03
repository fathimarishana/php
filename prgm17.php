<html>
<head>
    <title>Factorial</title>
</head>
<body>
    <form method="POST" action="">
        <label>Enter the number:</label>
        <input type="text" name="number">
        <input type="submit" name="sub" value="SUBMIT">
    </form>

    <?php
    if (isset($_POST["sub"])) {
        $num = $_POST["number"];

        // Check if the number is a valid positive integer
        if (is_numeric($num) && $num >= 0) {
            $fact = 1;
            // Corrected for loop syntax
            for ($i = 1; $i <= $num; $i++) {
                $fact = $fact * $i;
            }
            echo "Factorial of $num is $fact";
        } else {
            echo "Please enter a valid number.";
        }
    }
    ?>
</body>
</html>

