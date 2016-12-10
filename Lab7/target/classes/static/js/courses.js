

(function($) {
//     //relative path
     var COURSES_RESOURCE = "courses";
//     // Shorthand for $( document ).ready(), runs exactly once when page finishes loading



    $(function() {
        //click handler for the button
        document.getElementById("button").onclick = function() {
            makeCoursesRequest(COURSES_RESOURCE);
        };
        


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
          var url = 'coursrs/'+courseObject.id;
          eachCourse(url,courseObject);
          };
        });
    }

    function eachCourse(url,theObj){
      $.getJSON("courses/"+theObj.id, function(data) {
       // var ul = document.getElementById('li');

        // document.getElementById("id").write = "Course id: " + data.id ;
        // document.getElementById("id").write = "Course name: " + data.courseName;
        //  document.getElementById("id").write = "Course name: " + data.timeDay ;
        document.getElementById('id').innerHTML = '';

         var para = document.createElement('p');
         var node = document.createTextNode("Course id: " +data.id);
         para.appendChild(node);
         var theDiv = document.getElementById("id");
         theDiv.appendChild(para);

         var para2 = document.createElement('p');
         var node2 = document.createTextNode("Course name: " +data.courseName);
         para2.appendChild(node2);
         var theDiv2 = document.getElementById("id");
         theDiv2.appendChild(para2);

        var para3 = document.createElement('p');
         var node3 = document.createTextNode("Course Time/Day: " +data.timeDay);
         para3.appendChild(node3);
         var theDiv3 = document.getElementById("id");
         theDiv3.appendChild(para3);

         var para4 = document.createElement('p');
         var node4 = document.createTextNode("Course Units: " +data.numberOfUnits);
         para4.appendChild(node4);
         var theDiv4 = document.getElementById("id");
         theDiv4.appendChild(para4);

         var para5 = document.createElement('p');
         var node5 = document.createTextNode("Course Section: " +data.section);
         para5.appendChild(node5);
         var theDiv5 = document.getElementById("id");
         theDiv5.appendChild(para5);

         var para6 = document.createElement('p');
         var node6 = document.createTextNode("Course Room: " +data.classLocation);
         para6.appendChild(node6);
         var theDiv6 = document.getElementById("id");
         theDiv6.appendChild(para6);

         var para7 = document.createElement('p');
         var node7 = document.createTextNode("Course Instructor: " +data.instructor);
         para7.appendChild(node7);
         var theDiv7 = document.getElementById("id");
         theDiv7.appendChild(para7);


      var table = document.getElementById('table');
         var tr = document.createElement('tr');
         var th = document.createElement('th');
         th.innerHTML = "Student name";
         var th2 = document.createElement('th');
         th2.innerHTML = ""


         var divTable = document.getElementById('table');
      //   var table = document.createElement("table");
         var tr = document.createElement('tr');
         var th = document.createElement('th');
         var th1 = document.createElement('th');

         th.appendChild(document.createTextNode("Student name"));
         tr.appendChild(th);
        divTable.appendChild(tr);

         th1.appendChild(document.createTextNode("Lab1"))
         tr.appendChild(th1);
        divTable.appendChild(tr);

         var tr2 = document.createElement('tr');
       //  td.appendChild(document.createTextNode(
           data.std.forEach(function(info){ 
            var th = document.createElement('th');


            var td = document.createElement('td');
             td.appendChild(document.createTextNode(info.studentName));
           });

  
         tr2.appendChild(td);
          divTable.appendChild(tr2);

    
      });


    }





})(jQuery);

