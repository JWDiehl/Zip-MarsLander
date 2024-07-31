public class OnBoardComputer implements BurnStream {

    private static final int MAX_BURN = 200;
    private static final int SAFE_LANDING_VELOCITY = 2;

    @Override
    public int getNextBurn(DescentEvent status) {

        int currentVelocity = status.getVelocity();
        int currentAltitude = status.getAltitude();
        int burn = 0;

        //Control strategy - if altitude <= we already landed
        if (currentAltitude <= 0) {
            return 0;
        }

        //Calculating the burn rate to manage descent velo
        if (currentVelocity > SAFE_LANDING_VELOCITY) {
            burn = Math.min(MAX_BURN, (currentVelocity - SAFE_LANDING_VELOCITY) * 2);
        } else {
            burn = 0;
        }

        //Ensure the burn rate is within range
        burn = Math.max(0, Math.min(burn, MAX_BURN));

        System.out.println(burn); /*hack!*/
        return burn;
    }

}
