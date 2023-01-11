import { prismaClient } from '../../database/prismaClient'
import {
  ICreateContact,
  IExistedContact,
  IUpdateContact,
} from '../../repositories/IContact'

export const GetAllContactsProvider = async () => {
  const list = await prismaClient.contact.findMany()

  return list
}

export const GetAllFavContactsProvider = async () => {
  const list = await prismaClient.contact.findMany({
    where: {
      favorite: true,
    },
  })
}

export const GetOneContactProvider = async (id: string) => {
  const selected = await prismaClient.contact.findUnique({
    where: {
      id,
    },
  })

  return selected
}

export const createContactProvider = async ({
  fullName,
  phoneNumber,
  birth,
  sex,
}: ICreateContact) => {
  const newContact = await prismaClient.contact.create({
    data: {
      fullName,
      phoneNumber,
      birth,
      sex,
      favorite: false,
    },
  })

  return newContact
}

const existedContactProvider = async ({
  id,
}: IExistedContact) => {
  const select = await prismaClient.contact.findUnique({
    where: {
      id,
    },
  })

  if (select !== null) {
    return true
  }

  return false
}

export const updateContactProvider = async ({
  id,
  fullName,
  phoneNumber,
  birth,
  sex,
  // favorite,
}: IUpdateContact) => {
  const existed = await existedContactProvider({ id })

  if (existed === true) {
    const updatedContact =
      await prismaClient.contact.update({
        where: {
          id,
        },
        data: {
          fullName,
          phoneNumber,
          birth,
          sex,
          // favorite,
        },
      })

    return updatedContact
  }

  return null

  // const updateContact = await prismaClient.contact.update({
  //   where:{
  //     id:
  //   }
  // })
}

export const updateContactToFavProvider = async ({
  id,
  favorite,
}: {
  id: string
  favorite: boolean
}) => {
  const existed = await existedContactProvider({ id })

  if (existed === true) {
    const getOne = await GetOneContactProvider(id)

    const update = prismaClient.contact.update({
      where: {
        id,
      },
      data: {
        favorite: favorite,
      },
    })

    return update
  }

  return null
}

export const deleteContactProvider = async ({
  id,
}: IUpdateContact) => {
  const existed = await existedContactProvider({ id })

  if (existed === true) {
    const eliminated = await prismaClient.contact.delete({
      where: {
        id,
      },
    })

    return eliminated
  }

  return null
}
