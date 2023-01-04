-- CreateEnum
CREATE TYPE "Sex" AS ENUM ('MASC', 'FEMIN', 'OTHER');

-- CreateTable
CREATE TABLE "Contact" (
    "id" TEXT NOT NULL,
    "fullName" TEXT NOT NULL,
    "phoneNumber" TEXT NOT NULL,
    "birth" DATE NOT NULL,
    "sex" "Sex" NOT NULL,
    "favorite" BOOLEAN NOT NULL,

    CONSTRAINT "Contact_pkey" PRIMARY KEY ("id")
);
