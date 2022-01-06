import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CS 121 Book class
 * 
 * The Book class is the base class for this project. It creates the book object
 * and gives the books attributes.
 * 
 * @author Gavin Wale
 */

public class Book implements BookInterface {

	// Attributes of Book
	private String title;
	private String author;
	private String genre;
	private String filename;

	// Book constructor
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.genre = null; // Use setGenre
		this.filename = null; // Use setFilename
	}

// Getters and Setters for Book object

	/**
	 * Method to extract title of book object
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method to set title of book object
	 * 
	 * @param String title
	 * @return null
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Method to extract author of book object
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Method to set title of book object
	 * 
	 * @param String author
	 * @return null
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Method to extract genre of book object
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Method to set title of book object
	 * 
	 * @param String genre
	 * @return null
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Method to extract filename of book object
	 * 
	 * @return filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Method to set filename of book object
	 * 
	 * @param String filename
	 * @return null
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Method to check if the chosen file exists
	 * 
	 * 
	 * @return boolean
	 */
	public boolean isValid() {
		File file = new File(filename); // Making a file to see if it exists
		if (file.exists() && title != null && author != null && genre != null && filename != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to display text of a text file
	 * 
	 * @return text
	 */
	public String getText() {

		File file = new File(filename); // Making a file name to scan and print
		try {

			Scanner fileScan = new Scanner(file); // New Scanner

			while (fileScan.hasNextLine()) { // Loops until fileScan runs out of lines
				String line = fileScan.nextLine();
				System.out.println(line); // Prints the line to the console
			}
			fileScan.close(); // CLOSES THE SCANNER
		} catch (FileNotFoundException e) {
			System.out.println("File could not be opened"); // Catch statement

		}
		return null;

	}

	/**
	 * Method to display a book by attributes
	 * 
	 * @return Title, Author, Genre, Filename
	 */
	public String toString() {

		String titleString = ("Title: " + title + "\t");
		String authorString = ("Author: " + author + "\t");
		String genreString = ("Genre: " + genre + "\t");
		String filenameString = ("Filename: " + filename + "\t");

		return titleString + authorString + genreString + filenameString;
	}

}
