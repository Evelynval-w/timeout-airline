#  Timeout Airline - Flight Booking System

A backend web application for managing flight bookings, built with Java Spring Boot.

---

## 📖 What is This Project?

This is a flight booking system for a fictional airline called **Timeout Airline**. It allows customers to:

- Search for available flights
- Book flights online
- Earn rewards after multiple bookings

The system also helps the airline manage their planes, airports, flights, employees, and customers.

---

## Team

| Name | Role |
|------|------|
| Evelynval | User, Client, Employee, Booking, MilesReward |
| Hetvi | Plane, Airport, Flight, Flight Search |

---

## 🛠️ Technologies Used

- **Java 21** - Programming language
- **Spring Boot 4.0** - Backend framework
- **MySQL** - Database
- **Maven** - Dependency management
- **JPA/Hibernate** - Database ORM (auto-creates tables)
- **Postman** - API testing

---

## 📁 Project Structure

```
src/main/java/fr/epita/timeoutairline/
├── model/          → Database entities (User, Flight, Booking, etc.)
├── repository/     → Database access layer
├── service/        → Business logic
├── controller/     → REST API endpoints
├── dto/            → Data transfer objects
└── exception/      → Custom error handling
```

---

## 🗄️ Database Tables

The application automatically creates these tables:

| Table | Description |
|-------|-------------|
| `users` | Base info for all people (name, email, phone, etc.) |
| `clients` | Customers who book flights (has passport number) |
| `employees` | Airline staff (pilots, attendants, etc.) |
| `planes` | Aircraft information (brand, model, year) |
| `airports` | Airport details (name, city, country) |
| `flights` | Flight schedules and pricing |
| `bookings` | Customer flight reservations |
| `miles_rewards` | Tracks bookings and discount codes |

---

## 🚀 How to Run the Project

### Step 1: Make Sure You Have

- Java 21 installed
- MySQL installed and running
- An IDE (Eclipse or IntelliJ)

### Step 2: Create the Database

Open MySQL and run:

```sql
CREATE DATABASE timeout_airline;
```

### Step 3: Configure Database Connection

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/timeout_airline
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### Step 4: Run the Application

In your IDE, run `TimeoutairlineApplication.java`

Or in terminal:

```bash
./mvnw spring-boot:run
```

### Step 5: Test the API

Open Postman or your browser and go to:

```
http://localhost:8084/api/v1/planes
```

---

## 📡 API Endpoints

### Planes

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/planes` | Get all planes |
| GET | `/api/v1/planes/{id}` | Get one plane |
| POST | `/api/v1/planes` | Create a plane |
| PUT | `/api/v1/planes/{id}` | Update a plane |
| DELETE | `/api/v1/planes/{id}` | Delete a plane |

### Airports

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/airports` | Get all airports |
| GET | `/api/v1/airports/{id}` | Get one airport |
| GET | `/api/v1/airports/city/{city}` | Get airports by city |
| POST | `/api/v1/airports` | Create an airport |
| PUT | `/api/v1/airports/{id}` | Update an airport |
| DELETE | `/api/v1/airports/{id}` | Delete an airport |

### Flights

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/flights` | Get all flights |
| GET | `/api/v1/flights/{flightNumber}` | Get one flight |
| GET | `/api/v1/flights/search?from=X&to=Y&date=Z` | Search flights |
| POST | `/api/v1/flights` | Create a flight |
| PUT | `/api/v1/flights/{flightNumber}` | Update a flight |
| DELETE | `/api/v1/flights/{flightNumber}` | Delete a flight |

### Clients

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/clients` | Get all clients |
| GET | `/api/v1/clients/{id}` | Get one client |
| GET | `/api/v1/clients/passport/{numPassport}` | Get client by passport |
| POST | `/api/v1/clients` | Create a client |
| PUT | `/api/v1/clients/{id}` | Update a client |
| DELETE | `/api/v1/clients/{id}` | Delete a client |

