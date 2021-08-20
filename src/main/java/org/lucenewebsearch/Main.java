package org.lucenewebsearch;

import org.apache.lucene.search.TopDocs;

public class Main 
{
    public static void main( String[] args )
    {
    	if (args != null && args.length == 4 && !args[0].equals("") && !args[1].equals("") && !args[2].equals("") && !args[3].equals("")) {
			
			// Get seed url, crawl depth, index path, and query string from cmd line arguments
			String seedUrl = args[0];
			int crawlDepth = Integer.parseInt(args[1]);
			String indexPath = args[2];
			String query = args[3];
			
			// create a crawler object and call the startCrawl method by passing in
			// the seed url, crawl depth, and index path
			Crawler crawler = new Crawler();
			crawler.startCrawl(seedUrl, crawlDepth, indexPath);
			
			//Search and display results
			TopDocs results = SearchFiles.search(indexPath, query, true);
		}
		else {
			System.out.print("Invalid command line arguments. Must be run as follows:\n");
			System.out.print("java -jar lucene-web-search-1.0-jar-with-dependencies.jar [seed URL] [crawl depth] [path to index folder] [query]\n");
			return;
		}
    }
}
