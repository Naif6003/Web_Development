

(function($) {
//     //relative path
     var COURSES_RESOURCE = "courses";
//     // Shorthand for $( document ).ready(), runs exactly once when page finishes loading
    $(function() {
        //click handler for the button
        document.getElementById("button").onclick = function() {
            makeCoursesRequest(COURSES_RESOURCE);
        };
        
//         //Call it once on page load
     //    makeCoursesRequest(COURSES_RESOURCE);
//         //initializeAddEmployeeForm();
//         // document.getElementById("add-employee-button").onclick = function() {
//       //
//         //  var employeeObject = {};
//       //
//         //  employeeObject.firstName = document.getElementById("firstName").value;
//         //  employeeObject.lastName = document.getElementById("lastName").value;
//         //  employeeObject.address = document.getElementById("address").value;
//         //  employeeObject.country = {};
//       //
//         //  var countrySelect = document.getElementById("country");
//         //  var selectedCountry = countrySelect.options[countrySelect.selectedIndex];
//       //
//         //  employeeObject.country.id = parseInt(selectedCountry.value, 10);
//         //  employeeObject.country.name = selectedCountry.text;
//       //
//         //  console.log(employeeObject);
//       //
//         //  //posts to EmployeeController handled by AddEmployee
//         //  $.ajax({
//         //      type: "POST",
//         //      url: "employee",
//         //      data: JSON.stringify(employeeObject),
//         //      contentType: "application/json; charset=utf-8",
//         //      dataType: "json",
//         //      success: function(data){
//         //           console.log(data);
//           //         makeEmployeesRequest(EMPLOYEES_RESOURCE);
//         //      },
//         //      failure: function(errMsg) {
//         //          alert(errMsg);
//         //      }
//         //  });
//         //  initializeAddEmployeeForm();
//         // };
     });
//     //See JQuery getJSON doc: http://api.jquery.com/jquery.getjson/
    function makeCoursesRequest(url) {
      $.getJSON(url, function(data) {
        //JQuery parses the JSON string using JSON.parse for you.
        console.log(data);
        displayCourses(data);
      });
    }
//     //handler when response data is received
    function displayCourses(coursesArray) {
        var divElement = document.getElementById("div");

            
        coursesArray.forEach(function(courseObject){


          var eachButton = document.createElement('button');
          eachButton.innerHTML = courseObject.courseName;
          eachButton.id = "theCourse";
          divElement.appendChild(eachButton);
          eachButton.onclick = function(){
          window.location.href = 'courses/' + courseObject.id;

          };


        });
    }

})(jQuery);

