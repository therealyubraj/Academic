class Borrow():
    '''
    Borrow class handles borrowing and returning of books, creating notes for transactions and stores details for a given borrow.
    '''
    
    # static variables to store directory name of borrows and return note files
    borrowFileDir = 'Borrows\\'
    returnFileDir = 'Returns\\'

    def __init__(self, name, books, dateTime, totalPrice):
        '''
        Constructor for borrow object

        @parameters:    name:           name of the borrower,
                        borrowedBooks:  list of names of borrowed books
                        dateTime:       date and time in string(DD-MM-YY_HH-MM-SS) of borrow
                        amount:         total sum of the prices of each book                     
        '''
        self.borrowerName = name
        self.borrowedBooks = books
        self.dateTime = dateTime
        self.amount = totalPrice

    def getInFileFormat(self):
        '''
        This method is used to get a string for this borrow object that is in the format to be written to borrows.txt file.

        File format for borrows.txt:
        book1,book2,book3||borrowerName||dateTimeOfBorrow||totalAmountOfBorrow

        @parameters: none
        
        @return: string in file format   
        '''

        toRet = ','.join(self.borrowedBooks) + "||" + self.borrowerName + \
            "||" + self.dateTime + "||" + str(self.amount) + '\n'
        return toRet

    def createBorrowNote(self):
        '''
        This method is used to create a note for this borrow object.

        File format for note file:
        File Name: borrowerName dateTime.txt

        Content:
        Borrowed:-------------------- 
        Borrower Name: borrowerName
        Borrowed Books: borrowedBooks seprated by comma
        Borrowed Date(DD-MM-YY): Date of borrow
        Borrowed Time(HH-MM-SS): Time of borrow
        Total Amount: total amount of borrow

        @parameters: none
        
        @return: none
        '''

        noteFile = open(Borrow.borrowFileDir +
                        self.borrowerName + ' ' + self.dateTime + '.txt', 'w')

        noteFile.write("Borrowed:-------------------- \n")
        noteFile.write("Borrower Name: " + self.borrowerName + '\n')
        noteFile.write("Borrowed Books: " +
                       ','.join(self.borrowedBooks) + '\n')

        borrowedDate = self.dateTime.split('_')[0]
        borrowedTime = self.dateTime.split('_')[1]

        noteFile.write("Borrowed Date(DD-MM-YY): " + borrowedDate + '\n')
        noteFile.write("Borrowed Time(HH-MM-SS): " + borrowedTime + '\n')
        noteFile.write("Total Amount: $" + str(self.amount))

        noteFile.close()

    def returnBooks(self, returnerName, returnDateTime, fine):
        '''
        This method is used to create a return note for this borrow object.

        File format for return note file:
        File Name: returnerName dateTime.txt

        Content:
        Returned:-----------------
        Returner Name: returnerName
        Borrowed Books: returnedBooks separated by commas
        Return Date(DD-MM-YY):: Return date
        Return Time(HH-MM-SS):: returnTime
        Amount for books: total price of books
        Fine for late submission: fine if late submitted else 0
        Total Amount: Toal amount = amount for books + fine

        @parameters: none
        
        @return: none
        '''
        noteFile = open(Borrow.returnFileDir + returnerName +
                        ' ' + returnDateTime + '.txt', 'w')

        noteFile.write("Returned:----------------- \n")
        noteFile.write("Returner Name: " + returnerName + '\n')
        noteFile.write("Borrowed Books: " + ','.join(self.borrowedBooks) + '\n')

        returnedDate = returnDateTime.split('_')[0]
        returnedTime = returnDateTime.split('_')[1]

        noteFile.write("Return Date(DD-MM-YY):: " + returnedDate + '\n')
        noteFile.write("Return Time(HH-MM-SS):: " + returnedTime + '\n')
        noteFile.write("Amount for books: $" + str(self.amount) + '\n')
        noteFile.write("Fine for late submission: $" + str(fine) + '\n')
        noteFile.write("Total Amount: $" + str(self.amount + fine))

        noteFile.close()
