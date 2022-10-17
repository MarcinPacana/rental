package pl.rentalcar;

public enum MsgType {

    SUCCESS("success"),
    WARNING("warning"),
    DANGER("danger");

    public String message;

    MsgType(String danger) {
        this.message = danger;
    }
}
