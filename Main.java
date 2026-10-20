import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args){

        Palm laura = new Palm("Laura", 5.0);
        Palm olof = new Palm("Olof", 1.0);
        Cactus igge = new Cactus("Igge", 0.20);
        CarnivorousPlant meatloaf = new CarnivorousPlant("Meatloaf",0.7);

        // Polymorfism: olika typer av växter kan hanteras som Plant
        // fungerar eftersom alla växter ärver från plant, men har olika versioner av metoder
        Plant[] plants = {laura, olof, igge, meatloaf};
       String plantname = JOptionPane.showInputDialog("Vilken växt ska få vätska?");

        if (plantname == null || plantname.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Du måste skriva ett växtnamn");
            return;
        }
        plantname = plantname.trim();
        boolean found = false;

        for (Plant plant : plants) {
            if (plant.name.equalsIgnoreCase(plantname)) {
                found = true;
                String result = plant.name + "\n"
                        + plant.getWaterAmount() + " liter\n"
                        + plant.getLiquid();

                JOptionPane.showMessageDialog(null, result);
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Växten hittades inte.");
        }
    }

}
// classen plant implementerar interfacet Waterable
class Plant implements Waterable {
    String name;
    double height;

    Plant(String name, double height){
        this.name = name;
        this.height = height;
    }
    public double getWaterAmount() {
        return 0.5 * height;
    }
    public String getLiquid() {
        return "Kranvatten";
    }
}
//Palm ärver egenskaper o metoder från Plant
class Palm extends Plant {
    Palm(String name, double height) {
        super(name, height);
    }
        @Override
        public double getWaterAmount() {
            return 0.5 * height;
        }

}
// Cactus ärver egenskaper och metoder från Plant
class Cactus extends Plant {
    Cactus(String name, double height) {
        super(name, height);
    }
    @Override
    public double getWaterAmount (){
        return 0.02;
    }
    @Override
    public String getLiquid(){
        return "Mineralvatten";
    }
}
// carnivourusPlant ärver egenskaper och metoder från Plant
class CarnivorousPlant extends Plant {
    CarnivorousPlant(String name, double height){
        super(name, height);
    }
    @Override
    public double getWaterAmount (){
        return 0.1 + (0.2 * height);
    }
    @Override
    public String getLiquid(){
        return "Proteindryck";
    }
}