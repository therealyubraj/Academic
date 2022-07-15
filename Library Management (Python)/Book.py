class Book():    
    '''
    Book class stores all the details for a given book.
    '''
    def __init__(self, name, author, quantity, price):    
        '''
        Constructor for a book object

        @parameters: name, author, quantity and price of a book
        '''
        self.name, self.quantity, self.author, self.price = name, quantity, author, price

    def getInFileFormat(self):
        '''
        This method is used to get a string for this book object that is in the format to be written to books.txt file.

        File format for books.txt:
        book1||author1||quantityOfBook||priceOfBook

        @parameters: none
        
        @return: string in file format   
        '''
        return self.name + "," + self.author + "," + str(self.quantity) + "," + str(self.price) + "\n"
    
    def printBook(self):
        '''
        This method is used to get a print all the details for this book object to the terminal.

        Format for printing:
        Name: bookName
        Author: authorName
        Quantity: bookQuantity
        Price: bookPrice

        @parameters: none
        
        @return: none
        '''
        
        print("Name:", self.name)
        print("Author:", self.author)
        print("Quantity:", self.quantity)
        print("Price: $" + str(self.price))
        print('-------------------------------- \n')
