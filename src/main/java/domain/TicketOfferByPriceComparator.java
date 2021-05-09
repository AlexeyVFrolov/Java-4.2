package domain;

import java.util.Comparator;

public class TicketOfferByPriceComparator implements Comparator<TicketOffer> {
    public int compare(TicketOffer tO1, TicketOffer tO2) {
        return tO1.getFlightTime() - tO2.getFlightTime();
    }
}
