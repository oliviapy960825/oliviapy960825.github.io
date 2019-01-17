/*jshint esversion: 6 */

// multi-dimentional array
let top_movies = [
  ["The Shawshank Redemption", 1994, "Drama"],
  ["The Godfather", 1972, "Crime"],
  ["The Godfather: Part II", 1974, "Crime"],
  ["The Dark Knight", 2008, "Action"],
  ["12 Angry Men", 1957, "Drama"]
];

// write a for loop to output movie names
for(let i=0;i<top_movies.length;i++){
  console.log(top_movies[i][0]+", "+top_movies[i][1]+", "+top_movies[i][2]);
}


// use Iterator and Arrow function
// to loop over the array to out names with *** prefix
top_movies.forEach(movie=>console.log("*** "+movie[0]));


// Use Iterator and Arrow functions, .filter()
// to output the name and genre of movies after 1990
let new_movie_list=top_movies.filter(movie=>movie[1]>=1990);
for(let i=0;i<new_movie_list.length;i++){
  console.log(">>> "+new_movie_list[i][0]+","+new_movie_list[i][2]);
}




// change genre category for either "Crime" or "Drame"
// to "Crime, Drama" using .map() and output the result
// see https://www.w3schools.com/jsref/jsref_map.asp
let new_movie_list2=top_movies.map(function(movie){
  if(movie[2]==="Crime"||movie[2]==="Drama"){
     movie[2]=" Crime, Drama";
     return movie;
  }
  return movie;
});
for(let i=0;i<new_movie_list2.length;i++){
  console.log("### "+new_movie_list2[i][0]+","+new_movie_list2[i][2]);
}




// add code to calculate the number of years to become a millinaire
// with initial deposit of 10000 and 0.06 interest rate
let deposit=10000;
let interestRate=0.06;
let i=0;
while(deposit<1000000){
  deposit+=deposit*interestRate;
  i++;
}
console.log("You will be a millionaire in "+i+" years!");



// add player objects and output results according to lecture slides
let player1={
  name:"Stephen Curry",
  dob: "March 14, 1988",
  height:1.91,
  weight: 86,
  shoot(){
    return "3-pointer";
  }
};

let player2={
  name:"LeBron James",
  dob: "December 30, 1984",
  height:2.03,
  weight:118,
  shoot(){
    return "dunk";
  },
  info(){
    return this.name+ " is "+this.height+"m and "+this.weight+"kg.";
  }
};
console.log(player1.name);
console.log(player2.name);
console.log(player2.weight-player1.weight);
console.log(player1.shoot());
console.log(player2.shoot());
console.log(player2.info());
player2.draft_year=2003;
console.log(player2.draft_year);
