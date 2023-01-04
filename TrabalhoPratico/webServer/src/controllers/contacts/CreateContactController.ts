import { Request, Response } from 'express'
import { createContactProvider } from '../../providers/contacts/ContactProvider';

export const CreateContactController = async (
  request: Request,
  response: Response,
) => {
  if (request.method !== 'POST') {
    return response.status(405).json('Method not allowed')
  }

  const { fullName, phoneNumber, birth, sex } = request.body

  try {

    const created = await createContactProvider({
      fullName,
      phoneNumber,
      birth,
      sex
    })


    if(created === null){
      return response.status(500).json({Error:"Fail to Create Contact"});


    }

    return response.status(201).json(created)
  } catch (e) {
    return response
      .status(500)
      .json({ Error: 'Problem to connect' })
  }
}
