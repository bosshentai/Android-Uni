import { Request, Response } from "express";



export const updateContactController = async (request:Request, response: Response) =>{




  if(request.method !== "PUT")
  {
    return response.status(405).json("Method not allowed");
  }


  const {fullName,phoneNumber,birth,sex} = request.body



  try {
    
  } catch (e) {
    return response.status(500).json({Error:"Problem to connect"})
  }


}