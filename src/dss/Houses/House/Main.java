package dss.Houses.House;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MaterialFactory materialFactory = new MaterialFactory();
        List<MaterialsAbstract> materialsAbstracts = new ArrayList<>();
        materialsAbstracts.add(materialFactory.createHouse(MaterialType.BUDGET));
        materialsAbstracts.add(materialFactory.createHouse(MaterialType.MINIMALISTIC));
        materialsAbstracts.add(materialFactory.createHouse(MaterialType.LUXURY));
        materialsAbstracts.forEach(
                x -> {
                    System.out.println(x.getMaterials());
                }
        );
    }
}
