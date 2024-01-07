public class LeetCodeAddTwoSumVariation {

    public static void main(String[] argv) {
        System.out.println("7:00->"+getSongDurationInSec("7:00"));
        System.out.println("3:41->"+getSongDurationInSec("3:41"));
        System.out.println("3:59->"+getSongDurationInSec("3:59"));
        System.out.println("5:03->"+getSongDurationInSec("5:03"));
        System.out.println("1:57->"+getSongDurationInSec("1:57"));

        String[][] songTimes1 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"}, {"Hot Dog", "3:19"},
                {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
                {"Black Dog", "4:55"}
        };
        String[][] songTimes2 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"}, {"Black Dog", "4:55"},
                {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
                {"The Ocean", "4:31"}, {"Hot Dog", "3:19"}
        };
        String[][] songTimes3 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Hey Hey What Can I Do", "4:00"}, {"Poor Tom", "3:00"},
                {"Black Dog", "4:55"}
        };
        String[][] songTimes4 = {
                {"Hey Hey What Can I Do", "4:00"}, {"Rock and Roll", "3:41"},
                {"Communication Breakdown", "2:29"}, {"Going to California", "3:30"},
                {"Black Mountain Side", "2:00"}, {"Black Dog", "4:55"}
        };
        String[][] songTimes5 = {
                {"Hey Hey What Can I Do", "4:00"},{"Celebration Day", "3:30"},{"Black Mountain Side", "2:00"}, {"Going to California", "3:30"},{"Black Dog", "4:55"}
        };
        String[][] songTimes6 = {
                {"Rock and Roll", "3:41"}, {"If I lived here", "3:59"},
                {"Day and night", "5:03"}, {"Tempo song", "1:57"}
        };
        final String[] songs1 = findSongs(songTimes1, "7:00");
        final String[] songs2 = findSongs(songTimes2, "7:00");
        final String[] songs3 = findSongs(songTimes3, "7:00");
        final String[] songs4 = findSongs(songTimes4, "7:00");
        final String[] songs5 = findSongs(songTimes5, "7:00");
        final String[] songs6 = findSongs(songTimes6, "7:00");
        System.out.println();
    }

    static int getSongDurationInSec(String strDuration) {
        final String[] split = strDuration.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    /*
     cases:
     0 {"Rock and Roll", "3:41"},
     1 {"If I lived here", "3:59"},
     2 {"Day and night", "5:03"},
     3 {"Tempo song", "1:57"}

map
i0:[221,0]
i1[239,1]
i2[303,2]
i3 found

     map
     0 iteration, i=0
     420 - 221 = 199
     map contains 199? nope, then put 221, 0

     1 iteration, i 1
     420 - 239 = 181
     map contains 181? nope, then put 239, 1

     2 iteration, i 2
     420 - 303 = 117
     map contains 117? nope, then put 303, 2

     3 iteration, i 3
     420 - 117 = 303
     map contains 303? yes,

     */
  
    static String[] findSongs(String[][] songs, String strTargetDuration) {
        final int targetSongDuration = getSongDurationInSec(strTargetDuration);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < songs.length; i++) {
            final String[] song = songs[i];
            String songTitle = song[0];
            int songDuration = getSongDurationInSec(song[1]);
            final int songDiff = targetSongDuration - songDuration;
            if (map.containsKey(songDiff)) {
            return new String[]{songs[map.get(songDiff)][0], songTitle};
            } else {
                map.put(songDuration, i);
            }
        }
        return new String[]{"", ""};
    }
}
