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

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Authors
This project is maintained by [Yane Yanev].

---

### Задание (Task)
Решението на задачата включва моделиране и реализация на процеса на зареждане и продажба на стоки в магазин. В магазина се зареждат стоки, които ще се продават. Всяка стока се определя от идентификационен номер, име, единична доставна цена и категория (хранителни и нехранителни стоки). Освен това всяка стока има дата на изтичане на срока на годност.

Продажната цена на стоката се определя по следния начин: Хранителните и нехранителните стоки имат различен % надценка, който се определя в магазина. Ако срокът на годност наближава, т.е. остават по-малко от даден брой дни до изтичането му, продажната цена на стоката се намалява с определен %. Броят на дните до изтичането на срока и % намаление са различни за всеки магазин. Стоки с изтекъл срок на годност не трябва да се продават.

В магазина работят касиери, които имат име, идентификационен номер и определена месечна заплата. На всяка от касите в магазина може да работи по един касиер. Всеки касиер може да работи на различна каса. На всяка от касите в магазина, касиерите маркират стоките, които клиентите искат да си купят. Ако клиентите имат достатъчно пари, за да си купят стоките, касиерите им ги продават и издават касови бележки.

При продажба на стока, да се проверява дали има достатъчно налично количество от нея. Ако количеството не е достатъчно да се хвърля изключение. Изключението да показва от коя стока какво количество не достига, за да се извърши покупката.

Касовата бележка трябва да съдържат минимум следната информация: пореден номер, касиер, който издава касовата бележка, дата и час на издаване на касовата бележка, списък със стоки, които се включват в касовата бележка включително цената и количеството им и общата стойност, която трябва да се заплати от клиента.

Необходимо е да се съхранява общия брой на издадените касови бележки до момента и общата сума, която се генерира като оборот при издаването. При издаването на касовата бележка е необходимо нейното съдържание да се показва и да се запазва във файл. Всяка касова бележка трябва да се пази в отделен файл с име на файла, което да съдържа поредния номер на издадената касова бележка. Трябва да може да се провери колко са издадените касови бележки към момента. Информацията във файла, в който се записва касовата бележка трябва да може да се прочете.

В магазина се съхранява информация касиерите, които работят в него, за списъка с доставените и продадените стоки както и за издадените касови бележки. За всеки магазин трябва да може да се изчисли колко са разходите за: заплати на касиери и за доставка на стоки и колко са приходите от продадени стоки. Освен това, трябва да се изчислява колко е печалбата на магазина.

В проекта трябва да е използват подходи за управление на изключения и да се реализират unit тестове. Приложението трябва да бъде разработено на Java и да изпълнява изискванията, които са описани по-горе.

