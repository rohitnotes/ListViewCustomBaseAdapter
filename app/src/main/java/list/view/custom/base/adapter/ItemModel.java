package list.view.custom.base.adapter;

public class ItemModel {

    String title;
    String Description;
    int imgResId;

    public ItemModel(String title, String description, int imgResId) {
        this.title = title;
        Description = description;
        this.imgResId = imgResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
}
