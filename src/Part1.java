import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author  Tom Wulf Tom.Wulf@uc.edu
 *
 */
public class Part1
{
    public static void main(String[] args)
    {
        String[] scoobies = {"Velma", "Fred", "Shaggy", "Daphne", "Scooby Doo"};
        String[] upperCaseScooby;
        Set<String> scoobyTeamSet = new HashSet<>();
        Map<String, List<String>> scoobyTeamMap = new TreeMap<>();
        ArrayList<String> scoobyTeamList = new ArrayList<>();
        String scoobyTeamStr = "";
        System.out.println("Hello Stream Processing!\n");

        // Create a Stream from an existing Array
        // can use an array literal directly also

        Stream<String> scoobyTeam = Arrays.stream(scoobies); // or literal: ("Bob", "Carol". "Ted",...)

        // Join the elements into a single string with comma space delimiters
        // Could use tis to create CSV data streams
        scoobyTeamStr = scoobyTeam.collect(Collectors.joining(", "));

        System.out.println(scoobyTeamStr + "\n");

        // Because collect is a terminal operation, the Stream is closed
        // so we have to recreate it for the next example
        scoobyTeam = Arrays.stream(scoobies);

        // use a map function to convert all to uppercase and save to a delited String
        scoobyTeamStr = scoobyTeam
                .map(c -> c.toUpperCase())
                .collect(Collectors.joining(", "));

        System.out.println("Here is out string of Uppercase scoobies: " + scoobyTeamStr + "\n");

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


        // Here is how we defined the Map:

        //          Map<String, List<String>> scoobyTeamMap = new TreeMap<>(); The key retriees a list

        // key is the first Char of name creates a list for each initial letter note that Shaggy and Scooby Doo...
        // are in the same group.  We can fource the key to be 2 chars to make it unique
        scoobyTeamMap = scoobyTeam
                       .collect(Collectors.groupingBy(c -> c.substring(0,1)));

       System.out.println(scoobyTeamMap);

    }
}
