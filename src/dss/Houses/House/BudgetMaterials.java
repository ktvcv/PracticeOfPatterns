package dss.Houses.House;


import java.util.ArrayList;
import java.util.List;

public class BudgetMaterials implements MaterialsAbstract {

    private List<String> materials = new ArrayList<>();

    @Override
    public void addMaterials(String material) {
        materials.add(material);
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public List<String> getMaterials() {
        return this.materials;
    }
}
