import { Router } from 'express'
import query from '../../services/database.js'
import routes from './api-routes.js'

const company = Router()

// GET COMPANY DETAILS


// TEST
company.get(routes.COMPANY.STATUS_OK,(req,res) => {
    res.sendStatus(200)
})

export default company