# Technicale base code for creating a microservice

## Presentation 
    
A reactive Rest API for a Demands list management, developped with Spring Boot, spring WebFlux, Spring DATA R2DBC and DDD concepts

## Architecture

Maven modules, responsibilities, dependencies

### Demands-domain

**The hexagon** responsible for representing functional concepts. The technical details of storage are delegated to the infrastructure. This layer is at the heart of enterprise software.
- contains all business logic; validation rules of users inputs ; mandatory information for a Demands, format of fields and so on => it validates invariants of value objects entering into the system
- contains domain objects. Business concepts and words have their objects in your code (ubiquitous language). Here one domain object which is a Demands
- transaction boundaries : manage database transactions ; decide whether actions results should be persisted or rollbacked.

**dependencies :** nothing, that's important

### Demands-infra

**Infrastructure layer**
- Infrastructure Layer: responsible for communication with the outside world (data persistence, messaging, email, sms, etc.)

**dependencies** : Demands-domain

### Demands-app

**final runnable artifact** : the place where we will implement all the use cases that depend on a given front. For example, the exposure of api rest
- contains SpringBootApplication Class : entry point to launch our microservice
- application packaging : an auto-executable jar

**dependencies** : Demands-domain, ddd-infra, and many Spring/boot stuff for Rest JSON

## Usage :

TODO NKH : must clean dockerization and use kubernetes

docker build -t demands:1.0 .

docker run -d -p 8080:8080 -t demands:1.0

swagger URL is

http://localhost:8080/swagger-ui/
