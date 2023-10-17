package web.technologies.lab02.asset;

public class TIEFighter {

    private final String serialNumber;
    private final String pilot;
    private final int laserCannonsCount;
    private final String status;
    private final int flightHours;

    public TIEFighter(String serialNumber, String pilot, int laserCannonsCount, String status, int flightHours) {
        this.serialNumber = serialNumber;
        this.pilot = pilot;
        this.laserCannonsCount = laserCannonsCount;
        this.status = status;
        this.flightHours = flightHours;
    }

    public void fly() {
        System.out.println("TIE Fighter " + serialNumber + ", piloted by " + pilot + " with " + laserCannonsCount + " laser cannons, is taking off!");
    }

}
