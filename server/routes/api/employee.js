import { Router } from 'express'
import query from '../../services/database.js'
import routes from './api-routes.js'

const employees = Router()

// GET ALL EMPLOYEES
employees.get(routes.EMPLOYEE.GET_ALL,(req,res) => {
    res.sendStatus(200)
})

// GET EMPLOYEE BY ID
employees.get(routes.EMPLOYEE.GET_BY_ID,(req,res) => {
    res.json({
        status: 200,
        id: req.params.id
    })
})

// GET EMPLOYEE CONTACT

// GET EMPLOYEE CONTRACT

// TEST
employees.get(routes.EMPLOYEE.STATUS_OK,(req,res) => {
    res.sendStatus(200)
})

export default employees