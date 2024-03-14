package repo;

public class Repo {
    private double limit;
    private int numberOfDocuments;
    private double usedSpace;

    public Repo(double limit) {
        this.limit = limit;
        this.numberOfDocuments = 0;
        this.usedSpace = 0;
    }

    public Repo(double limit, int numberOfDocuments, double usedSpace) {
        this.limit = limit;
        this.numberOfDocuments = numberOfDocuments;
        this.usedSpace = usedSpace;
    }

    public boolean uploadDocument(Document document){
        if (this.limit - this.usedSpace >= document.getDocSize()){
            this.numberOfDocuments++;
            this.usedSpace += document.getDocSize();
            document.setRepo(this);
            return true;
        }
        return false;
    }

    public double freeSpace(){
        return  this.limit - this.usedSpace;
    }


    @Override
    public String toString() {
        return "Repo{" +
                "limit=" + limit +
                ", numberOfDocuments=" + numberOfDocuments +
                ", usedSpace=" + usedSpace +
                '}';
    }
}
