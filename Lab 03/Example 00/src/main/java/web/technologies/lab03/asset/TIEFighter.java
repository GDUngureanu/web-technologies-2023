package web.technologies.lab03.asset;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TIEFighter implements Asset {

    private final String serialNumber;
    private final String pilot;
    private final int laserCannonsCount;
    private final String status;
    private final int flightHours;

    public String takeAction() {
        return "TIE Fighter " + serialNumber + ", piloted by " + pilot + " with " + laserCannonsCount + " laser cannons, is taking off!";
    }

}
