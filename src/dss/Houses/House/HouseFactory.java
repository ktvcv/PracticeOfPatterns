package dss.Houses.House;

import static dss.Houses.House.Main.*;

public class HouseFactory {
    public static House createHouse(MaterialType type){
        House house = new House();

        switch (type) {
            case BUDGET:
                house.setMaterials(budgetMaterials.getMaterials());
                break;
            case MINIMALISTIC:
                house.setMaterials(minimalisticMaterials.getMaterials());
                break;
            case LUXURY:
                house.setMaterials(luxuryMaterials.getMaterials());
                break;
        }

        return house;
    }
}
