package dss.Houses.House;

import java.util.ArrayList;
import java.util.List;

public class LuxuryMaterials implements MaterialsAbstract {
    private List<String> luxuryMaterials = new ArrayList<>();

    @Override
    public void addMaterials(String material) {
        luxuryMaterials.add(material);
    }

    public List<String> getMaterials() {
        return this.luxuryMaterials;
    }

    public void setLuxuryMaterials(List<String > luxuryMaterials) {
        this.luxuryMaterials = luxuryMaterials;
    }

    @Override
    public String toString() {
        return "LuxuryMaterials{" +
                "luxuryMaterials=" + luxuryMaterials +
                '}';
    }
}

