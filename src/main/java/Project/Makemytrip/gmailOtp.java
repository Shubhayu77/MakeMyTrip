package Project.Makemytrip;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;

import org.openqa.selenium.WebDriver;

public class gmailOtp {
	
  public static String messageOtp() throws Exception {

  String host="imap.gmail.com";
  String username = "testng.pur.1@gmail.com";
  String passwoed = "testingpurpose1";

  Properties properties = System.getProperties();
  Properties props = new Properties();
  props.put("mail.store.protocol", "imaps");
  props.put("imap.gmail.com", host);
  props.put("mail.imap.port", "993");
  props.put("mail.imap.starttls.enable", "true");

  Session session = Session.getDefaultInstance(properties);

  Store store = session.getStore("imaps");
  store.connect(host, username, passwoed);

  Folder folder = store.getFolder("Inbox");
  String otpmessage = "";
  folder.open(Folder.READ_WRITE);
  Message[] msg = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
  for (int i = 0; i < msg.length; i++) 
  {
	  if(msg[i].getSubject().equalsIgnoreCase("OTP to login to your MakeMyTrip account"))
	  {
	  msg[i].setFlag(Flags.Flag.SEEN, true); 
	  String result = "";
	    if (msg[i].isMimeType("text/plain")) 
	    {
	        result = msg[i].getContent().toString();
	    } 
	    else if (msg[i].isMimeType("multipart/*")) 
	    {
	        MimeMultipart mimeMultipart = (MimeMultipart) msg[i].getContent();
	        int count = mimeMultipart.getCount();
		    for (int j = 0; j < count; j++) 
		    {
		        BodyPart bodyPart = mimeMultipart.getBodyPart(j);
		        if (bodyPart.isMimeType("text/plain")) 
		        {
		            result = result + "\n" + bodyPart.getContent();
		            break; // without break same text appears twice in my tests
		        } 
		        else if (bodyPart.isMimeType("text/html")) 
		        {
		            String html = (String) bodyPart.getContent();
		            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
		        } 
		        else if (bodyPart.getContent() instanceof MimeMultipart){
		            result = result + (MimeMultipart)bodyPart.getContent();
		        }
		    }
	        
	    }
	  otpmessage = result.split("is")[1].split("to")[0].trim();
	  }
  }
  
  
  
folder.close(true);
store.close();
//System.out.println(otpmessage);
return otpmessage;
  }
  
}
  
 