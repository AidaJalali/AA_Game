package enums;

public enum ImageEnum {
    AVATAR1("/images/1.png"),
    AVATAR2("/images/3.png"),
    AVATAR3("/images/4.png"),
    AVATAR4("/images/5.png"),
    AVATAR5("/images/2.png"),
    AVATAR6("/images/10.png"),
    PERSON("/images/person.png");



    public final String image;

    ImageEnum(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}

