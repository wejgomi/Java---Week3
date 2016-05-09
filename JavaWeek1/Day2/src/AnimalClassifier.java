import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class AnimalClassifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AnimalClassifier animals = new AnimalClassifier();

        System.out.print("Select the animal to investigate: ");
        String input = scan.next().toLowerCase();
        String classname = input.toUpperCase().charAt(0) + input.substring(1) + ".class";
        System.out.print(classname);
        try{
            AnimalClassifier.class.getMethod(classname).invoke(animals);
        } catch (IllegalAccessException e) {
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
        }

    }

    public class Animals extends AnimalClassifier {

        public boolean movement;
        public String celltype;
        public String reproduction;

        public Animals(boolean move, String cellt , String repro) {
            movement = move;
            celltype = cellt;
            reproduction = repro;
        }

        public Animals(){super();}

        public void setMovement(boolean newValue) {
            movement = newValue;
        }

        public void setCelltype(String newValue) {
            celltype = newValue;
        }

        public void setReproduction(String newValue) {
            reproduction = newValue;
        }
    }

    public class Vertebrates extends Animals {

        public boolean jaws;
        public String thermoregulation;
        public String respiration;

        public Vertebrates(boolean jaw, String thermoreg , String respi, boolean move, String cellt , String repro) {
            super(move, cellt , repro);
            jaws = jaw;
            thermoregulation = thermoreg;
            respiration = respi;
        }

        public Vertebrates(){
            super();
        }

        public void setJaws(boolean newValue) {
            jaws = newValue;
        }

        public void setThermoregulation(String newValue) {
            thermoregulation = newValue;
        }

        public void setRespiration(String newValue) {
            respiration = newValue;
        }
    }

    public class Fish extends Vertebrates {

        public Fish() {
            super();
            //super(jaw,thermoreg,respi,move, cellt , repro);
            //jaws = true;
            //thermoregulation = thermoreg;
            //respiration = respi;
        }

        public void swim() {
            System.out.println("A dog sleeps...");
        }


    }

    public class Reptiles extends Vertebrates {
        public Reptiles(boolean jaw, String thermoreg , String respi, boolean move, String cellt , String repro) {
            super(jaw,thermoreg,respi,move, cellt , repro);
            jaws = jaw;
            thermoregulation = thermoreg;
            respiration = respi;
        }
    }

    public class Amphibians extends Vertebrates {
        public Amphibians(boolean jaw, String thermoreg , String respi, boolean move, String cellt , String repro) {
            super(jaw,thermoreg,respi,move, cellt , repro);
            jaws = jaw;
            thermoregulation = thermoreg;
            respiration = respi;
        }
    }

    public class Birds extends Vertebrates {
        public Birds(boolean jaw, String thermoreg , String respi, boolean move, String cellt , String repro) {
            super(jaw,thermoreg,respi,move, cellt , repro);
            jaws = jaw;
            thermoregulation = thermoreg;
            respiration = respi;
        }
    }

    public class Mammals extends Vertebrates {
        public Mammals(boolean jaw, String thermoreg , String respi, boolean move, String cellt , String repro) {
            super(jaw,thermoreg,respi,move, cellt , repro);
            jaws = jaw;
            thermoregulation = thermoreg;
            respiration = respi;
        }
    }

    public class Invertebrates extends Animals {

        public boolean symmetry;
        public boolean metamorph;
        public String skeleton;

        public Invertebrates(boolean symmetrical, boolean meta, String skel, String repro, boolean move, String cellt) {
            super(move, cellt , repro);
            symmetry = symmetrical;
            metamorph = meta;
            skeleton = skel;
        }

        public void setSymmetrical(boolean newValue) {
            symmetry = newValue;
        }

        public void setMetamorph(boolean newValue) {
            metamorph = newValue;
        }

        public void setSkeleton(String newValue) {
            skeleton = newValue;
        }
    }

    //public class Artopods extends Invertebrates {
        //public Fish(boolean jaw, String thermoreg , String respi, boolean move, String cellt , String repro) {
        //    super(jaw,thermoreg,respi,move, cellt , repro);
            //jaws = jaw;
            //thermoregulation = thermoreg;
            //respiration = respi;
        //}
    //}
}
