<html>
<head>
<title>Login Form</title>
</head>
<body>
<h2>Login Form</h2>
<form method="GET" action="">
<label for="username">Username:</label>
<input type="text" name="username" required><br>
<label for="password">Password:</label>
<input type="password" name="password" required><br>
<input type="submit" value="Login" name="sbtn">
</form>
<?php
$servername = "localhost";
$username = "root";
$password = "";
$db = "mydb";
$conn = mysqli_connect($servername, $username, $password, $db);
if ($conn){
if (isset($_REQUEST["sbtn"])) {
$username = $_REQUEST["username"];
$password = $_REQUEST["password"];
$sql = "SELECT * FROM users_table";
$result = mysqli_query($conn, $sql);
while ($row = mysqli_fetch_array($result)) {
if (($row['username'] == $username) && ($row['password'] == $password)) {
header("Location: welcome.php?username=".$username);
exit();
} else {
echo "<script>alert('Incorrect Username or Password')</script>";
}
}
}

if ($conn) {
    // Define the current username and the new username you want to set
    $current_username = 'user';  // Current username you want to update
    $new_username = 'new_user';  // The new username you want to set

    // SQL query to update the username
    $sql = "UPDATE users_table SET username = '$new_username' WHERE username = '$current_username'";

    // Execute the query
    if (mysqli_query($conn, $sql)) {
        echo "Username updated successfully!";
    } else {
        echo "Error: " . mysqli_error($conn);
    }

mysqli_close($conn);
}?>
</body>
</html>               
