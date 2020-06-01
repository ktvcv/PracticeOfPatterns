package dss.Houses.House;

import static dss.Houses.House.Main.*;

public class MaterialFactory {
    public static void createMaterial(MaterialType type, String material){

        switch (type) {
            case BUDGET:
                budgetMaterials.addMaterials(material);
                break;
            case MINIMALISTIC:
                minimalisticMaterials.addMaterials(material);
                break;
            case LUXURY:
                luxuryMaterials.addMaterials(material);
                break;
        }

    }
}
