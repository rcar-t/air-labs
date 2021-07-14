FROM node:latest as build

RUN mkdir -p /air-labs-challenge

WORKDIR /air-labs-challenge

COPY package*.json ./

RUN npm install

EXPOSE 4200

COPY . .

RUN npm run build

CMD [ "npm", "start" ]