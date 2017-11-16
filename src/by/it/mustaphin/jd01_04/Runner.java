package by.it.mustaphin.jd01_04;

public class Runner {
    public static void main(String[] args) {
//        Singleton tA = new Singleton();
//        tA.multiple();

        InOut io = new InOut();
        int[] mas = io.in1D();
        int[] masCopy = mas;
        io.boubleSort1D(mas);
        io.showNewPlaces(masCopy, mas);
        io.out1D(mas, 5, "mas");

//        TaskB tB = new TaskB();
//        String lastNames[] = tB.setLastnames();
//        int salary[][] = tB.setSalaryPetQuart(lastNames);
//        tB.getSalaryTable(lastNames, salary);
    }
}
