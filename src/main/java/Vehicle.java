public class Vehicle {

    //PER TEST --> SUCCESS AND CRASHED - Start within initializing
    public static final int SUCCESS = 0;
    public static final int CRASHED = 1;

    // Various end-of-game messages and status result codes.
    public static final int DEAD = -3;
    public static final int EMPTYFUEL = -1;
    private static final int FLYING= 1;

    //Constants (K)
    //GRAVITY will always equal 100
    private static final int GRAVITY = 100;
    //MAX BURN Rate = 200
    private static final int MAX_BURN = 200;
    private static final int INITIAL_VELOCITY = 0;
    private static final int SAFE_LANDING_VELOCITY = 2;

    //Vehicle State

    private int fuel;
    private int velocity;
    public int altitude;
    private int burn;
    private int flying;

    public Vehicle(int InitialAltitude) {
        // initialize the altitude AND previous altitude to initialAltitude
        this.altitude = InitialAltitude;
        this.velocity = INITIAL_VELOCITY; //Initial Velocity
        this.fuel = 12000;
        this.burn = 0;
        this.flying = FLYING;
    }

//    int Gravity = 100;
    /* The rate in which the spaceship descents in free fall (in ten seconds) */


//    private static final String EMPTYFUEL = "\nThere is no fuel left. You're floating around like Major Tom.\n\n";
//    private static final String SUCCESS = "\nYou made it! Good job!\n\n";
//    private static final String CRASHED = "\nThe Starship crashed. Good luck getting back home. Elon is pissed.\n\n";
//    private static final String DEAD = "\nCRASH!!\n\tThere were no survivors.\n\n";

    //Constructor
    public Vehicle() {
        this(8000);
    }

    public String checkFinalStatus() {
//        String s = "";
        if (this.altitude <= 0) {
            if (this.velocity > SAFE_LANDING_VELOCITY) {
                this.flying = DEAD;
                return "\nCRASH!!\n\tThere were no survivors.\n\n";
            } else if (this.velocity > 3) {
                this.flying = CRASHED;
                return "\nThe Starship crashed. Good luck getting back home. Elon is pissed.\n\n";
            } else {
                this.flying = SUCCESS;
                return "\nYou made it! Good job!\n\n";
            }
        } else if (this.fuel <= 0) {
            this.flying = EMPTYFUEL;
            return "\nThere is no fuel left. You're floating around like Major Tom.\n\n";
        }
        return "";
    }

    public int computeDeltaV() {
        // return velocity + gravity - burn amount
        return GRAVITY - (burn - 100);
        //Change in velocity (delta V)
        //DeltaV = gravity - burn effect
    }


    //Adjust vehicle state for the given burn amount
    public void adjustForBurn(int burnAmount) {

        //Create conditional so burn amount cant be negativ
        if (burnAmount < 0) {
            throw new IllegalArgumentException("Burn amount cannot be negative");
        }
        if (burnAmount > MAX_BURN) {
            burnAmount = MAX_BURN;
        }

        // set burn to burnamount requested
        this.burn = burnAmount;

        //Update fuel
        this.fuel -= burnAmount;

        //Ensure fuel is non-negative
        if (this.fuel < 0) {
            this.fuel = 0;
        }

        //Calculate new velocity
        int deltaV = computeDeltaV();
        this.velocity += deltaV;

        //Ensure velo is non-negative
        if (this.fuel < 0) {
            this.fuel = 0;
        }

        //Update altitude
        this.altitude -= this.velocity / 10;
        }

    public boolean stillFlying() {
        // return true if altitude is positive
        return this.altitude > 0;
    }
    public boolean outOfFuel() {
        // return true if fuel is less than or equal to zero
        return this.fuel <= 0;
    }

    public DescentEvent getStatus(int tick) {
        // create a return a new DescentEvent object
        // filled in with the state of the vehicle.
        return new DescentEvent(tick, this.velocity, this.fuel, this.altitude, this.flying);
    }
}
