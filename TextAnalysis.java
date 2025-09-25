import java.io.*;
import java.net.*;
import java.util.*;

public class TextAnalysis {

    // Stop words list: prepositions, pronouns, conjunctions, articles, modal verbs
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
            "a","an","the","in","on","at","by","with","about","against","among",
            "before","between","into","through","during","above","below","to","from",
            "up","down","out","over","under","again","further","then","once",
            "he","she","it","they","them","his","her","my","our","your","their",
            "is","was","are","were","be","been","being",
            "and","or","but","if","because","as","until","while"
    ));

    public static void main(String[] args) {
        long start = System.nanoTime();

        try {
            // Read from the URL
            String urlString = "https://courses.cs.washington.edu/courses/cse390c/22sp/lectures/moby.txt";
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
            br.close();

            // Normalize and tokenize words
            String text = sb.toString().toLowerCase();
            String[] words = text.split("\\W+");

            Map<String, Integer> freq = new HashMap<>();
            int total = 0;

            for (String word : words) {
                if (word.isBlank()) continue;
                if (STOP_WORDS.contains(word)) continue;
                if (word.endsWith("'s")) word = word.substring(0, word.length()-2);

                freq.put(word, freq.getOrDefault(word, 0) + 1);
                total++;
            }

            // Top 5 frequent words
            List<Map.Entry<String,Integer>> top5 = freq.entrySet().stream()
                    .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .limit(5)
                    .toList();

            // Alphabetically sorted unique words (top 50)
            List<String> unique = freq.keySet().stream()
                    .sorted()
                    .limit(50)
                    .toList();

            // Output results
            System.out.println("=== TEXT ANALYSIS RESULTS ===");
            System.out.println("Total words (after filtering): " + total);

            System.out.println("\nTop 5 Words:");
            for (var e : top5) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }

            System.out.println("\nTop 50 Unique Words (alphabetical):");
            unique.forEach(System.out::println);

            // Processing time
            long end = System.nanoTime();
            double seconds = (end - start) / 1_000_000_000.0;
            System.out.printf("\nProcessing Time: %.2f seconds%n", seconds);

            // Repo name hint
            if (top5.size() >= 5) {
                String repoName = top5.get(0).getKey() + "_" + top5.get(4).getKey() + "_" + Math.round(seconds) + "s";
                System.out.println("\nSuggested Repo Name: " + repoName);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
