package Practica007;

public enum TypePriority {
    NORMAL_CLIENT(false), VIP_CLIENT(true);
    private boolean isPriority;

    TypePriority(boolean isPriority) {
        this.isPriority = isPriority;
    }

    public boolean getIsPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }
}
