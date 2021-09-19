package rs.itbootcamp.model;

public class FridgeModel {
    public int fridgeId, userId;

    public FridgeModel(int fridgeId, int userId) {
        this.fridgeId = fridgeId;
        this.userId = userId;
    }

    public int getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(int fridgeId) {
        this.fridgeId = fridgeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
