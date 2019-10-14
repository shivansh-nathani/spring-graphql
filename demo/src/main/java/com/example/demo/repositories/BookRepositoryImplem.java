package com.example.demo.repositories;

import com.example.demo.types.Book;
import com.example.demo.types.BookType;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookRepositoryImplem implements BookRepository{

	

    @Override
    public List<BookType> getBooks()  {
    	 List<BookType> b = new ArrayList<>();
    	String urlString = "http://localhost:8983/solr/gettingstarted/";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	solr.setParser(new XMLResponseParser());
    	SolrQuery query = new SolrQuery();
    	query.set("q", "*:*");
    	
    	try {
			QueryResponse response = solr.query(query);
			
			SolrDocumentList doclist = response.getResults();
		
			for(SolrDocument doc : doclist)
			{
				
				System.out.println( b.add(new BookType((String)doc.getFieldValue("id"),(String)doc.getFieldValue("name"))));
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println("herer");
         return b;
    }
    @Override
    public List<BookType> addBook(BookType bb){
    	String urlString = "http://localhost:8983/solr/gettingstarted/";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	solr.setParser(new XMLResponseParser());
    	
    	SolrInputDocument document = new SolrInputDocument();
    	document.addField("id",bb.getId() );
    	document.addField("name", bb.getName());
    	
    	try {
			solr.add(document);
			solr.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return getBooks();
    }
    public Boolean deleteBook(String id)
    {
    	String urlString = "http://localhost:8983/solr/gettingstarted/";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	solr.setParser(new XMLResponseParser());
    	try {
			solr.deleteById(id);
			return true;
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    public Boolean updateBook(Book book)
    {
    	SolrInputDocument sdoc = new SolrInputDocument();
    	sdoc.addField("id",book.getId());
    	Map<String,Object> fieldModifier = new HashMap<>(1);
    	fieldModifier.put("add",book.getName());
    	sdoc.addField("name", fieldModifier);  // add the map as the field value
    	String urlString = "http://localhost:8983/solr/gettingstarted/";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	solr.setParser(new XMLResponseParser());
    	try {
			solr.add( sdoc );
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;
    	// send it to the solr server
    }
 

}