### Employees

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/employees` | Get all employees |
| GET | `/api/v1/employees/{id}` | Get one employee |
| POST | `/api/v1/employees` | Create an employee |
| PUT | `/api/v1/employees/{id}` | Update an employee |
| DELETE | `/api/v1/employees/{id}` | Delete an employee |

### Bookings

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/bookings` | Get all bookings |
| GET | `/api/v1/bookings/{id}` | Get one booking |
| GET | `/api/v1/bookings/available-seats/{flightNumber}` | Check available seats |
| POST | `/api/v1/bookings` | Create a booking |
| POST | `/api/v1/bookings/book` | Book a flight (new or existing customer) |
| DELETE | `/api/v1/bookings/{id}` | Cancel a booking |

### Miles Rewards

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/miles-rewards` | Get all rewards |

---

## 🧪 Test Data Examples

### Create a Plane

```json
POST /api/v1/planes
{
    "brand": "Boeing",
    "model": "737",
    "manufacturingYear": 2020
}
```

### Create an Airport

```json
POST /api/v1/airports
{
    "nameAirport": "Charles de Gaulle",
    "countryAirport": "France",
    "cityAirport": "Paris"
}
```

### Create a Flight

```json
POST /api/v1/flights
{
    "flightNumber": "TA101",
    "departureCity": "Paris",
    "arrivalCity": "London",
    "departureHour": "08:00",
    "arrivalHour": "09:30",
    "departureDate": "2025-01-15",
    "numberOfSeat": 150,
    "firstClassSeatPrice": 500.00,
    "premiumSeatPrice": 300.00,
    "businessClassPrice": 200.00,
    "economicsClassPrice": 100.00,
    "plane": {"idPlane": 1},
    "departureAirport": {"idAirport": 1},
    "arrivalAirport": {"idAirport": 2}
}
```

### Book a Flight

```json
POST /api/v1/bookings/book
{
    "lastname": "Doe",
    "firstname": "John",
    "passportNumber": "AB123456",
    "birthdate": "1990-05-15",
    "departureCity": "Paris",
    "arrivalCity": "London",
    "flightNumber": "TA101",
    "typeOfSeat": "BUSINESS"
}
```

### Search for Flights

```
GET /api/v1/flights/search?from=Paris&to=London&date=2025-01-15
```

---

## ✨ Key Features

### 1. Flight Search
Customers can search for flights by:
- Departure city
- Arrival city
- Departure date

### 2. Smart Booking System
- Checks if seats are available before booking
- Creates new customer if they don't exist
- Uses existing customer if passport number is found

### 3. Miles Reward Program
- Every booking is recorded
- After 3 flights in the same year, a discount code is automatically generated
- Example: `DISC-EDDB7CDE`

### 4. Seat Availability Check
- The system prevents overbooking
- You can check available seats anytime

---

## ⚠️ Business Rules

1. **No overbooking** - You cannot book a flight if all seats are taken
2. **Unique passport** - Each client must have a unique passport number
3. **Unique employee number** - Each employee must have a unique employee number
4. **Discount rewards** - Discount code is generated every 3 flights per calendar year

---

## 🐛 Error Handling

The API returns helpful error messages:

**Resource Not Found:**
```json
{
    "status": 404,
    "error": "Not Found",
    "message": "Flight not found with flightNumber: 'TA999'"
}
```

**No Seats Available:**
```json
{
    "status": 400,
    "error": "Bad Request",
    "message": "No available seats on flight TA101. Total: 150, Booked: 150"
}
```

---

## Notes for Presentation

1. **Start the application** before the demo
2. **Create data in this order:**
   - Planes first
   - Airports second
   - Flights third (they need planes and airports)
   - Clients/Employees anytime
   - Bookings last (they need flights and clients)

3. **Show the discount code feature:**
   - Book 3 flights with the same client
   - Check miles rewards to see the discount code

---

## 📄 License

This project was created for EPITA's Java Application Development course by 
Okoene Makuo & Hetvi.

---

##  Acknowledgments

- EPITA School of Engineering
- Spring Boot Documentation
- Our Java Professor

---

Made with care by the Timeout Airline Team
