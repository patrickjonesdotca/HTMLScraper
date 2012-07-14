import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.*;

public class HTMLScraper {
  
  public Document document;
  
  public void getEndPoint(String url) {
    try{
      document = Jsoup.connect(url).get();
    } catch(Exception e) {
      System.out.println("Connection Error.");
    }
  }
  
  public org.jsoup.select.Elements getSelection(String selection) {
    return document.select(selection);
  }
  
  public String[] nodesTextArray(org.jsoup.select.Elements set) {
    String[] ret_val = new String[set.size()];
    int index = 0;
    Iterator iter = set.iterator();
    while(iter.hasNext()) {
      org.jsoup.nodes.Element el = (org.jsoup.nodes.Element)iter.next();
      ret_val[index] = el.text();
      index += 1;
    }
    return ret_val;
  }
  
  public String[] nodesAttributeArray(org.jsoup.select.Elements set, String attribute) {
    String[] ret_val = new String[set.size()];
    int index = 0;
    Iterator iter = set.iterator();
    while(iter.hasNext()) {
      org.jsoup.nodes.Element el = (org.jsoup.nodes.Element)iter.next();
      ret_val[index] = el.attr(attribute);
      index += 1;
    }
    return ret_val;
  }
  
  public HashMap<String, String> linksMap(org.jsoup.select.Elements set) {
    HashMap<String, String> _ret = new HashMap<String, String>(set.size());
    Iterator iter = set.iterator();
    while(iter.hasNext()) {
      org.jsoup.nodes.Element el = (org.jsoup.nodes.Element)iter.next();
      _ret.put(el.attr("abs:href"), el.text()); 
    }
    return _ret;
  }

}