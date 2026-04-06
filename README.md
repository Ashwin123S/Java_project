# 🚆 Railway Reservation System

A simple **Railway Reservation System** built in Java as a college project.  
It supports 3 types of coaches, handles seat booking, waiting lists, cancellations, and prints a full reservation chart.

---

## 📁 Project Structure

```
Java_project/
├── Ticket.java              → Data model for a single ticket
├── Coach.java               → Manages seats & waiting list per coach
├── ReservationSystem.java   → Core logic (all 4 modules)
└── Main.java                → Entry point with interactive menu
```

---

## 🚃 Coach Types

| Coach    | Total Seats | Waiting List |
|----------|-------------|--------------|
| AC       | 60          | 10           |
| NON_AC   | 60          | 10           |
| SEATER   | 60          | 10           |

> If both confirmed seats and waiting list are full, the booking request is **automatically cancelled**.

---

## 📦 Modules

### 1. 🎫 Ticket Booking
- Enter passenger name and coach type
- If seat is available → **CONFIRMED**
- If seats are full but waiting list has space → **WAITING**
- If both are full → **Request Cancelled**

### 2. 🔍 Availability Checking
- Shows total seats, booked seats, available seats, and waiting list count for any coach

### 3. ❌ Ticket Cancellation
- Cancel by Ticket ID
- If a waiting-list passenger exists, they are **automatically promoted** to confirmed

### 4. 📋 Prepare Chart
- Prints full reservation chart for all 3 coaches
- Shows confirmed passengers and waiting list separately

---

## ▶️ How to Run

### Step 1 – Compile
```bash
javac *.java
```

### Step 2 – Run
```bash
java Main
```

### Step 3 – Use the Menu
```
--------- MAIN MENU ---------
1. Book Ticket
2. Check Availability
3. Cancel Ticket
4. Prepare Full Chart
5. Check Ticket Status
6. Exit
```

---

## 💡 Sample Output

```
Enter passenger name : Ashwin
Coach types: AC | NON_AC | SEATER
Enter coach type     : AC

BOOKING SUCCESS: Ticket ID : 1001 | Name : Ashwin | Coach : AC | Status : CONFIRMED | Seat : 1
```

---

## 🧠 Concepts Used

- **OOP** – Classes: `Ticket`, `Coach`, `ReservationSystem`
- **ArrayList** – To store confirmed tickets
- **Queue (LinkedList)** – For waiting list (FIFO order)
- **HashMap** – To map coach types to Coach objects
- **Scanner** – For user input via console

---

## 👨‍💻 Author

**Ashwin S**  
GitHub: [@Ashwin123S](https://github.com/Ashwin123S)

---

## 📌 Note

This is a college-level academic project built for learning core Java concepts like OOP, Collections, and basic system design.
