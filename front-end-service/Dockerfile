FROM node:16-alpine

WORKDIR /usr/app/ebilling/front-end

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 3000

CMD ["npm", "start"]

