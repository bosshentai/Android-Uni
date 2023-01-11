import { Request, Response } from "express";
import { GetAllContactsProvider } from "../../providers/contacts/ContactProvider";




export const GetAllContactsController = async (request:Request,response:Response) =>{
  if(request.method !== "GET"){
    return response.status(405).json('Method not allowed')
  }

  try {
    const listContacts = await GetAllContactsProvider()



    return response.status(200).json(listContacts)
    
  } catch (e) {
    return response.status(500).json({Error:"Problem to connect"})
  }
}










