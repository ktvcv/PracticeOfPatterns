package dss.Houses.House;

import java.util.ArrayList;
import java.util.List;

public class MinimalisticMaterials implements MaterialsAbstract {
    private List<String> materials = new ArrayList<>();

    @Override
    public void addMaterials(String material) {
        materials.add(material);
    }

    public List<String> getMaterials() {
        return this.materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }
}
