/* 

     _   _                 _             _ 
    | \ | |               (_)           | |
    |  \| | ___  _ __ ___  _ _ __   __ _| |
    | . ` |/ _ \| '_ ` _ \| | '_ \ / _` | |
    | |\  | (_) | | | | | | | | | | (_| | |
    \_| \_/\___/|_| |_| |_|_|_| |_|\__,_|_|

    Package: SERVER
    Author: Carlos Pomares (https://github.com/pomaretta)
    Version: 0.1.0

*/

// UTIL
import getBanner from './util/banner.js'
import colors from './util/colors.js'
import colorTransform from './util/colorizer.js'

// IMPORTS
import express from 'express'
import bodyParser from 'body-parser'

// APPLICATION
const server = express()
const port = process.env.NODE_PORT | 8000

// MIDDLEWARES
server.use(bodyParser.urlencoded({extended: true}))
server.use(bodyParser.json())

// ROUTES
server.get('/',(req,res) => {
    res.sendStatus(200)
})

// LISTENER
server.listen(port, () => {
    console.log(colorTransform(colors.FGRED,getBanner()))
    console.log(colorTransform(`${colors.UNDERSCORE}${colors.FGMAGENTA}`,`STARTING SERVER ON ${port}`))
})