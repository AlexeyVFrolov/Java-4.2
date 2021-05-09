package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketOffer implements Comparable<TicketOffer>{
    private int id;
    private int price;
    private String fromIATA;
    private String toIATA;
    private int flightTime;

    @Override
    public int compareTo(TicketOffer tO) {
        return this.price - tO.price;
    }
}
