package org.hakanmetin;


import org.hakanmetin.dao.AgentDAO;
import org.hakanmetin.dao.BuyerDAO;
import org.hakanmetin.dao.PropertyDAO;
import org.hakanmetin.dao.SellerDAO;
import org.hakanmetin.model.Agent;
import org.hakanmetin.model.Buyer;
import org.hakanmetin.model.Property;
import org.hakanmetin.model.Seller;

import java.math.BigDecimal;
import java.util.List;


public class AppMain
{
    public static void main( String[] args )
    {

        Agent agent = new Agent();
        Buyer buyer1 = new Buyer();
        Seller seller = new Seller();
        Property property = new Property();

        AgentDAO agentDAO = new AgentDAO();
        BuyerDAO buyerDAO = new BuyerDAO();
        SellerDAO sellerDAO = new SellerDAO();
        PropertyDAO propertyDAO = new PropertyDAO();

        agent.setAgentFirstName("Alex");
        agent.setAgentLastName("Chat");
        agent.setAgentEmail("alex@outlook.com");
        agent.setAgentPhone("24332525");
        agent.setOfficeAddress("Karlsplatz 3, München");
        agent.setRating(4.5F);


        agent.setUsername("alexiss");
        agent.setPassword("wqdqedwqd12");


        agentDAO.saveAgent(agent);

        Agent agent2 = new Agent();


        agent2.setAgentFirstName("Carl");
        agent2.setAgentLastName("Maximum");
        agent2.setAgentEmail("carls@outlook.com");
        agent2.setAgentPhone("3444446353");
        agent2.setOfficeAddress("Karlsplatz 343, München");
        agent2.setRating(4.2F);

        agent2.setUsername("carllslwa");
        agent2.setPassword("sdqe2ee2e");
        agentDAO.saveAgent(agent2);

        Agent findInfo = agentDAO.getAgentFindById(1);

        System.out.println(findInfo.getAgentId());
        System.out.println(findInfo.getAgentFirstName());
        System.out.println(findInfo.getAgentLastName());
        System.out.println(findInfo.getAgentEmail());
        System.out.println(findInfo.getAgentPhone());
        System.out.println(findInfo.getOfficeAddress());
        System.out.println(findInfo.getRating());
        System.out.println(findInfo.getUsername());
        System.out.println(findInfo.getPassword());

        System.out.println("-----------");
        agent.setAgentId(1);
        agent.setAgentPhone("5677332525");
        agent.setRating(4.6F);

        agentDAO.updateAgent(agent);

        findInfo = agentDAO.getAgentFindById(1);

        System.out.println(findInfo.getAgentId());
        System.out.println(findInfo.getAgentFirstName());
        System.out.println(findInfo.getAgentLastName());
        System.out.println(findInfo.getAgentEmail());
        System.out.println(findInfo.getAgentPhone());
        System.out.println(findInfo.getOfficeAddress());
        System.out.println(findInfo.getRating());
        System.out.println(findInfo.getUsername());
        System.out.println(findInfo.getPassword());

        System.out.println("-----------");

        System.out.println(agentDAO.deleteAgentById(121)); // nicht existierte Datensatz
       // System.out.println(agentDAO.deleteAgentById(agent.getAgentId()));

        System.out.println("---BUYER--------" + agent.getAgentId());


        buyer1.setBuyerFirstName("Hakan");
        buyer1.setBuyerLastName("Metin");
        buyer1.setBuyerEmail("hakan@outlook.com");
        buyer1.setBuyerPhone("24332525");
        buyer1.setUsername("hakanella91");
        buyer1.setPassword("wqdqedwqd12");
        buyer1.setRating(4.7F);
        buyerDAO.saveBuyer(buyer1);

        Buyer buyer2 = new Buyer();

        buyer2.setBuyerFirstName("Natalie");
        buyer2.setBuyerLastName("Weiss");
        buyer2.setBuyerEmail("natalie@outlook.com");
        buyer2.setBuyerPhone("3526345325");
        buyer2.setUsername("natalie22");
        buyer2.setPassword("3rwdaddw22");
        buyer2.setRating(4.8F);
        buyerDAO.saveBuyer(buyer2);

        System.out.println("---SELLER--------");



        seller.setSellerFirstName("Maria");
        seller.setSellerLastName("Silva");
        seller.setSellerEmail("maria@outlook.com");
        seller.setSellerPhone("2433342525");
        seller.setUsername("maria22");
        seller.setPassword("3rwdaddw22");

        sellerDAO.saveSeller(seller);


        Seller seller2 = new Seller();

        seller2.setSellerFirstName("Raphael");
        seller2.setSellerLastName("Weiss");
        seller2.setSellerEmail("raphael@outlook.com");
        seller2.setSellerPhone("323434323");
        seller2.setUsername("raphael442");
        seller2.setPassword("wewe21e4");
        sellerDAO.saveSeller(seller2);


        System.out.println("---PROPERTIES--------");


        property.setPropertyName("Malikane");
        property.setPropertyTitle("Triplex");
        property.setPropertyDescription("Triplex Property");
        property.setPropertyType("Home");
        property.setLocation("Ankara");
        property.setPrice(BigDecimal.valueOf(1_000_000));

        property.setAgent(agent);
        property.setSeller(seller);
        propertyDAO.saveProperty(property);

        Property property2 = new Property();
        property2.setPropertyName("Malikane");
        property2.setPropertyTitle("Duplex");
        property2.setPropertyDescription("Cool Property");
        property2.setPropertyType("Home");
        property2.setLocation("Izmir");
        property2.setPrice(BigDecimal.valueOf(749_999));

        property2.setAgent(agent);
        property2.setSeller(seller2);

        propertyDAO.saveProperty(property2);


        System.out.println("-- the list of agents------");

        List<Agent> agentList = agentDAO.getAgentFindAll();

        for (Agent agent1 : agentList) {
            System.out.println(agent1.getAgentFirstName() + " " + agent1.getAgentLastName());
        }

        System.out.println("-- the list of sellers------");

        List<Seller> sellerList = sellerDAO.getSellerFindAll();
        for (Seller seller1 : sellerList) {
            System.out.println(seller1.getSellerFirstName() + " " + seller1.getSellerLastName());
        }


        System.out.println("-- the list of buyers------");
        List<Buyer> buyerList = buyerDAO.getBuyerFindAll();

        for (Buyer buyer : buyerList) {
            System.out.println(buyer.getBuyerFirstName() + " " + buyer.getBuyerLastName());
        }

        System.out.println("-- the list of properties------");
        List<Property> propertyList = propertyDAO.getPropertyFindAll();
        for (Property property1 : propertyList) {
            System.out.println(property1.getPropertyTitle() + " " + property1.getPropertyDescription() + " " + property1.getPropertyType());
        }


        agentDAO.deleteAgentById(agent2.getAgentId());
        agentList = agentDAO.getAgentFindAll();

        for (Agent agent1 : agentList) {
            System.out.println(agent1.getAgentFirstName() + " " + agent1.getAgentLastName());
        }

        agent = agentDAO.getAgentFindById(agent2.getAgentId());
       // System.out.println(agent.getAgentFirstName());



    }
}

/*
*
*
* Programm startet
→ SessionFactory wird einmal erstellt
→ Session wird geöffnet
→ Transaktion wird gestartet
→ Transaktion wird committed
→ Session wird automatisch geschlossen
→ SessionFactory wird geschlossen
→ Programm endet
*
* */



