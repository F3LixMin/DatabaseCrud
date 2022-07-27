package sg.edu.rp.c346.id21008740.demodatabasecrud;
import java.io.Serializable;
public class Songps implements Serializable {
    private 	int id;
    private 	String title;
    private String singers;
    private int year;
    private  int stars;
    private Object Songps;



    public Songps( int id, String title, String singers, int year, int stars  ) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }
    public int getId() { return id; }
    public String getTitle() {return  title ;}
    public String getSingers() {return  singers; }
    public int getYear() {return  year; }
    public int getStars() { return  stars; }

    public void setTitle(String title ){
        this.title= title;

    } public void setSingers(String singers ) {
        this.singers = singers;
    }
    public void setYear(Integer year ) {
        this.year = year;
    }
    public void setStars(Integer stars ) {
        this.stars = stars;
    }
    @Override
    public String toString() {
        return "ID" + id + "\n " + title + "\n" + singers + "\n" + year + "\n" + stars;
    }
    public Songps toStringClass(){ return(sg.edu.rp.c346.id21008740.demodatabasecrud.Songps) Songps;}
}