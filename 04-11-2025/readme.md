04-11-2025   Task-2

Sri Perumbuduri D M S Satyanarayana

ENC\16800

Objective

Design and implement a real-time data processing pipeline for an e-commerce application that handles order events with the following requirements
Step1: Create an SQS Queue 
Use Amazon SQS to create a queue (standard or FIFO depending on message ordering requirements).Standard queues: high throughput, at-least-once delivery.FIFO queues: exactly-once processing preserve message order.

 <img width="635" height="295" alt="image" src="https://github.com/user-attachments/assets/a4500b4f-d78c-4725-9b22-abcc2b90ae4b" />

Step2: Implement DynamoDB Table
Enable DynamoDB streams

 <img width="622" height="315" alt="image" src="https://github.com/user-attachments/assets/17dd5122-2030-471b-9626-e5f0520a233b" />

Step3: Lamda Function to process message body

 <img width="620" height="293" alt="image" src="https://github.com/user-attachments/assets/16eed21c-c573-4ccc-b44f-a1be307bbdbd" />

Step4 : Create Event Bridge Pipes

<img width="624" height="249" alt="image" src="https://github.com/user-attachments/assets/426bdce2-0638-4820-9b95-c8103a38116c" />

 
Filters in Event Bridge pipes

 <img width="620" height="277" alt="image" src="https://github.com/user-attachments/assets/8935ccc3-6d06-4cdb-bc2d-b691e3a8e992" />



Lamda Function for processing messages

<img width="624" height="269" alt="image" src="https://github.com/user-attachments/assets/14a6effa-9378-4c81-9d59-0aeb9a1945a4" />



Table contents

<img width="617" height="287" alt="image" src="https://github.com/user-attachments/assets/96f665b4-2302-4fde-a8db-9fbd0a88e5ca" />



Cloud Watch Logs

<img width="624" height="261" alt="image" src="https://github.com/user-attachments/assets/245f7207-b717-4281-afad-8ca48cd4b7f7" />







