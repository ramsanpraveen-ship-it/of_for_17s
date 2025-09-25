Text Analysis Program v2

This is a Kotlin/Java developer test task solution. The program analyzes the text file Moby Dick from the provided URL and produces word statistics after filtering out stopwords (prepositions, pronouns, conjunctions, articles, and modal verbs).

📌 Features

Total Word Count (after filtering stopwords).

Top 5 Most Frequent Words with their counts.

Top 50 Unique Words in alphabetical order.

Case Insensitive Processing (e.g., Hello, hello, HELLO are treated the same).

Exclusions Applied:

Prepositions (e.g., in, on, at)

Pronouns (e.g., he, she, it)

Conjunctions (e.g., and, or, but)

Articles (e.g., the, a, an)

Modal verbs (is, was, etc.)

Possessive postfix ('s)

⚙️ How It Works

Reads the text directly from the URL:
moby.txt

Normalizes the text to lowercase.

Splits into words using regex (\\W+) → only letters are considered.

Filters out stopwords and possessive postfixes.

Counts word frequencies using a HashMap.

Extracts:

Total count

Top 5 most frequent words

Alphabetically sorted list of unique words (top 50)

Prints processing time and suggests a repo name in the required format:

<MostFrequentWord>_<FifthFrequentWord>_<ProcessingTime>s

🚀 How to Run
Compile
javac TextAnalysis.java

Run
java TextAnalysis

📊 Example Output
=== TEXT ANALYSIS RESULTS ===
Total words (after filtering): 185739

Top 5 Words:
of -> 6467
that -> 3036
i -> 2108
s -> 1735
for -> 1594

Top 50 Unique Words (alphabetical):
000
1
10
100
...
1671

Processing Time: 17.05 seconds

Suggested Repo Name: of_for_17s

⏱️ Time Spent

I spent approximately 2 hours on this task, including:

Implementation (coding + testing)

Running analysis on the provided text

Preparing the README
