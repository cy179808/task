import java.util.List;
class ConferencePaper extends Publication{
    private String booktiltle;

    public ConferencePaper(String booktiltle) {
        this.booktiltle = booktiltle;
    }

    public ConferencePaper(List<String> authorlist, String title, int year, String pages, String booktiltle) {
        super(authorlist, title, year, pages);
        this.booktiltle = booktiltle;
    }

    public String getBooktiltle() {
        return booktiltle;
    }

    public void setBooktiltle(String booktiltle) {
        this.booktiltle = booktiltle;
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
                +booktiltle
                +"("+getPages()+")";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
