import { Request, Response } from 'express'
import { deleteContactProvider } from '../../providers/contacts/ContactProvider'

export const DeleteContactController = async (
  request: Request,
  response: Response,
) => {

  const {id} = request.params


  try {

    const eliminated = await deleteContactProvider({id})





    return response.status(200).json(eliminated)



  } catch (e) {

    return response.status(500).json({Error:"Problem to connect"})
  }
}
