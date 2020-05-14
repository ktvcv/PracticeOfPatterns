package dss.Houses.House;

public  class HouseFactory {
    //factory method for creation a house
    public  House createHouse(HouseType type){
        House house = null;
        switch (type) {
            case BUDGET:
                    house = new BudgetHouse();
                    house.setMaterials();
                break;
            case MINIMALISTIC:
                    house = new MinimalisticHouse();
                    house.setMaterials();
                break;
            case LUXURY:
                    house = new LuxuryHouse();
                    house.setMaterials();

                break;
        }
        return house;
    }
}
