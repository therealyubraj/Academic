import datetime

def getCurDateTimeString():
    '''
    Returns the current date-time in format: 'DD-MM-YY_HH-MM-SS' 
    Eg: 03-02-2021_20-02-01
        This would be 3rd February 2021. 8 'o clock evening, 2 minutes, 1 seconds.
    '''
    return datetime.datetime.now().strftime("%d-%m-%Y_%H-%M-%S")


def getDateTimeDifference(datetime1, datetime2):
    '''
    Returns the difference between two dates in days
    Eg: datetime1 = '01-01-2020_02_02_02', datetime1 = '06-01-2020_02_02_02': returns 5
    '''

    # extract year, day, month information from the string and store in each variable
    year1, day1, month1 = int(datetime1[6] + datetime1[7] + datetime1[8] + datetime1[9]), int(
        datetime1[0] + datetime1[1]), int(datetime1[3] + datetime1[4])
    year2, day2, month2 = int(datetime2[6] + datetime2[7] + datetime2[8] + datetime2[9]), int(
        datetime2[0] + datetime2[1]), int(datetime2[3] + datetime2[4])

    # make datetime objects so that difference can be calculated
    date1 = datetime.date(year1, month1, day1)
    date2 = datetime.date(year2, month2, day2)

    delta = date2 - date1

    #return difference in days
    return delta.days
