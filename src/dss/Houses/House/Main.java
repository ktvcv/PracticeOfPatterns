package dss.Houses.House;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HouseFactory houseFactory = new HouseFactory();
        List<House> houses = new ArrayList<>();
        houses.add(houseFactory.createHouse(HouseType.BUDGET));
        houses.add(houseFactory.createHouse(HouseType.MINIMALISTIC));
        houses.add(houseFactory.createHouse(HouseType.LUXURY));
        houses.forEach(
                x -> {
                    System.out.println(x.getMaterials());
                }
        );
    }
}
