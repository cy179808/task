import java.util.*;
abstract class Publication implements Comparable{
    private List<String> authorlist;
    private String title;
    private int year;
    private String pages;

    public Publication() {
    }

    public Publication(List<String> authorlist, String title, int year, String pages) {
        this.authorlist = authorlist;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public abstract int compareTo(Publication publication);
    public List<String> getAuthor() {
        return authorlist;
    }

    public void setAuthor(List<String> author) {
        this.authorlist=author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPages() {
        return pages;
    }

    public void setPages(String page) {
        this.pages = page;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  authorlist +"("+year+")"
                 +title;
    }
}
