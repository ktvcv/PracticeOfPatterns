package dss.Houses.Auction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BuildingPlan> buildingPlans = new ArrayList<>();
        buildingPlans.add(new BuildingPlan(new CityMallDecMaker(),9,1300000));
        buildingPlans.add(new BuildingPlan(new CityMallDecMaker(),12,1200000));
        buildingPlans.forEach(BuildingPlan::setApproved);
        buildingPlans.forEach(System.out::println);


    }
}
