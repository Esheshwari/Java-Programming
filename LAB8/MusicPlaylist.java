// Lab 2: Music Playlist using LinkedList
// Create a menu-driven program using LinkedList to manage a playlist. The program must allow:
// 1. Adding a song at the beginning or end
// 2. Removing the first or last song
// 3. Replacing a song at a given index
// 4. Displaying the complete playlist
import java.util.*;

public class MusicPlaylist {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Replace 4.Display 0.Exit");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1 -> {
                    System.out.print("1.Beginning 2.End: ");
                    int pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Song name: ");
                    String song = sc.nextLine();
                    if (pos == 1) playlist.addFirst(song);
                    else playlist.addLast(song);
                }
                case 2 -> {
                    System.out.print("1.First 2.Last: ");
                    int pos = sc.nextInt();
                    if (pos == 1 && !playlist.isEmpty()) playlist.removeFirst();
                    else if (pos == 2 && !playlist.isEmpty()) playlist.removeLast();
                }
                case 3 -> {
                    System.out.print("Index & New Song: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    if (idx >= 0 && idx < playlist.size())
                        playlist.set(idx, sc.nextLine());
                }
                case 4 -> playlist.forEach(System.out::println);
                case 0 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
