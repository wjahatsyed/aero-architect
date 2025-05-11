# ✈️ Aero Architect

A **modular, cloud-native airline operations suite** built with Java 17, Spring Boot, and modern architecture principles. This project is a demonstration of **scalable, resilient, secure, and observable** enterprise design aligned with architecture standards, NFRs, and DevSecOps practices.

## 🚀 Purpose

This repository showcases a **reference architecture** for an enterprise-grade application that:

- Models real-world **airline operations**
- Applies best practices in **microservice architecture**
- Demonstrates **migration readiness** from monoliths to distributed systems
- Aligns with **SRE, DevSecOps, and Observability** goals
- Reflects architectural responsibilities such as **ADRs, NFRs, platform alignment, and governance**

## 🧱 Architecture Overview

- **Spring Boot 3 + Java 17**
- **Reactive programming (WebFlux)** where applicable
- **Spring Cloud** for config, service discovery, resilience
- **RabbitMQ** for asynchronous communication
- **Kubernetes (AKS-ready)** deployments
- **Prometheus + Grafana + OpenTelemetry** for observability
- **GitHub Actions** for CI/CD
- **ADR logs** to capture architectural decisions
- **Security**: OAuth2 (Keycloak), Spring Security, OWASP guidelines

## 📦 Modules

| Module                | Description                                                           |
|-----------------------|-----------------------------------------------------------------------|
| `booking-service`     | Manages flight bookings, customer info, and seat allocation           |
| `flight-service`      | Manages flight schedule, routes, and aircraft metadata                |
| `notification-service`| Sends email/SMS push notifications (RabbitMQ consumer)                |
| `api-gateway`         | Central API routing with Spring Cloud Gateway                         |
| `config-server`       | Centralized configuration for all services                            |
| `service-registry`    | Eureka-based discovery service                                        |

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot, Spring Cloud**
- **RabbitMQ**
- **PostgreSQL**
- **Redis** (optional caching)
- **Kubernetes (AKS compatible)** + Helm
- **Docker + Docker Compose**
- **GitHub Actions** (CI/CD)
- **Prometheus + Grafana**
- **OpenTelemetry + Sleuth + Zipkin**
- **Keycloak** for Auth

## 📊 Non-Functional Requirements (NFRs)

- **Scalability**: Horizontal scaling on AKS
- **Resilience**: Retry, circuit breaker, fallback
- **Observability**: Tracing, metrics, and alerting
- **Security**: OAuth2, encrypted secrets, input sanitization
- **Maintainability**: Modular services, ADRs, clear CI/CD
- **Performance**: Reactive endpoints for non-blocking I/O

See [`/docs/NFRs.md`](docs/NFRs.md) for full list.

## 🧪 Testing Strategy

- Unit testing with **JUnit 5**, **Mockito**
- Integration testing with **Testcontainers**
- API contract validation with **Spring REST Docs**

## 🔐 DevSecOps

- Shift-left security using **dependency scanning**
- OWASP headers and API hardening
- Docker image hardening with multi-stage builds

## 📁 Project Structure

aero-architect/
├── services/
│ ├── booking-service/
│ ├── flight-service/
│ ├── notification-service/
│ └── ...
├── infra/
│ ├── docker-compose.yml
│ ├── aks-deployment.yaml
│ └── helm-charts/
├── architecture/
│ ├── ADRs/
│ └── diagrams/
├── observability/
│ ├── prometheus/
│ └── grafana/
├── docs/
│ ├── NFRs.md
│ ├── MigrationPlan.md
│ └── DevSecOpsPipeline.md
└── README.md


## 🧭 Getting Started

```bash
# Clone
git clone https://github.com/wjahatsyed/aero-architect.git
cd aero-architect

# Start local environment
docker-compose up --build

# Access services
Gateway: http://localhost:8080
RabbitMQ UI: http://localhost:15672
Grafana: http://localhost:3000
Keycloak: http://localhost:8081
📌 Roadmap
 Modular services with REST APIs

 Central config & service discovery

 RabbitMQ messaging

 NFR compliance & resilience

 Observability stack

 Azure AKS deployment scripts

 Monolith → microservice migration case

 Airline-specific use cases (GDS, loyalty, etc.)

🧾 License
MIT

📣 Contact
Wajahat Syed Muhammad
Principal Software Engineer | Java Architect
📧 wajahatsyed1257@gmail.com


“Architecture is not just about structure—it’s about sustainable, evolving decisions.”
