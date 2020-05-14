package dss.Houses.Auction;

public class SecurityDecMaker implements IDecisionMaker {
    @Override
    public boolean makeDecision(BuildingPlan plan) {
        return plan.getDueDateImMonths() < 20 && plan.getTotalPrice() < 1000000;
    }
}
