import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Empirical formula

        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();
        double[] mass = new double[n];
        double[] percentage = new double[n];
        double[] moles = new double[n];
        int[] subscript = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i+1) + " mass: ");
            mass[i] = input.nextDouble();
            System.out.print("Element " + (i+1) + " percentage: ");
            percentage[i] = input.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            moles[i] = percentage[i] / mass[i];
            System.out.println("Element " + (i+1) + ": " + percentage[i] + " / " + mass[i] + " = " + moles[i]);
        }
        double[] new_moles = new double[n];
        System.arraycopy(moles, 0, new_moles, 0, n);
        Arrays.sort(new_moles);
        double min_moles = new_moles[0];
        for (int i = 0; i < n; i++) {
            subscript[i] = (int) (Math.round(moles[i]/min_moles));
            System.out.println("Element " + (i+1) + ": " + moles[i] + " / " + min_moles + " = " + subscript[i]);
        }

        // Molecular formula

        System.out.print("\nMolecular mass of compound: ");
        double compound_molar_mass = input.nextDouble();
        double empirical_mass = 0.0;
        for (int i = 0; i < n; i++) {
            empirical_mass += mass[i] * subscript[i];
            if (i == 0) System.out.print("Empirical molar mass = ");
            if (i != 0) System.out.print(" ");
            System.out.print(subscript[i]+"("+mass[i]+")");
            if (i != n-1) System.out.print(" +");
        }
        System.out.print(" = " + empirical_mass);
        int mass_multiple = (int) (Math.round(compound_molar_mass / empirical_mass));
        System.out.println("\nMass multiple = " + compound_molar_mass + " / " + empirical_mass + " = " + mass_multiple);
        int molecular_formula_subscript[] = new int[n];
        for (int i = 0; i < n; i++) {
            molecular_formula_subscript[i] = subscript[i] * mass_multiple;
            System.out.println("Molecular formula subscript for Element " + (i + 1) + ": " + molecular_formula_subscript[i]);
        }
    }
}
