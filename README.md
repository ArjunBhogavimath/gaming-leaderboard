# Gaming Leaderboard

## 👨‍💻 Overview

A full-stack gaming leaderboard system that enables users to:

* Submit scores
* View a dynamic leaderboard (Top 10)
* Check a player's rank

The backend is built with **Java + Spring Boot**, the frontend with **Vue 3 + Quasar**, and the system is fully integrated with **PostgreSQL** and **New Relic APM** for monitoring.

---

## 🚀 Features Implemented

* ✅ Score submission API
* ✅ Top 10 leaderboard API
* ✅ Player rank lookup API
* ✅ PostgreSQL database with test data (10k users, 50k sessions)
* ✅ Full Vue 3 + Quasar frontend
* ✅ New Relic monitoring with real traffic
* ✅ Load testing with Python script

---

## 🧪 Load Simulation

Load testing was done using a custom Python script `simulate_load.py` that:

* Submits 1000+ randomized scores across users
* Generates traffic to `/submit` endpoint
* Triggers live leaderboard and rank updates

---

## 📈 New Relic Monitoring

New Relic was integrated using the Java Agent. Metrics observed:

* Application throughput
* Average response time
* Endpoint performance (`/submit`, `/top`, `/rank/{userId}`)
* Database activity

### 📸 Screenshots:

All monitoring visuals are stored in:

```
docs/newrelic-screenshots/
```

### 🔗 Direct Link to Dashboard:

[Click here to view the New Relic Dashboard](https://one.newrelic.com/nr1-core/apm/overview/NjkxNzIyNXxBUE18QVBQTElDQVRJT058OTg2Nzk2MTgy?account=6917225&duration=1800000&state=97b09630-3a55-4276-9ed9-5555dc685c37)

---

## 🧰 Tech Stack

* **Backend**: Java 17, Spring Boot, JPA, PostgreSQL (Docker)
* **Frontend**: Vue 3, Quasar CLI, Composition API
* **Monitoring**: New Relic APM
* **Testing**: Postman, Python load script

---

## 📂 Project Structure

```
gaming-leaderboard/
├── backend/                 # Spring Boot backend
│   └── docker-compose.yml   # PostgreSQL & pgAdmin
├── frontend/                # Vue + Quasar frontend
├── simulate_load.py         # Load testing script
├── docs/
│   ├── newrelic-screenshots/ # New Relic APM screenshots
│   └── ui-screenshots/       # Gaming leaderboard UI screenshots
└── README.md                # Project documentation (this file)
```

---

## 📦 How to Run

1. Start PostgreSQL with Docker:

   ```bash
   cd backend
   docker-compose up -d
   ```

2. Run backend with New Relic agent:

   ```bash
   cd backend
   JAVA_OPTS="-javaagent:./newrelic/newrelic-agent.jar" ./mvnw spring-boot:run
   ```

3. Run backend without New Relic (alternative):

   ```bash
   cd backend
   ./mvnw spring-boot:run
   ```

4. Run Quasar frontend:

   ```bash
   cd frontend
   quasar dev
   ```

5. Run load script:

   ```bash
   python simulate_load.py
   ```

---



**Made with ❤️ by Mallikarjunaiah B M**
[LinkedIn](https://www.linkedin.com/in/mallikarjunaiah-b-m-1331a319a/) | [vpmallikarjuna03@gmail.com](mailto:vpmallikarjuna03@gmail.com) | +91 7619413484
