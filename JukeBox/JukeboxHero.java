import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CS 121 Project 2: JukeboxHero
 *
 * The JukeboxHero program reads a user input file and prints,
 * analyzes, and searches for it's contents.
 *
 * @author Gavin Wale
 */

public class JukeboxHero {

	public static void main(String[] args) {

		System.out.println("*****************************");
		System.out.println("*       Program Menu        *");
		System.out.println("*****************************");
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyse catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit");
		System.out.println();

		Scanner scan = new Scanner(System.in);
		String userCommand = "";

		System.out.print("Please enter a command (press 'm' for Menu): ");

		ArrayList<Song> songList = new ArrayList<Song>();

		while (!userCommand.toLowerCase().equals("q")) {
			// While userCommand does not equal "q", this switch executes

			userCommand = scan.nextLine();

			switch (userCommand.toLowerCase()) {

			case "l":

				System.out.println("Load Catalog...");
				System.out.print("Please enter filename: ");
				String fileName = scan.nextLine();
				File file = new File(fileName);

				try {

					Scanner fileScan = new Scanner(file);

					while (fileScan.hasNextLine()) {
						String line = fileScan.nextLine();

						Scanner lineScan = new Scanner(line);
						lineScan.useDelimiter(",");

						String artist = lineScan.next();
						String album = lineScan.next();
						String title = lineScan.next();
						int playtime = lineScan.nextInt();

						Song songObject = new Song(artist, album, title, playtime);
						songObject.setArtist(artist);
						songObject.setAlbum(album);
						songObject.setTitle(title);
						songObject.setPlayTime(playtime);

						songList.add(songObject);

					}
					System.out.println("Successfully loaded " + songList.size() + " songs!");
					fileScan.close();
				}

				catch (FileNotFoundException e) {
					System.out.println("Unable to open file: " + fileName);
				}

				System.out.print("Please enter a command (press 'm' for Menu): ");
				break;

			case "s":
				// search the catalog

				System.out.println("Search Catalog...");
				System.out.print("Please enter the search query: ");
				String searchQuery = scan.nextLine();
				int searchMatches = 0;

				for (Song songObject : songList) {

					String titleChecker = songObject.getTitle();

					if (titleChecker.toLowerCase().contains(searchQuery.toLowerCase())) {

						searchMatches++;

					}

				}

				System.out.println("Found " + searchMatches + " matches");
				System.out.println("---------------------------------");

				for (Song songObject : songList) {

					String titleChecker = songObject.getTitle();

					if (titleChecker.toLowerCase().contains(searchQuery.toLowerCase())) {
						System.out.println(songObject);
					}
				}

				System.out.print("Please enter a command (press 'm' for Menu): ");
				break;

			case "a":
				// analyse the catalog

				System.out.println("Catalog Analysis...");

				System.out.println("Number of Artists: ");
				System.out.println("Number of Albums: ");
				System.out.println("Number of Songs: ");

				int playTimeTotal = 0;
				for (Song songObject : songList) {
					playTimeTotal = playTimeTotal + songObject.getPlayTime();
				}

				System.out.println("Catalog Playtime: " + playTimeTotal);

				System.out.print("Please enter a command (press 'm' for Menu): ");
				break;

			case "p":
				// print the catalog

				System.out.println("Song list contains " + songList.size() + " songs...");
				System.out.println("---------------------------------");

				for (Song songObject : songList) {
					System.out.println(songObject);
				}

				System.out.print("Please enter a command (press 'm' for Menu): ");
				break;

			case "m": // Displays the menu

				System.out.println("*****************************");
				System.out.println("*       Program Menu        *");
				System.out.println("*****************************");
				System.out.println("(L)oad catalog");
				System.out.println("(S)earch catalog");
				System.out.println("(A)nalyse catalog");
				System.out.println("(P)rint catalog");
				System.out.println("(Q)uit");
				System.out.println();
				System.out.print("Please enter a command (press 'm' for Menu): ");
				break;

			case "q":
				System.out.println("Goodbye!");
				break;

			default:
				System.out.println("Invalid selection!");
				System.out.print("Please enter a command (press 'm' for Menu): ");

			}

		}
		scan.close();
	}

}
