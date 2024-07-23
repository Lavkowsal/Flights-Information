### Flights-Information

<b>Flights-Information API</b> , built on `spring Boot` framework.
This repo will contain infrastructure and application code for `Flights-Information`


### Flights-Information

The purpose of this API 
- Fetching public flight information.Using AviationStack API (https://aviationstack.com/) 
- Store the basic flight data in a suitable database.
- Developed an endpoint to export the flight data as a JSON, CSV and/or as a PDF based on a user-provided date range.


### GET -  Flights-Information
This endpoint will retrieve flight information from the aviationstack API response.(dummy response)


### System Design Approach
### Architecture Overview
     * Spring Boot Application:
        - Acts as the main application framework.
        - Provides RESTful endpoints for data export.
          
     * Service Layer:
        - Implements logic to fetch flight information from an external API.

     * Data Layer:
       - ORM (Object-Relational Mapping) with JPA/Hibernate.

     * Controller Layer:
       - Provides endpoints to export flight data in various formats (JSON, CSV, PDF).
       
       

### Fetching and Storing Flight Data
     *  Flight Data Fetching Service:
        - Use a service to call the AviationStack API (or similar) periodically.

     * Data Storage:
        - Use JPA entities to map flight data to database tables.
        - Save fetched flight data into the database.
        
        

### Generating and Exporting Data
     * Data Retrieval:
       - Query the database for flight data within the user-provided date range.

     * Data Export:
        - Use libraries to generate different formats:
        - JSON: Directly return the data as JSON.
        - CSV: Use a library like Apache Commons CSV.
        - PDF: Use a library like iText or Apache PDFBox.
        
        

### Tools and Libraries
     - Spring Boot: Framework for building the application.
     - Spring Data JPA: For ORM and database interaction.
     - H2: For database management.
     - RestTemplate/WebClient: For calling the external API.
     - Apache Commons CSV: For CSV generation.
     - iText/Apache PDFBox: For PDF generation.

     
To invoke the endpoint, hit the following url using a REST Client such as Postman

 * Endpoint    -  Flight Information
 * HTTP Method -  GET
 * Environment -  Local
 * URL(getFlights) - http://localhost:8000/api/flightInfo/getFlights
 * URL (downloads) - http://localhost:8000/api/flightInfo/downloads?format=json

<details>
<summary><b>Sample Request Body</b></summary>

```
N/A
```
</details>

<details>
<summary><b>Sample Response</b></summary>

```
{
  "id": 1,
  "flight_date": "2019-12-12",
  "flight_status": "active",
  "airport": "San Francisco International",
  "depatureScheduled": "2019-12-12T04:20:00.000+00:00",
  "arrivalScheduled": "2019-12-12T04:20:00.000+00:00"
}
```
</details>


## Local Setup
Steps to set up this application locally -

1. Clone the project
```
git clone https://github.com/Lavkowsal/Flights-Information.git
```
2. Build project
```
mvn spring-boot:run
```
```
4. Test by hitting the endpoint, using a REST Client such as Postman -
```
http://localhost:8000/api/flightInfo/getFlights
```

