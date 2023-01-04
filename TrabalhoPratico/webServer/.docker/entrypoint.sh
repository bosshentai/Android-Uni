#!/bin/bash

npm install
npm
npx prisma generate
npx prisma migrate dev 


npm run dev