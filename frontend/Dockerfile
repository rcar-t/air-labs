FROM node:latest as build

RUN mkdir -p /air-labs-challenge

WORKDIR /air-labs-challenge

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build