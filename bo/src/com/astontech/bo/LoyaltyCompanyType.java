package com.astontech.bo;

public class LoyaltyCompanyType extends BaseBO {

    //region PROPERTIES

    private String loyaltyCompanyType;
    private int loyaltyCompanyId;
    private String companyName;

    //endregion

    //region CONSTRUCTORS

    public LoyaltyCompanyType(String loyaltyCompanyType, int loyaltyCompanyId) {
        this.loyaltyCompanyType = loyaltyCompanyType;
        this.loyaltyCompanyId = loyaltyCompanyId;
    }

    public LoyaltyCompanyType(String companyName) {
        this.companyName = companyName;
    }

    //endregion

    //region SETTERS GETTERS

    public String getLoyaltyCompanyType() {
        return loyaltyCompanyType;
    }

    public void setLoyaltyCompanyType(String loyaltyCompanyType) {
        this.loyaltyCompanyType = loyaltyCompanyType;
    }

    public int getLoyaltyCompanyId() {
        return loyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        this.loyaltyCompanyId = loyaltyCompanyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    //endregion
}
