import express from 'express'
import { contactsRoutes } from './src/routes/contacts'

const app = express()

app.disable('x-powered-by')
app.use(express.urlencoded({ extended: true }))

app.use('/contact', contactsRoutes)




app.listen(5020, () => {
  console.log('server is running on port 5020')
})
