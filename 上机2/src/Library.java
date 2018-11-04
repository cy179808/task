import java.util.*;
import java.io.*;
public class Library{
    public static String filepath="library.bib";
    List<Publication> publications;
    public Library(){
        this.publications=new ArrayList<Publication>();
    };
    void readlibrary ()throws IOException {
            File file=new File(filepath);
            FileReader fileReader=new FileReader(filepath);
            BufferedReader in=new BufferedReader(fileReader);
            String s,title,author,pages,journal,booktitle;
            int articleindex,inproceedingsindex,titleindex,authorindex,yearindex,year,pagesindex,journalindex,booktitleindex,start,end;
            char[] cbuf=new char[(int)file.length()];
            in.read(cbuf);
            in.close();
            fileReader.close();
            s=new String(cbuf);
            int count=0;
            articleindex=s.indexOf("article");
            while(articleindex<=s.lastIndexOf("article")) {
                titleindex = s.indexOf("title", articleindex);
                start = s.indexOf("{", titleindex);
                end = s.indexOf("}", titleindex);
                title = s.substring(start + 1, end);
                //System.out.println(title);

                authorindex = s.indexOf("author", articleindex);
                start = s.indexOf("{", authorindex);
                end = s.indexOf("}", authorindex);
                author = s.substring(start + 1, end);
                //System.out.println(author);
                ArrayList<String> authorlist = new ArrayList<String>();
                int index = end;
                do {
                    end = s.indexOf("and", start + 1);
                    if (end > index) end = index;
                    authorlist.add(s.substring(start + 1, end));
                    start = end + 3;
                } while (end < index);
                //for(String p:authorlist)
                //System.out.println(p);

                pagesindex = s.indexOf("pages", articleindex);
                start = s.indexOf("{", pagesindex);
                end = s.indexOf("}", pagesindex);
                pages = s.substring(start + 1, end);
                //System.out.println(pages);

                yearindex = s.indexOf("year", articleindex);
                start = s.indexOf("{", yearindex);
                end = s.indexOf("}", yearindex);
                String temp = s.substring(start + 1, end);
                year = Integer.parseInt(temp);
                //System.out.println(year);

                journalindex = s.indexOf("journal", articleindex);
                start = s.indexOf("{", journalindex);
                end = s.indexOf("}", journalindex);
                journal = s.substring(start + 1, end);
                //System.out.println(journal);

                Publication p = new Article(authorlist, title, year, pages, journal);
                this.publications.add(count++,p);
                if(articleindex==s.lastIndexOf("article"))break;
                articleindex = s.indexOf("article", journalindex);
            }
            inproceedingsindex=s.indexOf("inproceedings");
            while(inproceedingsindex<=s.lastIndexOf("inproceedings")){
                titleindex = s.indexOf("title",inproceedingsindex);
                start = s.indexOf("{", titleindex);
                end = s.indexOf("}", titleindex);
                title = s.substring(start + 1, end);
                //System.out.println(title);

                authorindex = s.indexOf("author", inproceedingsindex);
                start = s.indexOf("{", authorindex);
                end = s.indexOf("}", authorindex);
                author = s.substring(start + 1, end);
                //System.out.println(author);
                ArrayList<String> authorlist = new ArrayList<String>();
                int index = end;
                do {
                    end = s.indexOf("and", start + 1);
                    if (end > index) end = index;
                    authorlist.add(s.substring(start + 1, end));
                    start = end + 3;
                } while (end < index);


                pagesindex = s.indexOf("pages",inproceedingsindex);
                start = s.indexOf("{", pagesindex);
                end = s.indexOf("}", pagesindex);
                pages = s.substring(start + 1, end);
                //System.out.println(pages);

                yearindex = s.indexOf("year",inproceedingsindex);
                start = s.indexOf("{", yearindex);
                end = s.indexOf("}", yearindex);
                String temp = s.substring(start + 1, end);
                year = Integer.parseInt(temp);
                //System.out.println(year);

                booktitleindex= s.indexOf("booktitle",inproceedingsindex);
                start = s.indexOf("{", booktitleindex);
                end = s.indexOf("}",booktitleindex );
                booktitle= s.substring(start + 1, end);

                Publication p=new ConferencePaper(authorlist,title,year,pages,booktitle);
                this.publications.add(count++,p);
                if(inproceedingsindex==s.lastIndexOf("inproceedings"))break;
                inproceedingsindex=s.indexOf("inproceedings",booktitleindex);
            }


    }
    public static void printout(Publication p){
        System.out.println(p.toString());
    }
    public  static void main(String[] args)throws IOException{
             Library library=new Library();
             library.readlibrary();
             printout(library.publications.get(0));


    }
}
