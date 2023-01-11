import express from 'express'
import { CreateContactController } from '../../controllers/contacts/CreateContactController'
import { GetAllContactsController } from '../../controllers/contacts/GetAllContactController'
import { GetAllFavContactsController } from '../../controllers/contacts/GetAllFavContactContoller'
import { DeleteContactController } from '../../controllers/contacts/DeleteContactController'
import { UpdateContactController } from '../../controllers/contacts/UpdateContactController'
import { GetOneContactController } from '../../controllers/contacts/GetOneContactController'

const contactsRoutes = express.Router()

contactsRoutes.use(express.json())

contactsRoutes.post('/', CreateContactController)
contactsRoutes.get('/', GetAllContactsController)
contactsRoutes.get('/fav', GetAllFavContactsController)
contactsRoutes.get("/:id",GetOneContactController)
contactsRoutes.put("/:id",UpdateContactController)
contactsRoutes.delete('/:id', DeleteContactController)
export { contactsRoutes }
