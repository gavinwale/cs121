
import java.util.Scanner;

/**
 * CS 121 Project 3: LibraryOfBooks
 * 
 * Library of Books provides a console user interface that allows the user to
 * add, delete, and read books through methods in the book and library classes.
 * 
 * @author Gavin Wale
 */

public class LibraryOfBooks {

	public static void main(String[] args) {

		Library library = new Library(); // This was miserable
		library.getBooks(); // This was also miserable

		// Menu interface
		System.out.println("========================");
		System.out.println("      Library Menu      ");
		System.out.println("========================");
		System.out.println("(p)rint library contents");
		System.out.println("(a)dd a book");
		System.out.println("(d)elete a book");
		System.out.println("(r)ead a book");
		System.out.println("(q)uit");

		// New scanner object
		Scanner scan = new Scanner(System.in);
		String userCommand = "";

		// Prompting user to enter a command
		System.out.print("Please enter a command: ");

		// While user command is not "q" or "Q", run the switch
		while (!userCommand.toLowerCase().equals("q")) {

			userCommand = scan.nextLine();

			switch (userCommand.toLowerCase()) {

			case "p": // Prints library contents

				System.out.println(library);
				// TODO: add library empty
//				library.toString();
//
				System.out.println();
				System.out.print("Please enter a command: ");
				break;

			case "a": // Adds book, prompts Title, Author, Genre, Filename

				Book addedBook = new Book(null, null); // THIS WAS IT. I had to create a new instance variable inside.

				// Add title
				System.out.print("Title: ");
				String userTitle = scan.nextLine();
				addedBook.setTitle(userTitle);

				// Add author
				System.out.print("Author: ");
				String userAuthor = scan.nextLine();
				addedBook.setAuthor(userAuthor);

				// Add genre
				System.out.print("Genre: ");
				String userGenre = scan.nextLine();
				addedBook.setGenre(userGenre);

				// Add filename
				System.out.print("Filename: ");
				String userFilename = scan.nextLine();
				addedBook.setFilename(userFilename);

				// Adds addedBook to library
				library.addBook(addedBook);

				System.out.println("Book added!");
				System.out.println();
				System.out.print("Please enter a command: ");

				break;

			case "d": // Deletes book, prompts index (invalid index)

				System.out.println("Which book would you like to delete?");
				System.out.print("Index: ");
				String deleteBook = scan.nextLine();
				int deleteIndex = Integer.parseInt(deleteBook); // Turns scanned line into an integer

				try {
					library.removeBook(deleteIndex); // Try to remove the book at the given index
					System.out.println("Book deleted!");
				} catch (IndexOutOfBoundsException e) { // If not,
					System.out.println("Invalid index..."); // Output this
				}

				System.out.println();
				System.out.print("Please enter a command: ");

				break;

			case "r": // Reads book, prompts index (invalid index)

				System.out.println("Which book would you like to read?");
				System.out.print("Index: ");
				String readBook = scan.nextLine();
				int readIndex = Integer.parseInt(readBook); // Turns scanned line into an integer

				try {

					if (library.getBook(readIndex).isValid()) {
						library.getBook(readIndex).getText();
					} else if (!library.getBook(readIndex).isValid()) {
						System.out.println("Book is not available to read.");
						
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Invalid index...");

				}


				System.out.println();
			System.out.print("Please enter a command: ");

				break;

			case "q":
				System.out.println("Goodbye!"); // Quit exits program
				break;

			default:
				System.out.println("Invalid selection...");
				System.out.println("Please enter a command: ");

			}

		}

		scan.close(); // Closes scanner

	}

}
