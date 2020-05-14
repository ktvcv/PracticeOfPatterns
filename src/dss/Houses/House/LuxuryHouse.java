package dss.Houses.House;

import java.util.List;

public class LuxuryHouse extends House {
    @Override
    public void setMaterials() {
            materials.add("Luxury kitchen");
        }

    @Override
    public List<String> getMaterials() {
        return null;
    }
}

