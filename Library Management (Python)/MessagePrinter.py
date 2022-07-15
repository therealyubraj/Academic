import os
os.system("color") # to make terminal use ANSI escape codes correctly

class colors:
    ''' This class stores all the colors' ANSI codes to be used in the program so that 
    they can be accessed when needed instead of writing the code every time it is necessary.'''

    reset = '\033[0m'
    bold = '\033[01m'
    fg = {
        'red': '\033[31m',
        'green': '\033[32m',
        'blue': '\033[34m',
        'pink': '\033[95m'
    }
    bg = {
        'white': '\033[47m'
    }


class MessagePrinter():
    '''This class handles printing of special messages with ANSI colors. It has methods to print:
    Success, Warning, Error and the headings. All the methods are static so they can be called without instantiating an object of the class'''

    def printText(text, bgColor, fgColor, breakLine):
        e = '\n' if breakLine else '' #set end to '\n' if breakline == true else e = ''
        print(colors.fg[fgColor], colors.bold, colors.bg[bgColor], text, colors.reset, end=e) #print the text in the colors  in parameter
    
    def printSuccess(text):
        #success message = green text on white background
        MessagePrinter.printText('SUCCESS: ' + text, 'white', 'green', True)

    def printError(text):
        #error message = red text on white background
        MessagePrinter.printText('ERROR: ' + text, 'white', 'red', True)

    def printWarning(text):
        #warning message = pink text on white background
        MessagePrinter.printText('WARNING: ' + text, 'white', 'pink', True)

    def printHeading(text):
        #heading message = blue text on white background
        MessagePrinter.printText(text, 'white', 'blue', True)
    

