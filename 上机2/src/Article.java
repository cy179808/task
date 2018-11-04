import java.util.*;
class Article extends Publication {
     private String journal;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }


    public Article(List<String> author, String title, int year, String pages, String journal) {
        super(author, title, year, pages);
        this.journal = journal;
    }

    public int compareTo(Publication p){
        if(this.getYear()>p.getYear())
            return 1;
        else if(this.getYear()<p.getYear())
            return -1;
        else return super.getAuthor().get(0).compareTo(p.getAuthor().get(0));
    }
    @Override
    public String toString() {
        return super.toString()
                 + journal
                 +"("+getPages()+")";

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
