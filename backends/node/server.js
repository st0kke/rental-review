/**
* A simple api
*/
var express = require('express');
var app = express();
var bodyParser = require('body-parser');

var router = express.Router();


app.use(bodyParser());

var reviewId = 34;

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

router.put('/reviews/:id', function(request, response) {
  response.header('Access-Control-Allow-Origin', '*');
  console.log('in PUT request');
  
  var review = request.body;
  console.log('updating book ' + JSON.stringify(review));
  
  var currentReview = findReview(parseInt(request.params.id, 10));
  if (currentReview === null) {
    response.send(404);
  } else {
    currentReview.rating = review.rating;
    currentReview.comments = review.comments;
    response.send(review);
  }
});

router.post('/reviews/', function(request, response) {
  response.header('Access-Control-Allow-Origin', '*');
  var review = request.body;
  console.log('posted review ' + JSON.stringify(review));
  review.id = reviewId++;
  reviews.push(review);
  response.send(review);  
});

var allowCrossDomain = function(request, response, next) {
  console.log('in allowCrossDomain');
  response.header('Access-Control-Allow-Origin', '*');
  response.header('Access-Control-Allow-Methods', 'OPTIONS, GET, PUT, POST, DELETE');
  response.header('Access-Control-Allow-Headers', 'Content-Type');

  if ('OPTIONS' == request.method) {
    response.send(200);
  } else {
    next();
  }
};

app.use(allowCrossDomain);

app.use('/api', router);
//app.use('/', router);



app.listen(9000);


