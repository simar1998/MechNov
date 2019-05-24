<%--
  Created by IntelliJ IDEA.
  User: SimarpalKalsi
  Date: 2019-05-21
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: SimarpalKalsi
  Date: 2019-05-21
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body {
      font-family: Arial, Helvetica, sans-serif;

    }

    * {
      box-sizing: border-box;
    }

    input[type=text],
    select,
    textarea {
      width: 100%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      margin-top: 6px;
      margin-bottom: 16px;
      resize: vertical;
    }

    input[type=submit] {
      background-color: #4CAF50;
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type=submit]:hover {
      background-color: #45a049;

    }

    .container {
      border-radius: 5px;
      background-color: #f2f2f2;
      padding: 20px;
      margin-left: 20%;
      width: 60%;
    }

    h3 {
      margin-left: 45%;
    }
  </style>

</head>

<body>

<h3>Firmware Commands</h3>

<div class="container">
  <form method="POST" class="firmwareCommands" id="firmwareCommands" action="/">
    <label for="firmware">Firmware</label>
    <input type="text" id="firmware" name="firmware" placeholder="Enter Firmware Name..">

    <label for="command">Command</label>
    <input type="text" id="command" name="command" placeholder="Enter Command Name..">

    <label for="cmdShort">Command Description</label>
    <input type="text" id="cmdShort" name="cmdShort" placeholder="Enter Command Description Short..">

    <label for="cmdLong">Command Description Long</label>
    <textarea id="cmdLong" name="cmdLong" placeholder="Enter Command Description Long.."
              style="height:200px"></textarea>
    <div style="text-align: center">
      <input type="button" id="submit-form" value="Submit">
    </div>
  </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
  jQuery(function ($) {
    $(document).ready(function () {

      $("#submit-form").click('submit', function () {

        var fcData = new FormData();
        fcData.append("firmware", $('#firmware').val());
        fcData.append("command", $('#command').val());
        fcData.append("cmdShort", $('#cmdShort').val());
        fcData.append("cmdLong", $('#cmdLong').val());

        alert(fcData);
        console.log(fcData);

        jQuery.ajax({
          url: "http://localhost:8080/MechNovProjects_war/api/commandAPI/addCommand/",
          type: "POST",
          contentType: false,
          processData: false,
          dataType: 'text',
          cache: false,
          data: fcData,

          success: function (data) {
            console.log(data);
          }
        });
      });
    });
  });
</script>

</body>

</html>
