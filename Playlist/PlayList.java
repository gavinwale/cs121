import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * CS 121 Project 1: PlayList
 * 
 * The PlayList class utilizes a scanner, for loops, and strings to analyze a playlist
 * based on 3 input songs.
 * 
 * @author Gavin Wale
 */

public class PlayList {

	public static void main(String[] args) {
		String BAR_DIVIDER = "========================================================================================";

		Scanner scan = new Scanner(System.in); // New scanner object

		System.out.println("Enter title: "); // Title prompt
		String title = scan.nextLine();

		System.out.println("Enter artist: "); // Artist prompt
		String artist = scan.nextLine();

		System.out.println("Enter album: "); // Album prompt
		String album = scan.nextLine();

		System.out.println("Enter play time (mm:ss): "); // Play time prompt
		String playtimeString = scan.nextLine();

		int colonIndex = playtimeString.indexOf(':'); // Getting index of ':'

		String playtimeMins = playtimeString.substring(0, colonIndex); // Creating minute string
		String playtimeSecs = playtimeString.substring(colonIndex + 1, playtimeString.length()); // Creating second
																									// string

		int playtimeMinsInt = Integer.parseInt(playtimeMins); // Making a minutes integer
		int playtimeSecsInt = Integer.parseInt(playtimeSecs); // Making a seconds integer

		int minsToSecs = playtimeMinsInt * 60; // Converting minutes to seconds
		int playtime = minsToSecs + playtimeSecsInt; // Adding seconds and seconds

		Song song1 = new Song(title, artist, album, playtime); // New song object
		// System.out.println(song1.toString()); // Print song object

		System.out.println("Enter title: "); // Title prompt
		title = scan.nextLine();

		System.out.println("Enter artist: "); // Artist prompt
		artist = scan.nextLine();

		System.out.println("Enter album: "); // Album prompt
		album = scan.nextLine();

		System.out.println("Enter play time (mm:ss): "); // Play time prompt
		playtimeString = scan.nextLine();

		colonIndex = playtimeString.indexOf(':'); // Getting index of ':'

		playtimeMins = playtimeString.substring(0, colonIndex); // Creating minute string
		playtimeSecs = playtimeString.substring(colonIndex + 1, playtimeString.length()); // Creating second string

		playtimeMinsInt = Integer.parseInt(playtimeMins); // Making a minutes integer
		playtimeSecsInt = Integer.parseInt(playtimeSecs); // Making a seconds integer

		minsToSecs = playtimeMinsInt * 60; // Converting minutes to seconds
		playtime = minsToSecs + playtimeSecsInt; // Adding seconds and seconds

		Song song2 = new Song(title, artist, album, playtime); // New song object
		// System.out.println(song2.toString()); // Print song object

		System.out.println("Enter title: "); // Title prompt
		title = scan.nextLine();

		System.out.println("Enter artist: "); // Artist prompt
		artist = scan.nextLine();

		System.out.println("Enter album: "); // Album prompt
		album = scan.nextLine();

		System.out.println("Enter play time (mm:ss): "); // Play time prompt
		playtimeString = scan.nextLine();

		colonIndex = playtimeString.indexOf(':'); // Getting index of ':'

		playtimeMins = playtimeString.substring(0, colonIndex); // Creating minute string
		playtimeSecs = playtimeString.substring(colonIndex + 1, playtimeString.length()); // Creating second string

		playtimeMinsInt = Integer.parseInt(playtimeMins); // Making a minutes integer
		playtimeSecsInt = Integer.parseInt(playtimeSecs); // Making a seconds integer

		minsToSecs = playtimeMinsInt * 60; // Converting minutes to seconds
		playtime = minsToSecs + playtimeSecsInt; // Adding seconds and seconds

		Song song3 = new Song(title, artist, album, playtime); // New song object
		// System.out.println(song3.toString()); // Print song object

		double averagePlayTime = (double)((song1.getPlayTime() + song2.getPlayTime() + song3.getPlayTime()) / 3); // Average
																										// calculator
		DecimalFormat df = new DecimalFormat("#.00"); // Decimal formatting to always have .00
		System.out.println("Average play time: " + df.format(averagePlayTime)); // Print average play time with decimal
																				// format

		int songOneSeconds = song1.getPlayTime();
		int songTwoSeconds = song2.getPlayTime();
		int songThreeSeconds = song3.getPlayTime();

		if (Math.abs(songOneSeconds - 240) <= Math.abs(songTwoSeconds - 240)
				&& Math.abs(songOneSeconds - 240) <= Math.abs(songThreeSeconds - 240)) {
			System.out.println("Song with play time closest to 240 secs is: " + song1.getTitle());

		} else if (Math.abs(songTwoSeconds - 240) <= Math.abs(songOneSeconds - 240)
				&& Math.abs(songTwoSeconds - 240) <= Math.abs(songThreeSeconds - 240)) {
			System.out.println("Song with play time closest to 240 secs is: " + song2.getTitle());

		} else if (Math.abs(songThreeSeconds - 240) <= Math.abs(songOneSeconds - 240)
				&& Math.abs(songThreeSeconds - 240) <= Math.abs(songTwoSeconds - 240)) {
			System.out.println("Song with play time closest to 240 secs is: " + song3.getTitle());
		}

		// PRINTING ORGANIZED PLAYLIST

		System.out.println(BAR_DIVIDER);
		System.out.println("Title                          Artist               Album                           Time");
		System.out.println(BAR_DIVIDER);
		// SHORTEST SONG
		if (songOneSeconds <= songTwoSeconds && songOneSeconds <= songThreeSeconds) {
			System.out.println(song1);
		} else if (songTwoSeconds <= songThreeSeconds && songTwoSeconds <= songOneSeconds)
			System.out.println(song2);
		else {
			System.out.println(song3);
		}

		// MEDIUM SONG
		if (songOneSeconds < songTwoSeconds && songTwoSeconds < songThreeSeconds
				|| (songThreeSeconds < songTwoSeconds && songTwoSeconds < songOneSeconds)) {
			System.out.println(song2);
		} else if ((songTwoSeconds < songOneSeconds && songOneSeconds < songThreeSeconds)
				|| (songThreeSeconds < songOneSeconds && songOneSeconds < songTwoSeconds)) {
			System.out.println(song1);
		} else {
			System.out.println(song3);
		}

		// LONGEST SONG
		if (songOneSeconds >= songTwoSeconds && songOneSeconds >= songThreeSeconds) {
			System.out.println(song1);
		} else if (songTwoSeconds >= songThreeSeconds && songTwoSeconds >= songOneSeconds)
			System.out.println(song2);
		else {
			System.out.println(song3);
			// System.out.println(song1);
			// System.out.println(song2);
			// System.out.println(song3);
			System.out.println(BAR_DIVIDER);

			scan.close();

		}

	}
}
