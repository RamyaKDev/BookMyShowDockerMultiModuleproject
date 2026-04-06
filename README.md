![BookMyShow](https://github.com/user-attachments/assets/700811d6-29cf-42e4-98ec-d693c4c9daee)


1. Project Explanation:
“I worked on a Movie Ticket Booking application similar to BookMyShow, built using Spring Boot microservices.
The system allows users to browse movies, select shows, book seats, and receive booking notifications.
Each business capability like User, Show, Booking, and Notification is implemented as an independent service, deployed using Docker, and communicates via REST and Kafka.
I handled service-to-service communication, JWT security, database persistence with MySQL, and asynchronous notifications using Kafka.”

2. High-Level Architecture Explanation
“The application follows a microservices architecture.
Each service has its own responsibility, database tables, and REST APIs.
Services communicate using RestTemplate for synchronous calls and Kafka for asynchronous events.
All services run inside Docker containers and are connected through a Docker bridge network.”

3. Services in the project:
   
   <img width="636" height="350" alt="image" src="https://github.com/user-attachments/assets/b328fe48-eaba-4125-b21b-1a08bbc20e5d" />


   Output:
   
<img width="1231" height="889" alt="image" src="https://github.com/user-attachments/assets/fc94baf7-9ffc-47c7-8ad2-33be93f9c110" />
<img width="1282" height="702" alt="image" src="https://github.com/user-attachments/assets/14dec60a-00b1-40ea-ab2e-b208b3b9275a" />
<img width="1361" height="537" alt="image" src="https://github.com/user-attachments/assets/612c17f1-4f9a-4029-88f6-b1f73d73d6df" />

<img width="1485" height="805" alt="image" src="https://github.com/user-attachments/assets/60476754-746d-4ae6-98a0-f8b48d3cdd04" />

<img width="1185" height="686" alt="image" src="https://github.com/user-attachments/assets/ead92b9d-fd22-4f5e-82e9-09e20ee0170b" />
<img width="1173" height="596" alt="image" src="https://github.com/user-attachments/assets/94723941-2650-47ce-bf49-53a1f82e81d1" />

Now, when a booking is created:
    1. BookingService publishes a Kafka event (OrderEvent) to topic booking-topic.
    2. NotificationService consumes the event.
    3. It sends an email (or log) to the user.


    
![Booking flow](https://github.com/user-attachments/assets/291dee8b-405c-46de-a3a4-0fc379b8aab7)



    
![Untitled](https://github.com/user-attachments/assets/332459b5-eb15-46a3-997c-42511c088675)


