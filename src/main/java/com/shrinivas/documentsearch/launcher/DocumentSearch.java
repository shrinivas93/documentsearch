package com.shrinivas.documentsearch.launcher;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shrinivas.documentsearch.comparator.TfIdfComparator;
import com.shrinivas.documentsearch.document.Index;
import com.shrinivas.documentsearch.pojo.Document;
import com.shrinivas.documentsearch.repository.IndexRepository;

@Component
public class DocumentSearch {

	private static final Logger LOGGER = LogManager
			.getLogger(DocumentSearch.class);

	@Autowired
	private IndexRepository indexRepository;

	public void process() throws IOException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter word : ");
			String word = scanner.nextLine().toLowerCase();
			Index index = indexRepository.findOne(word);
			if (index != null) {
				List<Document> documents = index.getDbStatistic()
						.getDocuments();
				documents.sort(new TfIdfComparator());
				int rank = 0;
				for (Document document : documents) {
					System.out.println(++rank + "\t" + document.getPath() + "("
							+ document.getTfIdf() + ")");
				}
			} else {
				System.out.println("No documents found for the word '" + word
						+ "'");
			}
		}
	}
}
