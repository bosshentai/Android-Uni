import express from 'express'
import { CreateContactController } from '../../controllers/contacts/CreateContactController'
import { GetAllContactsController } from '../../controllers/contacts/GetAllContactController'
import { GetAllFavContactsController } from '../../controllers/contacts/GetAllFavContactContoller'
import { DeleteContactController } from '../../controllers/contacts/DeleteContactController'

const contactsRoutes = express.Router()

contactsRoutes.use(express.json())

contactsRoutes.post('/', CreateContactController)
contactsRoutes.get('/', GetAllContactsController)
contactsRoutes.get('/fav', GetAllFavContactsController)
contactsRoutes.delete('/:id', DeleteContactController)
export { contactsRoutes }
