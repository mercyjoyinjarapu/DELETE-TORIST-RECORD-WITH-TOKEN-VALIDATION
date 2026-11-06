# Tourist Delete Record with Token Validation

Spring Boot 3 + Java 17 + Spring Data JPA + H2 + Swagger UI.

## Run the project
1. Install JDK 17 and Maven.
2. Open this folder in Eclipse/IntelliJ/VS Code as an existing Maven project.
3. Run `TouristDeleteApplication.java`, or execute:
   ```bash
   mvn spring-boot:run
   ```
4. Open Swagger UI: http://localhost:8080/swagger-ui/index.html

## API testing
- List sample records: `GET http://localhost:8080/api/tourists`
- Delete a record: `DELETE http://localhost:8080/api/tourists/1`
- Required header: `Token: VERY_SECRET_TOKEN`

### Expected results
- Valid token: HTTP 200 — `Tourist Record Deleted Successfully`
- Invalid or missing token: HTTP 500 — `Deletion Server Error`
- Unknown tourist ID with valid token: HTTP 404

In Swagger UI, open the DELETE endpoint, click **Try it out**, enter an existing ID, and add the `Token` header if the UI provides the header field. If Swagger does not display the custom header field automatically, test with Postman or curl:

```bash
curl -X DELETE http://localhost:8080/api/tourists/1 -H "Token: VERY_SECRET_TOKEN"
```

Invalid token test:
```bash
curl -i -X DELETE http://localhost:8080/api/tourists/2 -H "Token: WRONG_TOKEN"
```

## H2 database
- Console: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:touristdb`
- Username: `sa`
- Password: leave blank

The sample records are recreated whenever the application restarts.

**Lab note:** HTTP 500 is implemented for the invalid-token response because that is what the supplied lab sheet asks for. In a production API, an invalid token should normally return HTTP 401 or 403.
