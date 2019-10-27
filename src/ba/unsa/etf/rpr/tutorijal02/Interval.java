package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    double poc, kraj;
    boolean pp, kp;

    Interval(double poc, double kraj, boolean pp, boolean kp) {
        if (poc > kraj) throw new IllegalArgumentException();
        this.poc = poc;
        this.kraj = kraj;
        this.pp = pp;
        this.kp = kp;
    }

    Interval() {
        this.poc = 0;
        this.kraj = 0;
        this.pp = false;
        this.kp = false;
    }

    public boolean isNull() {
        return (this.poc == 0 && this.kraj == 0 && !this.pp && !this.kp);
    }

    public boolean isIn(double tacka) {
        return (tacka > this.poc && tacka < this.kraj || (tacka==this.poc && this.pp) ||(tacka==this.kraj && this.kp));
    }

    public Interval intersect(Interval interval) {
        if (interval.poc > this.poc) {
            this.poc = interval.poc;
            this.pp = interval.pp;
        }
        if (interval.kraj < this.kraj) {
            this.kraj = interval.kraj;
            this.kp = interval.kp;
        }
        return new Interval(this.poc, this.kraj, this.pp, this.kp);
    }

    public static Interval intersect(Interval int1, Interval int2)
    {
        double np=int1.poc, nkp=int1.kraj;
        boolean b1=int1.pp,b2=int1.kp;
        if(int2.poc>np)
        {
            np=int2.poc;
            b1=int2.pp;
        }
        if(int2.kraj<nkp)
        {
            nkp=int2.kraj;
            b2=int2.kp;
        }
        return new Interval(np,nkp,b1,b2);
    }
    @Override
    public String toString()
    {
        if(isNull()) return "()";
         String rez="(";
         if(this.pp) rez="[";
         rez+=this.poc+","+this.kraj;
         if(this.kp) rez+="]";
         else rez+=")";
         return rez;
    }
    public boolean equals(Object o)
    {
        if(o!=null && getClass()==o.getClass())
        {
            Interval i=(Interval) o;
            return (this.poc==i.poc && this.kraj==i.kraj && this.pp==i.pp && this.kp==i.kp);
        }
        return false;
    }

}
