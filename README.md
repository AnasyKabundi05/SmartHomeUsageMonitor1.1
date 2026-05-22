# 🏠 Smart Home Usage Monitor

## Overview

Backend system to track smart appliance usage. Supports multi-user management, energy tracking, cost calculation, and intelligent recommendations for energy efficiency.

## Core Features

* Multi-user support
* Appliance ownership
* Usage logging and calculations
* DTO layer for clean API
* RESTful API

## Entities & DTOs

* User → UserDTO
* Appliance → ApplianceDTO
* UsageLog → UsageLogDTO
* Recommendation → RecommendationDTO

## Development Steps

1. Create entities
2. Create DTOs
3. Create mappers (Entities ↔ DTOs)
4. Create repositories
5. Implement service layer
6. Implement controllers using DTOs
7. Test APIs with Postman
8. Add frontend integration (Vue.js)
9. Containerize backend using Docker
10. Deploy containers using Kubernetes

## REST API Examples

* `POST /users` → create user
* `GET /users/{id}` → returns UserDTO
* `POST /users/{id}/appliances` → create appliance
* `GET /users/{id}/appliances` → returns ApplianceDTO list
* `POST /appliances/{id}/usage` → log usage
* `GET /appliances/{id}/recommendation` → returns RecommendationDTO

## Containerization (Docker)

The backend application can be containerized using Docker to ensure consistent deployment across different environments.

### Dockerfile Example

```
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/smart-home-monitor.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

### Build Docker Image

```
docker build -t smart-home-monitor .
```

### Run Docker Container

```
docker run -p 8080:8080 smart-home-monitor
```

The API will be accessible at:

```
http://localhost:8080
```

## Container Orchestration (Kubernetes)

Kubernetes can be used to deploy and manage the Docker containers in a scalable and resilient environment.

### Example Deployment

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: smart-home-monitor
spec:
  replicas: 2
  selector:
    matchLabels:
      app: smart-home-monitor
  template:
    metadata:
      labels:
        app: smart-home-monitor
    spec:
      containers:
      - name: smart-home-monitor
        image: smart-home-monitor:latest
        ports:
        - containerPort: 8080
```

### Example Service

```
apiVersion: v1
kind: Service
metadata:
  name: smart-home-monitor-service
spec:
  type: NodePort
  selector:
    app: smart-home-monitor
  ports:
  - port: 80
    targetPort: 8080
```

Kubernetes allows the backend to:

* Automatically restart failed containers
* Scale the application based on traffic
* Perform rolling updates without downtime
* Load balance requests across multiple instances

## Technologies

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* REST APIs
* Vue.js (frontend)
* Docker (containerization)
* Kubernetes (container orchestration)

## Author

Anastasios Kabundi
