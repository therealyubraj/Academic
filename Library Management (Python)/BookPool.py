from Borrow import Borrow
from Book import Book
from customDateTime import getCurDateTimeString, getDateTimeDifference
from MessagePrinter import MessagePrinter

'''
This file is dependent on Borrow.py, Book.py, customDateTime.py, MessagePrinter.py
Code might not be clear without understanding those files first.
'''

class BookPool():
    '''
    This class deals with all the collection data types. It reads from files and appropriately stores the data in 
    appropriate data structures. All the variables and methods in this class are static i.e., there is no need to instantiate.
    '''

    # constant numeric values are WRITTEN_LIKE_THIS. These variables are here to reduce 'magic numbers' in the program.
    MAX_RETURN_DAYS = 10
    FINE_FOR_LATE_RETURN = 2

    # file names for the files to read from: books.txt, borrows.txt
    booksFileName = 'books.txt'
    borrowFileName = 'borrows.txt'

    # data structures to store the read data in. 
    # books is a dictionary: book name is key, book object is value --> read from books.txt
    # borrows is a list of borrow objects --> read from borrows.txt
    books = {}
    borrows = []

    def addBook(name, author, quantity, price, writeToFile):
        '''
        This method is used to add a book to the books dictionary or to the books.txt file if required.

        @parameters:    name, author, quantity, price of book
                        writeToFile:boolean value that determines whether or not the books.txt file is
                                    overwritten by the current books dictionary data
        
        @return: none   
        '''

        b = Book(name, author, quantity, price)
        BookPool.books[b.name] = b

        #if writeToFile is True then overwrite the books.txt file by current books dictionary
        if(writeToFile):
            BookPool.writeBooksToFile()

    def addBorrow(bookNames, borrowerName, borrowedTime, amount, writeToMainFile, writeToNote):
        '''
        This method is used to add a borrow to the borrows list or to the borrows.txt file if required.

        @parameters:    bookNames: list of names of books to borrow,
                        borrowerName, borrowedTime, amount, 
                        writeToMainFile:boolean value that determines whether or not the borrows.txt file is
                                        overwritten by the current borrows list data
                        writeToNote:boolean value that determines whether or not a note is created for this borrow
        
        @return: none   
        '''

        b = Borrow(borrowerName, bookNames, borrowedTime, amount)
        BookPool.borrows.append(b)

        #if writeToMainFile is True then overwrite the borrows.txt file by current borrows list
        if(writeToMainFile):
            BookPool.writeBorrowsToFile()

        #if writeToNote is True then create a note for this borrow in borrows directory
        if(writeToNote):
            b.createBorrowNote()

    def getAllBorrows():
        '''
        This method is used to get a list of all the borrows in the borrows list.

        @parameters: none
        
        @return: a list of dictionary in this format:
                                                    'Index': an integer representing this borrow
                                                    'Name': name of the borrower
                                                    'Books': a string that is a list of names of books separated by comma.   
                Each dictionary represents a borrow object present in the borrows list.
        '''

        # list to return where all the dictionaries are stored
        allBorrows = []
        i = 1 # starting the indices at 1
        for b in BookPool.borrows:
            # making the dictionary and appending to allBorrows
            allBorrows.append({"Index": i, "Name": b.borrowerName, "Books": ",".join(b.borrowedBooks)})
            i += 1

        return allBorrows # return the list

    def getBorrowableBooks():
        '''
        This method is used to get a list of all the books' names that can be borrowed.

        @parameters: none
        
        @return: a list of names of books whose quantity is greater than 0
        '''
        # list to return
        borrowableBooks = []

        for b in BookPool.books.values():
            # if the quantity is greater than 0
            if b.quantity > 0:
                borrowableBooks.append(b.name) # append to the list to return
        return borrowableBooks

    def borrowBooks(bookNames, borrowerName):
        '''
        This method is used to borrow books.

        @parameters: bookNames: a list of names of books to borrow, borrowerName : name of borrower
        
        @return: none
        '''

        amount = 0 # total price of all books
        for book in bookNames:
            BookPool.books[book].quantity -= 1 # decrement each book quantity by 1
            amount += BookPool.books[book].price

        # add this borrow to the borrows list, replace the borrows.txt by borrows list and write a note
        BookPool.addBorrow(bookNames, borrowerName,
                       getCurDateTimeString(), amount, True, True) 

        # since quantity of books changed, overwrite books.txt by books dictionary
        BookPool.writeBooksToFile()

        MessagePrinter.printSuccess("Books borrowed successfully for price of $" + str(amount) + '!!!') # print message in color

    def returnBooks(borrowInd, returnerName):
        curDateTime = getCurDateTimeString() # get current date time and store it
        fine = 0 # fine = 0 by default

        # get duration of the borrow i.e., the difference in days between borrow time and return time using getDateTimeDifference() method
        returnDurationInDays = getDateTimeDifference(BookPool.borrows[borrowInd].dateTime, curDateTime) 

        # if return is after MAX_RETURN_DAYS
        if returnDurationInDays > BookPool.MAX_RETURN_DAYS:
            fine = BookPool.FINE_FOR_LATE_RETURN * (returnDurationInDays - BookPool.MAX_RETURN_DAYS) # fine for each day of late return

        # if fine > 0 print a warning message for fine
        if fine > 0:
            MessagePrinter.printWarning("Because of late submission, there is a fine of $" + str(fine))

        # create a return note
        BookPool.borrows[borrowInd].returnBooks(returnerName, curDateTime, fine)

        # increase quantity of all returned books by 1
        for book in BookPool.borrows[borrowInd].borrowedBooks:
            BookPool.books[book].quantity += 1

        # remove returned borrow from borrows list
        BookPool.borrows.pop(borrowInd)

        # overwrite both books.txt and borrows.txt by books and borrows
        BookPool.writeBorrowsToFile()
        BookPool.writeBooksToFile()

        MessagePrinter.printSuccess("Books returned successfully!!!") # print message in color

    def readFromFile():
        '''
        This method is used to ready all the data structures on file open.
        It reads from books.txt and borrows.txt and stores all data on books and borrows.

        @parameters: none
        
        @return: none
        '''

        # open books.txt file
        booksFile = open(BookPool.booksFileName)

        # read from file and make a list of each line
        bookFileLines = booksFile.read().split('\n')

        for line in bookFileLines:
            if line != '':
                # extract information from each line and store them in variables
                col = line.split(',')
                bookName = col[0]
                author = col[1]
                quantity = int(col[2])
                price = float(col[3])

                # call addBook to add the book to books dictionary but without overwriting books.txt
                BookPool.addBook(bookName, author, quantity, price, False)

        booksFile.close() # close the file

        # open borrows.txt file
        borrowFile = open(BookPool.borrowFileName)

        # read from file and make a list of each line
        borrowFileLines = borrowFile.read().split('\n')

        for line in borrowFileLines:
            if line != '':
                # extract information from each line and store them in variables
                col = line.split('||')
                bookNames = col[0].split(',')
                borrowerName = col[1]
                borrowedTime = col[2]
                borrowedAmount = float(col[3])

                # call addBorrow to add the borrow to borrows list but without overwriting borrows.txt
                BookPool.addBorrow(bookNames, borrowerName,
                               borrowedTime, borrowedAmount, False, False)

        borrowFile.close() # close the file

    def writeBooksToFile():
        '''
        This method is used to overwrite the books.txt file by the contents of books dictionary.

        @parameters: none
        
        @return: none
        '''

        file = open(BookPool.booksFileName, 'w') # open books.txt in write mode

        for b in BookPool.books.values():
            file.write(b.getInFileFormat()) # use getInFileFormat() to write it into file

        file.close() # close the file

    def writeBorrowsToFile():
        '''
        This method is used to overwrite the borrows.txt file by the contents of borrows list.

        @parameters: none
        
        @return: none
        '''

        file = open(BookPool.borrowFileName, 'w') # open borrows.txt in write mode

        for b in BookPool.borrows:
            file.write(b.getInFileFormat()) # use getInFileFormat() to write it into file

        file.close() # close the file

    def printAllBooks():
        '''
        This method is used to print all the books in books dictionary.

        @parameters: none
        
        @return: none
        '''
        # for every book in books print using printBook() method
        for b in BookPool.books.values():
            b.printBook()
