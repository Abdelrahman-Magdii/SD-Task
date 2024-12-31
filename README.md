# Spring Boot MapStruct Task

## Overview
This task involves creating a Spring Boot project that uses MapStruct (with the latest versions of dependencies). The project consists of entities, DTOs, mappers, services, and unit tests.

---

## Project Requirements

### Entities
#### Country
- **Fields:**
  - `id`: int
  - `isoCode`: String

#### Company
- **Fields:**
  - `id`: int
  - `name`: String
  - `country`: Country

### DTOs
#### CountryDto
```java
record CountryDto(int id, String name) {}
```

#### CompanyDto
```java
record CompanyDto(int id, String name, CountryDto country) {}
```

### Mappers
- **CountryMapper**
  - Maps `Country` to `CountryDto`'
  - unMaps `Country` to `CountryDto`
  - Uses `CountryService`

- **CompanyMapper**
  - Maps `Company` to `CompanyDto`
  - unMaps `Company` to `CompanyDto`
  - Uses `CountryMapper`

### Services
#### CountryService
- Includes a dummy method:
```java
public String getName(String isoCode) {
    return "name of " + isoCode;
}
```

### Tests
- Unit tests for all mapper methods to ensure proper mapping between entities and DTOs.

---

## Useful Links
- [MapStruct Documentation](https://mapstruct.org/)
- [Data Transfer Object - Wikipedia](https://en.wikipedia.org/wiki/Data_transfer_object)

---

## Development Steps
1. **Setup the Project**
   - Initialize a Spring Boot project.
   - Add dependencies for MapStruct and other required libraries.

2. **Define the Entities**
   - Create `Country` and `Company` entities.

3. **Define the DTOs**
   - Create `CountryDto` and `CompanyDto` records.

4. **Implement the Mappers**
   - Use MapStruct to create `CountryMapper` and `CompanyMapper`.

5. **Add Services**
   - Implement the `CountryService` with the dummy method.

6. **Write Unit Tests**
   - Test all mapper methods to ensure correctness.

---

## Example Implementation

### Dependencies in `pom.xml`
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.5.3.Final</version>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>1.5.3.Final</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Directory Structure
```
src/
├── main/
│   ├── java/com/spring/task/
│   │   ├── Country/
│   │   │   ├── Entity/CountryEntity.java
│   │   │   ├── Dto/CountryDto.java
│   │   │   ├── Mapper/CountryMapper.java
│   │   │   └── Service/CountryService.java
│   │   ├── Company/
│   │   │   ├── Entity/CompanyEntity.java
│   │   │   ├── Dto/CompanyDto.java
│   │   │   ├── Mapper/CompanyMapper.java
│   │   │   └── Service/CompanyService.java
│   └── resources/
└── test/
    ├── java/com/spring/task/Country/CountryMapperTest.java
    └── java/com/spring/task/Company/CompanyMapperTest.java
```

---

## Notes
- The task focuses on applying MapStruct for DTO mapping.
- Follow best practices for coding and testing.
- Ensure high code readability and maintainability.
