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


4. 
