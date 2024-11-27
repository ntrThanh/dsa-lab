package hus.dsa.lab.lab5;

public class Store {
    private int id;
    private String name;
    private boolean isMain;
    private String address;
    private int total;

    public Store(int id, String name, boolean isMain, String address, int total) {
        this.id = id;
        this.name = name;
        this.isMain = isMain;
        this.address = address;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Store" + '[' +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isMain=" + isMain +
                ", address='" + address + '\'' +
                ", total=" + total +
                ']';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Store() {
        this.isMain = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
