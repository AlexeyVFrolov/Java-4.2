package repository;

import domain.TicketOffer;
import exception.NotFoundException;

import java.util.Arrays;

public class TicketOfferRepository {
    private TicketOffer[] ticketOffers = new TicketOffer[0];

    public void save(TicketOffer newticketOffer) {
        TicketOffer[] tmp = new TicketOffer[ticketOffers.length + 1];

        System.arraycopy(ticketOffers, 0, tmp, 0, ticketOffers.length);
        tmp[tmp.length - 1] = newticketOffer;
        ticketOffers = tmp;
    }

    public TicketOffer[] findAll() {
        return ticketOffers;
    }

    public TicketOffer findById(int id) {

        for (TicketOffer ticketOffer : ticketOffers) {
            if (ticketOffer.getId() == id) {
                return ticketOffer;
            }
        }
        return null;
    }

    public TicketOffer[] findByFromTo(String from, String to) {
        TicketOffer[] tmp = new TicketOffer[ticketOffers.length];
        int index = 0;

        for (TicketOffer ticketOffer : ticketOffers) {
            if (ticketOffer.getFromIATA().equalsIgnoreCase(from) && ticketOffer.getToIATA().equalsIgnoreCase(to)) {
                tmp[index++] = ticketOffer;
            }
        }

        if (index != 0) {
            TicketOffer[] result = new TicketOffer[index];
            System.arraycopy(tmp, 0, result, 0, index);
            Arrays.sort(result);
            return result;
        }

        return null;
    }

    public void removeById(int id) {

        if (this.findById(id) == null) throw new NotFoundException("Element with id: \" + id + \" not found");
        TicketOffer[] tmp = new TicketOffer[ticketOffers.length - 1];
        int index = 0;
        for (TicketOffer ticketOffer : ticketOffers) {
            if (ticketOffer.getId() != id) {
                tmp[index] = ticketOffer;
                index++;
            }
        }
        // меняем наши элементы
        ticketOffers = tmp;

    }

    public void removeAll() {
        ticketOffers = new TicketOffer[0];
    }
}
