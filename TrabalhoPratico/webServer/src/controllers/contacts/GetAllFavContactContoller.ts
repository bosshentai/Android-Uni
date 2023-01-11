import {Request, Response} from "express"
import { GetAllFavContactsProvider } from "../../providers/contacts/ContactProvider"





export const GetAllFavContactsController = async (request: Request, response: Response)=>{

  if(request.method !== "GET"){
    return response.status(405).json("Method not allowed")
  }

  try {

    const listFavContacts = await GetAllFavContactsProvider()



    return response.status(200).json(listFavContacts)

  } catch (e) {
    return response.status(500).json({Error: "Problem to connect"})
  }
}