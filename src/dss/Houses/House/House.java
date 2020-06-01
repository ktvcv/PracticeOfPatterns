package dss.Houses.House;

import java.util.List;

public class House {
    List<String> materials;

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "House{" +
                "materials=" + materials +
                '}';
    }
}
