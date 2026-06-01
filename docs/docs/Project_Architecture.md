# Project Architecture

## High-Level Architecture

```text
Frontend Dashboard
(HTML + CSS + JavaScript)

            ↓

REST APIs
(Spring Boot Controllers)

            ↓

Business Logic
(Service Layer)

            ↓

Data Access Layer
(Repository Layer)

            ↓

MySQL Database
```

---

## Component Breakdown

### 1. Frontend Layer

Technologies:

* HTML
* CSS
* JavaScript
* Chart.js

Responsibilities:

* Display KPI Cards
* Display Charts
* Display Product Rankings
* Display AI Insights
* Call Backend APIs using Fetch API

---

### 2. Controller Layer

Controllers:

* SalesRecordController
* AnalyticsController

Responsibilities:

* Receive HTTP Requests
* Validate Input
* Return JSON Responses
* Connect Frontend with Backend

Example:

```http
GET /analytics/dashboard
```

---

### 3. Service Layer

Services:

* SalesRecordService
* AnalyticsService

Responsibilities:

* Implement Business Logic
* Process Analytics
* Calculate Revenue
* Calculate Profit
* Generate Dashboard Data

Example:

```java
getTotalRevenue()
getTotalProfit()
getTopProduct()
```

---

### 4. Repository Layer

Repository:

* SalesRecordRepository

Responsibilities:

* Database Communication
* Execute SQL/JPA Queries
* Retrieve Aggregated Data

Example:

```java
getTotalRevenue()
getTopProduct()
getMonthlySales()
```

---

### 5. Database Layer

Database:

MySQL

Table:

sales_records

Columns:

* id
* date
* product
* category
* sales
* profit
* customer

---

## Request Flow Example

Dashboard Request:

```text
Browser

↓

dashboard.js

↓

GET /analytics/dashboard

↓

AnalyticsController

↓

AnalyticsService

↓

SalesRecordRepository

↓

MySQL Database

↓

JSON Response

↓

Dashboard UI Update
```

---

## Design Patterns Used

### Repository Pattern

Purpose:

Separates database access logic from business logic.

Example:

```java
SalesRecordRepository
```

---

### Service Layer Pattern

Purpose:

Separates business rules from controllers.

Example:

```java
AnalyticsService
```

---

### DTO Pattern

Purpose:

Transfer data between backend and frontend.

Examples:

* DashboardResponse
* RevenueResponse
* ProfitResponse
* TopProductResponse

---

## Benefits of Architecture

* Modular Design
* Easy Maintenance
* Scalability
* Reusability
* Clean Separation of Concerns
* Industry Standard Structure
