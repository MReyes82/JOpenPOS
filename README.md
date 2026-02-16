# JOpenPOS

## Microbusiness Management System

A comprehensive management application for a microbusiness. It provides a graphical user interface to register and maintain information about employees, customers, and products, as well as manage sales and data storage. The application is organized into three main layers: backend, frontend, and resources.

Built with **Java**, **Maven**, and **Swing UI** for my Java lang workshop Uni class.

---

## Features

### Employee Management
- **Registration** — Capture first name, last name, age, salary, and employee type (baker, cleaning staff, salesperson, etc.).
- **Update & Delete** — Modify or remove employee records.
- **Shift Assignment** — Assign employees to morning, afternoon, or night shifts.
- **Listing & Filtering** — List and filter employees by type.

### Customer Management
- **Registration** — Record personal and contact information.
- **Update** — Edit customer data such as phone number or address.
- **Points** — Customers accumulate points through purchases for discounts or promotions.
- **Purchase History** — Full transaction history per customer.

### Product Management
- **Registration** — Add various items with price, description, and category.
- **Update & Delete** — Edit or remove product records.
- **Classification** — Organize products by type.

### Sales Management
- **Receipt Generation** — Generate detailed receipts for every sale.
- **Sales Recording** — Automatic inventory updates with each transaction.

### Data Storage
- **Save & Load** — Persist all employee, customer, and product data to serialized files, and restore it on startup.

---

## Prerequisites

- **Java JDK** 8 or higher
- **Apache Maven** 3.6+

---

## Building

```bash
# Clone the repository
git clone <repository-url>
cd JOpenPOS

# Compile and package the project
mvn clean package
```

## Running

```bash
# Option 1 — Run with Maven
mvn exec:java -Dexec.mainClass="APLICACION_PRINCIPAL.mainApp"

# Option 2 — Run the compiled classes directly
java -cp target/classes APLICACION_PRINCIPAL.mainApp
```

The main entry point is located at `src/main/java/APLICACION_PRINCIPAL/mainApp.java`.

---

## Project Structure

```
src/main/java/
├── APLICACION_PRINCIPAL/   # Application entry point
├── backend/
│   ├── modelos/            # Data models (Cliente, Producto, Empleados)
│   ├── saves/              # Serialization / data persistence
│   └── servicios/          # Business logic (Factura, Venta)
└── frontend/
    ├── ventanasLogin/      # Login & support windows
    ├── ventanasMantenimiento/  # CRUD windows for employees, customers, products
    └── ventanasMenuPrincipal/  # Main menu
```

---

## License

MIT, this project is open source.
