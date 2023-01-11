import { Request, Response } from 'express'

export const updateContactToFavController = async (
  request: Request,
  response: Response,
) => {
  if (request.method !== 'PUT') {
    return response.status(405).json('Method not allowed')
  }

  const { id } = request.params
  const { favorite } = request.body

  try {


    


  } catch (e) {
    return response
      .status(500)
      .json({ Error: 'Problem to connection' })
  }
}
