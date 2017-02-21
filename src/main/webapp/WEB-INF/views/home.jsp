<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript">
        function validateForm() {
        		var unindexed_array = $("#myForm").serializeArray();
                var indexed_array = {};
                $.each(unindexed_array,
                	    function(i, v) {
                	indexed_array[v.name] = v.value;
                	    });
                var jsonData = JSON.stringify(indexed_array);
                alert(jsonData)
                $.ajax({
                	  type: "POST",
                	  url: "executeCustomJob",
                	  data: jsonData,
                	  success:function(data){
                		  var display = data.fetchedRecords.replace(/\n/g, '<br />');
                		  $("#p1").html(display)
                	  },
                	  dataType: "json",
                	  contentType : "application/json"
                	});
        		return false;
        	}
        function getFormData($form){
            var unindexed_array = $form.serializeArray();
            var indexed_array = {};
            $.each(unindexed_array,
            	    function(i, v) {
            	indexed_array[v.name] = v.value;
            	    });
            alert(indexed_array);
            return indexed_array;
        }
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>This is the homepage!</p>
        <form id="myForm" name="myForm" >
			Host Name: <input type="text" name="hostName"> <br><br>
			Host User: <input type="text" name="hostUser"> <br><br>
			Host Password: <input type="text" name="hostPassword"><br><br>
			Host Port: <input type="text" name="hostPort"><br><br>
			Custom Job Location : <input type="text" name="customJobLocation"><br><br>
			File Name: <input type="text" name="fileName"><br><br>
			Job Type: <input type="text" name="jobType"><br><br>
			Class Name: <input type="text" name="customJobClassName"><br><br>
			Job Details: <textarea  form="myForm" name="jobDetails"></textarea><br><br>
		          <input type="button" value="Submit" onClick="return validateForm()">
        </form>
        <p id="p1" >Pending!</p>
    </body>
</html>
