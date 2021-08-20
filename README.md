# Lucene Web Search

Web search engine using Apache Lucene and Java

This package contain a Crawler that index on Lucene a website via HTTP Crawling and a Searcher that query the index to find a result.

Thank you @tchanda90 which the initial code was taken from https://github.com/tchanda90/lucene-web-crawler

# Build

```
mvn package
```

# Run

```
java -jar target\lucene-web-search-1.0-jar-with-dependencies.jar [seed URL] [crawl depth] [path to index folder] [query]
```

ex:

```
java -jar target\lucene-web-search-1.0-jar-with-dependencies.jar https://www.example.com 1 .\data World
```

# Crawling

```java
String seedUrl = "https://www.example.com";
int crawlDepth = 1;
String indexPath = ".\index";

// create a crawler object and call the startCrawl method by passing in
// the seed url, crawl depth, and index path
Crawler crawler = new Crawler();
crawler.startCrawl(seedUrl, crawlDepth, indexPath);
```

# Searching

```java
String indexPath = ".\index";
String query = "Some Words";

TopDocs results = SearchFiles.search(indexPath, query);
ScoreDoc[] hits = results.scoreDocs;
int numTotalHits = Math.toIntExact(results.totalHits);

// Iterate over the hits array
for (int i = 0; i < numTotalHits; i++) {
	Document doc = searcher.doc(hits[i].doc);

	String title = doc.get("title");
	String url = doc.get("url");
	double score = 	hits[i].score;

	if (url != null) {
		// prints the document rank and title 1. Manchester United.html
		System.out.println((i+1) + ". " + title);

		// prints the path of the document
		System.out.println("   Url: " + url);

		// prints document score
		System.out.println("   Score: " + score + "\n");
		
	} else {
		System.out.println((i+1) + ". " + "Document does not exist");
	}
}
```