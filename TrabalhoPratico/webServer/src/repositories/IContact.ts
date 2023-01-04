import { Sex } from "@prisma/client"

export interface ICreateContact{
  fullName : string
  phoneNumber : string
  birth: Date
  sex: Sex
}


export interface IExistedContact {
  id: string
}


export interface IUpdateContact {
  id: string
  fullName?: string
  phoneNumber?: string
  birth?: Date
  sex?: Sex
  favorite?: boolean
}