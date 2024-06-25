# Read-Write API

## About the Project

This project is a Spring Boot-based microservices architecture application. The application provides writing and reading services that store and query text data. The microservices are built using Spring Cloud Gateway, Eureka, Config Server, PostgreSQL, MongoDB, and Redis.

## Project Structure

- **read-write-api**: Main project.
- **server-parent**: Parent project for all server modules.
  - **server-gateway**: Uses Spring Cloud Gateway for routing and load balancing.
  - **server-discovery**: Provides service discovery using Eureka Server.
  - **server-config**: Uses Spring Config Server for centralized configuration management.
- **service-parent**: Parent project for all service modules.
  - **service-write**: Receives text data, generates a link, stores the link in PostgreSQL, and saves the text in MongoDB with the link.
  - **service-read**: Checks if a given link exists in Redis. If not, queries PostgreSQL and MongoDB, caches the result in Redis, and returns the text to the client.

## Installation and Running

### Requirements

- Java 17 or higher
- Maven 3.6 or higher
- Docker and Docker Compose

### Steps

1. Clone the repository:

    ```sh
    git clone https://github.com/Hattatoglu/read_write_api.git
    cd read_write_api
    ```
	
2. Update project IPs in servers and services application.properties and docker compose yml files.

3. Download Maven dependencies and build the project:

    ```sh
    mvn clean install
    ```
	
4. To create Docker images for each service, navigate to the respective directories and run:

    ```sh
    docker build -t <<image-name>> .
    ```	

5. Use Docker Compose to start the services:

    ```sh
    cd docs/docker-compose
    docker-compose <<image-name>> up -d
    ```

## Configuration

### Gateway Configuration

Necessary routing and load balancing configurations are done in the `server-gateway` module.

### Eureka Server

Eureka Server configurations are done in the `server-discovery` module. All services register with Eureka Server.

### Config Server

Necessary settings for centralized configuration management are done in the `server-config` module.

## Microservices

### service-write

- **Function**: Receives text data, generates a link, stores it in PostgreSQL, and saves the text in MongoDB with the link.
- **Databases**: PostgreSQL, MongoDB

### service-read

- **Function**: Checks if a given link exists in Redis. If not, queries PostgreSQL and MongoDB, caches the result in Redis, and returns the text to the client.
- **Databases**: PostgreSQL, MongoDB, Redis

## Docker Compose Files

Separate Docker Compose files for each service can be found in the `docs/docker-compose` folder. You can run the services independently or all together.

## Example Requests

Example JSON request bodies can be found in the `docs/request-bodies` folder. These files can be used for create, read, delete, and update operations.

## Contributing

If you want to contribute, please send a pull request or open an issue.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.
