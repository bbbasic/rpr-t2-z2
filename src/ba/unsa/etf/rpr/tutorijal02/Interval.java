package ba.unsa.etf.rpr.tutorijal02;

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
        return x1 == 0 && x2 == 0 && !prva_tacka && !druga_tacka;
    }

    public boolean isIn(double tacka) {
        return tacka >= x1 && tacka < x2;
    }

    public Interval intersect(Interval i1) {

        if(i1.x1 < x1 && i1.x2 < x2) return  new Interval(x1, i1.x2, prva_tacka,i1.druga_tacka);
        else if(i1.x1 < x1 && i1.x2 > x2)  return  new Interval(x1, x2, prva_tacka, druga_tacka);
        else if (i1.x1 > x1 && i1.x2 < x2)  return  new Interval(i1.x1,i1.x2, i1.prva_tacka, i1.druga_tacka);
        else  return  new Interval(i1.x1, x2, i1.prva_tacka, druga_tacka);
    }

    public static Interval intersect(Interval i1, Interval i2) {
        if(i1.x1 < i2.x1 && i1.x2 < i2.x2) return  new Interval(i2.x1, i1.x2, i2.prva_tacka, i1.druga_tacka);
        else if(i1.x1 < i2.x1 && i1.x2 > i2.x2)  return  new Interval(i2.x1, i2.x2, i2.prva_tacka, i2.druga_tacka);
        else if (i1.x1 > i2.x1 && i1.x2 < i2.x2)  return  new Interval(i1.x1,i1.x2, i1.prva_tacka, i1.druga_tacka);
        else  return  new Interval(i1.x1, i2.x2, i1.prva_tacka, i2.druga_tacka);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(!(o instanceof Interval))
            return false;
        Interval i1 = (Interval) o;
        return x1 == i1.x1 && x2 == i1.x2 && prva_tacka == i1.prva_tacka && druga_tacka == i1.druga_tacka;

    }

    @Override
    public String toString() {
        if(x1 == 0  && x2 == 0) return  "()";
        String s = "";

        if(prva_tacka) s = s + "[";
        else
            s = s + "(";

        s = s + x1 + "," + x2;

        if(druga_tacka) s = s + "]";
        else
            s = s + ")";
        return  s;
    }
}
