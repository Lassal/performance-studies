# docker build -t mysql-perfdb .

# Derived from official mysql image (our base image)
FROM mysql:latest

EXPOSE 3306

# Add a database
ENV MYSQL_DATABASE perfDB
ENV MYSQL_ROOT_PASSWORD="pwd12345" MYSQL_USER="admin" MYSQL_PASSWORD="admin"
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./sql/ /docker-entrypoint-initdb.d/

RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/