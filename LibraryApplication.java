/**
 * @author Matthew Lewis
 * 
 * Main method that loops if you want to do several things with a book and it's catalog
 */

package assg6_lewism20;

import java.util.*;

public class LibraryApplication 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String filename = "assg6_catalog.txt";
		
		int input = 0;
		
		BookCatalog catalog = new BookCatalog();
		catalog.loadData(filename);
		
		int counter = 0;
		
		while(input != 9)
		{
			System.out.println("Pick an option displayed below: ");
			System.out.println("1. Display all the books in the catalog.");
			System.out.println("2. Search for a book.");
			System.out.println("3. Add a new book.");
			System.out.println("4. Update an existing book.");
			System.out.println("5. Remove a book.");
			System.out.println("6. Display books by a publisher.");
			System.out.println("7. Sort all the books based on title.");
			System.out.println("8. Save data.");
			System.out.println("9. Exit.");
			
			input = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(input) 
			{
				case 1: catalog.displayCatalog();
						break;
						
				case 2: System.out.print("\nEnter the title you want to search for: ");
						String tTitle = keyboard.nextLine();
						System.out.println();
						if (catalog.searchForBook(tTitle) == null)
						{
							System.out.println("\nThe book you searched for was not found.\n");
						}
						else
						{
							System.out.println(catalog.searchForBook(tTitle));
						}
						counter++;
						break;
						
				case 3: System.out.print("\nEnter the ISBN of the new book: ");
						int ISBN = keyboard.nextInt();
						keyboard.nextLine();
						System.out.print("\nEnter the title of the new book: ");
						String title = keyboard.nextLine();
						System.out.print("\nEnter the author of the new book: ");
						String author = keyboard.nextLine();
						System.out.print("\nEnter the publisher of the new book: ");
						String publisher = keyboard.nextLine();
						System.out.print("\nEnter the year the new book was published: ");
						int pYear = keyboard.nextInt();
						System.out.println();
						catalog.addBook(ISBN, title, author, publisher, pYear);
						counter++;
						break;
						
				case 4: System.out.print("\nEnter the title of the book you want to update: ");
						String nTitle = keyboard.nextLine();
						int choice = -1;
						
						while(catalog.searchForBook(nTitle) == null)
						{
							System.out.println("\nInvalid title");
							System.out.print("Enter the title of the book you want to update: ");
							nTitle = keyboard.nextLine();
						}
						
						Book tBook = catalog.searchForBook(nTitle);
						
						while (choice != 0)
						{
							System.out.println();
							System.out.println("Pick an option displayed below: ");
							System.out.println("0. Return to main menu.");
							System.out.println("1. Change the ISBN.");
							System.out.println("2. Change the author.");
							System.out.println("3. Change the publisher.");
							System.out.println("4. Change the published year.");
							
							choice = keyboard.nextInt();
							keyboard.nextLine();
							
							tBook = catalog.searchForBook(nTitle);
							
							switch(choice)
							{
								case 0:	break;
								case 1: System.out.print("\nEnter the ISBN of the book you want to update: ");
										int nISBN = keyboard.nextInt();
										keyboard.nextLine();
										catalog.updateBook(nISBN, nTitle, tBook.getAuthor(), tBook.getPublisher(), tBook.getPubYear());
										break;
								case 2: System.out.print("\nEnter the author of the book you want to update: ");
										String nAuthor = keyboard.nextLine();
										catalog.updateBook(tBook.getISBN(), nTitle, nAuthor, tBook.getPublisher(), tBook.getPubYear());
										break;
								case 3: System.out.print("\nEnter the publisher of the book you want to update: ");
										String nPublisher = keyboard.nextLine();
										catalog.updateBook(tBook.getISBN(), nTitle, tBook.getAuthor(), nPublisher, tBook.getPubYear());
										break;
								case 4: System.out.print("\nEnter the year the book you want to update was published: ");
										int nPYear = keyboard.nextInt();
										catalog.updateBook(tBook.getISBN(), nTitle, tBook.getAuthor(), tBook.getPublisher(), nPYear);
										break;
							}
						}
						counter++;
						break;
				case 5: System.out.print("\nEnter the title of the book you want to remove: ");
						String rTitle = keyboard.nextLine();
						System.out.println();
						catalog.removeBook(rTitle);
						counter++;
						break;
				case 6: System.out.print("Enter the name of the publisher: ");
						String sPublisher = keyboard.nextLine();
						ArrayList<Book> pBookList = catalog.getBooksByPublisher(sPublisher);
						Iterator<Book> iter = pBookList.iterator();
						System.out.println();
						while(iter.hasNext())
						{
							System.out.println(iter.next());
						}
						System.out.println("All books made by " + sPublisher + " are printed above.");
						System.out.println();
						counter++;
						break;
				case 7: catalog.sortByTitle();
						System.out.println("Sorted books by title.");
						System.out.println();
						counter++;
						break;
				case 8: catalog.Save();
						System.out.println("Data Saved.");
						System.out.println();
						break;
				case 9: if (counter > 0)
						{
							catalog.Save();
						}
						break;
			}
		}
		
		keyboard.close();
	}
}
