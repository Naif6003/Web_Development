//Your JavaScript code here

var tries = 0;
var stoneHits = 0;
var i = 0;
var lastClicked;


var grid = clickableGrid(3,3,function(el,row,col,i,img){
    

    // print the information about the row , colomn, item number and the num of tires.
    console.log("You clicked on element:",el);
    console.log("You clicked on row:",row);
    console.log("You clicked on col:",col);
    console.log("You clicked on item #:",i);
    console.log("the number of tries :", ++tries);

// show the stone if the user click on table data 1 , 5 , 8
    if(i == 1 || i == 5 || i == 8){
        img.src = 'images/stone.jpg';
        stoneHits++;
    }else {
        img.src = "images/redX.jpg";
    }

    checkWinning(tries,stoneHits);
});


function checkWinning(tries, stoneHits){

// if the user exceeded 3 tries and iftries, stoneHits he wins the game. 
    if(tries == 3 ){
        if(stoneHits == 3){
        alert("WooooHoooo you win!!");
          location.reload();
    }else{
        alert("boooooo you lost!!!");
          location.reload();
    }
}
}



function clickableGrid( rows, cols, callback ){
    
// creating the table 
    var grid = document.createElement('table');
    grid.className = 'grid';


// creating the 3 x 3 table with the pictures on it.
    for (var r=0;r<rows;++r){
       
                    var tr = grid.appendChild(document.createElement('tr'));

    for (var c=0;c<cols;++c){

                    var cell = tr.appendChild(document.createElement('td'));
                    

                    // creating the image variable and modify it with css. 

                    var img = document.createElement('img');
                    img.src = 'images/cup.jpeg';
                    img.className = 'img';


                    // counter is denoting every cell with a number
                    var count = ++i;

                    // adding the image to the table data.
                    cell.appendChild(img);

                    // the event listener on every cell on the table. 
                    cell.addEventListener('click',(function(el,r,c,i,img){

                        return function(){
                             callback(el,r,c,i,img);
                        }
                    })(cell,r,c,i,img),false);
            }
        }
    return grid;

}

document.body.appendChild(grid);



// i tried to add the button to call the same functions above to work but i couldn't.
// function buttonFunction(){


// var img = document.createElement('img');
// img.src = 'images/stone.jpg'

// var grid = clickableGrid(3,3,function(el,row,col,i,img){



// });


// }



