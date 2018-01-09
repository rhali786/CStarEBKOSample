var port = process.env.PORT || 3000;
var express = require('express');

var app = express();

app.get('/', function(req, res) {
  res.send({
    "Output": "Hello World!"
  });
});

app.get('/zain', function(req, res) {
  res.send({
    "Output": "Hello Zain!"
  });
});

app.listen(port);
