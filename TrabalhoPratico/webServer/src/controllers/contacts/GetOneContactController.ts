import {Request,Response} from "express"
import { GetOneContactProvider } from "../../providers/contacts/ContactProvider"



export const GetOneContactController = async(request: Request,response:Response)=>{




    const {id} = request.params


    try {

      const selectedOne = await GetOneContactProvider(id)




      return response.status(200).json(selectedOne)

    } catch (e) {
      return response.status(500).json({Error:"Problem to connect"})
    }


}


