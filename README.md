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
