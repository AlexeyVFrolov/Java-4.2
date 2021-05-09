package repository;

import domain.TicketOffer;
import domain.TicketOfferByPriceComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferRepositoryTest {
    TicketOfferRepository ticketOfferRepository = new TicketOfferRepository();

    TicketOffer firstTicketOffer = new TicketOffer(1, 750000, "DME", "BAX", 240);
    TicketOffer secondTicketOffer = new TicketOffer(1, 150000, "ASF", "BAX", 300);
    TicketOffer thirdTicketOffer = new TicketOffer(1, 1750000, "DME", "BAX", 200);
    TicketOffer forthTicketOffer = new TicketOffer(1, 900000, "VKO", "BTK", 540);
    TicketOffer fifthTicketOffer = new TicketOffer(1, 550000, "DME", "BAX", 840);

    @BeforeEach
    public void setUp() {
        ticketOfferRepository.save(firstTicketOffer);
        ticketOfferRepository.save(secondTicketOffer);
        ticketOfferRepository.save(thirdTicketOffer);
        ticketOfferRepository.save(forthTicketOffer);
        ticketOfferRepository.save(fifthTicketOffer);
    }

    @Test
    public void shouldFindByFromToIfExistsAndSort() {
        TicketOffer[] expected = new TicketOffer[] {thirdTicketOffer, firstTicketOffer, fifthTicketOffer};
        TicketOfferByPriceComparator ticketOfferByPriceComparator = new TicketOfferByPriceComparator();

        assertArrayEquals(expected, ticketOfferRepository.findByFromTo("DME", "BAX", ticketOfferByPriceComparator));
    }

    @Test
    public void shouldReturnNullWhenFindByFromToIfNotExists() {
        TicketOfferByPriceComparator ticketOfferByPriceComparator = new TicketOfferByPriceComparator();

        assertNull(ticketOfferRepository.findByFromTo("VKO", "BAX", ticketOfferByPriceComparator));
    }

}