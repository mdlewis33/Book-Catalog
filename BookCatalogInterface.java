/**
 * @author Matthew Lewis
 * 
 * Interface that promises certain behaviors that relate to cataloging books
 */

package assg6_lewism20;

import java.util.ArrayList;

public interface BookCatalogInterface 
{
	ArrayList<Book> bookList = new ArrayList<Book>();
	
	/**
	 * Imports the data from a file and puts it into an ArrayList of books
	 * @param FileN File that imports the data
	 */
	public void loadData(String FileN);
	
	/**
     * Displays every book in the "catalog"(ArrayList)
     */
	public void displayCatalog();
	
	/**
     * Iterates through books to find the same title and returns the entire Book
     * @param gTitle The given title to compare
     * @return The Book class
     */
	public Book searchForBook(String gTitle);
	
	/**
     * Adds a new book if there is not the same one already in the list
     * @param gISBN Given ISBN for new book
     * @param gTitle Given Title for new book
     * @param gAuthor Given Author for new book
     * @param gPub Given Publisher for new book
     * @param gYear Given Year for new book
     * @return true if the book was added, false if the book is already in the list
     */
	public boolean addBook(int gISBN, String gTitle, String gAuthor, String gPub, int gYear);
	
	/**
     * If there is a book with the same title it replaces it. If none are the same it exits without doing anything
     * @param gISBN Given ISBN for replacement book
     * @param gTitle Given Title for replacement book
     * @param gAuthor Given Author for replacement book
     * @param gPub Given Publisher for replacement book
     * @param gYear Given Year for replacement book
     * @return true if the same title is found after replacing info, false if there is no same title
     */
	public boolean updateBook(int gISBN, String gTitle, String gAuthor, String gPub, int gYear);
	
	/**
     * Removes a book when the title check out
     * @param gTitle Given title to compare
     * @return true when title is the same, false with no same title
     */
	public boolean removeBook(String gTitle);
	
	/**
     * Checks through an ArrayList of Books and if the publisher matches the given one, it gets added to a different ArrayList.
     * @param gPub Given publisher to compare
     * @return The ArrayList with the books that are made by the given publisher
     */
	public ArrayList<Book> getBooksByPublisher(String gPub);
	
	/**
     * Sorts the catalog of books by title
     */
	public void sortByTitle();
	
	/**
     * Saves the current catalog into the a file
     */
	public void Save();
}
