/**
 * @author Matthew Lewis
 * A class that is used to create Books that store ISBN, title, author, publisher, and year published. 
 * 	Class is also used to compare books with each other and see if they are equal.
 */

package assg6_lewism20;

public class Book implements Comparable<Book>
{
	private int ISBN;
    private String title;
    private String author;
    private String publisher;
    private int pubYear;
    
    /**
     * One constructor for all the needed information
     * @param gISBN The given ISBN number
     * @param gTitle The given book title
     * @param gAuthor The given authors name
     * @param gPublisher The given publisher
     * @param gPubYear The given year of publish
     */
    public Book(int gISBN, String gTitle, String gAuthor, String gPublisher, int gPubYear)
    {
        ISBN = gISBN;
        title = gTitle;
        author = gAuthor;
        publisher = gPublisher;
        pubYear = gPubYear;
    }
    
    /**
     * Returns the current ISBN number
     * @return Current ISBN number
     */
    public int getISBN() 
    {
		return ISBN;
	}
    
    /**
     * Sets the ISBN
     * @param iSBN New ISBN
     */
	public void setISBN(int iSBN) 
	{
		ISBN = iSBN;
	}
	
	/**
	 * Returns the current author
	 * @return Current author
	 */
	public String getAuthor() 
	{
		return author;
	}
	
	/**
	 * Sets the author
	 * @param author New author
	 */
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	/**
	 * Returns the current publisher
	 * @return Current publisher
	 */
	public String getPublisher() 
	{
		return publisher;
	}
	
	/**
	 * Sets the publisher
	 * @param publisher New publisher
	 */
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	
	/**
	 * Returns the current year
	 * @return Current year
	 */
	public int getPubYear() 
	{
		return pubYear;
	}
	
	/**
	 * Sets the publishing year
	 * @param pubYear New year
	 */
	public void setPubYear(int pubYear) 
	{
		this.pubYear = pubYear;
	}
	
	/**
	 * Returns the current title
	 * @return Current title
	 */
	public String getTitle() 
	{
		return title;
	}
	
	/**
	 * Checks if the titles of two books are the same
	 * @param gBook Given Book as object
	 */
	public boolean equals(Object gBook)
	{
		if ((this.getTitle()).equals(((Book) gBook).getTitle()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Compares the authors of books
	 * @param gBook The book being compared to
	 * @return 1 if after, 0 if the same, -1 if before
	 */
	@Override
	public int compareTo(Book gBook)
	{
		return (this.getTitle()).compareTo(gBook.getTitle());
	}
	
	/**
     * Converts the book into a string with each variable on a separate line
     */
    @Override
    public String toString() 
    {
        return ISBN + "\n" + title + "\n" + author + "\n" + publisher + "\n" + pubYear + "\n";
    }
}
