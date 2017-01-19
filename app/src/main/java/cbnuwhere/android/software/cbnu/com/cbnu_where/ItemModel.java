package cbnuwhere.android.software.cbnu.com.cbnu_where;

public class ItemModel {
    private String name;
    private String startTime;
    private String endTile;
    private String latitude;
    private String longitude;
    private String category;
    private int image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTile() {
        return endTile;
    }

    public void setEndTile(String endTile) {
        this.endTile = endTile;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int itemImage) {
        this.image = itemImage;
    }
}

