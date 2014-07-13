/**
* A simple api
*/
var express = require('express');
var app = express();
var bodyParser = require('body-parser');

var router = express.Router();


app.use(bodyParser());

var reviewId = 32;

function findReview(id){
  for (var i=0; i < reviews.length; i++) {
    if (reviews[i] === id) {
      return reviews[i];
    }
  }
  return null;
}


function removeReview(id) {
  var reviewIndex = 0;
  for (var i=0; i < reviews.length; i++) {
    if (reviews[i] === id) {
      reviewIndex = i;
    }
  }
 
  reviews.splice(reviewIndex, 1);
}


var reviews = [
{id:32, rating:1, comments:'very poor'},
{id:33, rating:5, comments:'perfect'}];

router.get('/reviews', function(request, response){
    response.header('Access-Control-Allow-Origin', '*');
    console.log('in GET function');
    response.json(reviews);
  });

app.use('/api', router);
//app.use('/', router);

app.listen(9000);


