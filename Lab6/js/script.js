//Your JavaScript code here
(function($){


    document.getElementById("button").onclick = function(){

    var apiKey = document.getElementById("apiKey").value;

    var address = document.getElementById("address").value;


    if(!apiKey){
      alert("missing api key!!");
    } else{
      makeRequest('https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+'+address+'&key='+apiKey);
    }
   };



function makeRequest(url) {

    //Set text to loading... before request is made
    document.getElementById("loading").innerHTML="<p>loading...</p>";

   $.getJSON(url, function(data){

       console.log(data);

       displayHTML(data);
   });
  }


  //handler when response data is received
  function displayHTML(data) {

        //Clear previous
        document.getElementById("loading").innerHTML="";


        var arr = [];

        for(var x=0;x<20;x++){
            arr[x] = data.results[x];
        }



      for(var x=0 ; x<20 ;x++){

          var row = document.createElement("tr");

              row.insertCell(0).innerText = arr[x].name;
              row.insertCell(1).innerText = arr[x].formatted_address;
              row.insertCell(2).innerText = arr[x].rating;
             try{
                 row.insertCell(3).innerText = arr[x].opening_hours.open_now;
             }catch(err){
                 row.insertCell(3).innerText = "No Info";
             }
            //   var button = document.createElement("button");
            //   button.style.width = "100px";
            //   button.style.height = "30px";
              //button.onclick = function(){


                //    var mapCanvas = document.getElementById("map");

                //    var la = arr[x].viewport.northeast.lat;
                //    var lng = arr[x].viewport.northeast.lng;
                   

                //    var latlng = new google.maps.LatLng(la,lng);

                //     var mapOptions = {
                //     center: latlng, 
                //      zoom: 11
                //         }
                //         var map = new google.maps.Map(mapCanvas, mapOptions);
                //      var marker = new google.maps.Marker({
                //         position: latlng,
                //             map: map
                //                   });

                






//              }

             // row.insertAdjacentElement("beforeend" , button);




            
        var table = document.getElementById("info");
        table.appendChild(row);

    };

  }

})(jQuery);
