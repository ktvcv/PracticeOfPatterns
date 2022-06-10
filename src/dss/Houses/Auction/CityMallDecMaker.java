package dss.Houses.Auction;

public class CityMallDecMaker implements IDecisionMaker {
    @Override
    public boolean makeDecision(BuildingPlan plan) {
        return plan.getDueDateImMonths() < 10 && plan.getTotalPrice() < 1500000;
    }
}
