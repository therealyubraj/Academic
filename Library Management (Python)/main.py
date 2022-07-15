from BookPool import BookPool
from MessagePrinter import MessagePrinter
import time

'''
This file is dependent on BookPool.py, MessagePrinter.py.
Code might not be clear without understanding those files first.
'''

# read from file when the program starts
BookPool.readFromFile()


def printMainMenu():
    '''
    This method prints the main menu and asks the user for a numeric input of where they want to go
    
    @parameters: none
    @returns: user input wihtout input validation
    '''

    print("--------------------------------------------\n")
    MessagePrinter.printHeading("Main menu:")  # print in color
    print("1: Add a new book")
    print("2: Borrow books")
    print("3: Return books")
    print("4: Display all books")
    print("5: Exit")
    print('--------------------------------------- \n')
    return input("Enter the number for where you want to go: ")


def addBookMenu():
    '''
    This method deals with the addition of a new book to the current list of books.
    It prints all the required user input prompts.

    @parameters: none
    @returns: name, author, quantity, price of book in that order (all numeric fields have been input validated)
    '''
    
    print("---------------------------------------------")
    MessagePrinter.printHeading("Add a book: ")  # print in color
    name = input("Enter the name of the new book: ")
    author = input("Enter the name of the author: ")

    # keep asking for input until user inputs valid value
    while(True):
        try:
            quantity = int(input("Enter the quantity of the book: "))
            if quantity > 0:
                break  # input is valid so break out of while loop
            quantity = int('a')

        except:
            MessagePrinter.printError(
                "Please enter a valid number for quantity. Valid values are positive integers: 1, 2, 3,...")  # print error message in color

    # keep asking for input until user inputs valid value
    while(True):
        try:
            price = float(input("Enter the price of the book: "))
            if price > 0:
                break  # input is valid so break out of while loop
            price = float('a')
        except:
            MessagePrinter.printError(
                "Please enter a valid number for price. Valid values are positive decimal numbers. 0.1, 2,...")  # print error message in color

    return name, author, quantity, price


def borrowBooksMenu():

    '''
    This method deals with the borrowing of books.
    It prints all the required user input prompts.

    @parameters: none
    @returns: list of names of books to borrow, name of the borrower in that order (all numeric fields have been input validated)
    '''

    print('--------------------------------------------')
    MessagePrinter.printHeading('Borrow Menu:')  # print in color

    borrowedBooks = []  # list to store all books names user wishes to borrow

    # get all books' names which can be borrowed
    borrowableBooks = BookPool.getBorrowableBooks()

    # if no books can be borrowed print message
    if len(borrowableBooks) == 0:
        MessagePrinter.printWarning(
            "No books can be borrowed!!! Please wait for some books to be added or returned.")  # print warning in color
        print("---------------------------------------")
        return '', ''  # return empty because no books can be borrowed

    borrowerName = input("Enter the name of the borrower: ")

    # keep asking for input until user inputs valid value
    while(True):
        try:
            numberOfBooks = int(input(
                "Out of " + str(len(borrowableBooks)) + " books how many books to borrow: "))
            if numberOfBooks < 1 or numberOfBooks > len(borrowableBooks):
                # input not in range so induce an exception manually
                numberOfBooks = int('a')
            break  # if code reaches here, then input is valid so break out of loop

        except:
            MessagePrinter.printError(
                "Please enter a valid number. Valid values are positive integers: 1 to " + str(len(borrowableBooks)))  # print error in color

    MessagePrinter.printHeading(
        "---Number indices for all the borrowable books:---")  # print in color

    i = 1  # indices for books start at one and i stores them
    for b in borrowableBooks:
        print(str(i) + ":", b)  # print index with book's name
        i += 1
    print('----------------------------------------- \n')

    # take input numberOfBooks times as the user wishes to borrow that many books
    for i in range(0, numberOfBooks):

        # keep asking for input until user inputs valid value
        while(True):
            try:
                toBorrowInd = int(
                    input("Enter the index number for book to be borrowed: "))
                if toBorrowInd > 0 and toBorrowInd <= len(borrowableBooks):
                    # user cant borrow same book twice
                    if(borrowableBooks[toBorrowInd - 1] in borrowedBooks):
                        MessagePrinter.printError(
                            "ERROR:You cannot borrow 2 of the same book! Please choose another book!")  # print error in color
                    else:
                        # add the book name to the borrowedBooks list
                        borrowedBooks.append(borrowableBooks[toBorrowInd - 1])
                        break  # valid input so break out of while loop
                else:
                    # input out of valid range so induce exception manually
                    toBorrowInd = int('a')

            except:
                MessagePrinter.printError(
                    "Please enter a valid number for index. Valid values are positive integers: 1 to " + str(len(borrowableBooks)))  # print error in color

    return borrowedBooks, borrowerName  # return list of books and name of borrower


