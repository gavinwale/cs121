import java.util.ArrayList;


/**
 * CS 121 Project 3 Library Class
 * 
 * The Library class creates methods for an ArrayList object making it act like
 * a library.
 * 
 * @author Gavin Wale
 */

public class Library implements LibraryInterface {

	private ArrayList<Book> books = new ArrayList<Book>();

	

	/**
	 * Makes a copy of books ArrayList
	 * 
	 * @return Copy of books
	 */
	public ArrayList<Book> getBooks() {

		ArrayList<Book> library = (ArrayList<Book>) this.books.clone();
		return library;
	}

	/**
	 * Carries out add method to books
	 * 
	 * @param Book object
	 * 
	 * @return books + newBook
	 */
	public void addBook(Book newBook) { // DONE

		this.books.add(newBook); // Adds book newBook
		
	}

	/**
	 * Carries out remove method to books
	 * 
	 * @param int index
	 * 
	 * @return books without removed book
	 */
	public void removeBook(int index) { // DONE

		this.books.remove(index); // Removes book at given index
	}

	/**
	 * Retrieves book at given index
	 * 
	 * @param int index
	 * @return Reference to book at index
	 */
	public Book getBook(int index) { // DONE

		if (index >= this.books.size() || index < 0) { // If given index is larger than books or less than 0
			return null; // Return null
		} else { // Else (if given index is within the bounds of the books ArrayList
			return this.books.get(index); // Return the book at the given index.

		}

	}

	/**
	 * Checks books ArrayList for book objects and prints them with attributes
	 * 
	 * @return List of books
	 */
	public String toString() { // DONE

		
		
		String libraryString = "";
		
		for (int i = 0; i < books.size(); i++) {
			libraryString += ("Index: " + i + "\t" + books.get(i) + "\n");
			
		}
		
		
//		 int i = 0;
//		
//		 for (Book newBook : this.books) {
//
//			 System.out.print("Index: " + i + "\t"); 
//			 System.out.println((newBook.toString()));
//
//		 i++;
//
//		}

		return libraryString;
	}

}
