public class BurnDataStream implements BurnStream {
    // these are the series of burns made each 10 secs by the lander.
    // change them to see if you can get the lander to make a soft landing.
    // burns are between 0 and 200. This burn array usually crashes.

    //Adjust burn rates to decrease velocity for a safe landing as spacecraft appraoches the surface
    //Initial burn set to '0' bc for a free-fall phase - the spacecraft descends with thrust = no crash

    int burnArray[] = {0, 0, 0, 0, 0, 50, 100, 150, 200, 200, 150, 100, 50, 30, 20, 10};
    int burnIdx = -1;

    public BurnDataStream() { }
    public BurnDataStream(int[] burns) {

        this.burnArray = burns;
    }

    @Override
    public int getNextBurn(DescentEvent status) {
        //Moved Increment index to first
        burnIdx++;

        if (burnIdx < burnArray.length) {

            System.out.println(burnArray[burnIdx]); /*hack!*/
            return burnArray[burnIdx];
        }
        return 0;
    }
}
