package edu.pjwstk.sri.lab2.exeptions;

public class ItemUnavailableExpection extends Exception {
    public String productName;

    public ItemUnavailableExpection(String productName)
    {
        this.productName = productName;
    }
}
