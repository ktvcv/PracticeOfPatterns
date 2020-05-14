package dss.Houses.House;

import java.util.List;

public class BudgetHouse extends House {
    @Override
    public void setMaterials() {
        materials.add("Budget kitchen");
    }

    @Override
    public List<String> getMaterials() {
        return null;
    }
}
