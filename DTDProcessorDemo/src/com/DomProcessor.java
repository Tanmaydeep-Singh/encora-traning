package com;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class DomProcessor {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		
		dbf.setValidating(true);
		dbf.setIgnoringElementContentWhitespace(true);
		
		DocumentBuilder db=dbf.newDocumentBuilder();
				
		Document doc=db.parse("books.xml");		
		Element rootElement= doc.getDocumentElement();	
		
		
		System.out.println(rootElement.getNodeName());
		System.out.println(rootElement.getChildNodes().getLength());
		
		System.out.println(rootElement.getFirstChild().getNodeName());//book
		System.out.println(rootElement.getFirstChild().getFirstChild().getNodeType());//name
		System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild().getNodeType());//name
		
		for(int i=0;i<rootElement.getChildNodes().getLength();i++) {
			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
				System.out.println
		(rootElement.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue());
			}
		}
		
		
		getNodeChilds(rootElement);
		
		
		
		
		
	}
	
	
//	Recursion

	public static void getNodeChilds(Node node)
	{
		
		
		Optional.ofNullable(node)
		.filter( n -> n.hasChildNodes())
		.ifPresentOrElse( n -> { 
			
			
			
			for(int i = 0 ; i < n.getChildNodes().getLength(); i++)
			{
				getNodeChilds(n.getChildNodes().item(i));
			}
			  }, ()  -> {
			System.out.println(node.getNodeValue());
		});
	
	}
	
}