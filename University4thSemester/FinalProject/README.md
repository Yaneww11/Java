# Store Management System

## Description
This project involves the modeling and implementation of a process for stocking and selling goods in a store. The store stocks goods which are to be sold. Each item is identified by an ID number, name, unit purchase price, and category (food and non-food items). Additionally, each item has an expiration date.

## Features
- **Pricing:** 
  - Selling price is calculated based on the purchase price with a markup percentage, which is different for food and non-food items.
  - Items close to their expiration date have a reduced selling price, with the reduction percentage and the number of days until expiration being specific to each store.
  - Items past their expiration date are not sold.

- **Staff:**
  - Cashiers have a name, ID number, and a specified monthly salary.
  - Each cashier can work at different cash registers in the store.
  - Cashiers scan items that customers wish to purchase. If customers have sufficient funds, the cashiers complete the sale and issue receipts.

- **Stock Management:**
  - Checks are made to ensure there is sufficient stock for each sale.
  - If stock is insufficient, an exception is thrown, indicating the item and the quantity shortfall.

- **Receipts:**
  - Receipts contain the following minimum information:
    - Serial number
    - Cashier issuing the receipt
    - Date and time of issuance
    - List of items included in the receipt, along with their price and quantity
    - Total amount to be paid by the customer
  - Total number of issued receipts and the total revenue generated are stored.
  - Receipt contents are displayed and saved to a file upon issuance, with each receipt stored in a separate file named with its serial number.
  - The number of issued receipts can be checked, and the information in the receipt files can be read.

- **Store Information:**
  - Maintains information about the cashiers working in the store, the list of stocked and sold items, and the issued receipts.
  - Calculates the costs for cashier salaries and item deliveries, the revenue from sold items, and the store's profit.

## Requirements
- **Programming Language:** Java
- **Testing:** Implement unit tests
- **Exception Handling:** Use proper exception management approaches

## How to Run
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/store-management-system.git
    cd store-management-system
    ```
2. Open the project in your preferred Java IDE.
3. Build and run the project.
4. Follow the instructions in the application to simulate stocking and selling goods.

## Project Structure
