FROM node:latest as build

RUN mkdir -p /app

WORKDIR /app

COPY package.json /app

RUN npm install

COPY . /app

COPY ./nginx.conf /nginx.conf

RUN npm run build --prod

# CMD [ "npm", "start" ]



FROM nginx:1.17.1-alpine

COPY --from=build /app/dist/frontend /usr/share/nginx/html

COPY --from=build /nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