def returnBooksMenu():

    '''
    This method deals with the returning of books.
    It prints all the required user input prompts.

    @parameters: none
    @returns: Index of the borrow that user wishes to return, name of the returner in that order (all numeric fields have been input validated)
    '''

    # get all pending borrows that have not yet been returned
    allBorrows = BookPool.getAllBorrows()

    print('--------------------------------------------')
    MessagePrinter.printHeading('Return Menu:')

    # if no borrows are pending
    if(len(allBorrows) == 0):
        MessagePrinter.printWarning("All borrows have been returned!!!!")
        return -1, ''

    returnerName = input('Enter the name of the returner: ')

    MessagePrinter.printHeading(
        "Number indices for all the returnable borrows:")  # print in color
    print('-----------------------------')

    # print all the borrows with their indices, borrower name and book names
    for b in allBorrows:
        print(str(b['Index']) + ": Borrower Name:",
              b['Name'] + ', Borrowed Books:', b['Books'])

    print('------------------------------ \n')

    toReturnInd = 0  # this variable stores the index of borrow that user wishes to return

    # keep asking for input until user inputs valid value
    while(True):
        try:
            toReturnInd = int(
                input("Enter the index number for borrow to be returned: "))
            if toReturnInd < 1 or toReturnInd > len(allBorrows):
                # input out of valid range so induce exception manually
                toReturnInd = int('a')
            break  # if code reaches here then input was valid so break out of while loop

        except:
            MessagePrinter.printError(
                "Please enter a valid number for index. Valid values are positive integers: 1 to " + str(len(allBorrows)))  # print error in color

    ''' toReturnInd is decremented by 1 as the indices in list start at 0 but
    user was shown borrows with indices starting with 1 '''
    return toReturnInd - 1, returnerName  # return return index and returner name

# main infinite loop which breaks only when user wishes to exit the program
while(True):
    try:
        ip = int(printMainMenu()) # get value from method and try to convert to integer

        if ip < 1 or ip > 5:
            ip = int('a') # input was in invalid range so induce exception manually

        # input is in between 1 and 5 so check for each case
        if ip == 1:
            #add book menu
            name, author, quantity, price = addBookMenu() # call addBookMenu() and store returned values in respective variables

            BookPool.addBook(name, author, quantity, price, True) # add new book to the books dictionary and to books.txt file
            MessagePrinter.printSuccess('Book added successfully!!!!') # print success message in color
            print('--------------------------------- \n')

        elif ip == 2:
            # borrow book menu
            borrowedBookNames, borrowerName = borrowBooksMenu() # call borrowBooksMenu() and store returned values in respective variables
            
            # if no books can be borrowed, then borrowedBookNames == '' 
            if borrowedBookNames != '':
                BookPool.borrowBooks(borrowedBookNames, borrowerName) # add to borrows list and borrows.txt file and create a borrow note

        elif ip == 3:
            # return book menu
            returnInd, returnerName = returnBooksMenu() # call returnBooksMenu() and store returned values in respective variables
            if returnInd != -1:
                BookPool.returnBooks(returnInd, returnerName) # remove from borrows list and borrows.txt file and create a return note

        elif ip == 4:
            BookPool.printAllBooks() # print all the books with their details

        elif ip == 5:
            MessagePrinter.printHeading("GOODBYE!!!!!! See you soon!!!!") # print goodbye message in color
            time.sleep(5) # sleep so that the user can see the message before termination
            break # user wishes to exit so break out of main while loop
    except:
        MessagePrinter.printError("Please enter an integer between 1 and 5.") # print error message in color
