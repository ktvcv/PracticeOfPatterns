package dss.Houses.House;

public class Material {
    private MaterialType materialType;
    private Materials materials;

    private float price;

    public Material(MaterialType materialType, Materials materials, float price) {
        this.materialType = materialType;
        this.materials = materials;
        this.price = price;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Materials getMaterials() {
        return materials;
    }

    public void setMaterials(Materials materials) {
        this.materials = materials;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
