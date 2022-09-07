# Appointment_Scheduler


Technologies Used :
 Java 8
 Spring Boot 
 H2 DB (to make easy for evaluation)
 Microservices Environment 
     1. Trainer Service
     2. Application  Service
     3. Eureka Server

Trainer Service :

1. Designed Following  APIs-
      GET http://localhost:8081/trainer/hello  - To Test Service is UP
      GET http://localhost:8081/trainer/all  - Retrieve  all Trainer Details 
      GET http://localhost:8081/trainer/name/{trainer Name} - Retrieve trainer Details By Name
      GET http://localhost:8081/trainer/slots/{trainer Name} - Retrieve trainer Details By Name
      POST http://localhost:8081/trainer/add - takes Tainer Data in JSON format and Generates  Slots for his Availability  and adds Slots into DB

 {
    "trainerName": "Christ Schumm",
    "dayOfWeek": "Monday",
    "availableFrom": "9:00 AM",
    "availableTo": "5.30 PM"

}

Trainer Service DB :
http://localhost:8081/h2-console

	JDBC URL : jdbc:h2:file:./data/trainerDataBase

Appointment Service : 

GET  http://localhost:8082/appointment/hello -To Test if Service is UP
GET  http://localhost:8082/appointment/trainerSlots/John  - trainer availability by trainer name 
                - Internally calls Trainer Service and feches the Trainer's Slots and Then Querying  Slots from Appointment  table Shows Only available  Slots.
GET  http://localhost:8082/appointment/id/{appointment ID}  - View  appointment by ID
DELETE http://localhost:8082/appointment/cancelAppointment/{appointment ID}
POST http://localhost:8082/appointment/John/add  - Takes SLOT JSON Data and Creates Appointment.

{
            "slotId": 210,
            "slotBegin": "06:00 AM",
            "slotEnd": "06:30 AM",
            "trainerName": "John",
            "status": "Available",
            "day": "Monday"

        }

Appointment Service DB :
http://localhost:8082/h2-console/
	JDBC URL : jdbc:h2:file:./data/appointmentDataBase

