FROM nginx:alpine
COPY nginx.conf.prod /etc/nginx/conf.d/default.conf
WORKDIR /usr/share/nginx/html
COPY dist/frontend .
EXPOSE 4200