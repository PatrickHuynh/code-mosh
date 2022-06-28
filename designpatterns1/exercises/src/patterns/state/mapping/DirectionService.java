package patterns.state.mapping;

public class DirectionService {
    private TravelMode travelMode;

    public DirectionService() {
        this.travelMode = new TravelModeDriving();
    }

    public Object getEta() {
        return travelMode.getEta();
    }

    public Object getDirection() {
        return travelMode.getDirection();
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }
}
