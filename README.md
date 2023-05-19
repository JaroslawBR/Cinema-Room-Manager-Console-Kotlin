# PL: Cinema Room Manager

Jest to program napisany w języku Kotlin, który umożliwia rezerwację biletów w kinie. Program pozwala użytkownikom wyświetlić dostępne miejsca, zakupić bilety oraz uzyskać statystyki dotyczące sprzedaży biletów.

## Instrukcje Użycia

1. Po wprowadzeniu danych, podaj liczbę rzędów w sali kinowej.

2. Podaj liczbę miejsc w każdym rzędzie.

3. Wybierz jedną z dostępnych opcji:

    - `Show the seats:` Wyświetla aktualny stan miejsc w sali kinowej.

    - `Buy a ticket:` Pozwala użytkownikowi na zakup biletu poprzez wybranie konkretnego miejsca.

    - `Statistics:` Udostępnia statystyki dotyczące sprzedaży biletów, w tym liczbę zakupionych biletów, procentowy udział sprzedanych miejsc, bieżący przychód oraz całkowity przychód.

    - `Exit:` Kończy działanie programu.
  
## Przykład
```shell
Enter the number of rows: 7
Enter the number of seats in each row: 10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 1

Cinema:
  1 2 3 4 5 6 7 8 9 10
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 2

Enter a row number: 3
Enter a seat number in that row: 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 3

Number of purchased tickets: 1
Percentage: 0.24%
Current income: $10
Total income: $70

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 0
```
### Opis
Ten program wykorzystuje tablicę dwuwymiarową do reprezentowania miejsc w sali kinowej. Początkowo wszystkie miejsca są oznaczone jako 'S' (dostępne). Po zakupie biletu, miejsce jest oznaczane jako 'B' (zajęte).

# ENG: Cinema Room Manager Console Kotlin 
## This is a Kotlin program for a cinema ticket booking system. The program allows users to view available seats, purchase tickets, and obtain statistics about ticket sales.

### Usage Instructions

1. When prompted, enter the number of rows in the cinema hall.

2. Enter the number of seats in each row.

3. Choose from the following options:

    - `Show the seats:` Displays the current status of seats in the cinema hall.

    - `Buy a ticket:` Allows the user to purchase a ticket by selecting a specific seat.

    - `Statistics:` Provides statistics on ticket sales, including the number of purchased tickets, the percentage of seats sold, current income, and total income.

    - `Exit:` Terminates the program.
### Example
```shell
Enter the number of rows: 7
Enter the number of seats in each row: 10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 1

Cinema:
  1 2 3 4 5 6 7 8 9 10
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S
S S S S S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 2

Enter a row number: 3
Enter a seat number in that row: 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 3

Number of purchased tickets: 1
Percentage: 0.24%
Current income: $10
Total income: $70

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

Enter your choice: 0
```
### Description
This program uses a mutable list to represent the seats in the cinema hall. Each seat is initially marked as 'S' to indicate it is available. When a ticket is purchased, the seat is marked as 'B' to indicate it is occupied.
