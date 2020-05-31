package dss.Houses.House;

public  class MaterialFactory {
    //factory method for creation a house
    public MaterialsAbstract createHouse(MaterialType type){
        MaterialsAbstract materialsAbstract = null;
        switch (type) {
            case BUDGET:
                    materialsAbstract = new BudgetMaterialsAbstract();
                break;
            case MINIMALISTIC:
                    materialsAbstract = new MinimalisticMaterials();
                break;
            case LUXURY:
                    materialsAbstract = new LuxuryMaterials();
                                  break;
        }
        return materialsAbstract;
    }
}
