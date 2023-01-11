import { Request, Response } from "express";
import { updateContactProvider } from '../../providers/contacts/ContactProvider';



export const UpdateContactController = async (request:Request, response: Response) =>{




  if(request.method !== "PUT")
  {
    return response.status(405).json("Method not allowed");
  }


  const {id} = request.params
  const {fullName,phoneNumber,birth,sex} = request.body

  console.log(fullName)
  console.log(phoneNumber)
  console.log(birth)
  console.log(sex)

  try {

    const updatedContact = await updateContactProvider({
      id,
      phoneNumber,
      fullName,
      sex,
      birth : new Date(birth)
    })



    return response.status(200).json(updatedContact)
    
  } catch (e) {
    return response.status(500).json({Error:"Problem to connect"})
  }


}