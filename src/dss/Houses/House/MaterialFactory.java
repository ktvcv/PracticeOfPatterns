package dss.Houses.House;

public  class MaterialFactory {
    //factory method for creation a house
    public MaterialsAbstract createHouse(MaterialType type){
        MaterialsAbstract materialsAbstract = null;
        switch (type) {
            case BUDGET:
                    materialsAbstract = new BudgetMaterialsAbstract();
                    materialsAbstract.setMaterials();
                break;
            case MINIMALISTIC:
                    materialsAbstract = new MinimalisticMaterials();
                    materialsAbstract.setMaterials();
                break;
            case LUXURY:
                    materialsAbstract = new LuxuryMaterials();
                    materialsAbstract.setMaterials();

                break;
        }
        return materialsAbstract;
    }
}
