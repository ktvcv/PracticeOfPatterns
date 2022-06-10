package dss.Houses.Auction;

public class BuildingPlan {
    //Strategy for each house to make decision
    private final IDecisionMaker decisionMaker;
    private int dueDateImMonths;
    private float totalPrice;
    private boolean isApproved;

    public BuildingPlan(IDecisionMaker decisionMaker, int dueDateImMonths, float totalPrice) {
        this.decisionMaker = decisionMaker;
        this.dueDateImMonths = dueDateImMonths;
        this.totalPrice = totalPrice;
    }

    public int getDueDateImMonths() {
        return dueDateImMonths;
    }

    public void setDueDateImMonths(int dueDateImMonths) {
        this.dueDateImMonths = dueDateImMonths;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved() {
        this.isApproved = decisionMaker.makeDecision(this);
    }

    @Override
    public String toString() {
        return "BuildingPlan{" +
            "decisionMaker=" + decisionMaker +
            ", dueDateImMonths=" + dueDateImMonths +
            ", totalPrice=" + totalPrice +
            ", isApproved=" + isApproved +
            '}';
    }
}
