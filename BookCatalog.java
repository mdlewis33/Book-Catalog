/**
 * @author Matthew Lewis
 * 
 * A class that can load books from a file, display the books to the screen, search for a specific book by the title,
 * 		add a new book, update a book, remove a book, returns books with the same publisher, sort the books by the title,
 * 		and finally save the data into the original file.
 */

package assg6_lewism20;

import java.io.*;
import java.util.*;

public class BookCatalog 
{
	ArrayList<Book> bookList = new ArrayList<Book>();
	
	/**
	 * Imports the data from a file and puts it into an ArrayList of books
	 * @param FileN File that imports the data
	 */
    public void loadData(String FileN) 
    {
        Scanner inputStream = null;
        
        try 
        {
            inputStream = new Scanner(new File(FileN));
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("Could not open/find file " + FileN);
            System.exit(1);
        }
        
        while (inputStream.hasNext())
        {
            String[] tempA = new String[4];
            
            int tempI1 = inputStream.nextInt();
            
            for (int x = 0; x < 4; x++) 
            {
                tempA[x] = inputStream.nextLine();
            }
            int tempI2 = inputStream.nextInt();
            
            bookList.add(new Book(tempI1, tempA[1], tempA[2], tempA[3], tempI2));
        }
        
        inputStream.close();
    }
    
    /**
     * Displays every book in the "catalog"(ArrayList)
     */
    public void displayCatalog()
    {
        Iterator<Book> iter = bookList.iterator();
        
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
    
    /**
     * Iterates through books to find the same title and returns the entire Book
     * @param gTitle The given title to compare
     * @return The Book class
     */
    public Book searchForBook(String gTitle)
    {
    	Iterator<Book> iter = bookList.iterator();
    	
    	while(iter.hasNext())
    	{
    		Book newestBook = iter.next();
    		
    		if (newestBook.getTitle().equals(gTitle))
    		{
    			return newestBook;
    		}
    	}
    	return null;
    }
    
    /**
     * Adds a new book if there is not the same one already in the list
     * @param gISBN Given ISBN for new book
     * @param gTitle Given Title for new book
     * @param gAuthor Given Author for new book
     * @param gPub Given Publisher for new book
     * @param gYear Given Year for new book
     * @return true if the book was added, false if the book is already in the list
     */
    public boolean addBook(int gISBN, String gTitle, String gAuthor, String gPub, int gYear)
    {
    	Iterator<Book> iter = bookList.iterator();
    	
    	while(iter.hasNext())
    	{
    		Book newestBook = iter.next();
    		
    		if ((newestBook).getTitle().equals(gTitle))
    		{
    			System.out.println("Book already exists.");
    			return false;
    		}
    	}
    	
    	bookList.add(new Book(gISBN, gTitle, gAuthor, gPub, gYear));
    	return true;
    }
    
    /**
     * If there is a book with the same title it replaces it. If none are the same it exits without doing anything
     * @param gISBN Given ISBN for replacement book
     * @param gTitle Given Title for replacement book
     * @param gAuthor Given Author for replacement book
     * @param gPub Given Publisher for replacement book
     * @param gYear Given Year for replacement book
     * @return true if the same title is found after replacing info, false if there is no same title
     */
    public boolean updateBook(int gISBN, String gTitle, String gAuthor, String gPub, int gYear)
    {
    	Iterator<Book> iter = bookList.iterator();
    	
    	int counter = 0;
    	
    	while(iter.hasNext())
    	{
    		Book newestBook = iter.next();
    		
    		if ((newestBook).getTitle().equals(gTitle))
    		{
    			bookList.remove(counter);
    			bookList.add(counter, new Book(gISBN, gTitle, gAuthor, gPub, gYear));
    			return true;
    		}
    		counter++;
    	}
    	
    	System.out.println("Book already exists.");
		return false;
    }
    
    /**
     * Removes a book when the title check out
     * @param gTitle Given title to compare
     * @return true when title is the same, false with no same title
     */
    public boolean removeBook(String gTitle)
    {
    	Iterator<Book> iter = bookList.iterator();
    	
    	int counter = 0;
    	
    	while(iter.hasNext())
    	{
    		Book newestBook = iter.next();
    		
    		if ((newestBook.getTitle()).equals(gTitle))
    		{
    			bookList.remove(counter);
    			return true;
    		}
    		counter++;
    	}
    	
    	System.out.println("Book does not exist.");
    	return false;
    }
    
    /**
     * Checks through an ArrayList of Books and if the publisher matches the given one, it gets added to a different ArrayList.
     * @param gPub Given publisher to compare
     * @return The ArrayList with the books that are made by the given publisher
     */
    public ArrayList<Book> getBooksByPublisher(String gPub)
    {
    	ArrayList<Book> nBookList = new ArrayList<Book>();
    	
    	Iterator<Book> iter = bookList.iterator();
    	
    	while(iter.hasNext())
    	{
    		Book newestBook = iter.next();
    		if (newestBook.getPublisher().equals(gPub))
    		{
    			nBookList.add(newestBook);
    		}
    	}
    	
    	return nBookList;
    }
    
    /**
     * Sorts the catalog of books by title
     */
    public void sortByTitle()
    {
    	Collections.sort(bookList);
    }
    
    /**
     * Saves the current catalog into the a file
     */
    public void Save()
    {
    	String fileOut = "assg6_catalog.txt";
    	PrintWriter outputStream = null;
    	
    	try
        {
            outputStream = new PrintWriter(fileOut);
        }
        catch(IOException e)
        {
            System.out.println("Error opening file " + fileOut);
            System.exit(1);
        }
    	
    	Iterator<Book> iter = bookList.iterator();
    	while (iter.hasNext())
    	{
    		Book newestBook = iter.next();
    		
    		outputStream.println(newestBook.getISBN());
    		outputStream.println(newestBook.getTitle());
    		outputStream.println(newestBook.getAuthor());
    		outputStream.println(newestBook.getPublisher());
    		outputStream.println(newestBook.getPubYear());
    		outputStream.println();
    	}
    	
    	outputStream.close();
    }
}
