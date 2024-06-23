const express = require('express')
const router = express.Router();
const User = require('../models/Users');
const bcrypt = require('bcryptjs');

//registering a new user 
router.post('/register', async (req, res) => {
    const { email, fullName, password } = req.body;
    try {
        let user = await User.findOne({ email } );
        if(!user){
            return res.status(400).json({message: 'No User Credentials'});

        }
        const isMatch = bycrypt.compare(password, user.password);

        if(!isMatch){
            return res.status(400).json({ messages: 'Invalid Credentials'});

        }
        res.status(200).json({ message: 'Login Successful'});
    } catch(err){
        console.error(err);
        res.status(500).send('Server error');
    }
});

module.exports = router;
