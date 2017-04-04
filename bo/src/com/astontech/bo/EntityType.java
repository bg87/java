package com.astontech.bo;

public class EntityType extends BaseBO {

    // region PROPERTIES

    private int entityTypeId;
    private String entityTypeName;

    // endregion

    //region CONSTRUCTORS

    public EntityType() {}

    public EntityType(String name) {
        this.entityTypeName = name;
    }

    //endregion

    //region GETTERS SETTERS

    public int getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }

    //endregion
}
