# **Scalable IoT Data Processing**  
## **Overview**  
This project is a scalable event-driven IoT data processing system built using **Kafka, PostgreSQL, and Java Spring Boot**. It efficiently processes **high-throughput IoT data streams** and can be deployed to **AWS using Terraform**.  

## **Features**  
- IoT Sensor Data Processing (Vehicle Telemetry, GPS, Speed, Acceleration)  
- Apache Kafka for Real-time Streaming  
- PostgreSQL for Data Storage and Querying  
- Spring Boot API for Data Ingestion  
- Python IoT Simulator for Testing  
- AWS (MSK, RDS, ECS) for Cloud Deployment  
- Terraform for Infrastructure as Code  
- Docker-Compose for Local Testing  

## **Technologies Used**  
- Java Spring Boot  
- Apache Kafka  
- PostgreSQL  
- Docker & Docker Compose  
- AWS (MSK, RDS, ECS)  
- Terraform  
- Python (IoT Data Simulation)  

## **Installation & Setup**  
### **Prerequisites**  
Ensure you have the following installed:  
- Java 17+  
- Apache Maven  
- Python 3+  
- Docker & Docker Compose  
- Terraform  
- PostgreSQL  


### **Start Kafka and PostgreSQL Using Docker**  
```sh
docker-compose up -d
```

### **Run the Spring Boot API (IoT Data Ingestion)**  
```sh
cd api
mvn spring-boot:run
```

### **Run the Kafka Consumer (Processing IoT Data)**  
```sh
cd consumer
mvn spring-boot:run
```

### **Run the Python IoT Data Simulator**  
```sh
cd simulator
python simulate_iot_data.py
```

---

## **Usage**  
### **Send IoT Data to API Manually**  
Use the following `curl` command to send IoT data:  
```sh
curl -X POST "http://localhost:8080/api/vehicle/send" -H "Content-Type: application/json" -d '{
  "vehicleId": "ABC123",
  "speed": 80,
  "acceleration": -5.4,
  "brakingForce": 8.9,
  "gpsLatitude": 37.7749,
  "gpsLongitude": -122.4194,
  "timestamp": 1710790500
}'
```

### **Run the Python IoT Data Simulator**  
The Python script automatically generates and sends IoT data every **2 seconds**.  
```sh
cd simulator
python simulate_iot_data.py
```
📄 **Python Code (`simulator/simulate_iot_data.py`)**
```python
import requests
import json
import random
import time

API_URL = "http://localhost:8080/api/vehicle/send"

def generate_vehicle_data():
    return {
        "vehicleId": "vehicle_" + str(random.randint(1, 100)),
        "speed": round(random.uniform(0, 120), 2),
        "acceleration": round(random.uniform(-6, 0), 2),
        "brakingForce": round(random.uniform(0, 10), 2),
        "gpsLatitude": round(37.7749 + random.uniform(-0.01, 0.01), 6),
        "gpsLongitude": round(-122.4194 + random.uniform(-0.01, 0.01), 6),
        "timestamp": int(time.time() * 1000)
    }

while True:
    vehicle_data = generate_vehicle_data()
    response = requests.post(API_URL, json=vehicle_data)
    print(f"Sent: {vehicle_data}, Response: {response.text}")
    time.sleep(2)
```

### **Check Data in PostgreSQL**  
```sql
SELECT * FROM vehicle_iot_data ORDER BY timestamp DESC;
```

### **View Kafka Messages**  
```sh
kafka-console-consumer --bootstrap-server localhost:9092 --topic iot-sensor-data --from-beginning
```

---

## **Deploy to AWS Using Terraform**  
### **Initialize and Apply Terraform**  
```sh
cd terraform
terraform init
terraform apply -auto-approve
```

---


## **License**  
This project is licensed under the MIT License.  
