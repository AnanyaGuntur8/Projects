const express = require('express');
const mongoose = require('mongoose');
const bcrypt = require('bcrypt.js');
const jwt = require('jsonwebtoken');
const bodyParser = require('body-parser');
const cors = require('cors');

//middle ware
const app = express();
app.use(bodyParser.json());
app.use(cors()); 

//mongoDB connection
mongoose.connect('mongodb://localhost:27017/studysesh', { 
                    useNewUrlParser: true, 
                    useUnifiedTopology: true,
                    useCreateIndex: true,
}).then(() => console.log('MongoDB Connected'))
.catch(err => console.log(err));

//define routes
const users = require('./routes/users');
app.use('/api/users', users)

const PORT = process.env.PORT || 5000;
app.listen(port, () => console.log('Server running on Port ${port}')); 



