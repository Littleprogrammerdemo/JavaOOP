package InterfacesAndAbstraction.carShopExtend;

public interface Rentable extends Car{
    Integer getMinRentDay();
    Double getPricePerDay();
}