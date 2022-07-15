package ABYSS;

/**
 *
 * @author ABYSS
 * Attributes:  noOfCols: total attributes count
 *              custId: customer id
 *              custName: customer Name
 *              custPhone : customer phone
 *              custAddress : customer address
 *              genre: genre of the selected song
 *              artist: artist of the selected song
 *              album: album of the selected song
 *              title: title of the selected song
 *              purchase type: type of the purchase
 *              paid via: medium of payment
 *              cost: cost of the purchase
 *              sortedOrder: array will store indices of the object if it were sorted by the ith column.
 * 
 */
public class Purchase {

    public static int noOfCols = 11;

    public String custId, custName, custPhone, custAddress, genre, artist, album, title, purchaseType, paidVia;
    public float cost;
    public int[] sortedOrder;

    public Purchase(String custId, String custName, String custPhone, String custAddress, String genre, String artist, String album, String title, String purchaseType, String paidVia, float cost) {
        //sets all the attributes based on the parameters and initialized sortedOrder
        this.custId = custId;
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.title = title;
        this.purchaseType = purchaseType;
        this.paidVia = paidVia;
        this.cost = cost;

        sortedOrder = new int[Purchase.noOfCols];
    }
    
    public String[] getInTableFormat() {
        // Returns the string array of all the attributes for this purchase object
        return new String[]{custId, custName, custPhone, custAddress, genre, artist, album, title, purchaseType, paidVia, String.valueOf(cost)};
    }
}
