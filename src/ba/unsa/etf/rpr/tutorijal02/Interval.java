package ba.unsa.etf.rpr.tutorijal02;
//Interval(1.1, 2.5, true, false);
public class Interval {
    private double x1, x2;
    private boolean prva_tacka, druga_tacka;
    public Interval(double x1, double x2, boolean prva_tacka, boolean druga_tacka) throws  IllegalArgumentException{
        if(x1 > x2) throw new IllegalArgumentException("Pocetna tacka veca od krajnje");
        this.prva_tacka = prva_tacka;
        this.druga_tacka = druga_tacka;
        this.x1 = x1;
        this.x2 = x2;
    }
    public Interval() {
        prva_tacka = false;
        druga_tacka = false;
        x1 = 0;
        x2 = 0;
    }
    public boolean isNull() {
        return x1 == 0 && x2 == 0 && prva_tacka && druga_tacka;
    }

    public boolean isIn(double tacka) {
        return tacka >= x1 && tacka <= x2;
    }
    //2
    public Interval intersect(Interval i1) {

        if(i1.x1 < x1 && i1.x2 < x2) return  new Interval(i1.x1, i1.x2, false,false);
        else if(i1.x1 < x1 && i1.x2 > x2)  return  new Interval(i1.x1, x2, false, false);
        else if (i1.x1 > x1 && i1.x2 < x2)  return  new Interval(x1,i1.x2, false, false);
        else  return  new Interval(i1.x1, x2, false, false);
    }

    public static Interval intersect(Interval i1, Interval i2) {
        if(i1.x1 < i2.x1 && i1.x2 < i2.x2) return  new Interval(i1.x1, i1.x2, false,false);
        else if(i1.x1 < i2.x1 && i1.x2 > i2.x2)  return  new Interval(i1.x1, i2.x2, false, false);
        else if (i1.x1 > i2.x1 && i1.x2 < i2.x2)  return  new Interval(i2.x1,i1.x2, false, false);
        else  return  new Interval(i1.x1, i2.x2, false, false);
    }




}
