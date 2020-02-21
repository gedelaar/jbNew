package xml;

//Client.java
public class Client{
  private BaseFileParser baseFileParser;
  public Client(BaseFileParser baseFileParser){
    this.baseFileParser=baseFileParser;
  }  
  public void parseFile(){
    baseFileParser.parseFile();
  } 
  public static void main(String args[]){
    //Lets say the client needs to parse an XML file
    //The file type(XML/CSV) can also be taken as 
    //input from command line args[]
    Client client=new Client(new XMLFileParser());
    client.parseFile();
  }
}