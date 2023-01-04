import express from 'express'
import { CreateContactController } from '../../controllers/contacts/CreateContactController'

const contactsRoutes = express.Router()

contactsRoutes.use(express.json())

contactsRoutes.post('/', CreateContactController)

export { contactsRoutes }
