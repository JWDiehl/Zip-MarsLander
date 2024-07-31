public class DescentEvent {
    int Seconds = 0;
    int Velocity = 0;
    int Fuel = 0;
    int Altitude = 0;
    int Status = 0;

//    private int altitude;
//    private int velocity;
//    private int fuel;
//    private int time;

    public DescentEvent(int t, int sp, int f, int h, int st) {
        this.Seconds = t * 10;
        this.Velocity = sp;
        this.Fuel = f;
        this.Altitude = h;
        this.Status = st;
    }

    public int getAltitude() {
        return this.Altitude;
    }

    public int getVelocity() {
        return this.Velocity;
    }

//    public int getFuel() {
//        return fuel;
//    }

//    public int getVelocity() {
//        return this.Velocity;
//    }
//
//    public int getAltitude() {
//        return this.Altitude;
//    }

    public int getStatus() {
        return this.Status; }

    @Override
    public String toString() {
//        return time + "\t" + velocity + "\t\t" + fuel + "\t\t" + altitude + "\t\t";
        String s = this.Seconds +"\t\t" + this.Velocity + " \t\t" + this.Fuel + " \t\t" + this.Altitude;
        return s;
    }
}
