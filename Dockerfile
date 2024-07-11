 FROM ubuntu
 WORKDIR /app

  

 COPY . .

 ENV PORT=8080

 EXPOSE 8080

