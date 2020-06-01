package dss.Houses.House;

import static dss.Houses.House.HouseFactory.createHouse;
import static dss.Houses.House.MaterialFactory.createMaterial;

public class Main {
    static BudgetMaterials budgetMaterials = new BudgetMaterials();
    static LuxuryMaterials luxuryMaterials = new LuxuryMaterials();
    static MinimalisticMaterials minimalisticMaterials = new MinimalisticMaterials();

    public static void main(String[] args) {
        createMaterial(MaterialType.LUXURY, "Kitchen Walmart-1000");
        createMaterial(MaterialType.LUXURY, "Cell Walmart-AS1");
        createMaterial(MaterialType.BUDGET, "Kitchen Walmart-500");
        createMaterial(MaterialType.BUDGET, "Cell Walmart-AS1");
        createMaterial(MaterialType.MINIMALISTIC, "Kitchen Walmart-100");
        createMaterial(MaterialType.MINIMALISTIC, "Cell Walmart-AS1");

       House houseLuxury = createHouse(MaterialType.LUXURY);
        House houseBudget = createHouse(MaterialType.BUDGET);
        House houseMinimalistic = createHouse(MaterialType.MINIMALISTIC);

       System.out.println("Luxury house: " + houseLuxury);
        System.out.println("Budget house: " + houseBudget);
        System.out.println("Minimalistic house: " + houseMinimalistic);


    }


}
