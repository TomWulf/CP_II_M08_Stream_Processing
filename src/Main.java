import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] scoobies = {"Velma", "Fred", "Shaggy", "Daphne", "Scooby Doo"};
        String[] upperCaseScooby;
        Set<String> scoobyTeamSet = new HashSet<>();
        Map<String, String> scoobyTeamMap = new TreeMap<>();
        ArrayList<String> scoobyTeamList = new ArrayList<>();
        String scoobyTeamStr = "";
        System.out.println("Hello Stream Processing!\n");

        // Create a Stream from an existing Array
        // can use an array literal directly also

        Stream<String> scoobyTeam = Arrays.stream(scoobies);

        // Join the elements into a single string with comma space delimiters
        scoobyTeamStr = scoobyTeam.collect(Collectors.joining(", "));

        System.out.println(scoobyTeamStr + "\n");

        // Because collect is a terminal operation, the Stream is closed
        // so we have to recreate it for the next example
        scoobyTeam = Arrays.stream(scoobies);

        // use a map function to convert all to uppercase and save to a delited String
        scoobyTeamStr = scoobyTeam
                .map(c -> c.toUpperCase())
                .collect(Collectors.joining(", "));

        System.out.println("Here is out string of scoobies: " + scoobyTeamStr + "\n");

        // Now lets do that again but save the results to an Array instead
        // of collecting them to a string
        scoobyTeam = Arrays.stream(scoobies);

        upperCaseScooby = scoobyTeam
                .map(c -> c.toUpperCase())
                .toArray(String[]::new);

        System.out.println("Here is our array of scoobies:");
        for (String s : upperCaseScooby)
            System.out.println(s);


        System.out.println("\n\nSet:");

        // now let's do a set
        // recreate the Stream...
        scoobyTeam = Arrays.stream(scoobies);

        // use a map function to convert all to lowercase and save to a Set
        scoobyTeamSet = (HashSet<String>) scoobyTeam
                .map(c -> c.toLowerCase())
                .collect(Collectors.toSet());

        scoobyTeamSet.forEach(s -> System.out.println(s));

        // now let's do a list
        System.out.println("\n\n List:");

        // recreate the Stream...
        scoobyTeam = Arrays.stream(scoobies);

        // use a map function to convert to Capital case and save to a List
        scoobyTeamList = (ArrayList<String>) scoobyTeam
                .map(c -> c.substring(0, 1).toUpperCase() + c.substring(1).toLowerCase())
                .sorted()
                .collect(Collectors.toList());

        scoobyTeamList.forEach(s -> System.out.println(s));

        // Now output a Map where the first letter of the name is the key
        System.out.println("\n\n Map:");

        // recreate the Stream...
        scoobyTeam = Arrays.stream(scoobies);

        // use a map function to convert to Capital case and save to a List
        // key is the first two characters of the name to be unique
//        scoobyTeamMap = (TreeMap<String, String>) scoobyTeam
//                .map(c -> c.substring(0,1).toUpperCase() + c.substring(1))
//                .collect(Collectors.toMap(c.substring(0,2), c.));

 //       System.out.println(scoobyTeamMap);

    }
}
