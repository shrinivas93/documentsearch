package com.shrinivas.documentsearch.comparator;

import java.util.Comparator;

import com.shrinivas.documentsearch.pojo.Document;

public class TfIdfComparator implements Comparator<Document> {

	@Override
	public int compare(Document document1, Document document2) {
		if (document1.getTfIdf() > document2.getTfIdf()) {
			return -1;
		}
		if (document1.getTfIdf() < document2.getTfIdf()) {
			return 1;
		}
		return 0;
	}
}
