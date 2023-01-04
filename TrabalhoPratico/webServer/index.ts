import express from 'express'
import { contactsRoutes } from './src/routes/contacts'

const app = express()

app.disable('x-powered-by')
app.use(express.urlencoded({ extended: true }))

app.use('/contact', contactsRoutes)
// app.use((req, res, next) => {
//   res.setHeader('Access-Control-Allow-Origin', '*')
//   res.setHeader(
//     'Access-Control-Allow-Headers',
//     'Origin, X-Requested-With, Content-Type, Accept, Authorization',
//   )
//   res.setHeader(
//     'Access-Control-Allow-Methods',
//     'GET, POST, PATCH, DELETE',
//   )

//   next()
// })




app.listen(5020, () => {
  console.log('server is running on port 5020')
})
